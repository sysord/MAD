package com.sysord.mad.evaluator.impl.ocl.customization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;


@Target(value= {ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface OCLTypeDef {
	
	/**
	 * When type is an OCL container, define the container type
	 * the element type will be defined by ePackage and eClassifierJavaInterface
	 * @return
	 */
	OCL_CONTAINER_TYPE containerType() default OCL_CONTAINER_TYPE.NONE;
	
	/**
	 * EPackage owning the for ECLasssifier
	 * @return
	 */
	Class<? extends EPackage> ePackage();
	
	/**
	 * EClassifier java interface
	 * @return
	 */
	Class<?> eClassifierJavaInterface();
	
	/**
	 * false if the annotation is really set (not a mandatory value) 
	 * if true annotation will not be processed. 
	 * @return
	 */
	boolean ignore() default false;
}
