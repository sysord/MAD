package com.sysord.acceleo.tools.generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.generation.AbstractAcceleoEnvironmentFactory;
import org.eclipse.acceleo.engine.generation.AcceleoEngine;
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.internal.environment.AcceleoEnvironmentFactory;
import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.emf.common.util.Monitor;

/**
 * AcceleoEngine who uses {@link AcceleoEnvironmentFactory2} for exposisng Generation context
 * in the Thread Local.
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class AcceleoEngine2 extends AcceleoEngine {
	
	/**
	 * This will be used to create a clean environment for each generation.
	 * 
	 * @param generationRoot
	 *            Root of the generation for which this environment will be used.
	 * @param rootModule
	 *            Root module of said generation.
	 * @param strategy
	 *            The generation strategy will control the creation of files for this generation.
	 * @param monitor
	 *            Process monitor which will be used to display information to the user about the current
	 *            generation.
	 * @return The created environment (an AcceleoEnvironmentFactory2 whose set the generation 
	 * 			context in the {@link CurrentAcceleoEvaluationContext} thread local.
	 */
	protected AbstractAcceleoEnvironmentFactory createEnvironmentFactory(File generationRoot,
			Module rootModule, IAcceleoGenerationStrategy strategy, Monitor monitor) {
		final List<IAcceleoTextGenerationListener> listenersCopy = new ArrayList<IAcceleoTextGenerationListener>(listeners);
		return new AcceleoEnvironmentFactory2(generationRoot, rootModule, listenersCopy, propertiesLookup, strategy, monitor);
	}
}
