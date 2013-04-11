
package com.sysord.mad.configuration;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MadConfigDslStandaloneSetup extends MadConfigDslStandaloneSetupGenerated{

	public static void doSetup() {
		new MadConfigDslStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

