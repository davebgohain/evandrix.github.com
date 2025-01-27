/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

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
package org.gephi.ui.components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

//WORK IN PROGRESS, NOT WORKING NOT TESTED YET
public class SwapListPanel extends javax.swing.JPanel {

    /** Creates new form SwapListPanel */
    public SwapListPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        scrollPane1 = new javax.swing.JScrollPane();
        itemList1 = new javax.swing.JList();
        scrollPane2 = new javax.swing.JScrollPane();
        itemList2 = new javax.swing.JList();
        leftButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        itemList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollPane1.setViewportView(itemList1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(scrollPane1, gridBagConstraints);

        itemList2.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        scrollPane2.setViewportView(itemList2);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(scrollPane2, gridBagConstraints);

        leftButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/gephi/ui/components/resources/leftArrow.png"))); // NOI18N
        leftButton.setText(org.openide.util.NbBundle.getMessage(SwapListPanel.class, "SwapListPanel.leftButton.text")); // NOI18N
        leftButton.setMinimumSize(new java.awt.Dimension(33, 23));
        leftButton.setPreferredSize(new java.awt.Dimension(33, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        add(leftButton, gridBagConstraints);

        rightButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/gephi/ui/components/resources/rightArrow.png"))); // NOI18N
        rightButton.setText(org.openide.util.NbBundle.getMessage(SwapListPanel.class, "SwapListPanel.rightButton.text")); // NOI18N
        rightButton.setMinimumSize(new java.awt.Dimension(33, 23));
        rightButton.setPreferredSize(new java.awt.Dimension(33, 23));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 0, 0, 0);
        add(rightButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList itemList1;
    private javax.swing.JList itemList2;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JScrollPane scrollPane2;
    // End of variables declaration//GEN-END:variables

    private class SwapListModel {

        JList leftList;
        JList rightList;
        DefaultListModel leftModel = new DefaultListModel();
        DefaultListModel rightModel = new DefaultListModel();
        JButton leftButton;
        JButton rightButton;

        public SwapListModel(JList leftList, JList rightList, JButton leftButton, JButton rightButton) {
            this.leftList = leftList;
            this.rightList = rightList;
            this.leftButton = leftButton;
            this.rightButton = rightButton;
            leftList.setModel(leftModel);
            rightList.setModel(rightModel);

            leftButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    fromRightToLeftAction();
                }
            });

            rightButton.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    fromLeftToRightAction();
                }
            });
        }

        public void fromLeftToRightAction() {
            Object value = leftList.getSelectedValue();
            rightModel.addElement(value);
            leftModel.removeElement(value);
            rightButton.setEnabled(!rightModel.isEmpty());
            leftButton.setEnabled(!leftModel.isEmpty());
        }

        public void fromRightToLeftAction() {
            Object value = rightList.getSelectedValue();
            leftModel.addElement(value);
            rightModel.removeElement(value);
            rightButton.setEnabled(!rightModel.isEmpty());
            leftButton.setEnabled(!leftModel.isEmpty());
            if (leftList.getSelectedIndex() == -1 && !leftModel.isEmpty()) {
                leftList.setSelectedIndex(0);
            }
            if (rightList.getSelectedIndex() == -1 && !rightModel.isEmpty()) {
                rightList.setSelectedIndex(0);
            }
        }

        public Object[] getLeftValues() {
            return leftModel.toArray();
        }

        public Object[] getRightValues() {
            return rightModel.toArray();
        }

        public void setLeftValues(Object[] values) {
            leftModel.clear();
            for (Object o : values) {
                leftModel.addElement(o);
            }
            if (!leftModel.isEmpty()) {
                leftList.setSelectedIndex(0);
            }
            if (!rightModel.isEmpty()) {
                rightList.setSelectedIndex(0);
            }
            rightButton.setEnabled(!rightModel.isEmpty());
            leftButton.setEnabled(!leftModel.isEmpty());
        }
    }
}
