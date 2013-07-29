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
package com.sysord.eclipse.tools.runtime;

import java.io.IOException;
import java.util.Date;
import java.util.Stack;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.sysord.eclipse.tools.swt.ColorRegistry;
import com.sysord.eclipse.tools.swt.SWTUtil;

/**
 * Implementations of this class provide a service for logging messages or errors in an
 * eclipse console with a specified level.
 * <p>
 * By default, the messages are written in black and the errors are written in red and
 * time is insert at the beginning of each message.
 * <p>
 * Log levels :
 * <ul>
 * <li>{@link #VERY_HIGH}</li>
 * <li>{@link #NORMAL}</li>
 * <li>{@link #LOW}</li>
 * <li>{@link #VERY_LOW}</li>
 * </ul>
 * 
 * @author Fabien Vignal <vignalf@gmail.com>
 */
public abstract class ConsoleLogger {

	/**
	 * Flag to set on the logger level for disabling the messages.
	 */
	public static final byte DISABLED = 0x00;

	/**
	 * Flag for very important messages and errors.
	 */
	public static final byte VERY_HIGH = 0x01;

	/**
	 * Flag for normal messages and errors.
	 */
	public static final byte NORMAL = 0x02;

	/**
	 * Flag for lower importance messages and errors.
	 */
	public static final byte LOW = 0x04;

	/**
	 * Flag for traces
	 */
	public static final byte VERY_LOW = 0x08;

	/**
	 * Red color code : {@value #RED}
	 */
	public static final int RED = 0xFF0000;

	/**
	 * Orange color code : {@value #ORANGE}
	 */
	public static final int ORANGE = 0xFFBF00;

	/**
	 * Black clor code : {@value #BLACK}
	 */
	public static final int BLACK = 0;

	private byte loggerLevel;

	private boolean showTime = true;

	/**
	 * The current console where the messages are written.
	 */
	protected MessageConsole console;

	private StreamThread messageThread;

	private StreamThread errorThread;

	private StreamThread warningThread;

	/**
	 * Creates a logger, logging all errors and messages with a minimum level of
	 * {@link #NORMAL}.
	 */
	public ConsoleLogger() {
		loggerLevel = NORMAL | VERY_HIGH;
		messageThread = new StreamThread(this, getStream(getMessageColor()));
		errorThread = new StreamThread(this, getStream(getErrorColor()));
		warningThread = new StreamThread(this, getStream(getWarningColor()));
	}

	/**
	 * Logs the given message with the specified log level.
	 * 
	 * @param message The message to log.
	 * @param logLevel
	 */
	public void log(String message, byte logLevel) {
		if ((loggerLevel & logLevel) != 0) {
			writeToConsole(message, messageThread);
		}
	}

	/**
	 * Logs the given error with the specified log level.
	 * 
	 * @param error The error to log.
	 * @param logLevel
	 */
	public void logError(String error, byte logLevel) {
		if ((loggerLevel & logLevel) != 0) {
			writeToConsole(error, errorThread);
		}
	}

	/**
	 * Logs the given warning with the specified log level.
	 * 
	 * @param warning The warning to log.
	 * @param logLevel
	 */
	public void logWarning(String warning, byte logLevel) {
		if ((loggerLevel & logLevel) != 0) {
			writeToConsole(warning, warningThread);
		}
	}

	/**
	 * Logs the given message with a {@link #NORMAL} log level.
	 * 
	 * @param message The message to log.
	 */
	public void log(String message) {
		log(message, NORMAL);
	}

	/**
	 * Logs the given error with a {@link #NORMAL} log level.
	 * 
	 * @param error The error to log.
	 */
	public void logError(String error) {
		logError(error, NORMAL);
	}

	/**
	 * Logs the given warning with a {@link #NORMAL} log level.
	 * 
	 * @param warning The warning to log.
	 */
	public void logWarning(String warning) {
		logWarning(warning, NORMAL);
	}

	/**
	 * Logs the given error with a {@link #NORMAL} log level.
	 * <p>
	 * This method call at first {@code String.valueOf(error)} or build a String if the
	 * given {@code error} is an exception.
	 * 
	 * @param error The error to log.
	 */
	public void logError(Object error) {
		logError(error, NORMAL);
	}

	/**
	 * Logs the given error with the specified log level.
	 * <p>
	 * This method calls at first {@code String.valueOf(error)} or build a String if the
	 * given {@code error} is an exception.
	 * 
	 * @param error The error to log.
	 * @param logLevel
	 */
	public void logError(Object error, byte logLevel) {
		logError(getStringFromObject(error), logLevel);
	}

	/**
	 * Sets the logger level of messages and errors to log.
	 * <p>
	 * The {@code loggerLevel} is either a constant of this interface or must be built by
	 * <em>bitwise OR</em>'ing together two or more of this interface constants.
	 * 
	 * @param loggerLevel
	 */
	public void setLoggerLevel(byte loggerLevel) {
		this.loggerLevel = loggerLevel;
	}

	/**
	 * Defines the show time status of this {@code ConsoleLogger}.
	 * <p>
	 * If the given {@code showTime} is {@code true}, the date of the message will be
	 * insert at the beginning of the message.
	 * 
	 * @param showTime Show/Hide the time of written messages.
	 */
	public void showTime(boolean showTime) {
		this.showTime = showTime;
	}

	/**
	 * Returns the logger level defined on this {@code ConsoleLogger}.
	 * <p>
	 * The logger level returned is either one of this interface's contants or a
	 * <em>bitwise construction</em> of this interface's constants.
	 * 
	 * @return the logger level defined on this {@code ConsoleLogger}.
	 */
	public byte getLoggerLevel() {
		return loggerLevel;
	}

	/**
	 * Writes the given
	 * 
	 * @param message
	 * @param thread
	 */
	protected void writeToConsole(final String message, StreamThread thread) {
		thread.putMessage(message);

		switch (thread.getState()) {
		case WAITING:
			synchronized (thread) {
				thread.wakeUpIsNeeded = true;
				thread.notify();
			}
			break;
		case NEW:
			thread.start();
			break;
		case TERMINATED:
			if (thread == messageThread) {
				messageThread = thread = new StreamThread(this, getStream(getMessageColor()));
			} else if (thread == errorThread) {
				errorThread = thread = new StreamThread(this, getStream(getErrorColor()));
			} else {
				warningThread = thread = new StreamThread(this, getStream(getWarningColor()));
			}
			thread.putMessage(message);
			break;
		}
	}

	private static void write(String message, MessageConsoleStream stream) {
		try {
			stream.println(message);
			stream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the color to use for errors.
	 * <p>
	 * This method do nothing and the color for errors is {@link #RED} by default;
	 * override this method in subclasses to change the color of errors.
	 * 
	 * @return the color to use for errors.
	 */
	protected int getErrorColor() {
		return RED;
	}

	/**
	 * Returns the color to use for errors.
	 * <p>
	 * This method do nothing and the color for errors is {@link #RED} by default;
	 * override this method in subclasses to change the color of errors.
	 * 
	 * @return the color to use for errors.
	 */
	protected int getWarningColor() {
		return ORANGE;
	}

	/**
	 * Returns the color to use for messages.
	 * <p>
	 * This method do nothing and the color for messages is {@link #BLACK} by default;
	 * override this method in subclasses to change the color of messages.
	 * 
	 * @return the color to use for messages.
	 */
	protected int getMessageColor() {
		return BLACK;
	}

	/**
	 * Returns a MAD console {@link MessageConsoleStream}.
	 * 
	 * @return a MAD console {@link MessageConsoleStream}.
	 */
	protected MessageConsole getConsole() {
		if (console == null) {
			console = SWTUtil.getConsole(getConsoleId(), false);
		}
		return console;
	}

	/**
	 * Returns the id of the console where the messages will be written.
	 * <p>
	 * The {@code ConsoleLogger} create a new console only if
	 * <code>{@link #console} == null</code>.
	 * 
	 * @return the id of the console where the messages will be written.
	 */
	protected abstract String getConsoleId();

	/**
	 * Create a {@link MessageConsoleStream} with the given color code.
	 * 
	 * @param colorCode Color code of the text to flush in the stream.
	 * @return the created {@link MessageConsoleStream}.
	 */
	protected MessageConsoleStream getStream(int colorCode) {
		MessageConsoleStream stream = getConsole().newMessageStream();
		changeStreamColor(stream, colorCode);
		return stream;
	}

	/**
	 * Transforms the given object in a String.
	 * <p>
	 * If the object is an exception, a trace with the exception message and its causes
	 * will be returned.
	 * 
	 * @param o The object to transform into a string.
	 * @return the String corresponding to the object.
	 */
	protected String getStringFromObject(Object o) {
		String errorMessage;
		if (o instanceof Exception) {
			Exception exception = (Exception) o;
			StringBuilder err = new StringBuilder(((Exception) o).getMessage());
			Throwable throwable = exception.getCause();
			while (throwable != null) {
				err.append('\n').append("Caused by : " + throwable.getMessage());
				throwable = throwable.getCause();
			}
			errorMessage = err.toString();
		} else {
			errorMessage = String.valueOf(o);
		}
		return errorMessage;
	}

	private void changeStreamColor(final MessageConsoleStream stream, final int colorCode) {
		Display.getDefault().syncExec(new Runnable() {

			@Override
			public void run() {
				stream.setColor(ColorRegistry.get(colorCode));
			}
		});
	}

	protected static class StreamThread extends Thread {

		private ConsoleLogger logger;

		private MessageConsoleStream stream;

		private Stack<MessageData> messages;

		private boolean wakeUpIsNeeded;

		public StreamThread(ConsoleLogger logger, MessageConsoleStream stream) {
			this.logger = logger;
			this.stream = stream;
			messages = new Stack<MessageData>();
		}

		@Override
		public final void run() {
			while (!messages.isEmpty()) {
				while (!messages.isEmpty()) {
					write(createMessage(messages.pop()), stream);
				}
				lock();
			}
		}

		public void putMessage(String message) {
			messages.push(new MessageData(new Date(), message == null ? "null" : message));
		}

		/**
		 * Creates a string message corresponding to the given {@link MessageData data}.
		 * 
		 * @param messageData The data of the message to create.
		 * @return a string message corresponding to the given {@link MessageData data}.
		 */
		@SuppressWarnings("deprecation")
		protected String createMessage(MessageData messageData) {
			StringBuilder builder = new StringBuilder();
			if (logger.showTime) {
				builder.append('[');
				if (messageData.getDate().getHours() < 10) {
					builder.append('0');
				}
				builder.append(messageData.getDate().getHours());
				builder.append(':');
				if (messageData.getDate().getMinutes() < 10) {
					builder.append('0');
				}
				builder.append(messageData.getDate().getMinutes());
				builder.append(':');
				if (messageData.getDate().getSeconds() < 10) {
					builder.append('0');
				}
				builder.append(messageData.getDate().getSeconds());
				builder.append(']').append(' ');
			}
			builder.append(messageData.getMessage());
			return builder.toString();
		}

		private void lock() {
			wakeUpIsNeeded = false;
			synchronized (this) {
				try {
					while (!wakeUpIsNeeded) {
						wait();
					}
				} catch (InterruptedException e) {
				}
			}
		}
	}

	protected static class MessageData {

		private Date date;
		private String message;

		public MessageData(Date date, String message) {
			this.date = date;
			this.message = message;
		}

		public Date getDate() {
			return date;
		}

		public String getMessage() {
			return message;
		}

	}
}