/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.controller;

import com.jotase.crystalsystem.logic.ControllerStrategy;
import com.jotase.crystalsystem.logic.QueryStrategy;
import com.jotase.crystalsystem.models.Customers;
import com.jotase.crystalsystem.models.DAO.CustomerDAO;
import com.jotase.crystalsystem.models.DAO.ServiceDAO;
import com.jotase.crystalsystem.view.SearchView;

/**
 *
 * @author JotaSe
 * @param <T>
 *
 */
public class SearchController<T> extends ControllerStrategy<T, SearchView> implements ControllerInterface<T> {

    final T t;
    final QueryStrategy queryStrategy = new QueryStrategy();

    public SearchController(SearchView view, T t) {
        this.view = view;
        this.t = t;
    }

    private void initComponents() {
        initCombo();
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void initCombo() {
        view.getComboFilters().removeAllItems();

        for (String filter : queryStrategy.getQueryFilters(t)) {
            view.getComboFilters().addItem(filter);
        }

    }

}
