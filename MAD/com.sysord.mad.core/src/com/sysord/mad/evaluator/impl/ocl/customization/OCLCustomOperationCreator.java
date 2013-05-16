package com.sysord.mad.evaluator.impl.ocl.customization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

@Target(value= {ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OCLCustomOperationCreator {
	String name();
}
