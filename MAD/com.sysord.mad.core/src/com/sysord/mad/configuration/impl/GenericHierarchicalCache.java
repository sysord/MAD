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
package com.sysord.mad.configuration.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericHierarchicalCache<T> {

	protected Map<Object,Object> root = new HashMap<Object, Object>();

	public void flush(){
		root.clear();
	}

	public boolean containsItem(Object key){
		return getItem(key) != null;
	}

	public boolean containsItem(List<Object> key){
		return getItem(key) != null;
	}

	public T getItem(Object key){
		return getItem(Arrays.asList(key));
	}

	public T getItem(List<Object> key){
		Map<Object,Object> currentLevel = root;
		for(int i = 0; i < key.size(); i++){
			Object keyFragment = key.get(i);
			if(i == key.size() - 1){
				//the last
				return (T) currentLevel.get(keyFragment);
			}else{
				//reach next level
				currentLevel = (Map<Object, Object>) currentLevel.get(keyFragment);
				if(currentLevel == null){
					return null;
				}
			}			
		}
		return null;
	}

	public void storeItem(Object key, T item){
		storeItem(Arrays.asList(key), item);
	}

	public void storeItem(List<Object> key, T item){
		Map<Object,Object> currentLevel = root;
		for(int i = 0; i < key.size(); i++){
			Object keyFragment = key.get(i);
			if(i == key.size() - 1){
				//the last
				currentLevel.put(keyFragment, item);
			}else{
				//reach next level
				Map<Object,Object> nextLevel = (Map<Object, Object>) currentLevel.get(keyFragment);
				if(nextLevel == null){
					nextLevel = new HashMap<Object, Object>();
					currentLevel.put(keyFragment, nextLevel);
				}
				currentLevel = nextLevel;
			}			
		}
	}
	
	
}
