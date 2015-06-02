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
package com.sysord.eclipse.tools;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;

import com.sysord.eclipse.tools.collection.Predicate;
import com.sysord.eclipse.tools.io.FileTemp;
import com.sysord.eclipse.tools.swt.ImageResource;

/**
 * Utility class for eclipse platform.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class EclipseTools {

	/**
	 * Scheme for platforms URI : {@value #PLATFORM_SCHEME}.<br>
	 * 
	 * @since 1.2
	 */
	public static final String PLATFORM_SCHEME = "platform:/"; //$NON-NLS-1$

	/**
	 * Scheme for platform resources : {@value #PLATFORM_RESOURCE}.<br>
	 * (without trailing slash)
	 */
	public static final String PLATFORM_RESOURCE = PLATFORM_SCHEME + "resource"; //$NON-NLS-1$

	/**
	 * Scheme for platform plug-ins : {@value #PLATFORM_PLUGIN}.<br>
	 * (without trailing slash)
	 */
	public static final String PLATFORM_PLUGIN = PLATFORM_SCHEME + "plugin"; //$NON-NLS-1$

	private static String fileSeparatorRegex;

	// Suppresses default constructor, ensuring non-instantiability.
	private EclipseTools() {}

	/**
	 * Returns the class with the specified class name.
	 * 
	 * @param className The name of the class to find.
	 * @return the class with the specified class name.
	 * @throws ClassNotFoundException if the class cannot be located.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> findClass(String className) throws ClassNotFoundException {
		return (Class<T>) Class.forName(className);
	}

	/**
	 * Returns the class with the specified class name contained by the specified
	 * {@link Bundle}.
	 * 
	 * @param bundleId {@link Bundle}'s ID.
	 * @param className The name of the class to find.
	 * @return the class with the specified class name contained by the specified
	 *         {@link Bundle}.
	 * @throws ClassNotFoundException if the bundle or class couldn't be found.
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> findClass(String bundleId, String className) throws ClassNotFoundException {
		Bundle bundle = Platform.getBundle(bundleId);
		if (bundle == null) {
			throw new ClassNotFoundException(L.bind(L.error_noBundleFound, bundleId));
		}
		return (Class<T>) bundle.loadClass(className);
	}

	/**
	 * Returns the class with the specified class name in the
	 * {@link IConfigurationElement} bundle, or {@code null} if the class couldn't be
	 * found.
	 * 
	 * @param configurationElement
	 * @param className
	 * @return the class with the specified class name, or {@code null}.
	 */
	public static <T> Class<T> findClass(IConfigurationElement configurationElement, String className) {
		Class<T> clazz = null;
		try {
			clazz = findClass(className);
		} catch (ClassNotFoundException e) {
			// try another way
			try {
				String declaringID = configurationElement.getContributor().getName();
				clazz = findClass(declaringID, className);
			} catch (ClassNotFoundException e1) {
				return null;
			}
		}
		return clazz;
	}

	/**
	 * Returns the class with the specified name or {@code null} if the class hasn't been
	 * found.
	 * 
	 * @param className The name of the class to find.
	 * @return the class with the specified name; {@code null} if the class hasn't been
	 *         found.
	 */
	public static <T> Class<T> loadClass(String className) {
		try {
			return findClass(className);
		} catch (ClassNotFoundException e) {
			EclipseToolsPlugin.log(e.getMessage(), IStatus.WARNING, e);
			return null;
		}
	}

	/**
	 * Returns the class with the specified name. If the class hasn't been found, this
	 * method uses the bundle class loader with the specified bundleId to find the class.
	 * If the class name is still not resolved, {@code null} is returned.
	 * 
	 * @param bundleId The symbolic name of the bundle containing the class.
	 * @param className Name of the class to load.
	 * @return the class with the specified name;<br>
	 *         {@code null} if the class hasn't been found.
	 */
	public static <T> Class<T> loadClass(String bundleId, String className) {
		try {
			return findClass(className);
		} catch (ClassNotFoundException e) {
			// Try another way
			try {
				return findClass(bundleId, className);
			} catch (ClassNotFoundException e1) {
				EclipseToolsPlugin.log(e1.getMessage(), IStatus.WARNING, e1);
				return null;
			}
		}
	}

	/**
	 * Creates a new instance for the given class considering the fact there is a
	 * default constructor in it.
	 * 
	 * @param clazz The class to instantiate.
	 * @return a new instance for the given class.
	 */
	public static <T> T getNewInstance(Class<T> clazz) {
		try {
			return clazz.newInstance();
		} catch (Exception e) {
			EclipseToolsPlugin.log(e);
		}
		return null;
	}

	/**
	 * Convenient method for {@link RegistryFactory#getRegistry()}
	 * <code>.getConfigurationElementsFor(String, String)</code>.
	 * 
	 * @param namespace The extension point's namespace.
	 * @param extensionPointName The simple identifier for the extension point.
	 * @return an array of {@link IConfigurationElement configuration elements} for the
	 *         given extension.
	 */
	public static IConfigurationElement[] getConfigurationElementsFor(String namespace, String extensionPointName) {
		return RegistryFactory.getRegistry().getConfigurationElementsFor(namespace, extensionPointName);
	}

	/**
	 * Returns the {@link IConfigurationElement}s with the specified {@code elementName}.
	 * 
	 * @param configElements
	 * @param elementName
	 * @return the {@link IConfigurationElement}s with the specified {@code elementName}.
	 */
	public static IConfigurationElement[] getConfigurationElementsFor(IConfigurationElement[] configElements,
			String elementName) {
		List<IConfigurationElement> elements = new ArrayList<IConfigurationElement>(configElements.length);
		for (IConfigurationElement child : configElements) {
			if (elementName.equals(child.getName())) {
				elements.add(child);
			}
		}
		return elements.toArray(new IConfigurationElement[elements.size()]);
	}

	/**
	 * Returns the children {@link IConfigurationElement}s of the specified configElements
	 * with the specified {@code childElementName}.
	 * 
	 * @param configElements
	 * @param childElementName
	 * @return the {@link IConfigurationElement}s with the specified {@code elementName}.
	 */
	public static IConfigurationElement[] getConfigurationChildrenElementsFor(IConfigurationElement[] configElements,
			String childElementName) {
		List<IConfigurationElement> elements = new ArrayList<IConfigurationElement>(configElements.length);
		for (IConfigurationElement child : configElements) {
			IConfigurationElement[] children = child.getChildren(childElementName);
			for (IConfigurationElement childElement : children) {
				elements.add(childElement);
			}
		}
		return elements.toArray(new IConfigurationElement[0]);
	}

	/**
	 * Returns the {@link File} path of the current workspace.
	 * 
	 * @return the {@link File} path of the current workspace.
	 */
	public static File getCurrentWorkspacePath() {
		File path = new File(Platform.getInstanceLocation().getURL().getFile());
		return path;
	}

	/**
	 * Returns the current {@link IWorkspace} or {@code null} if the
	 * {@link ResourcesPlugin} is shutdown.
	 * <p>
	 * Convenient method for {@link ResourcesPlugin}.{@code getWorkspace()}.
	 * 
	 * @return the current {@link IWorkspace} or {@code null}.
	 */
	public static IWorkspace getCurrentWorkspace() {
		try {
			return ResourcesPlugin.getWorkspace();
		} catch (IllegalStateException e) {
			return null;
		}
	}

	/**
	 * Returns an absolute path for the specified workspace relative path.
	 * <p>
	 * A workspace relative path is like : {@code /projectName[/pathOrFileName]*}
	 * <p>
	 * If the specified path is not in the workspace the path is not changed.
	 * 
	 * @param workspaceRelativePath
	 * @return an absolute path for the specified workspace relative path.
	 */
	public static String getAbsolutePath(String workspaceRelativePath) {
		if (workspaceRelativePath.length() > 0 && workspaceRelativePath.charAt(0) == File.separatorChar) {
			String[] pathSplit = workspaceRelativePath.split(getFileSeparator());
			if (pathSplit.length >= 2) {
				if (getCurrentWorkspace().getRoot().getProject(pathSplit[1]).exists()) {
					workspaceRelativePath = getCurrentWorkspacePath().getAbsolutePath() + workspaceRelativePath;
				}
			}
		}
		return workspaceRelativePath;
	}

	/**
	 * Returns a <em>regex</em> for the platform specific file separator.
	 * <p>
	 * examples:
	 * <ul>
	 * <li>on Windows systems returns "\\\\"</li>
	 * <li>on UNIX systems returns "/"</li>
	 * </ul>
	 * 
	 * @return a regex for the platform specific file separator.
	 */
	public static String getFileSeparator() {
		if (fileSeparatorRegex == null) {
			/*
			 * The replace is necessary when using the separator with regex on windows.
			 */
			fileSeparatorRegex = File.separator.replace("\\", "\\\\"); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return fileSeparatorRegex;
	}

	/**
	 * Returns a workspace relative path with the specified path.
	 * <p>
	 * A workspace relative path is like : {@code /projectName[/pathOrFileName]*}
	 * 
	 * @param path
	 * @return a workspace relative path with the specified path.
	 */
	public static String getRelativePath(String path) {
		if (path.startsWith(getCurrentWorkspacePath().getAbsolutePath())) {
			path = path.substring(getCurrentWorkspacePath().getAbsolutePath().length());
		}
		return path;
	}

	/**
	 * Creates a {@link java.io.File} with an {@link IFile}.
	 * 
	 * @param file
	 * @return the created {@link File file}.
	 */
	public static File createFile(IFile file) {
		return new File(file.getLocation().toOSString());
	}

	/**
	 * Creates the given {@link IFile file} and its parents if they don't exist. The
	 * file's project must exist.
	 * 
	 * @param file The file to create
	 * @throws CoreException
	 */
	public static void createIFile(IFile file) throws CoreException {
		Stack<IContainer> parents = new Stack<IContainer>();
		IContainer parent = file.getParent();
		while (!parent.exists()) {
			if ((parent.getType() & IContainer.PROJECT) != 0) {
				// The project does not exist and can't be created here
				throw new IllegalStateException(L.error_fileSProjectNotExist);
			}// else
			parents.add(parent);
			parent = parent.getParent();
		}
		// Creation of the file's parent containers
		while (!parents.isEmpty()) {
			parent = parents.pop();
			if ((parent.getType() & IContainer.FOLDER) != 0) {
				((IFolder) parent).create(true, true, null);
			}
		}
		// Creation of the file
		file.create(new ByteArrayInputStream(new byte[0]), true, null);
	}

	/**
	 * Indicates if the specified {@link IProject} contains the nature with the natureId.
	 * <p>
	 * If the project does not exist or if the project is not open, return {@code false}.
	 * 
	 * @param project
	 * @param natureId
	 * @return {@code true} if the project contains the nature; {@code false} otherwise.
	 */
	public static boolean containsNature(IProject project, String natureId) {
		try {
			return project.exists() && project.isOpen() && project.getNature(natureId) != null;
		} catch (CoreException e) {
			return false;
		}
	}

	/**
	 * Removes the specified nature natureId from the project.
	 * 
	 * @param project
	 * @param natureId
	 */
	public static void removeProjectNature(IProject project, String natureId) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			for (int i = 0; i < natures.length; i++) {
				String nature = natures[i];
				if (nature.equals(natureId)) {
					String[] newNatures = new String[natures.length - 1];
					System.arraycopy(natures, 0, newNatures, 0, i);
					System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);

					// Set the new updated natures of the project
					description.setNatureIds(newNatures);
					project.setDescription(description, null);

					break;// We found the nature to remove
				}
			}
		} catch (CoreException e) {
			EclipseToolsPlugin.log(e);
		}
	}

	/**
	 * Adds the specified nature natureId to the project.
	 * 
	 * @param project
	 * @param natureId
	 */
	public static void addProjectNature(IProject project, String natureId) {
		try {
			IProjectDescription description = project.getDescription();
			addProjectNature(description, natureId);

			// Update the description on the project
			project.setDescription(description, null);
		} catch (CoreException e) {
			EclipseToolsPlugin.log(e);
		}
	}

	/**
	 * Adds the nature natureId into the specified {@link IProjectDescription}.
	 * 
	 * @param description {@link IProjectDescription Project description} into which the
	 *        nature have to be added.
	 * @param natureId The ID of the nature to add.
	 */
	public static void addProjectNature(IProjectDescription description, String natureId) {
		String[] natures = description.getNatureIds();
		String[] newNatures = new String[natures.length + 1];
		System.arraycopy(natures, 0, newNatures, 0, natures.length);
		newNatures[natures.length] = natureId;

		// Set the new updated natures into the project description
		description.setNatureIds(newNatures);
	}

	/**
	 * Toogles the specified nature natureId on the project.
	 * 
	 * @param project The project for which the given nature is toogled.
	 * @param natureId The ID of the nature to add or remove.
	 */
	public static void toogleProjectNature(IProject project, String natureId) {
		if (containsNature(project, natureId)) {
			// Remove the nature from the project
			removeProjectNature(project, natureId);
		} else {
			// Add the nature to the project
			addProjectNature(project, natureId);
		}
	}

	/**
	 * Adds the specified builders to the given project description.
	 * <p>
	 * Don't forget to reset the description into the project.
	 * 
	 * @param description {@link IProjectDescription Project description} into which the
	 *        builders have to be added.
	 * @param builderIds The IDs of the builders to add.
	 */
	public static void addProjectBuilders(IProjectDescription description, String... builderIds) {
		List<ICommand> commands = new ArrayList<ICommand>(builderIds.length);
		commands.addAll(Arrays.asList(description.getBuildSpec()));
		for (String builderId : builderIds) {
			boolean exist = false;
			for (ICommand c : commands) {
				if (c.getBuilderName().equals(builderId)) {
					exist = true;
					break;// Builder found
				}
			}
			if (!exist) {
				ICommand command = description.newCommand();
				command.setBuilderName(builderId);
				commands.add(command);
			}
		}
		description.setBuildSpec(commands.toArray(new ICommand[commands.size()]));
	}

	/**
	 * Add the specified builders to the project.
	 * 
	 * @param project The project for which the builders will be added.
	 * @param builderIds The IDs of the builders to add.
	 * @throws CoreException
	 */
	public static void addProjectBuilders(IProject project, String... builderIds) throws CoreException {
		IProjectDescription description = project.getDescription();
		addProjectBuilders(description, builderIds);
		project.setDescription(description, null);
	}

	/**
	 * Returns the <b>opened</b> projects of the current workspace with one of the
	 * specified natures.
	 * 
	 * @param natureIds IDs of the natures of the prjects to find.
	 * @return the <b>opened</b> projects of the current workspace with one of the
	 *         specified natures.
	 */
	public static List<IProject> getWorkspaceProjectsOfNature(String... natureIds) {
		List<IProject> projects = new LinkedList<IProject>();
		for (IProject project : getCurrentWorkspace().getRoot().getProjects()) {
			for (String natureId : natureIds) {
				if (containsNature(project, natureId)) {
					projects.add(project);
					break;// The project contains at least one of the natures
				}
			}// break
		}
		return projects;
	}

	/**
	 * Returns the resource with the given path if exists; {@code null} otherwise.
	 * <p>
	 * Convenient method for
	 * {@code ResourcesPlugin.getWorkspace().getRoot().findMember(String)}.
	 * 
	 * @param path A workspace relative path ({@code /projectName[/folderOrFileName]*})
	 * @return the resource with the given path if exists; {@code null} otherwise.
	 */
	public static IResource getIResourceFromPath(String path) {
		IResource resource = null;
		resource = getCurrentWorkspace().getRoot().findMember(path);
		return resource;
	}

	/**
	 * Returns a {@link File file} from the {@link URI} represented by the given string.
	 * <p>
	 * This method is usable only for URIs with a <em>platform</em> scheme :
	 * <ul>
	 * <li>platform:/resource/&lt;projectName&gt;/&lt;path&gt;</li>
	 * <li>platform:/resource/&lt;bundleName&gt;/&lt;path&gt;</li>
	 * </ul>
	 * 
	 * @param uri The string representation of the URI of the file.
	 * @return a {@link File file} from the {@link URI} represented by the given string.
	 * @throws URISyntaxException
	 * @throws IOException
	 */
	public static File getFileFromURI(String uri) throws URISyntaxException, IOException {
		return getFileFromURI(new URI(uri));
	}

	/**
	 * Returns a {@link File file} from the given {@link URI}.
	 * <p>
	 * This method is usable only for URIs with a <em>platform</em> scheme :
	 * <ul>
	 * <li>platform:/resource/&lt;projectName&gt;/&lt;path&gt;</li>
	 * <li>platform:/resource/&lt;bundleName&gt;/&lt;path&gt;</li>
	 * </ul>
	 * 
	 * @param uri The URI of the file.
	 * @return a {@link File file} from the given {@link URI}.
	 * @throws IOException
	 */
	public static File getFileFromURI(URI uri) throws IOException {
		if (uri.getScheme() == null || !uri.getScheme().equals("platform")) { //$NON-NLS-1$
			throw new IllegalArgumentException(L.error_onlyPlatformScheme);
		}// else

		File file = null;

		String uriPath = uri.getPath();
		String[] path = uriPath.split("/"); //$NON-NLS-1$
		int i = 0;
		while (i < path.length && (path[i] == null || path[i].length() == 0)) {
			i++;
		}
		if (i < path.length) {
			if (path[i].equals("resource")) { //$NON-NLS-1$
				i++;
				String projectName = path[i++];// TODO control length
				StringBuilder resourcePath = new StringBuilder();
				while (i < path.length) {
					resourcePath.append(path[i]);
					resourcePath.append('/');
					i++;
				}
				if (resourcePath.length() > 0) {
					resourcePath.deleteCharAt(resourcePath.length() - 1);
				}
				IProject project = getCurrentWorkspace().getRoot().getProject(projectName);
				IFile resource = project.getFile(resourcePath.toString());
				if (resource.exists()) {
					file = createFile(resource);
				}
			} else if (path[i].equals("plugin")) { //$NON-NLS-1$
				i++;
				String bundleName = path[i++];// TODO control length
				Bundle bundle = Platform.getBundle(bundleName);
				StringBuilder resourcePath = new StringBuilder();
				while (i < path.length) {
					resourcePath.append(path[i]);
					resourcePath.append('/');
					i++;
				}
				if (resourcePath.length() > 0) {
					resourcePath.deleteCharAt(resourcePath.length() - 1);
				}
				file = getFileFromBundle(bundle, resourcePath.toString());
			}
		}
		return file;
	}

	/**
	 * Returns the {@link File file} located at the specified path in the given
	 * {@link Bundle bundle} or {@code null} if the file doesn't exist.
	 * <p>
	 * If the bundle is in a jar file, the returned file is temporary file, so the
	 * modifications done to it will not be reported to the bundle's file.
	 * 
	 * @param bundle The bundle containing the file.
	 * @param filePath The file path relative to the bundle.
	 * @return the {@link File file} located at the specified path in the given
	 *         {@link Bundle bundle} or {@code null}.
	 */
	public static File getFileFromBundle(Bundle bundle, String filePath) {
		URL url = FileLocator.find(bundle, new Path(filePath), null);
		try {
			if (url != null) {
				url = FileLocator.resolve(url);
				if (url.getProtocol().startsWith("jar")) {//$NON-NLS-1$
					JarFile jarFile = new JarFile(FileLocator.getBundleFile(bundle));
					filePath = filePath.startsWith("/") ? filePath.substring(1) : filePath;
					JarEntry bundleEntry = jarFile.getJarEntry(filePath);
					File tempFile = bundle.getDataFile(filePath);
					if (!tempFile.exists()) {
						File parent = tempFile.getParentFile();
						if (parent != null && !parent.exists()) {
							parent.mkdirs();
						}
						tempFile.createNewFile();
					}
					tempFile.deleteOnExit();
					return new FileTemp(jarFile.getInputStream(bundleEntry), tempFile, true);
				}// else

				return new File(url.toURI());
			} else {
				EclipseToolsPlugin.log(L.bind(L.error_fileNotExistsInBundle, filePath, bundle.getBundleId()),
						IStatus.ERROR);
			}
		} catch (IOException e) {
			EclipseToolsPlugin.log(e);
		} catch (URISyntaxException e) {
			EclipseToolsPlugin.log(e);
		}
		return null;
	}

	/**
	 * Creates a hierarchy of {@link IFolder}s with the given folder as leaf.
	 * 
	 * @param folder Leaf of the folder's hierarchy to create
	 * @param force
	 * @param local
	 * @param monitor
	 * @return the given folder
	 * @throws CoreException if the method create on IFolder fails.
	 * @throws IllegalArgumentException if there is an other type of {@link IResource}
	 *         than {@link IFolder} that does not exist in the given folder's hierarchy.
	 * @see IFolder#create(boolean, boolean, IProgressMonitor)
	 */
	public static IFolder createFolderHierarchy(IFolder folder, boolean force, boolean local, IProgressMonitor monitor)
			throws CoreException {
		LinkedList<IFolder> folders = new LinkedList<IFolder>();
		folders.addFirst(folder);
		IContainer currentFolder = folder.getParent();
		while (currentFolder != null && !currentFolder.exists()) {
			if (currentFolder instanceof IFolder) {
				folders.addFirst((IFolder) currentFolder);
				currentFolder = currentFolder.getParent();
			} else {
				throw new IllegalArgumentException(L.error_foundOtherThanIFolder);
			}
		}

		// Create the folders
		for (IFolder f : folders) {
			f.create(force, local, monitor);
		}

		return folder;
	}

	/**
	 * Returns the members of the given type of the specified {@link IContainer container}
	 * .
	 * <p>
	 * The depth indicates the level of search of the resource members :
	 * <ul>
	 * <li>1 : the direct members of the container</li>
	 * <li>2 : the direct members and the members of the direct members</li>
	 * <li>...</li>
	 * <li>-1 : all direct and indirect members</li>
	 * </ul>
	 * The resource type is one of :
	 * <ul>
	 * <li>{@link IResource#NONE} : for all type of resources (returns a list of
	 * {@link IResource})</li>
	 * <li>{@link IResource#PROJECT} : for projects (returns a list of {@link IProject})</li>
	 * <li>{@link IResource#FOLDER} : for folders (returns a list of {@link IFolder})</li>
	 * <li>{@link IResource#FILE} : for files (returns a list of {@link IFile})</li>
	 * <li>{@link IResource#ROOT} : for the workspace root (returns a list of
	 * {@link IWorkspaceRoot})</li>
	 * </ul>
	 * The resource type can be a combination of these types for returning a list of
	 * {@link IResource}.
	 * 
	 * @param container
	 * @param predicate
	 * @param resourceType
	 * @param depth
	 * @return the members of the given type of the specified {@link IResource resource}.
	 * @throws CoreException if the given container does not exist or is not opened if
	 *         it's a project.
	 * @throws ClassCastException if the return type is not compatible with the given
	 *         resource type.
	 */
	public static <T extends IResource> List<T> members(IContainer container, Predicate<T> predicate, int resourceType,
			int depth) throws CoreException {
		List<T> resources = new ArrayList<T>();
		members(resources, container, predicate, resourceType, depth);
		return resources;
	}

	/**
	 * See {@link #members(IContainer, int, int)}.
	 * 
	 * @see #members(IContainer, int, int)
	 */
	@SuppressWarnings("unchecked")
	private static <T extends IResource> void members(List<T> resources, IContainer container, Predicate<T> predicate,
			int resourceType, int depth) throws CoreException {
		for (IResource member : container.members()) {
			if ((member.getType() & resourceType) != 0 && (predicate == null || predicate.apply((T) member))) {
				resources.add((T) member);
			}
			if (member instanceof IContainer && depth != 0) {
				try {
					// Recursive call
					members(resources, (IContainer) member, predicate, resourceType, depth - 1);
				} catch (CoreException e) {
					/*
					 * We can't get this container's members, so we continue to search the
					 * others
					 */
				}
			}
		}
	}

	/**
	 * Returns the project with the given name in the current workspace if exists,
	 * {@code null} otherwise.
	 * 
	 * @param name
	 * @return the project with the given name in the current workspace if exists,
	 *         {@code null} otherwise.
	 */
	public static IProject getProject(String name) {
		IProject project = getCurrentWorkspace().getRoot().getProject(name);
		return project.exists() ? project : null;
	}

	/**
	 * Returns the {@link ImageDescriptor} corresponding to the given {@code symbolicName}
	 * contained in the workbench shared images.
	 * <p>
	 * Convenient method for {@link PlatformUI}.
	 * {@code getWorkbench().getSharedImages().getImageDescriptor(String)}
	 * 
	 * @param symbolicName
	 * @return the {@link ImageDescriptor} corresponding to the given {@code symbolicName}
	 *         contained in the workbench shared images.
	 */
	public static ImageDescriptor getSharedImageDescriptor(String symbolicName) {
		return PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(symbolicName);
	}

	/**
	 * Returns the {@link Image} corresponding to the given {@code symbolicName} contained
	 * in the {@link ISharedImages workbench shared images}.
	 * <p>
	 * Convenient method for {@link PlatformUI}.
	 * {@code getWorkbench().getSharedImages().getImage(String)}
	 * 
	 * @param symbolicName
	 * @return the {@link Image} corresponding to the given {@code symbolicName} contained
	 *         in the workbench shared images.
	 */
	public static Image getSharedImage(String symbolicName) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(symbolicName);
	}

	/**
	 * Returns the {@link ImageDescriptor} corresponding to the given {@code imagePath} in
	 * the specified plugin.
	 * 
	 * @param plugin The plug-in containing the image.
	 * @param imagePath The path of the image relative to the plugin.
	 * @return the {@link ImageDescriptor} corresponding to the given {@code imagePath}.
	 */
	public static ImageDescriptor getImageDescriptorFromPlugin(AbstractUIPlugin plugin, String imagePath) {
		ImageRegistry imageRegistry = plugin.getImageRegistry();
		ImageDescriptor descriptor = imageRegistry.getDescriptor(imagePath);
		if (descriptor == null) {
			URL imageURL = plugin.getBundle().getResource(imagePath);
			descriptor = ImageDescriptor.createFromURL(imageURL);
			imageRegistry.put(imagePath, descriptor);
		}
		return descriptor;
	}

	/**
	 * Returns the {@link Image} corresponding the given {@link ImageResource
	 * imageResource} that should be referenced by the given {@code plug-in}.
	 * 
	 * @param plugin The plug-in containing the image.
	 * @param imageResource The image resource descriptor.
	 * @return the {@link Image} corresponding the given {@link ImageResource
	 *         imageResource}
	 */
	public static Image getImageFromPlugin(AbstractUIPlugin plugin, ImageResource imageResource) {
		ImageRegistry imageRegistry = plugin.getImageRegistry();
		Image image = imageRegistry.get(imageResource.getImageIdentifier());
		if (image == null && imageResource.getURL() != null) {
			ImageDescriptor descriptor = ImageDescriptor.createFromURL(imageResource.getURL());
			imageRegistry.put(imageResource.getImageIdentifier(), descriptor);
			// Force the imageRegistry to create the image
			imageRegistry.getDescriptor(imageResource.getImageIdentifier());
			image = imageRegistry.get(imageResource.getImageIdentifier());
		}
		return image;
	}

	/**
	 * Opens the default editor for the given {@link IFile file}.
	 * 
	 * @param file The file to open.
	 * @return The opened {@link IEditorPart editor} or {@code null} if no editor could be
	 *         opened.
	 */
	public static IEditorPart openDefaultEditor(IFile file) {
		IWorkbenchWindow activeWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWindow != null) {
			IWorkbenchPage page = activeWindow.getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			try {
				IEditorPart editorPart = page.openEditor(new FileEditorInput(file), desc.getId(), true);
				return editorPart;
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * Opens the default editor for the file located at the given {@code filePath}.
	 * 
	 * @param filePath Path of the file to open.
	 * @return The opened {@link IEditorPart editor} or {@code null} if no editor could be
	 *         opened.
	 */
	public static IEditorPart openDefaultEditor(String filePath) {
		IFile file = (IFile) EclipseTools.getIResourceFromPath(filePath);
		return openDefaultEditor(file);
	}
}
