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
package com.sysord.mad.evaluator.impl.ocl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

import com.sysord.mad.evaluator.impl.ocl.OCLCustomisationHelper.OCLOperationDefinition;
import com.sysord.mad.evaluator.impl.ocl.OCLCustomisationHelper.OCLTypedElementDefinition;

/**
 * Custom environment for add new EOperation to OCL
 *
 * 
 * @author philippe.palau@sysord.com
 * http://www.sysord.com
 *
 */
public class MadEcoreEnvironment extends MadOCLEcoreEnvironment {

	public static final String MAD_ENVIRONMENT_ID = "MADEnvironment";

	
	
	public MadEcoreEnvironment(EcoreEnvironmentFactory fac, Resource resource) {
		super(fac, resource);
	}

	public MadEcoreEnvironment(MadEcoreEnvironment parent) {
		super(parent);
	}
	
	protected String getCustomEnvironmentId(){
		return MAD_ENVIRONMENT_ID;
	}



}
