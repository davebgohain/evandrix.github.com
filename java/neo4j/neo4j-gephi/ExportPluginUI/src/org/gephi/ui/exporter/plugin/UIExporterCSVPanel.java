/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UIExporterCSVPanel.java
 *
 * Created on 20 avr. 2010, 18:23:54
 */
package org.gephi.ui.exporter.plugin;

import org.gephi.io.exporter.plugin.ExporterCSV;

/**
 *
 * @author Mathieu Bastian
 */
public class UIExporterCSVPanel extends javax.swing.JPanel {

    public UIExporterCSVPanel() {
        initComponents();
    }

    public void setup(ExporterCSV exporterCSV) {
        listRadio.setSelected(exporterCSV.isList());
        matrixRadio.setSelected(!exporterCSV.isList());
        nodeIdCheckbox.setSelected(exporterCSV.isHeader());
        edgeWeightCheckbox.setSelected(exporterCSV.isEdgeWeight());
        zeroEdgeCheckbox.setSelected(exporterCSV.isWriteZero());
    }

    public void unsetup(ExporterCSV exporterCSV) {
        exporterCSV.setList(listRadio.isSelected());
        exporterCSV.setHeader(nodeIdCheckbox.isSelected());
        exporterCSV.setEdgeWeight(edgeWeightCheckbox.isSelected());
        exporterCSV.setWriteZero(zeroEdgeCheckbox.isSelected());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        buttonGroup1 = new javax.swing.ButtonGroup();
        edgeWeightCheckbox = new javax.swing.JCheckBox();
        labelExport = new javax.swing.JLabel();
        nodeIdCheckbox = new javax.swing.JCheckBox();
        zeroEdgeCheckbox = new javax.swing.JCheckBox();
        listRadio = new javax.swing.JRadioButton();
        matrixRadio = new javax.swing.JRadioButton();

        edgeWeightCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterCSVPanel.class, "UIExporterCSVPanel.edgeWeightCheckbox.text")); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, matrixRadio, org.jdesktop.beansbinding.ELProperty.create("${selected}"), edgeWeightCheckbox, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        labelExport.setText(org.openide.util.NbBundle.getMessage(UIExporterCSVPanel.class, "UIExporterCSVPanel.labelExport.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, matrixRadio, org.jdesktop.beansbinding.ELProperty.create("${selected}"), labelExport, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        nodeIdCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterCSVPanel.class, "UIExporterCSVPanel.nodeIdCheckbox.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, matrixRadio, org.jdesktop.beansbinding.ELProperty.create("${selected}"), nodeIdCheckbox, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        zeroEdgeCheckbox.setText(org.openide.util.NbBundle.getMessage(UIExporterCSVPanel.class, "UIExporterCSVPanel.zeroEdgeCheckbox.text")); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, matrixRadio, org.jdesktop.beansbinding.ELProperty.create("${selected}"), zeroEdgeCheckbox, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        buttonGroup1.add(listRadio);
        listRadio.setSelected(true);
        listRadio.setText(org.openide.util.NbBundle.getMessage(UIExporterCSVPanel.class, "UIExporterCSVPanel.listRadio.text")); // NOI18N

        buttonGroup1.add(matrixRadio);
        matrixRadio.setText(org.openide.util.NbBundle.getMessage(UIExporterCSVPanel.class, "UIExporterCSVPanel.matrixRadio.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listRadio)
                        .addGap(18, 18, 18)
                        .addComponent(matrixRadio))
                    .addComponent(zeroEdgeCheckbox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelExport)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(edgeWeightCheckbox)
                            .addComponent(nodeIdCheckbox))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listRadio)
                    .addComponent(matrixRadio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelExport)
                    .addComponent(nodeIdCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edgeWeightCheckbox)
                .addGap(18, 18, 18)
                .addComponent(zeroEdgeCheckbox)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox edgeWeightCheckbox;
    private javax.swing.JLabel labelExport;
    private javax.swing.JRadioButton listRadio;
    private javax.swing.JRadioButton matrixRadio;
    private javax.swing.JCheckBox nodeIdCheckbox;
    private javax.swing.JCheckBox zeroEdgeCheckbox;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
