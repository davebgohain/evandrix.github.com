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
package org.gephi.visualization.api.selection;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;
import org.gephi.graph.api.Renderable;
import org.gephi.visualization.apiimpl.ModelImpl;
import org.gephi.lib.gleem.linalg.Vecf;

/**
 *
 * @author Mathieu Bastian
 */
public interface SelectionArea {

    public abstract float[] getSelectionAreaRectancle();

    public abstract float[] getSelectionAreaCenter();

    public abstract boolean mouseTest(Vecf distanceFromMouse, ModelImpl object);

    public abstract boolean select(Renderable object);

    public abstract boolean unselect(Renderable object);

    public void drawArea(GL gl, GLU glu);

    public boolean isEnabled();

    public boolean blockSelection();
}
