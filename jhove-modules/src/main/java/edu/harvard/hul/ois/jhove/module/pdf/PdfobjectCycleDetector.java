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

import java.util.HashSet;

/**
 * Class for a simplified cycle detector for the graphs of object IDs in a 
 * PDF file.  
 * @author Sheila Morrissey
 * @version 1.0
 */
public class PdfobjectCycleDetector implements ICycleDetector {

	private HashSet nodeSet;
	/**
	 * Constructor.
	 */
	public PdfobjectCycleDetector() {
		nodeSet = new HashSet();
	}// end PdfobjectCycleDetector() 

	/**
	 * Determines if a node has already been visited during graph traversal
	 * @param node Object for which we wish to determine whether or not it has been visited
	 * @return true if node was previously visited when traversing object graph
	 * @see org.portico.tool.jhove_1_1.ICycleDetector#wasPreviouslyVisited(java.lang.Object)
	 */
	public boolean wasPreviouslyVisited(Object node) {
		// adding an object to a Set returns true if object was not previously contained in the set
		boolean wasNotVisited = this.nodeSet.add(node);
		boolean wasVisited = !wasNotVisited;
		if (wasNotVisited){
			// remove the node (and the side effect of putting node in set of visited nodes)
			nodeSet.remove(node);
		}
		return wasVisited;
	}// end wasPreviouslyVisited(Object node)

	/**
	 * Visit a node in the objectID graph.  We can only successfully visit a node 
	 * which has not previously been visited.
	 * @param node ObjectID to be visited
	 * @throws CycleException if ObjectID to be visited was previously visited.
	 * @see org.portico.tool.jhove_1_1.ICycleDetector#visitNode(java.lang.Object)
	 */
	public void visitNode(Object node) throws CycleException {
		if (this.wasPreviouslyVisited(node)){
			throw new CycleException("Previously visited " + node.toString());	
		}
		else {
			this.nodeSet.add(node);
		}
	}// end visitNode(Object node)
	
	/**
	 * Resets Cycle Detector for reuse
	 */
	public void reset(){
		nodeSet.clear();
	}

}// end class
