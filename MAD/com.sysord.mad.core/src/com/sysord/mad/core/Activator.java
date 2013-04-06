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
package com.sysord.mad.core;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.google.inject.*;
import com.sysord.eclipse.tools.EclipseTools;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.evaluator.QueryEvaluatorProvider;
import com.sysord.mad.evaluator.impl.ocl.OCLQueryEvaluator;

/**
 * Activator for the MAD Core plugin.
 */
public class Activator extends AbstractUIPlugin {

	// The shared instance
	private static Activator plugin;

	// Guice Injector
	private Injector injector;

	// Logger
	private static final Logger logger = Logger.getLogger(Activator.class);

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		_init();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public Injector getInjector() {
		if (injector == null) {
			injector = createInjector();
		}
		return injector;
	}

	public ImageDescriptor getImageDescriptor(String imagePath) {
		return EclipseTools.getImageDescriptorFromPlugin(this, imagePath);
	}

	protected Injector createInjector() {
		try {
			Module module = getModule();
			return Guice.createInjector(module);
		} catch (Exception e) {
			logger.error("Failed to create injector for MAD");
			logger.error(e.getMessage(), e);
			throw new RuntimeException("Failed to create injector for MAD", e);
		}
	}

	private void _init() {
		// init the configuration manager
		getInjector().getInstance(ConfigurationManager.class).initialize();

		QueryEvaluatorProvider queryEvaluatorProvider = getInjector().getInstance(QueryEvaluatorProvider.class);

		// Registering default OCL query evaluator
		queryEvaluatorProvider.registerQueryEvaluator(new OCLQueryEvaluator());
	}

	private Module getModule() {
		Module module = null;
		IConfigurationElement[] modules = EclipseTools.getConfigurationElementsFor(
				EclipseTools.getConfigurationElementsFor(IMADConstants.PLUGIN_ID, IMADConstants.MAD_EXTENSION_ID),
				IMADConstants.MAD_EXT_MODULE);
		if (modules.length > 0) {
			// There should be only one Module.
			String moduleClassName = modules[0].getAttribute("class");
			Class<Module> moduleClass = EclipseTools.findClass(modules[0], moduleClassName);
			module = EclipseTools.getNewInstance(moduleClass);
			System.out.println("Getting module from " + modules[0].getNamespaceIdentifier());
		}
		if (module == null) {
			module = new MadDefaultModule();
			System.out.println("Getting MAD Default Module");
		}
		return module;
	}

	/**
	 * Logs the given {@link Exception exception}.
	 * 
	 * @param exception The {@code exception} to log.
	 */
	public static void log(Exception exception) {
		log(exception.getMessage(), IStatus.ERROR, exception);
	}

	/**
	 * Logs the given message with the specified {@code severity}.
	 * <p>
	 * The {@code severity} is one of :
	 * <ul>
	 * <li>{@link IStatus#INFO}</li>
	 * <li>{@link IStatus#WARNING}</li>
	 * <li>{@link IStatus#ERROR}</li>
	 * </ul>
	 * 
	 * @param message The message to log.
	 * @param severity The severity of the message.
	 */
	public static void log(String message, int severity) {
		log(message, severity, null);
	}

	/**
	 * Logs the given message with the specified {@code severity} and {@link Exception
	 * exception}.
	 * <p>
	 * The {@code severity} is one of :
	 * <ul>
	 * <li>{@link IStatus#INFO}</li>
	 * <li>{@link IStatus#WARNING}</li>
	 * <li>{@link IStatus#ERROR}</li>
	 * </ul>
	 * The {@code exception} can be {@code null}.
	 * 
	 * @param message The message to log.
	 * @param severity The severity of the message.
	 * @param exception The originating exception.
	 */
	public static void log(String message, int severity, Exception exception) {
		ILog log = getDefault().getLog();
		IStatus status = new Status(severity, IMADConstants.PLUGIN_ID, message, exception);
		log.log(status);
	}

}
