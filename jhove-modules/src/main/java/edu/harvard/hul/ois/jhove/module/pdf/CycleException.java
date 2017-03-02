/**********************************************************************
 * Jhove - JSTOR/Harvard Object Validation Environment
 * Copyright 2003-2004 by JSTOR and the President and Fellows of Harvard College
 * 
 * Portico PDF module
 * Copyright 2006 by Portico
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307
 * USA
 **********************************************************************/
package edu.harvard.hul.ois.jhove.module.pdf;

/**
 * @author smorrissey
 *
 */
public class CycleException extends Exception {

	/**
	 * 
	 */
	public CycleException() {
		super();
	}

	/**
	 * @param arg0
	 */
	public CycleException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public CycleException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CycleException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
