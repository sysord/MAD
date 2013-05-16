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
package com.sysord.mad.type;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.tools.JavaCompiler;

import org.eclipse.emf.ecore.EObject;

import com.sysord.mad.type.TypeDescriptor.TYPE_CATEGORY;

public class TypeDescriptorUtil {

	public static final TypeDescriptor UNKNOW_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.UNKNOW, null, null);
	public static final TypeDescriptor NULL_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.NULL, null, null);
	public static final TypeDescriptor STRING_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.STRING, String.class, null);
	public static final TypeDescriptor BOOLEAN_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.BOOLEAN, Boolean.class, null);
	public static final TypeDescriptor DATE_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.DATE, java.util.Date.class, null);

	public static final TypeDescriptor INTEGER_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.INTEGER, Integer.class, null);
	public static final TypeDescriptor LONG_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.LONG, Long.class, null);
	public static final TypeDescriptor FLOAT_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.FLOAT, Float.class, null);
	public static final TypeDescriptor DOUBLE_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.DOUBLE, Float.class, null);

	public static final TypeDescriptor OBJECT_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.OBJECT, Object.class, null);

	public static final TypeDescriptor OBJECT_SEQUENCE_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.SEQUENCE, Object.class, null).setItemTypeDescriptor(OBJECT_TYPE);
	public static final TypeDescriptor OBJECT_SET_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.SET, Object.class, null).setItemTypeDescriptor(OBJECT_TYPE);
	public static final TypeDescriptor OBJECT_ORDEREDSET_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.ORDERED_SET, Object.class, null).setItemTypeDescriptor(OBJECT_TYPE);
	public static final TypeDescriptor OBJECT_BAG_TYPE = new TypeDescriptorImpl(TYPE_CATEGORY.BAG, Object.class, null).setItemTypeDescriptor(OBJECT_TYPE);

	/**
	 * Create type descriptor for an object
	 * if object is a collection, contained type will be Object.
	 * @param object
	 * @return
	 */
	public static TypeDescriptor createTypeDescriptor(Object object){
		if(object == null){
			return NULL_TYPE;
		}else if(EObject.class.isAssignableFrom(object.getClass())){
			return new TypeDescriptorImpl(TYPE_CATEGORY.EOBJECT, object.getClass(), ((EObject)object).eClass());			
		}else if(Collection.class.isAssignableFrom(object.getClass())){			
			if(List.class.isAssignableFrom(object.getClass())){
				return new TypeDescriptorImpl(TYPE_CATEGORY.SEQUENCE, object.getClass(), null).setItemTypeDescriptor(OBJECT_TYPE);
			}else if(Set.class.isAssignableFrom(object.getClass())){
				return new TypeDescriptorImpl(TYPE_CATEGORY.SET, object.getClass(), null).setItemTypeDescriptor(OBJECT_TYPE);
			}						
		}else if(object instanceof String){
			return STRING_TYPE;
		}else if(object instanceof Boolean){
			return BOOLEAN_TYPE;
		}else if(object instanceof java.util.Date){
			return DATE_TYPE;			
		}else if(object instanceof Number){
			if(object instanceof Integer){
				return INTEGER_TYPE;							
			}else if(object instanceof Long){
				return LONG_TYPE;
			}else if(object instanceof Float){
				return FLOAT_TYPE;
			}else if(object instanceof Double){
				return DOUBLE_TYPE;
			}
		}
		
		return new TypeDescriptorImpl(TYPE_CATEGORY.UNKNOW, object.getClass(), null);

	}

//	public static TypeDescriptor createTypeDescriptor(Class clazz){
//		if(clazz == null){
//			return NULL_TYPE;
//		}else if(EObject.class.isAssignableFrom(clazz)){
//			return new TypeDescriptorImpl(TYPE_CATEGORY.EOBJECT, clazz, ((EObject)object).eClass());			
//		}else if(Collection.class.isAssignableFrom(object.getClass())){			
//			if(List.class.isAssignableFrom(object.getClass())){
//				return new TypeDescriptorImpl(TYPE_CATEGORY.SEQUENCE, object.getClass(), null).setItemTypeDescriptor(OBJECT_TYPE);
//			}else if(Set.class.isAssignableFrom(object.getClass())){
//				return new TypeDescriptorImpl(TYPE_CATEGORY.SET, object.getClass(), null).setItemTypeDescriptor(OBJECT_TYPE);
//			}						
//		}else if(object instanceof String){
//			return STRING_TYPE;
//		}else if(object instanceof Boolean){
//			return BOOLEAN_TYPE;
//		}else if(object instanceof java.util.Date){
//			return DATE_TYPE;			
//		}else if(object instanceof Number){
//			if(object instanceof Integer){
//				return INTEGER_TYPE;							
//			}else if(object instanceof Long){
//				return LONG_TYPE;
//			}else if(object instanceof Float){
//				return FLOAT_TYPE;
//			}else if(object instanceof Double){
//				return DOUBLE_TYPE;
//			}
//		}
//		
//		return new TypeDescriptorImpl(TYPE_CATEGORY.UNKNOW, object.getClass(), null);
//
//	}

}
