/*
Copyright 2008-2009 Gephi
Authors : Helder Suzuki <heldersuzuki@gephi.org>
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
package org.gephi.layout.plugin.force;

import org.gephi.graph.api.Spatial;
import org.gephi.layout.plugin.ForceVectorUtils;

/**
 *
 * @author Helder Suzuki <heldersuzuki@gephi.org>
 */
public abstract class AbstractForce {

    public ForceVector calculateForce(Spatial node1, Spatial node2) {
        return calculateForce(node1, node2,
                              ForceVectorUtils.distance(node1, node2));
    }

    public abstract ForceVector calculateForce(Spatial node1, Spatial node2,
                                               float distance);
}
