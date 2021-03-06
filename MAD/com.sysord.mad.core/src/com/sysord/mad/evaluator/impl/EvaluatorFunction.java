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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for mapping
 * functions to java method for a query evaluator 
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
@Target(value= {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EvaluatorFunction {
	String name() default "";	
}
