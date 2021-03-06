package com.sysord.acceleo.tools.module;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.acceleo.model.mtl.ModuleElement;
import org.eclipse.emf.common.util.URI;

/**
 * Utility Class for retrieving source 
 * from emtl elements
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class EmtlSourceProvider {

	/**
	 * Returns source for all moduleElements of an emtl module
	 * 
	 * @param moduleElement
	 * @return
	 */
	public static Map<ModuleElement, String> getModuleElementsSources(Module emtlModule){
		Map<ModuleElement, String> sources = new LinkedHashMap<ModuleElement, String>();
		//load source content
		String source = getModuleSource(emtlModule);
		for(ModuleElement moduleElement : emtlModule.getOwnedModuleElement()){
			//extract module element source
			sources.put(moduleElement, source.substring(moduleElement.getStartPosition(), moduleElement.getEndPosition()));
		}
		return sources;
	}

	/**
	 * Returns source for the moduleElement
	 * 
	 * @param moduleElement
	 * @return
	 */
	public static String getModuleElementSource(ModuleElement moduleElement){
		//load source content
		String source = getModuleSource((Module) moduleElement.eContainer());
		//extract module element source
		return source.substring(moduleElement.getStartPosition(), moduleElement.getEndPosition());
	}
	
	
	/**
	 * Create source module URL for an emtlModule 
	 * @param emtlModule
	 * @return
	 */
	public static URL getModuleSourceURL(Module emtlModule){
		try {
			URI emtlUri = emtlModule.eResource().getURI();
			//replace emtl by mtl and bin by src.
			return new URL(emtlUri.toString().replaceFirst(".emtl", ".mtl").replaceFirst("/bin/", "/src/"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Reads and Returns source module content as text from an emtl module.
	 * 
	 * @param emtlModule
	 * @return
	 */
	public static String getModuleSource(Module emtlModule){
		return getModuleSource(getModuleSourceURL(emtlModule));
	}

	/**
	 * Reads and Returns source module content as text from its URL.
	 * @param moduleURL
	 * @return
	 */
	public static String getModuleSource(URL moduleURL) {
		String moduleSource = null;
		try {
			final InputStream inputStream = moduleURL.openConnection().getInputStream();
			final ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buffer = new byte[512];
			int len;
			while ((len = inputStream.read(buffer)) > 0) {
				output.write(buffer, 0, len);
			}
			moduleSource = output.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moduleSource;
	}
	
	
}
