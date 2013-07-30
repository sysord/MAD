package com.sysord.acceleo.tools.generator;

import java.io.File;
import java.util.List;

import org.eclipse.acceleo.engine.event.IAcceleoTextGenerationListener;
import org.eclipse.acceleo.engine.generation.strategy.IAcceleoGenerationStrategy;
import org.eclipse.acceleo.engine.internal.environment.AcceleoEnvironmentFactory;
import org.eclipse.acceleo.engine.internal.environment.AcceleoPropertiesLookup;
import org.eclipse.acceleo.engine.internal.evaluation.AcceleoEvaluationContext;
import org.eclipse.acceleo.model.mtl.Module;
import org.eclipse.emf.common.util.Monitor;

/**
 * AcceleoEnvironmentFactory who exposes the current {@link AcceleoEvaluationContext}
 * in a thread local.
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class AcceleoEnvironmentFactory2 extends AcceleoEnvironmentFactory {

	public AcceleoEnvironmentFactory2(File generationRoot, Module module, List<IAcceleoTextGenerationListener> listeners, AcceleoPropertiesLookup properties,
			IAcceleoGenerationStrategy strategy, Monitor monitor) {
		super(generationRoot, module, listeners, properties, strategy, monitor);
		
		//Register context in thread local
		CurrentAcceleoEvaluationContext.setEvaluationContext(context);
	}

	@Override
	public void dispose() {
		//Remove context from thread local
		CurrentAcceleoEvaluationContext.releaseEvaluationContext();
		super.dispose();
	}

	
	
}
