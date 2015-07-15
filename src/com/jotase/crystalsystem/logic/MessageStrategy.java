/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.crystalsystem.logic;

import com.jotase.crystalsystem.models.Customers;
import javax.swing.JOptionPane;

/**
 *
 * @author JotaSe
 */
public class MessageStrategy {
    final String SAVED = "Guardado";
    final String DELETED = "Borrado";
    final String EDITED = "Editado";
    
    public void showMessage(String operationType,Object object){
        JOptionPane.showMessageDialog(null, getObjectType(object)+ " ha sido "+operationType+" con exito!");
    }
    private String getObjectType(Object object){
        if(object instanceof Customers) return "Cliente";
        return "Datos";
    }
}
