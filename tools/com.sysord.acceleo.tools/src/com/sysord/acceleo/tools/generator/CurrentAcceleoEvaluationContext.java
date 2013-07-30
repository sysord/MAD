package com.sysord.acceleo.tools.generator;

import org.eclipse.acceleo.engine.internal.evaluation.AcceleoEvaluationContext;

/**
 * Thread local for exposing the current {@link AcceleoEvaluationContext}
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class CurrentAcceleoEvaluationContext {

	protected static InheritableThreadLocal<AcceleoEvaluationContext<?>> threadLocalContext = new InheritableThreadLocal<AcceleoEvaluationContext<?>>();

	public static AcceleoEvaluationContext<?> getEvaluationContext() {
		return threadLocalContext.get();
	}

	public static void setEvaluationContext(AcceleoEvaluationContext<?> value) {
		threadLocalContext.set(value);
	}

	public static void releaseEvaluationContext() {
		threadLocalContext.remove();
	}
	
	
	
}
