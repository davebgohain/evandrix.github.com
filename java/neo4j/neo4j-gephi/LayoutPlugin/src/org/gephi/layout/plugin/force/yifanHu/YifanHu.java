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
package org.gephi.layout.plugin.force.yifanHu;

import javax.swing.Icon;
import javax.swing.JPanel;
import org.gephi.layout.plugin.force.StepDisplacement;
import org.gephi.layout.spi.Layout;
import org.gephi.layout.spi.LayoutBuilder;
import org.gephi.layout.spi.LayoutUI;
import org.openide.util.NbBundle;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author Helder Suzuki <heldersuzuki@gephi.org>
 */
@ServiceProvider(service=LayoutBuilder.class)
public class YifanHu implements LayoutBuilder {

    private YifanHuLayoutUI ui = new YifanHuLayoutUI();

    public YifanHuLayout buildLayout() {
        YifanHuLayout layout = new YifanHuLayout(this, new StepDisplacement(1f));
        return layout;
    }

    public String getName() {
        return NbBundle.getMessage(YifanHu.class, "YifanHu.name");
    }

    public LayoutUI getUI() {
        return ui;
    }

    private static class YifanHuLayoutUI implements LayoutUI {

        public String getDescription() {
            return NbBundle.getMessage(YifanHu.class, "YifanHu.description");
        }

        public Icon getIcon() {
            return null;
        }

        public JPanel getSimplePanel(Layout layout) {
            return null;
        }

        public int getQualityRank() {
            return 3;
        }

        public int getSpeedRank() {
            return 4;
        }
    }
}
