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
package org.gephi.visualization.opengl.text;

import javax.swing.ImageIcon;
import org.gephi.visualization.VizController;
import org.gephi.visualization.apiimpl.GraphDrawable;
import org.gephi.visualization.apiimpl.ModelImpl;

/**
 *
 * @author Mathieu Bastian
 */
public class FixedSizeMode implements SizeMode {

    //private static float FACTOR_3D = 800f;
    private GraphDrawable drawable;

    public void init() {
        drawable = VizController.getInstance().getDrawable();
    }

    public void setSizeFactor2d(float sizeFactor, TextDataImpl text, ModelImpl model) {
        float factor = sizeFactor * 1.9f + 0.1f;        //Between 0.1 and 2
        factor *= text.getSize();
        text.setSizeFactor(factor);
    }

    public void setSizeFactor3d(float sizeFactor, TextDataImpl text, ModelImpl model) {
        float factor = sizeFactor / drawable.getViewportWidth() * model.getCameraDistance();
        factor *= text.getSize();
        text.setSizeFactor(factor);
    }

    public String getName() {
        return "Fixed";
    }

    public ImageIcon getIcon() {
        return new ImageIcon(getClass().getResource("/org/gephi/visualization/opengl/text/FixedSizeMode.png"));
    }

    @Override
    public String toString() {
        return getName();
    }
}
