/***************************************************************************
 * Copyright (c) 2013 Sysord.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Sysord - initial API and implementation
 ****************************************************************************/
package com.sysord.mad.configDsl.externalQueryManager;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.resource.generic.EmfUiModule;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.osgi.framework.BundleContext;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.util.Modules;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationService;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExtQManagerManagerActivator extends AbstractUIPlugin {
	
	// The plug-in ID
	public static final String PLUGIN_ID = "com.sysord.mad.configDsl.extQManager"; //$NON-NLS-1$

	// The shared instance
	private static ExtQManagerManagerActivator plugin;
	
	private Injector injector;
	
	/**
	 * Registered ExternalQueryConfigurationService
	 */
	protected List<ExternalQueryConfigurationService> extQConfigServices; 
	

	/**
	 * The constructor
	 */
	public ExtQManagerManagerActivator() {
	}

	public Injector getInjector() {
		return injector;
	}

	private void initializeEcoreInjector() {
		injector = Guice.createInjector(
				Modules.override(Modules.override(new EmfUiModule(this))
				.with(new ExtQManagerRuntimeModule()))
				.with(new SharedStateModule()));		
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		try {
			initializeEcoreInjector();
		} catch(Exception e) {
//			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		injector = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExtQManagerManagerActivator getDefault() {
		return plugin;
	}
	
	
	public List<ExternalQueryConfigurationService> getExtQConfigServices() {
		if(extQConfigServices == null){
			loadExtQCOnfigServices();
		}
		return extQConfigServices;
	}

	private void loadExtQCOnfigServices() {
		extQConfigServices = new ArrayList<ExternalQueryConfigurationService>();
        IConfigurationElement[] extQServices = EclipseTools.getConfigurationElementsFor(
                EclipseTools.getConfigurationElementsFor(PLUGIN_ID, "ExtQConfigService"), "extQService");
        for(IConfigurationElement configElement : extQServices){
            // There should be only one Module.
            String extQServiceClassName = configElement.getAttribute("class");
            Class<ExternalQueryConfigurationService> extQServiceClass = EclipseTools.findClass(configElement, extQServiceClassName);
            ExternalQueryConfigurationService service = EclipseTools.getNewInstance(extQServiceClass);
            if(service != null){
                System.out.println("ExtQConfigService " + extQServiceClass.getName() 
                				+ " from " + configElement.getNamespaceIdentifier()); 
                extQConfigServices.add(service);
            }
        	
        }
		
	}

	
	

}
