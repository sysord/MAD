package com.sysord.mad.configuration.extension;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.QualifiedName;

public interface ExternalQueryConfigurationService {

	/**
	 * Selects only supported external query from candidates
	 * 
	 * @param candidates 
	 * @return
	 */
	public Collection<EObject> selectQueries(Collection<EObject> candidates);
	
	
	public List<EClass> getQueriesEClass();
	
	/**
	 * Provides a Qualified name for the element
	 * @param element
	 * @return the Qualified name if element is an external Query, null otherwise
	 */
	public QualifiedName qualifiedName(EObject element);
	
	
	/**
	 * Returns the label for the query element
	 * @param element
	 * @return
	 */
	public String getQueryLabel(EObject element);

	/**
	 * Returns the label for the call query element
	 * @param element
	 * @return
	 */
	public String getQueryCallExpr(EObject element);


	//TODO: add after Query Evaluation service externalization
	//public QueryEvaluationContextFactory getQueryEvaluationContextFactory();



}
