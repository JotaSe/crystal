/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.logic;

import com.jotase.crystalsystem.utils.UxUTils;
import com.jotase.crystalsystem.view.SearchView;
import java.awt.Container;


/**
 *
 * @author JotaSe
 * @param <T> Data model object
 * @param <K> JComponet for the view
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
            message.showMessage(message.SAVED, t, true);
        }
    }

    public void delete() {

        message.showMessage(message.DELETED, t, delete(t));

    }

    @Override
    public void edit() {

        util.enable((Container) view, enabled);
        super.edit();
    }

    public void cancel() {
        util.clean((Container) view);
    }

    public void search() {
        final SearchView sv = new SearchView(t);
       
        sv.setVisible(true);
        t = (T) sv.controller.getObject();
    }

}
