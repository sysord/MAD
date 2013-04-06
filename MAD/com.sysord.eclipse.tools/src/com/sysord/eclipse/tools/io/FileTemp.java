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
package com.sysord.eclipse.tools.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.UUID;

/**
 * Create a {@link File file} from an {@link InputStream} by copying the content of the
 * {@code InputStream} into the given temporary file.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class FileTemp extends File {

	private static final long serialVersionUID = 1L;

	/**
	 * The {@link InputStream} of this file.
	 */
	protected InputStream inputStream;

	/**
	 * The temporary {@link File file} containing the content of the {@link InputStream}.
	 */
	protected File tempFile;

	// Indicates if the input stream is loaded into the cache file.
	private boolean loaded;

	/**
	 * Creates a new {@code FileTemp} by copying the content of the given
	 * {@link InputStream} into the specified file.
	 */
	public FileTemp(InputStream inputStream, File tempFile) {
		this(inputStream, tempFile, false);
	}

	/**
	 * Creates a new {@code FileTemp}.
	 * <p>
	 * If {@code addSuffix} is {@code true}, the cache file wille be the given file name
	 * and an auto generated suffix.
	 */
	public FileTemp(InputStream inputStream, File tempFile, boolean addSuffix) {
		super(genPath(tempFile.getAbsolutePath(), addSuffix));
		this.inputStream = inputStream;
		this.tempFile = tempFile;
	}

	private static String genPath(String absolutePath, boolean addSuffix) {
		if (addSuffix) {
			StringBuilder path = new StringBuilder(absolutePath);
			int insertionPoint = absolutePath.lastIndexOf('.');
			insertionPoint = insertionPoint < 0 ? path.length() - 1 : insertionPoint;
			path.replace(insertionPoint, insertionPoint, "_" + UUID.randomUUID());
		}
		return absolutePath;
	}

	@Override
	public String getName() {
		load();
		return tempFile.getName();
	}

	@Override
	public String getParent() {
		load();
		return tempFile.getParent();
	}

	@Override
	public File getParentFile() {
		load();
		return tempFile.getParentFile();
	}

	@Override
	public String getPath() {
		load();
		return tempFile.getPath();
	}

	@Override
	public boolean isAbsolute() {
		load();
		return tempFile.isAbsolute();
	}

	@Override
	public String getAbsolutePath() {
		load();
		return tempFile.getAbsolutePath();
	}

	@Override
	public File getAbsoluteFile() {
		load();
		return tempFile.getAbsoluteFile();
	}

	@Override
	public String getCanonicalPath() throws IOException {
		load();
		return tempFile.getCanonicalPath();
	}

	@Override
	public File getCanonicalFile() throws IOException {
		load();
		return tempFile.getCanonicalFile();
	}

	@Override
	@SuppressWarnings("deprecation")
	public URL toURL() throws MalformedURLException {
		load();
		return tempFile.toURL();
	}

	@Override
	public URI toURI() {
		load();
		return tempFile.toURI();
	}

	@Override
	public boolean canRead() {
		load();
		return tempFile.canRead();
	}

	/**
	 * Returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean canWrite() {
		return false;
	}

	@Override
	public boolean exists() {
		load();
		return tempFile.exists();
	}

	@Override
	public boolean isDirectory() {
		load();
		return tempFile.isDirectory();
	}

	@Override
	public boolean isFile() {
		load();
		return tempFile.isFile();
	}

	@Override
	public boolean isHidden() {
		load();
		return tempFile.isHidden();
	}

	@Override
	public long lastModified() {
		load();
		return tempFile.lastModified();
	}

	@Override
	public long length() {
		load();
		return tempFile.length();
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean createNewFile() throws IOException {
		return false;
	}

	@Override
	public boolean delete() {
		load();
		return tempFile.delete();
	}

	@Override
	public void deleteOnExit() {
		load();
		tempFile.deleteOnExit();
	}

	@Override
	public String[] list() {
		load();
		return tempFile.list();
	}

	@Override
	public String[] list(FilenameFilter filter) {
		load();
		return tempFile.list(filter);
	}

	@Override
	public File[] listFiles() {
		load();
		return tempFile.listFiles();
	}

	@Override
	public File[] listFiles(FilenameFilter filter) {
		load();
		return tempFile.listFiles(filter);
	}

	@Override
	public File[] listFiles(FileFilter filter) {
		load();
		return tempFile.listFiles(filter);
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean mkdir() {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean mkdirs() {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean renameTo(File dest) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setLastModified(long time) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setReadOnly() {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setWritable(boolean writable, boolean ownerOnly) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setWritable(boolean writable) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setReadable(boolean readable, boolean ownerOnly) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setReadable(boolean readable) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setExecutable(boolean executable, boolean ownerOnly) {
		return false;
	}

	/**
	 * Does nothing and returns always {@code false}.
	 * 
	 * @return {@code false}.
	 */
	@Override
	public boolean setExecutable(boolean executable) {
		return false;
	}

	@Override
	public boolean canExecute() {
		load();
		return tempFile.canExecute();
	}

	@Override
	public long getTotalSpace() {
		load();
		return tempFile.getTotalSpace();
	}

	@Override
	public long getFreeSpace() {
		load();
		return tempFile.getFreeSpace();
	}

	@Override
	public long getUsableSpace() {
		load();
		return tempFile.getUsableSpace();
	}

	@Override
	public int compareTo(File pathname) {
		load();
		return tempFile.compareTo(pathname);
	}

	@Override
	public boolean equals(Object obj) {
		load();
		return tempFile.equals(obj);
	}

	@Override
	public int hashCode() {
		load();
		return tempFile.hashCode();
	}

	@Override
	public String toString() {
		load();
		return tempFile.toString();
	}

	/**
	 * Loads the content of the {@link InputStream}.
	 */
	protected void load() {
		if (!loaded) {
			loaded = true;
			if (!tempFile.isDirectory()) {
				try {
					if (!tempFile.exists()) {
						tempFile.createNewFile();
					}
					copyFileContent(inputStream, tempFile);
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						inputStream.close();
					} catch (IOException e) {
						// Ignore
					}
				}
			} else {
				// TODO Create cache file for directory
			}
		}
	}

	/**
	 * Copies the content from the given {@link InputStream} into the specified
	 * {@link File file}.
	 * 
	 * @param inputStream InputStream from which copying the content.
	 * @param cacheFile File into which copying the content.
	 * @throws IOException
	 */
	public static void copyFileContent(InputStream inputStream, File cacheFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(cacheFile);
		byte[] buffer = new byte[1024];
		try {
			int len = 0;
			while ((len = inputStream.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// Ignore
			}
		}
	}
}
