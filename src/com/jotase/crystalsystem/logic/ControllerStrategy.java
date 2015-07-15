/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.logic;

import com.jotase.crystalsystem.utils.UxUTils;
import java.awt.Container;
import javax.swing.JOptionPane;

/**
 *
 * @author JotaSe
 */
public class ControllerStrategy<T, K> extends DataStrategy<T> {

    final UxUTils util = new UxUTils();
    public K view;
    public T t;
    final MessageStrategy message = new MessageStrategy();

    public T retrieveObject() {
        return null;
    }

    public void save() {
        if (save(retrieveObject())) {
            cancel();
            message.showMessage(message.SAVED, t);
        }
    }

    public void delete() {
        delete(t);
        message.showMessage(message.DELETED, t);
    }

    @Override
    public void edit() {

        util.enable((Container) view, enabled);
        super.edit();
    }

    public void cancel() {
        util.clean((Container) view);
    }
    
    public void search(){
        
    }

}