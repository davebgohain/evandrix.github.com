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
package org.gephi.graph.dhns.core;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Generates incremental IDs for node and edges;
 *
 * @author Mathieu Bastian
 */
public class IDGen {

    private AtomicInteger nodeGen = new AtomicInteger();
    private AtomicInteger edgeGen = new AtomicInteger();

    public int newNodeId() {
        return nodeGen.getAndIncrement();
    }

    public int newEdgeId() {
        return edgeGen.getAndIncrement();
    }

    public void setNodeGen(int nodeGen) {
        this.nodeGen.set(nodeGen);
    }

    public void setEdgeGen(int edgeGen) {
        this.edgeGen.set(edgeGen);
    }

    public int getNodeGen() {
        return nodeGen.get();
    }

    public int getEdgeGen() {
        return edgeGen.get();
    }
}
