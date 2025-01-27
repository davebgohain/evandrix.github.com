/*
Copyright 2008 WebAtlas
Authors : Mathieu Bastian, Mathieu Jacomy, Julian Bilcke
Website : http://www.gephi.org

This file is part of Gephi.

Gephi is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Gephi is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Gephi.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.gephi.graph.api;

import org.gephi.project.api.Workspace;

/**
 * Controller that maintain the graph models, one per Workspace.
 * <p>
 * This controller is a service and can therefore be found in Lookup:
 * <pre>GraphController gc = Lookup.getDefault().lookup(GraphController.class);</pre>
 * 
 * @author Mathieu Bastian
 */
public interface GraphController {

    /**
     * Returns the graph model for the current workspace, or <code>null</code>
     * if project is empty.
     * @return          the current graph model
     */
    public GraphModel getModel();

    /**
     * Returns the graph model for the given <code>workspace</code>.
     * @param workspace the workspace that graph modl is to be returned
     * @return          the <code>workspace</code>'s graph model
     */
    public GraphModel getModel(Workspace workspace);
}
