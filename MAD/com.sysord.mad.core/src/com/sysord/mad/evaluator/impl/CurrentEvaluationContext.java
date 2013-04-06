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
package com.sysord.mad.evaluator.impl;

import com.sysord.mad.evaluator.EvaluationAnalyze;

public class CurrentEvaluationContext {
	
	private static ThreadLocal<EvaluationAnalyze> threadlocal = new ThreadLocal<EvaluationAnalyze>();

	public static void setEvaluationAnalyze(EvaluationAnalyze evalAnalyze){
		threadlocal.set(evalAnalyze);
	}

	public static EvaluationAnalyze getEvaluationAnalyze(){
		return threadlocal.get();
	}

	public static void releaseEvaluationAnalyser(){
		threadlocal.remove();
	}

}
