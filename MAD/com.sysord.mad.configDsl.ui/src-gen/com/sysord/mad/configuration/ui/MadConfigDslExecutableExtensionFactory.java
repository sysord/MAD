/*
 * generated by Xtext
 */
package com.sysord.mad.configuration.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import com.sysord.mad.configuration.ui.internal.MadConfigDslActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MadConfigDslExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MadConfigDslActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MadConfigDslActivator.getInstance().getInjector(MadConfigDslActivator.COM_SYSORD_MAD_CONFIGURATION_MADCONFIGDSL);
	}
	
}
