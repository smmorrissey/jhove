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
 * Interface for a simplified cycle detector for the graphs of objects in a 
 * PDF file.  
 * @author Sheila Morrissey
 * @version 1.0
 *
 */
public interface ICycleDetector {
	/**
	 * Determines if a node has already been visited during graph traversal
	 * @param node Object for which we wish to determine whether or not it has been visited
	 * @return true if node was previously visited when traversing object graph
	 */
	public boolean wasPreviouslyVisited(Object node);
	/**
	 * Visit a node in the object graph.  We can only successfully visit a node 
	 * which has not previously been visited.
	 * @param node Object to be visited
	 * @throws CycleException if Object to be visited was previously visited.
	 */
	public void visitNode(Object node) throws CycleException;
	/**
	 * Resets Cycle Detector for reuse
	 */
	public void reset();
	
}
