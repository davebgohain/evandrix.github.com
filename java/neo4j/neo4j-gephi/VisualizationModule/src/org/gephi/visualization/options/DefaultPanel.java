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
package org.gephi.visualization.options;

import com.connectina.swing.fontchooser.JFontChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.gephi.ui.utils.ColorUtils;
import org.gephi.ui.utils.FontUtils;
import org.gephi.visualization.apiimpl.VizConfig;
import org.openide.util.NbPreferences;
import org.openide.windows.WindowManager;

final class DefaultPanel extends javax.swing.JPanel {

    private final DefaultOptionsPanelController controller;
    //Settings
    private Font nodeFont;
    private Font edgeFont;

    DefaultPanel(DefaultOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        nodeFontButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Font font = JFontChooser.showDialog(WindowManager.getDefault().getMainWindow(), nodeFont);
                if (font != null) {
                    nodeFont = font;
                    nodeFontButton.setText(nodeFont.getFontName() + ", " + nodeFont.getSize());
                }
            }
        });
        edgeFontButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Font font = JFontChooser.showDialog(WindowManager.getDefault().getMainWindow(), edgeFont);
                if (font != null) {
                    edgeFont = font;
                    edgeFontButton.setText(edgeFont.getFontName() + ", " + edgeFont.getSize());
                }
            }
        });
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleDesign = new org.jdesktop.swingx.JXTitledSeparator();
        titleLabel = new org.jdesktop.swingx.JXTitledSeparator();
        labelDefaultSettings = new javax.swing.JLabel();
        use3dCheckbox = new javax.swing.JCheckBox();
        autoSelectNeighborCheckbox = new javax.swing.JCheckBox();
        highlightCheckbox = new javax.swing.JCheckBox();
        labelColor = new javax.swing.JLabel();
        nodeLabelColorButton = new net.java.dev.colorchooser.ColorChooser();
        labelNodeLabelColor = new javax.swing.JLabel();
        labelEdgeLabelColor = new javax.swing.JLabel();
        edgeLabelColorButton = new net.java.dev.colorchooser.ColorChooser();
        labelFont = new javax.swing.JLabel();
        nodeFontButton = new javax.swing.JButton();
        labelNodeFont = new javax.swing.JLabel();
        labelEdgeFont = new javax.swing.JLabel();
        edgeFontButton = new javax.swing.JButton();
        labelBackground = new javax.swing.JLabel();
        labelBackgroundPanel = new javax.swing.JPanel();
        backgroundColor = new net.java.dev.colorchooser.ColorChooser();
        labelBackgroundColor = new javax.swing.JLabel();
        resetButton = new javax.swing.JButton();

        titleDesign.setTitle(org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.titleDesign.title")); // NOI18N

        titleLabel.setTitle(org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.titleLabel.title")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelDefaultSettings, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelDefaultSettings.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(use3dCheckbox, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.use3dCheckbox.text")); // NOI18N
        use3dCheckbox.setMargin(new java.awt.Insets(2, 0, 2, 2));

        org.openide.awt.Mnemonics.setLocalizedText(autoSelectNeighborCheckbox, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.autoSelectNeighborCheckbox.text")); // NOI18N
        autoSelectNeighborCheckbox.setMargin(new java.awt.Insets(2, 0, 2, 2));

        org.openide.awt.Mnemonics.setLocalizedText(highlightCheckbox, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.highlightCheckbox.text")); // NOI18N
        highlightCheckbox.setMargin(new java.awt.Insets(2, 0, 2, 2));

        org.openide.awt.Mnemonics.setLocalizedText(labelColor, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelColor.text")); // NOI18N

        nodeLabelColorButton.setPreferredSize(new java.awt.Dimension(12, 12));

        javax.swing.GroupLayout nodeLabelColorButtonLayout = new javax.swing.GroupLayout(nodeLabelColorButton);
        nodeLabelColorButton.setLayout(nodeLabelColorButtonLayout);
        nodeLabelColorButtonLayout.setHorizontalGroup(
            nodeLabelColorButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        nodeLabelColorButtonLayout.setVerticalGroup(
            nodeLabelColorButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(labelNodeLabelColor, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelNodeLabelColor.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelEdgeLabelColor, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelEdgeLabelColor.text")); // NOI18N

        edgeLabelColorButton.setPreferredSize(new java.awt.Dimension(12, 12));

        javax.swing.GroupLayout edgeLabelColorButtonLayout = new javax.swing.GroupLayout(edgeLabelColorButton);
        edgeLabelColorButton.setLayout(edgeLabelColorButtonLayout);
        edgeLabelColorButtonLayout.setHorizontalGroup(
            edgeLabelColorButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        edgeLabelColorButtonLayout.setVerticalGroup(
            edgeLabelColorButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        org.openide.awt.Mnemonics.setLocalizedText(labelFont, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelFont.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(nodeFontButton, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.nodeFontButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelNodeFont, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelNodeFont.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelEdgeFont, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelEdgeFont.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(edgeFontButton, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.edgeFontButton.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(labelBackground, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelBackground.text")); // NOI18N

        labelBackgroundPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 5));

        backgroundColor.setPreferredSize(new java.awt.Dimension(12, 12));

        javax.swing.GroupLayout backgroundColorLayout = new javax.swing.GroupLayout(backgroundColor);
        backgroundColor.setLayout(backgroundColorLayout);
        backgroundColorLayout.setHorizontalGroup(
            backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        backgroundColorLayout.setVerticalGroup(
            backgroundColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        labelBackgroundPanel.add(backgroundColor);

        labelBackgroundColor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        org.openide.awt.Mnemonics.setLocalizedText(labelBackgroundColor, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.labelBackgroundColor.text")); // NOI18N
        labelBackgroundColor.setPreferredSize(new java.awt.Dimension(28, 14));
        labelBackgroundPanel.add(labelBackgroundColor);

        org.openide.awt.Mnemonics.setLocalizedText(resetButton, org.openide.util.NbBundle.getMessage(DefaultPanel.class, "DefaultPanel.resetButton.text")); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleDesign, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDefaultSettings)
                            .addComponent(labelBackground))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(use3dCheckbox)
                            .addComponent(autoSelectNeighborCheckbox)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelBackgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(highlightCheckbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelColor)
                            .addComponent(labelFont, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nodeFontButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNodeFont))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edgeLabelColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEdgeLabelColor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nodeLabelColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNodeLabelColor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(edgeFontButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelEdgeFont))))
                    .addComponent(resetButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleDesign, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(labelDefaultSettings))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(use3dCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoSelectNeighborCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(highlightCheckbox)))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelBackground)
                    .addComponent(labelBackgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelColor)
                        .addGap(34, 34, 34)
                        .addComponent(labelFont))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nodeLabelColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNodeLabelColor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edgeLabelColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelEdgeLabelColor))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nodeFontButton)
                            .addComponent(labelNodeFont))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edgeFontButton)
                            .addComponent(labelEdgeFont))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(resetButton)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.USE_3D);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.HIGHLIGHT);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.NEIGHBOUR_SELECT);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.BACKGROUND_COLOR);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.NODE_LABEL_COLOR);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.EDGE_LABEL_COLOR);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.NODE_LABEL_FONT);
        NbPreferences.forModule(VizConfig.class).remove(VizConfig.EDGE_LABEL_FONT);
        load();
    }//GEN-LAST:event_resetButtonActionPerformed

    void load() {
        //Default design settings
        use3dCheckbox.setSelected(NbPreferences.forModule(VizConfig.class).getBoolean(VizConfig.USE_3D, VizConfig.DEFAULT_USE_3D));
        highlightCheckbox.setSelected(NbPreferences.forModule(VizConfig.class).getBoolean(VizConfig.HIGHLIGHT, VizConfig.DEFAULT_HIGHLIGHT));
        autoSelectNeighborCheckbox.setSelected(NbPreferences.forModule(VizConfig.class).getBoolean(VizConfig.NEIGHBOUR_SELECT, VizConfig.DEFAULT_NEIGHBOUR_SELECT));
        backgroundColor.setColor(ColorUtils.decode(NbPreferences.forModule(VizConfig.class).get(VizConfig.BACKGROUND_COLOR, ColorUtils.encode(VizConfig.DEFAULT_BACKGROUND_COLOR))));

        //Label settings
        nodeLabelColorButton.setColor(ColorUtils.decode(NbPreferences.forModule(VizConfig.class).get(VizConfig.NODE_LABEL_COLOR, ColorUtils.encode(VizConfig.DEFAULT_NODE_LABEL_COLOR))));
        edgeLabelColorButton.setColor(ColorUtils.decode(NbPreferences.forModule(VizConfig.class).get(VizConfig.EDGE_LABEL_COLOR, ColorUtils.encode(VizConfig.DEFAULT_EDGE_LABEL_COLOR))));
        nodeFont = Font.decode(NbPreferences.forModule(VizConfig.class).get(VizConfig.NODE_LABEL_FONT, FontUtils.encode(VizConfig.DEFAULT_NODE_LABEL_FONT)));
        nodeFontButton.setText(nodeFont.getFontName() + ", " + nodeFont.getSize());
        edgeFont = Font.decode(NbPreferences.forModule(VizConfig.class).get(VizConfig.EDGE_LABEL_FONT, FontUtils.encode(VizConfig.DEFAULT_EDGE_LABEL_FONT)));
        edgeFontButton.setText(edgeFont.getFontName() + ", " + edgeFont.getSize());
    }

    void store() {
        //Default design settings
        NbPreferences.forModule(VizConfig.class).putBoolean(VizConfig.USE_3D, use3dCheckbox.isSelected());
        NbPreferences.forModule(VizConfig.class).putBoolean(VizConfig.HIGHLIGHT, highlightCheckbox.isSelected());
        NbPreferences.forModule(VizConfig.class).putBoolean(VizConfig.NEIGHBOUR_SELECT, autoSelectNeighborCheckbox.isSelected());
        NbPreferences.forModule(VizConfig.class).put(VizConfig.BACKGROUND_COLOR, ColorUtils.encode(backgroundColor.getColor()));

        //Label settings
        NbPreferences.forModule(VizConfig.class).put(VizConfig.NODE_LABEL_COLOR, ColorUtils.encode(nodeLabelColorButton.getColor()));
        NbPreferences.forModule(VizConfig.class).put(VizConfig.EDGE_LABEL_COLOR, ColorUtils.encode(edgeLabelColorButton.getColor()));
        NbPreferences.forModule(VizConfig.class).put(VizConfig.NODE_LABEL_FONT, FontUtils.encode(nodeFont));
        NbPreferences.forModule(VizConfig.class).put(VizConfig.EDGE_LABEL_FONT, FontUtils.encode(edgeFont));
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox autoSelectNeighborCheckbox;
    private net.java.dev.colorchooser.ColorChooser backgroundColor;
    private javax.swing.JButton edgeFontButton;
    private net.java.dev.colorchooser.ColorChooser edgeLabelColorButton;
    private javax.swing.JCheckBox highlightCheckbox;
    private javax.swing.JLabel labelBackground;
    private javax.swing.JLabel labelBackgroundColor;
    private javax.swing.JPanel labelBackgroundPanel;
    private javax.swing.JLabel labelColor;
    private javax.swing.JLabel labelDefaultSettings;
    private javax.swing.JLabel labelEdgeFont;
    private javax.swing.JLabel labelEdgeLabelColor;
    private javax.swing.JLabel labelFont;
    private javax.swing.JLabel labelNodeFont;
    private javax.swing.JLabel labelNodeLabelColor;
    private javax.swing.JButton nodeFontButton;
    private net.java.dev.colorchooser.ColorChooser nodeLabelColorButton;
    private javax.swing.JButton resetButton;
    private org.jdesktop.swingx.JXTitledSeparator titleDesign;
    private org.jdesktop.swingx.JXTitledSeparator titleLabel;
    private javax.swing.JCheckBox use3dCheckbox;
    // End of variables declaration//GEN-END:variables
}
