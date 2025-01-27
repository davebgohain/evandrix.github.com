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

package org.gephi.ui.exporter.plugin;

import org.gephi.io.exporter.plugin.ExporterGEXF;

/**
 *
 * @author Mathieu
 */
public class UIExporterGEXFPanel extends javax.swing.JPanel {

    /** Creates new form UIExporterGEXFPanel */
    public UIExporterGEXFPanel() {
        initComponents();
    }

    public void setup(ExporterGEXF exporterGEXF) {
        colorsExportCheckbox.setSelected(exporterGEXF.isExportColors());
        positionExportCheckbox.setSelected(exporterGEXF.isExportPosition());
        sizeExportCheckbox.setSelected(exporterGEXF.isExportSize());
        attributesExportCheckbox.setSelected(exporterGEXF.isExportAttributes());
        normalizeCheckbox.setSelected(exporterGEXF.isNormalize());
    }

    public void unsetup(ExporterGEXF exporterGEXF) {
        exporterGEXF.setExportAttributes(attributesExportCheckbox.isSelected());
        exporterGEXF.setExportColors(colorsExportCheckbox.isSelected());
        exporterGEXF.setExportSize(sizeExportCheckbox.isSelected());
        exporterGEXF.setExportPosition(positionExportCheckbox.isSelected());
        exporterGEXF.setNormalize(normalizeCheckbox.isSelected());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelExport = new javax.swing.JLabel();
        positionExportCheckbox = new javax.swing.JCheckBox();
        colorsExportCheckbox = new javax.swing.JCheckBox();
        attributesExportCheckbox = new javax.swing.JCheckBox();
        sizeExportCheckbox = new javax.swing.JCheckBox();
        labelNormalize = new javax.swing.JLabel();
        normalizeCheckbox = new javax.swing.JCheckBox();

        labelExport.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.labelExport.text")); // NOI18N

        positionExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.positionExportCheckbox.text")); // NOI18N

        colorsExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.colorsExportCheckbox.text")); // NOI18N

        attributesExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.attributesExportCheckbox.text")); // NOI18N

        sizeExportCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.sizeExportCheckbox.text")); // NOI18N

        labelNormalize.setFont(new java.awt.Font("Tahoma", 0, 10));
        labelNormalize.setForeground(new java.awt.Color(102, 102, 102));
        labelNormalize.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.labelNormalize.text")); // NOI18N

        normalizeCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterGEXFPanel.class, "UIExporterGEXFPanel.normalizeCheckbox.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelExport)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(attributesExportCheckbox)
                            .addComponent(sizeExportCheckbox)
                            .addComponent(colorsExportCheckbox)
                            .addComponent(positionExportCheckbox)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(normalizeCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelNormalize)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExport)
                    .addComponent(positionExportCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(colorsExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sizeExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(attributesExportCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(normalizeCheckbox)
                    .addComponent(labelNormalize))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox attributesExportCheckbox;
    private javax.swing.JCheckBox colorsExportCheckbox;
    private javax.swing.JLabel labelExport;
    private javax.swing.JLabel labelNormalize;
    private javax.swing.JCheckBox normalizeCheckbox;
    private javax.swing.JCheckBox positionExportCheckbox;
    private javax.swing.JCheckBox sizeExportCheckbox;
    // End of variables declaration//GEN-END:variables

}
