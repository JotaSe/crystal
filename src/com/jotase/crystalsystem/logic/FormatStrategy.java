/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.logic;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.text.JTextComponent;

/**
 *
 * @author JotaSe
 */
public class FormatStrategy {

    private final DecimalFormat entry = new DecimalFormat("###,##0.00");
    public static final int TEXT = 1;
    public static final int INTEGER = 2;
    public static final int DOUBLE = 3;
    public static final int BOOLEAN = 4;

    public boolean setFormat(int type, JTextComponent textComponent,KeyEvent evt) {
        String source = textComponent.getText()+ evt.getKeyChar();
        //System.out.println("source = " + source);
        try {
            if (!source.isEmpty()) {
                switch (type) {
                    case INTEGER: //I LAVA YOU
                        entry.parse(source).intValue();
                        break;
                    case DOUBLE:
                        entry.parse(source).doubleValue();
                        break;
                }
            }
            textComponent.setForeground(Color.BLACK);
        } catch (ParseException parseException) {
            textComponent.setForeground(Color.red);
            return false;
            //parseException.printStackTrace();
        }
        return true;
    }

}
