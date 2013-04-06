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
package com.sysord.mad.core;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.sysord.eclipse.tools.nls.I18nService;
import com.sysord.eclipse.tools.nls.I18nServiceImpl;
import com.sysord.eclipse.tools.runtime.ConsoleLogger;
import com.sysord.emf.tools.misc.EMFImageProvider;
import com.sysord.mad.configuration.ConfigurationManager;
import com.sysord.mad.configuration.LayerManager;
import com.sysord.mad.configuration.extension.ExternalQueryConfigurationServiceProvider;
import com.sysord.mad.configuration.impl.ConfigurationManagerImpl;
import com.sysord.mad.configuration.impl.LayerManagerImpl;
import com.sysord.mad.converter.ValueConverterFactory;
import com.sysord.mad.emitter.ViewEmitter;
import com.sysord.mad.emitter.ViewHolder;
import com.sysord.mad.emitter.WidgetFactory;
import com.sysord.mad.emitter.impl.ViewEmitterImpl;
import com.sysord.mad.emitter.impl.ViewHolderImpl;
import com.sysord.mad.emitter.impl.WidgetFactoryImpl;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluationContextFactory;
import com.sysord.mad.evaluator.QueryEvaluationService;
import com.sysord.mad.evaluator.QueryEvaluatorProvider;
import com.sysord.mad.evaluator.impl.FormatExpressionEvaluationServiceImpl;
import com.sysord.mad.evaluator.impl.QueryEvaluationServiceImpl;
import com.sysord.mad.evaluator.impl.QueryEvaluatorProviderImpl;
import com.sysord.mad.evaluator.impl.mad.MadMacrosEvaluatorV1;
import com.sysord.mad.log.MADLoggerImpl;
import com.sysord.mad.mao.ModelAccessObject;
import com.sysord.mad.mao.TransactionalCommandProvider;
import com.sysord.mad.mao.impl.MadWidgetCommandFactory;
import com.sysord.mad.mao.impl.ModelAccessObjectImpl;
import com.sysord.mad.mao.impl.TransactionalCommandProviderImpl;
import com.sysord.mad.model.cache.ModelCache;
import com.sysord.mad.model.cache.ModelCacheImpl;
import com.sysord.mad.model.provider.ModelProviderFactory;
import com.sysord.mad.model.provider.ModelProviderService;
import com.sysord.mad.model.provider.impl.ModelProviderFactoryImpl;
import com.sysord.mad.model.provider.impl.ModelProviderServiceImpl;
import com.sysord.mad.model.provider.impl.URIExtenderModelProvider;
import com.sysord.mad.model.provider.impl.URIModelProvider;
import com.sysord.mad.query.impl.DefaultQueryEvaluationContextFactory;
import com.sysord.mad.structure.MadAttributesFactory;
import com.sysord.mad.structure.MadAttributesFactoryImpl;
import com.sysord.mad.uicommand.MadUICommandService;
import com.sysord.mad.uicommand.impl.MadUICommandServiceImpl;
import com.sysord.mad.validator.WidgetValueValidationService;
import com.sysord.mad.validator.impl.WidgetValueValidationServiceImpl;
import com.sysord.mad.widget.WidgetBuilder;
import com.sysord.mad.widget.impl.WidgetBuilderImpl;

public class MadDefaultModule implements Module {

	@Override
	public void configure(Binder binder) {
		
		//----------------
		// Configuration
		//----------------		
		// Configuration manager
	    bindConfigurationManager(binder);
		// Configuration manager
	    bindLayerManager(binder);

		// I18N
	    bindI18NService(binder);

	    
		//----------------
		// Model Cache
		//----------------
	    bindModelCache(binder);

	    //----------------
		// Model Provider
		//----------------
	    bindModelProviderFactory(binder);
	    bindURIModelProvider(binder);
	    bindURIExtenderModelProvider(binder);
	    
		bindModelProviderService(binder);

		//--------------
		// MAD Services
		//--------------
		bindMadAttributesFactory(binder);
		

		//-----------
		// Evaluator
		//-----------
		bindQueryEvaluatorProvider(binder);
		bindextQServiceProvider(binder);
		bindQueryEvaluationService(binder);
		bindMadMacrosEvaluator(binder);
	    bindFormatExpressionEvaluation(binder);
				
		//MAO
		bindModelAccessObject(binder);
		bindTransactionalCommandProvider(binder);
		
		// EMF ItemProviderAdapter provider
        bindEMFItemProviderAdapterProvider(binder);
		
		// WidgetBuilder
		bindWidgetBuilder(binder);

		//Command
		bindMADCommandFactory(binder);
		
		// ViewBuilder
		bindViewBuilder(binder);
		// ViewHolder
		bindViewHolder(binder);
		// ViewEmitter
		bindViewEmitter(binder);
		// WidgetFactory
		bindWidgetFactory(binder);
		
		// Widget Value Converter Factory
		bindValueConverterFactory(binder);

		// Widget Validation
		bindValidationService(binder);
		
		//UI Command
		bindMadUICommandService(binder);

		
		// MAD Logger
		bindLogger(binder);
	}

	protected void bindLayerManager(Binder binder) {
        binder.bind(LayerManager.class).to(LayerManagerImpl.class).asEagerSingleton();
    }

    protected void bindConfigurationManager(Binder binder) {
        binder.bind(ConfigurationManager.class).to(ConfigurationManagerImpl.class).asEagerSingleton();
    }

    protected void bindI18NService(Binder binder) {
    	//Eclipse tools I18N Service
        binder.bind(I18nService.class).to(I18nServiceImpl.class).asEagerSingleton();
	}

    protected void bindModelCache(Binder binder) {
        binder.bind(ModelCache.class).to(ModelCacheImpl.class).asEagerSingleton();		
	}
    
    protected void bindModelProviderFactory(Binder binder) {
        binder.bind(ModelProviderFactory.class).to(ModelProviderFactoryImpl.class).asEagerSingleton();
    }
    
    protected void bindURIModelProvider(Binder binder) {
        binder.bind(URIModelProvider.class);
    }
    
    protected void bindURIExtenderModelProvider(Binder binder) {
        binder.bind(URIExtenderModelProvider.class);
    }
    
    protected void bindModelProviderService(Binder binder) {
        binder.bind(ModelProviderService.class).to(ModelProviderServiceImpl.class).asEagerSingleton();
    }
    
    protected void bindMadAttributesFactory(Binder binder) {
        binder.bind(MadAttributesFactory.class).to(MadAttributesFactoryImpl.class).asEagerSingleton();
    }
    
    protected void bindQueryEvaluatorProvider(Binder binder) {
        binder.bind(QueryEvaluatorProvider.class).to(QueryEvaluatorProviderImpl.class).asEagerSingleton();
    }
    
	private void bindextQServiceProvider(Binder binder) {
		binder.bind(ExternalQueryConfigurationServiceProvider.class);
	}

    
    protected void bindQueryEvaluationService(Binder binder) {
        binder.bind(QueryEvaluationService.class).to(QueryEvaluationServiceImpl.class).asEagerSingleton();
        binder.bind(QueryEvaluationContextFactory.class).to(DefaultQueryEvaluationContextFactory.class).asEagerSingleton();
        
    }
    
    protected void bindMadMacrosEvaluator(Binder binder) {
        binder.bind(MadMacrosEvaluatorV1.class);
    }

    protected void bindFormatExpressionEvaluation(Binder binder) {
        binder.bind(FormatExpressionEvaluationService.class).to(FormatExpressionEvaluationServiceImpl.class).asEagerSingleton();
	}

    
    protected void bindModelAccessObject(Binder binder) {
        binder.bind(ModelAccessObject.class).to(ModelAccessObjectImpl.class).asEagerSingleton();
    }
    
	protected void bindMADCommandFactory(Binder binder) {
		binder.bind(MadWidgetCommandFactory.class);
	}

    protected void bindTransactionalCommandProvider(Binder binder) {
        binder.bind(TransactionalCommandProvider.class).to(TransactionalCommandProviderImpl.class).asEagerSingleton();
    }
	
	protected void bindEMFItemProviderAdapterProvider(Binder binder) {
        binder.bind(EMFImageProvider.class);
	}
    
    protected void bindWidgetBuilder(Binder binder) {
        binder.bind(WidgetBuilder.class).to(WidgetBuilderImpl.class).asEagerSingleton();
    }
    
    protected void bindViewBuilder(Binder binder) {
        // Must be overridden in subclasses.
    }
    
    protected void bindViewHolder(Binder binder) {
        binder.bind(ViewHolder.class).to(ViewHolderImpl.class);
    }
    
    protected void bindViewEmitter(Binder binder) {
        binder.bind(ViewEmitter.class).to(ViewEmitterImpl.class);
    }
    
    protected void bindWidgetFactory(Binder binder) {
        binder.bind(WidgetFactory.class).to(WidgetFactoryImpl.class);
    }
    
    protected void bindMadUICommandService(Binder binder) {
        binder.bind(MadUICommandService.class).to(MadUICommandServiceImpl.class).asEagerSingleton();
	}

	private void bindValidationService(Binder binder) {
        binder.bind(WidgetValueValidationService.class).to(WidgetValueValidationServiceImpl.class).asEagerSingleton();
	}

    protected void bindValueConverterFactory(Binder binder) {
        binder.bind(ValueConverterFactory.class);
    }

    protected void bindLogger(Binder binder) {
        binder.bind(ConsoleLogger.class).to(MADLoggerImpl.class).asEagerSingleton();
    }

}
