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
package com.sysord.acceleo.tools.module;

import java.util.*;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.ocl.ecore.*;

import com.sysord.acceleo.tools.module.TemplatePrototype.TemplateType;
import com.sysord.acceleo.tools.module.impl.ParameterImpl;
import com.sysord.emf.tools.EmfToolsFacade;

/**
 * Builder for {@link TemplatePrototype}.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class PrototypeBuilder {

    /*
     * OCL Any Type
     */

    public static final EClassifier ANY = EcorePackage.eINSTANCE.getAnyType();

    /*
     * Common primitive types
     */

    public static final PrimitiveType STRING = createPrimitiveType(String.class);
    public static final PrimitiveType BOOLEAN = createPrimitiveType(Boolean.class);
    public static final PrimitiveType INTEGER = createPrimitiveType(Integer.class);
    public static final PrimitiveType LONG = createPrimitiveType(Long.class);
    public static final PrimitiveType FLOAT = createPrimitiveType(Float.class);
    public static final PrimitiveType DOUBLE = createPrimitiveType(Double.class);
    public static final PrimitiveType BYTE = createPrimitiveType(Byte.class);
    public static final PrimitiveType CHARACTER = createPrimitiveType(Character.class);

    // The TemplatePrototype built by this builder
    private TemplatePrototypeImpl buildingPrototype;

    private ParameterImpl lastAddedParameter;
    private boolean returnTypeDefined;

    /**
     * Creates a new {@code PrototypeBuilder}.
     */
    public PrototypeBuilder() {
        buildingPrototype = new TemplatePrototypeImpl();
    }

    /**
     * Defines the name of the {@link TemplatePrototype prototype}.
     * 
     * @param name Name to set to the prototype.
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder setName(String name) {
        buildingPrototype.name = name;
        return this;
    }

    /**
     * Defines the comment describing the {@link TemplatePrototype prototype}.
     * 
     * @param comment
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder setComment(String comment) {
        buildingPrototype.comment = comment;
        return this;
    }

    /**
     * Defines the {@link TemplateType type} of template.
     * 
     * @param type The {@link TemplateType type} of template.
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder setType(TemplateType type) {
        buildingPrototype.type = type;
        return this;
    }

    /**
     * Add a {@link Parameter parameter} defined by the given {@code name} and
     * {@code type}, to the {@link TemplatePrototype prototype}.
     * 
     * @param name Name to set to the prototype.
     * @param type The parameter type.
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder addParameter(String name, EClassifier type) {
        ParameterImpl parameter = new ParameterImpl();
        parameter.setName(name);
        parameter.setType(type);
        buildingPrototype.parameters.add(parameter);
        lastAddedParameter = parameter;
        returnTypeDefined = false;
        return this;
    }

    /**
     * Add a Sequence({@code type}) parameter with the given {@code name} to the
     * {@link TemplatePrototype prototype}.
     * 
     * @param name
     * @param type The sequence item type
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder addSequence(String name, EClassifier type) {
        return addParameter(name, createSequence(type));
    }

    /**
     * Add a Set({@code type}) parameter with the given {@code name} to the
     * {@link TemplatePrototype prototype}.
     * 
     * @param name
     * @param type The set item type
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder addSet(String name, EClassifier type) {
        return addParameter(name, createSet(type));
    }

    /**
     * Add a Bag({@code type}) parameter with the given {@code name} to the
     * {@link TemplatePrototype prototype}.
     * 
     * @param name
     * @param type The bag item type
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder addBag(String name, EClassifier type) {
        return addParameter(name, createBag(type));
    }

    /**
     * Add a OrderedSet({@code type}) parameter with the given {@code name} to the
     * {@link TemplatePrototype prototype}.
     * 
     * @param name
     * @param type The ordered set item type
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder addOrderedSet(String name, EClassifier type) {
        return addParameter(name, createOrderedSet(type));
    }

    /**
     * Defines the return type of the {@link TemplatePrototype prototype}.
     * 
     * @param name Name to set to the prototype.
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder setReturnType(EClassifier returnType) {
        buildingPrototype.returnType = returnType;
        lastAddedParameter = null;
        returnTypeDefined = true;
        return this;
    }

    /**
     * Adds the given comment to the last added parameter or return type.
     * 
     * @param comment The comment to add to a parameter or return type
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder addComment(String comment) {
        if (lastAddedParameter != null) {
            lastAddedParameter.setComment(comment);
            lastAddedParameter = null;
        } else if (returnTypeDefined) {
            buildingPrototype.returnComment = comment;
            returnTypeDefined = false;
        }
        return this;
    }

    /**
     * Defines the given content of the prototype.
     * 
     * @param content The content to define.
     * @return this {@link PrototypeBuilder builder}.
     */
    public PrototypeBuilder setContent(String content) {
        buildingPrototype.content = content;
        return this;
    }

    /**
     * Returns a <strong>deep copy</strong> of the internal built
     * {@link TemplatePrototype prototype}.
     * <p>
     * The returned {@code prototype} is <em>immutable</em>.
     * 
     * @param name Name to set to the prototype.
     * @return the built {@link TemplatePrototype prototype}.
     * @see TemplatePrototype
     */
    public TemplatePrototype create() {
        try {
            return buildingPrototype.clone();
        } catch (CloneNotSupportedException e) {
            // Should never happen, TemplatePrototypeImpl implements Cloneable
            return null;
        }
    }

    /**
     * Creates a {@link SequenceType} with the given element type.
     * 
     * @param name
     * @param type
     * @return a {@link SequenceType} with the given element type.
     */
    public static SequenceType createSequence(EClassifier type) {
        SequenceType sequence = EcoreFactory.eINSTANCE.createSequenceType();
        sequence.setElementType(type);
        sequence.setName(sequence.getName());
        return sequence;
    }

    /**
     * Creates a {@link SetType} with the given element type.
     * 
     * @param name
     * @param type
     * @return a {@link SetType} with the given element type.
     */
    public static SetType createSet(EClassifier type) {
        SetType set = EcoreFactory.eINSTANCE.createSetType();
        set.setElementType(type);
        set.setName(set.getName());
        return set;
    }

    /**
     * Creates a {@link BagType} with the given element type.
     * 
     * @param name
     * @param type
     * @return a {@link BagType} with the given element type.
     */
    public static BagType createBag(EClassifier type) {
        BagType bag = EcoreFactory.eINSTANCE.createBagType();
        bag.setElementType(type);
        bag.setName(bag.getName());
        return bag;
    }

    /**
     * Creates a {@link OrderedSetType} with the given element type.
     * 
     * @param name
     * @param type
     * @return a {@link OrderedSetType} with the given element type.
     */
    public static OrderedSetType createOrderedSet(EClassifier type) {
        OrderedSetType orderedSet = EcoreFactory.eINSTANCE.createOrderedSetType();
        orderedSet.setElementType(type);
        orderedSet.setName(orderedSet.getName());
        return orderedSet;
    }

    /**
     * Creates a {@link PrimitiveType} for the given java {@link Class}.
     * 
     * @param instanceClass
     * @return a {@link PrimitiveType} for the given java {@link Class}.
     */
    public static PrimitiveType createPrimitiveType(Class<?> instanceClass) {
        PrimitiveType type = EcoreFactory.eINSTANCE.createPrimitiveType();
        type.setInstanceClass(instanceClass);
        type.setInstanceClassName(instanceClass.getName());
        type.setInstanceTypeName(instanceClass.getName());
        type.setName(instanceClass.getSimpleName());
        return type;
    }

    /**
     * Creates a {@link PrimitiveType} for the given java {@link Class}.
     * 
     * @param instanceClass
     * @return a {@link PrimitiveType} for the given java {@link Class}.
     */
    public static EDataType createEDataType(Class<?> instanceClass) {
        EDataType type = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE.createEDataType();
        type.setInstanceClass(instanceClass);
        type.setInstanceClassName(instanceClass.getName());
        type.setInstanceTypeName(instanceClass.getName());
        type.setName(instanceClass.getSimpleName());
        return type;
    }

    private static class TemplatePrototypeImpl implements TemplatePrototype, Cloneable {

        private String name;
        private String comment;
        private TemplateType type = TemplateType.TEMPLATE;
        private List<Parameter> parameters;
        private EClassifier returnType;
        private String returnComment;
        private String content;

        // Returned by the parameters getter for avoiding external modifications
        private List<Parameter> parametersExternView;

        /**
         * Creates a new {@code PrototypeBuilder.TemplatePrototypeImpl}.
         */
        public TemplatePrototypeImpl() {
            parameters = new ArrayList<Parameter>(5);
            parametersExternView = Collections.unmodifiableList(parameters);
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getComment() {
            return comment;
        }

        @Override
        public TemplateType getTemplateType() {
            return type;
        }

        @Override
        public List<Parameter> getParameters() {
            return parametersExternView;
        }

        @Override
        public EClassifier getReturnType() {
            return returnType;
        }

        @Override
        public String getReturnComment() {
            return returnComment;
        }

        @Override
        public String getContent() {
            return content;
        }

        @Override
        public boolean equals(Object other) {
            // TODO : Also compare the content ?
            return hasSameParameters(other) && namesAreEqual(other);
        }

        /**
         * Indicates if this prototype's name equals the other's name.
         * 
         * @param other
         * @return {@code true} if this prototype's name equals the other's name;<br>
         *         {@code false} otherwise.
         */
        private boolean namesAreEqual(Object other) {
            if (other == null || !(other instanceof TemplatePrototype))
                return false;
            // else
            TemplatePrototype otherProto = (TemplatePrototype) other;
            return name == otherProto.getName() || name != null ? name.equals(otherProto.getName()) : false;
        }

        @Override
        public boolean hasSameParameters(Object other) {
            if (this == other)
                return true;
            // else
            if (other == null)
                return false;
            // else
            if (!(other instanceof TemplatePrototype))
                return false;
            // else

            TemplatePrototype otherProto = (TemplatePrototype) other;
            if (parameters.size() != otherProto.getParameters().size())
                return false;
            // else

            Iterator<Parameter> thisIter = parameters.iterator();
            Iterator<Parameter> otherIter = otherProto.getParameters().iterator();
            while (thisIter.hasNext()) {
                Parameter thisParam = thisIter.next();
                Parameter otherParam = otherIter.next();
                if (!thisParam.equals(otherParam)) {
                    return false;
                }// else
            }

            return EmfToolsFacade.getInstance().typesEqual(returnType, otherProto.getReturnType());
        }

        /**
         * Create a String representation for the prototype
         * @return
         */
        @Override
        public String toString(){
        	StringBuilder sb = new StringBuilder();
        	sb.append(type.toString()).append("_")
        	.append(name).append("(");
        	for(Parameter parameter : parameters){
        		sb.append(parameter.getType().getInstanceClassName()).append(" ");
        	}
        	sb.append(name).append(")")
        	.append(returnType == null ? "" : ":" + returnType.getInstanceClassName());

        	return sb.toString();
        }
        
        @Override
        protected TemplatePrototype clone() throws CloneNotSupportedException {
            TemplatePrototypeImpl clone = (TemplatePrototypeImpl) super.clone();
            clone.parameters = new ArrayList<Parameter>(parameters.size());
            for (Parameter parameter : parameters) {
                clone.parameters.add(((ParameterImpl) parameter).clone());
            }
            clone.parametersExternView = Collections.unmodifiableList(clone.parameters);
            return clone;
        }
    }
}
