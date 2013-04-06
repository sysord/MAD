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
package com.sysord.mad.configuration;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;

import com.sysord.mad.configuration.madConfigDsl.MADConfiguration;
import com.sysord.mad.evaluator.FormatExpressionEvaluationService;

/**
 * Extract editor configuration for a model element type.
 * 
 * @author philippe.palau@sysord.com
 *         http://www.sysord.com
 */
public interface ConfigurationManager {

	/**
	 * Main Layer ID
	 */
	public static final String MAIN_LAYER = "**MAIN_LAYER**";

	/**
	 * Default Mad config
	 */
	public static final String DEFAULT_MAD_CONFIG = "DEFAULT_MAD_CONFIG";

	/**
	 * Main Layer ID
	 */
	public static final String I18N_PREFIX = "@I18N:";

	/**
	 * Initializes this {@code ConfigurationManager}.
	 */
	public void initialize();
	
	/**
	 * Reloads all the registered configurations.
	 */
	public void reloadConfigurations();

	/**
	 * Extracts the configuration of the given type from the mad configuration repository.
	 * 
	 * @param type Type of the element for which we want the MAD configuration.
	 * @return the MAD configuration of the given type or {@code null} if no configuration
	 *         exists for the element type.
	 */
	public TypeConfiguration getConfiguration(EClass type);

	/**
	 * Returns the label provider expression for the given type.
	 * <p>
	 * This is a format expression usable for all MAD configuration labels (see
	 * {@link FormatExpressionEvaluationService} for more details).
	 * 
	 * @param type Type of the element for which we want the label provider expression.
	 * @return the label provider expression for the given type.
	 */
	public String getLabelProviderExpressionForType(EClass type);

	/**
	 * Returns the root layer.
	 * <p>
	 * There is always a main layer, this is the default layer implicitly created by the
	 * configuration.
	 * 
	 * @return the root layer.
	 */
	public Layer getMainLayer();

	/**
	 * Returns the layer with the given {@code ID}, or {@code null} if no layer exists
	 * with this id.
	 * 
	 * @param layerId The ID of the layer to retrieve.
	 * @return The layer with the given {@code ID}, or {@code null}.
	 */
	public Layer getLayerById(String layerId);

	/**
	 * Returns all the {@link URI}s used in the declared MAD configurations.
	 * 
	 * @return all the used {@link URI}s.
	 */
	public Collection<URI> getImportedURIs();

	/**
	 * Returns the {@link URI}s used by the given MAD configuration.
	 * 
	 * @param madConfig The configuration from which we want the used {@code URI}s.
	 * @return the {@link URI}s used by the given MAD configuration.
	 */
	public Collection<URI> getImportedURIs(MADConfiguration madConfig);

	/**
	 * Returns all the {@code NS URI} used in the declared MAD configurations.
	 * 
	 * @return all the used {@code NS URI}.
	 */
	public Collection<String> getImportedResourcesNsURIs();

	/**
	 * Returns the {@code NS URI} used by the given MAD configuration.
	 * 
	 * @return the {@code NS URI} used by the given MAD configuration.
	 */
	public Collection<String> getImportedResourcesNsURIs(MADConfiguration madConfig);

	/**
	 * Adds the given {@link ConfigurationManagerListener} to this
	 * {@code ConfigurationManager}.
	 * 
	 * @param listener The listener to add.
	 */
	public void addListener(ConfigurationManagerListener listener);

	/**
	 * Removes the given {@link ConfigurationManagerListener} from this
	 * {@code ConfigurationManager}.
	 * 
	 * @param listener The listener to remove.
	 */
	public void removeListener(ConfigurationManagerListener listener);

	/**
	 * Listener for configuration chain notification.
	 */
	public interface ConfigurationManagerListener {

		/**
		 * Notifies this listener the configuration has been reloaded.
		 */
		public void onConfigurationReloaded();

		/**
		 * Notification about an invalid <em>.mad</em> configuration file.
		 * 
		 * @param respourceUri URI of the invalid resource.
		 * @param message Message of the problem.
		 */
		public void onInvalidMadConfiguration(String respourceUri, String message);
	}

}
