/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.utils;

import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author JotaSe
 */
public class UxUTils {

    private List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<Component>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container) {
                compList.addAll(getAllComponents((Container) comp));
            }
        }
        return compList;
    }

    public void clean(final Container c) {

        for (Component C : getAllComponents(c)) {

            if (C instanceof JTextField || C instanceof JTextArea) {

                ((JTextComponent) C).setText(""); //abstract superclass
            } else if (C instanceof JCheckBox) {
                ((JCheckBox) C).setSelected(false);
            } else if (C instanceof JLabel && "imagen".equals(((JLabel) C).getName())) {
                ((JLabel) C).setIcon(null);
            }

        }
    }

    public void enable(final Container c, boolean b) {
        for (Component C : getAllComponents(c)) {

            if (C instanceof JTextField || C instanceof JTextArea) {

                ((JTextComponent) C).setEnabled(b); //abstract superclass
            } else if (C instanceof JCheckBox) {
                ((JCheckBox) C).setEnabled(b);
            }

        }

    }
}
