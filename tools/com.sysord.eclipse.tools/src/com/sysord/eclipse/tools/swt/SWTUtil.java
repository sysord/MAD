/*
 * SWTUtil.java                                        17 déc. 2012
 * 
 * Copyright (c) 2012 Sysord
 */
package com.sysord.eclipse.tools.swt;

import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.browser.IWebBrowser;
import org.eclipse.ui.browser.IWorkbenchBrowserSupport;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.sysord.eclipse.tools.EclipseTools;

/**
 * Utility class for SWT.
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public class SWTUtil {

	public static final String LBL_BROWSE = "Browse...";

	public static final int STD_BUTTON_WIDTH = 100;

	// Suppresses default constructor, ensuring non-instantiability.
	private SWTUtil() {
	}

	/**
	 * Returns the widget's {@link Display}.
	 * <p>
	 * If the widget's {@code Display} is {@code null}, returns the current or default
	 * {@code Display}.
	 * 
	 * @param widget
	 * @return the widget's {@link Display}.
	 */
	public static Display getDisplay(Widget widget) {
		Display display = null;
		if (widget != null && !widget.isDisposed()) {
			display = widget.getDisplay();
		}
		if (display == null) {
			display = getDisplay();
		}
		return display;
	}

	/**
	 * Returns the current {@link Display} if this method is called in an UI thread,
	 * otherwise returns the default {@link Display}.
	 * 
	 * @return the current {@link Display} or the default one.
	 */
	public static Display getDisplay() {
		Display display = Display.getCurrent();
		if (display == null) {
			display = Display.getDefault();
		}
		return display;
	}

	/**
	 * Creates a {@link Text} field with a "Browse" {@link Button} and return the created
	 * composite containing the field.
	 * <p>
	 * The Browse button open a dialog for choosing a <b>file</b>.
	 * <p>
	 * The {@code Text} control and the {@code Button} control are registered in the
	 * specified {@code controls} array.<br>
	 * => {@code controls[0]} is the {@code Text} control.<br>
	 * => {@code controls[1]} is the {@code Button} control.
	 * 
	 * @param parent
	 * @param controls
	 * @param extensions
	 * @param filterPath
	 * @param filterIndex
	 * @param absolute
	 * @return the created composite containing the field
	 */
	public static Composite createBrowseFileField(Composite parent, Control[] controls, final String[] extensions,
			final String filterPath, final int filterIndex, final boolean absolute) {
		// Container of the file browser field
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(GridLayoutHelper.createWithNoMargin(2));

		// Text field
		final Text txt_fileName = new Text(container, SWT.BORDER);
		txt_fileName.setLayoutData(GridDataHelper.horizontalFill());

		// Browse button
		Button btn_browse = new Button(container, SWT.NONE);
		btn_browse.setText(LBL_BROWSE);
		btn_browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String filePath = null;
				Shell shell = getActiveShell();
				if (shell != null) {
					FileDialog fileDialog = new FileDialog(shell);
					fileDialog.setFilterExtensions(extensions);
					fileDialog.setFilterPath(filterPath);
					fileDialog.setFilterIndex(filterIndex);
					filePath = fileDialog.open();
				}
				if (filePath != null) {
					if (!absolute) {
						String workspace = EclipseTools.getCurrentWorkspacePath().getPath();
						if (filePath.startsWith(workspace)) {
							filePath = filePath.substring(workspace.length());
						}
					}
					txt_fileName.setText(filePath);
				}
			}
		});

		if (controls != null && controls.length > 0) {
			controls[0] = txt_fileName;
			if (controls.length > 1) {
				controls[1] = btn_browse;
			}
		}

		return container;
	}

	/**
	 * Creates a {@link Text} field with a "Browse" {@link Button} and return the created
	 * composite containing the field.
	 * <p>
	 * The Browse button open a dialog for choosing a <b>folder</b>.
	 * <p>
	 * The {@code Text} control and the {@code Button} control are registered in the
	 * specified {@code controls} array.<br>
	 * => {@code controls[0]} is the {@code Text} control.<br>
	 * => {@code controls[1]} is the {@code Button} control.
	 * 
	 * @param parent
	 * @param controls
	 * @param filterPath
	 * @param absolute
	 * @return the created composite containing the field
	 */
	public static Composite createBrowseFolderField(Composite parent, Control[] controls, final String filterPath,
			final boolean absolute) {
		// Container of the file browser field
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(GridLayoutHelper.createWithNoMargin(2));

		// Text field
		final Text txt_folderName = new Text(container, SWT.BORDER);
		txt_folderName.setLayoutData(GridDataHelper.horizontalFill());

		// Browse button
		Button btn_browse = new Button(container, SWT.NONE);
		btn_browse.setText(LBL_BROWSE);
		btn_browse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String folderPath = null;
				Shell shell = getActiveShell();
				if (shell != null) {
					DirectoryDialog folderDialog = new DirectoryDialog(shell);
					folderDialog.setFilterPath(filterPath);
					folderPath = folderDialog.open();
				}
				if (folderPath != null) {
					if (!absolute) {
						String workspace = EclipseTools.getCurrentWorkspacePath().getPath();
						if (folderPath.startsWith(workspace)) {
							folderPath = folderPath.substring(workspace.length());
						}
					}
					txt_folderName.setText(folderPath);
				}
			}
		});

		if (controls != null && controls.length > 0) {
			controls[0] = txt_folderName;
			if (controls.length > 1) {
				controls[1] = btn_browse;
			}
		}

		return container;
	}

	/**
	 * Returns the current active {@link Shell} or {@code null} if the current thread is
	 * not a user-interface thread.
	 * 
	 * @return the current active {@link Shell} or null.
	 */
	public static Shell getActiveShell() {
		Display current = Display.getCurrent();
		if (current != null) {
			return current.getActiveShell();
		}// else
		return null;
	}

	/**
	 * Create and open an error {@link MessageBox} with the specified title and message.
	 * <p>
	 * The message box is open with a call to {@code Display.getDefault().asyncExec()} and
	 * if the obtained {@link Shell} is {@code null}, the error is flushed in the standard
	 * error {@link PrintStream} ({@code System.err}).
	 * 
	 * @param title
	 * @param errorMessage
	 */
	public static void showErrorMessage(final String title, final String errorMessage) {
		showMessage(title, errorMessage, SWT.ICON_ERROR);
	}

	/**
	 * Create and open a {@link MessageBox} with the specified title, message and style.
	 * <p>
	 * The message box is open with a call to {@code Display.getDefault().asyncExec()} and
	 * if the obtained {@link Shell} is {@code null}, the message is flushed in the
	 * standard {@link PrintStream} ({@code System.out} or {@code System.err} if it is an
	 * error).
	 * 
	 * @param title
	 * @param errorMessage
	 */
	public static void showMessage(final String title, final String message, final int style) {
		final PrintStream _err = System.err;
		final PrintStream _out = System.out;
		Display.getDefault().asyncExec(new Runnable() {

			@Override
			public void run() {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				if (shell != null) {
					MessageBox msgBox = new MessageBox(shell, style);
					msgBox.setMessage(message);
					msgBox.setText(title);
					msgBox.open();
				} else {
					if ((style & SWT.ICON_ERROR) == 1) {
						_err.println(message);
					} else {
						_out.println(message);
					}
				}
			}
		});
	}

	/**
	 * Write the message in the specified {@code consoleId}.
	 * <p>
	 * If the console does not exist a new one is created and the message is flushed into
	 * it.
	 * 
	 * @param consoleId
	 * @param message
	 */
	public static void println(String consoleId, String message) {
		MessageConsole console = getConsole(consoleId);

		// Write the message into the console
		MessageConsoleStream consoleStream = console.newMessageStream();
		try {
			consoleStream.write(message + "\n");
			consoleStream.flush();
		} catch (IOException e) {
			// TODO Error message
		}
	}

	/**
	 * Return the {@link MessageConsole} with the specified {@code consoleId}.
	 * <p>
	 * If the console does not exist a new one is created.
	 * 
	 * @param consoleId
	 * @return the existing or created {@code MessageConsole}.
	 */
	public static MessageConsole getConsole(String consoleId) {
		return getConsole(consoleId, true);
	}

	/**
	 * Return the {@link MessageConsole} with the given {@code consoleId} and show it if
	 * it wasn't opened and {@code show} is set to {@code true}.
	 * <p>
	 * If the console does not exist a new one is created.
	 * 
	 * @param consoleId
	 * @return the existing or created {@code MessageConsole}.
	 */
	public static MessageConsole getConsole(String consoleId, boolean show) {
		IConsoleManager consoleManager = ConsolePlugin.getDefault().getConsoleManager();
		MessageConsole console = null;

		// Search an existing console of the specified type
		IConsole[] consoles = consoleManager.getConsoles();
		for (IConsole currentConsole : consoles) {
			if (currentConsole.getName().equals(consoleId) && currentConsole instanceof MessageConsole) {
				console = (MessageConsole) currentConsole;
				break;
			}
		}

		if (console == null) {
			// Create the console if none have been found
			console = new MessageConsole(consoleId, null);
			consoleManager.addConsoles(new IConsole[] { console });
			if (show) {
				consoleManager.showConsoleView(console);
			}
		}
		return console;
	}

	/**
	 * Return a new {@link MessageConsoleStream} from the console with the specified
	 * {@code consoleId}.
	 * 
	 * @param consoleId
	 * @return a new {@link MessageConsoleStream} from the console with the specified
	 *         {@code consoleId}.
	 */
	public static MessageConsoleStream getConsoleStream(String consoleId) {
		return getConsole(consoleId).newMessageStream();
	}

	/**
	 * Create a new {@link ListViewer}.
	 * 
	 * @param list The base {@link List} for the {@link ListViewer} to create.
	 * @param contentProvider
	 * @param labelProvider
	 * @param elementComparer
	 * @param input
	 * @return the created new {@link ListViewer}.
	 */
	public static ListViewer createListViewer(List list, IContentProvider contentProvider,
			IBaseLabelProvider labelProvider, IElementComparer elementComparer, Object input) {
		ListViewer listViewer = new ListViewer(list);
		if (contentProvider != null) {
			listViewer.setContentProvider(contentProvider);
		} else {
			listViewer.setContentProvider(new ArrayContentProvider());
		}
		if (labelProvider != null) {
			listViewer.setLabelProvider(labelProvider);
		}
		if (elementComparer != null) {
			listViewer.setComparer(elementComparer);
		}
		if (input != null) {
			listViewer.setInput(input);
		}
		return listViewer;
	}

	/**
	 * Create a new {@link ListViewer} with an {@link ArrayContentProvider} as content
	 * provider.
	 * 
	 * @param list The base {@link List} for the {@link ListViewer} to create.
	 * @param labelProvider
	 * @param elementComparer
	 * @param input
	 * @return the created new {@link ListViewer}.
	 */
	public static ListViewer createListViewer(List list, IBaseLabelProvider labelProvider,
			IElementComparer elementComparer, Object input) {
		return createListViewer(list, null, labelProvider, elementComparer, input);
	}

	/**
	 * Create a new {@link ListViewer} with an {@link ArrayContentProvider} as content
	 * provider and without {@link IElementComparer}.
	 * 
	 * @param list The base {@link List} for the {@link ListViewer} to create.
	 * @param labelProvider
	 * @param input
	 * @return the created new {@link ListViewer}.
	 */
	public static ListViewer createListViewer(List list, IBaseLabelProvider labelProvider, Object input) {
		return createListViewer(list, null, labelProvider, null, input);
	}

	/**
	 * Conform the button's width to the defined standard width if possible.
	 * <p>
	 * The standard button with is defined by {@link #STD_BUTTON_WIDTH} and has a value of
	 * {@value #STD_BUTTON_WIDTH}.
	 * 
	 * @param button
	 * @param data
	 */
	public static void computeButtonWidth(Button button, GridData data) {
		if (button != null && data != null && !button.isDisposed()) {
			Point size = button.computeSize(SWT.DEFAULT, SWT.DEFAULT);
			int widthHint = Math.max(size.x, STD_BUTTON_WIDTH);
			data.widthHint = widthHint;
			button.setLayoutData(data);
		}
	}

	/**
	 * Increment the font size of the specified {@link Control}.
	 * <p>
	 * Specify a negative number of points to reduce the font size.
	 * 
	 * @param control
	 * @param points Number of points to add to the default font size of the
	 *        control.
	 */
	public static void incrementFontSize(Control control, int points) {
		FontData[] fontData = control.getFont().getFontData();
		int newHeight;
		for (int i = 0; i < fontData.length; i++) {
			newHeight = fontData[i].getHeight() + points;
			fontData[i].setHeight(newHeight < 0 ? 0 : newHeight);
		}
		control.setFont(new Font(control.getFont().getDevice(), fontData));
	}

	/**
	 * Open a browser for the given {@link URL}.
	 * <p>
	 * If {@code useExternalBrowser} is set to {@code true}, the {@code URL} will be open
	 * in the system web browser.
	 * 
	 * @param url
	 * @param display
	 * @param useExternalBrowser
	 */
	public static void openBrowser(final URL url, Display display, final boolean useExternalBrowser) {
		display.asyncExec(new Runnable() {
			@Override
			public void run() {
				internalOpen(url, useExternalBrowser);
			}
		});
	}

	/**
	 * @see org.eclipse.jdt.internal.ui.actions.OpenBrowserUtil
	 * @param url
	 * @param useExternalBrowser
	 */
	private static void internalOpen(final URL url, final boolean useExternalBrowser) {
		BusyIndicator.showWhile(null, new Runnable() {
			public void run() {
				URL helpSystemUrl = PlatformUI.getWorkbench().getHelpSystem().resolve(url.toExternalForm(), true);
				if (helpSystemUrl == null) { // can happen if org.eclipse.help.ui is not
												// available
					return; // the resolve() method already wrote
							// "Unable to instantiate help UI" to the log
				}
				try {
					IWorkbenchBrowserSupport browserSupport = PlatformUI.getWorkbench().getBrowserSupport();
					IWebBrowser browser;
					if (useExternalBrowser)
						browser = browserSupport.getExternalBrowser();
					else
						browser = browserSupport.createBrowser(null);
					browser.openURL(helpSystemUrl);
				} catch (PartInitException ex) {
					System.err.println("Opening Javadoc failed"); //$NON-NLS-1$
				}
			}
		});
	}

	/**
	 * Paints a border on the given {@link Composite}.
	 * 
	 * @param composite The {@link Composite} for which to paint a border.
	 * @param borderWidth The width of the border.
	 * @param color The {@link Color} of the border.
	 * @since 1.1
	 */
	public static void paintBorder(Composite composite, int borderWidth, Color color) {
		final Rectangle area = composite.getClientArea();
		final Rectangle top = new Rectangle(area.x, area.y, area.width, borderWidth);
		final Rectangle right = new Rectangle(area.x + area.width - borderWidth, area.y, borderWidth, area.height);
		final Rectangle bottom = new Rectangle(area.x, area.y + area.height - borderWidth, area.width, borderWidth);
		final Rectangle left = new Rectangle(area.x, area.y, borderWidth, area.height);
		final GC gc = new GC(composite);
		gc.setBackground(color);
		gc.fillRectangle(top);
		gc.fillRectangle(right);
		gc.fillRectangle(bottom);
		gc.fillRectangle(left);
		gc.dispose();
	}
}
