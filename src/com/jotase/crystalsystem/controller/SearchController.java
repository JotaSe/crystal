/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.controller;

import com.jotase.crystalsystem.logic.ControllerStrategy;
import com.jotase.crystalsystem.logic.CustomTableModel;
import com.jotase.crystalsystem.logic.FormatStrategy;
import com.jotase.crystalsystem.logic.QueryStrategy;
import com.jotase.crystalsystem.models.Budget;
import com.jotase.crystalsystem.models.BudgetId;
import com.jotase.crystalsystem.models.Customers;
import com.jotase.crystalsystem.models.DAO.BudgetDAO;
import com.jotase.crystalsystem.models.DAO.CustomerDAO;
import com.jotase.crystalsystem.models.DAO.GlassesDAO;
import com.jotase.crystalsystem.models.Glasses;
import com.jotase.crystalsystem.models.GlassesId;
import com.jotase.crystalsystem.models.Orderglass;
import com.jotase.crystalsystem.models.Replacement;
import com.jotase.crystalsystem.models.ReplacementId;
import com.jotase.crystalsystem.models.Service;
import com.jotase.crystalsystem.models.enums.GlassAttr;
import com.jotase.crystalsystem.view.SearchView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JotaSe
 * @param <T>
 *
 */
public class SearchController<T> extends ControllerStrategy<T, SearchView> implements ControllerInterface<T> {

    T t;
    final QueryStrategy queryStrategy = new QueryStrategy();
    final FormatStrategy formatStrategy = new FormatStrategy();

    public SearchController(SearchView view, T t) {
        this.view = view;
        this.t = t;

        initComponents();
    }

    private void initComponents() {

        initCombo();
        setActionlisteners();
    }

    public void formatInput(KeyEvent evt) {
        final int type = queryStrategy.filterType(t, view.getComboFilters().getSelectedIndex());
        //System.out.println("type = " + type);

        switch (type) {
            case FormatStrategy.DOUBLE:
            case FormatStrategy.INTEGER:
                view.getSearchButton().setEnabled(formatStrategy.setFormat(type, view.getjTextField1(),evt));
                //view.getjTextField1().requestFocus();
                break;

        }

    }

    private void setActionlisteners() {
        final int type = queryStrategy.filterType(t, view.getComboFilters().getSelectedIndex());
        view.getComboFilters().addActionListener((ActionEvent e) -> {
            isText(type == FormatStrategy.TEXT);

            checkForList();
        });
    }

    private void checkForList() {
        final String value = view.getComboFilters().getSelectedItem().toString();
        switch (value) {
            case "Espesor":
                prepareComboValue();
                for (GlassAttr.GlassThickness object : GlassAttr.GlassThickness.values()) {
                    view.getComboValue().addItem(object.getName());
                }
                break;
            case "Estado":
                prepareComboValue();
                for (GlassAttr.GlassState object : GlassAttr.GlassState.values()) {
                    view.getComboValue().addItem(object.getName());
                }
                break;
            case "Tipo de precio":
                prepareComboValue();
                for (GlassAttr.PriceType object : GlassAttr.PriceType.values()) {
                    view.getComboValue().addItem(object.getName());
                }
                break;
            case "Nombre":
                if (t instanceof Service) {
                    prepareComboValue();
                    for (GlassAttr.GlassService object : GlassAttr.GlassService.values()) {
                        view.getComboValue().addItem(object.getName());
                    }
                }
                break;
            case "Suministrado":
                prepareComboValue();
                view.getComboValue().addItem("Suministrado");
                view.getComboValue().addItem("Para Fabricar");
            default:
                isText(true);
        }
    }

    private void prepareComboValue() {
        isText(false);
        view.getComboValue().removeAllItems();
    }

    private void isText(boolean b) {
        if (b) {
            view.getjTextField1().setEnabled(true);
            view.getComboValue().setEnabled(false);
        } else {
            view.getjTextField1().setEnabled(false);
            view.getComboValue().setEnabled(true);
        }
    }

    @Override
    public void load() {
        String value = (view.getjTextField1().isEnabled()) ? view.getjTextField1().getText() : view.getComboValue().getSelectedItem().toString();
        List<T> ts = new ArrayList<T>();
        final int index = view.getComboFilters().getSelectedIndex();
        value = (index == 0) ? "1" : value;
        if (t instanceof Customers) {
            final Customers object = (Customers) t;
            final CustomerDAO temp = new CustomerDAO();

            try {
                object.setId(Integer.parseInt(value));
            } catch (NumberFormatException numberFormatException) {
            }
            object.setRif(value);
            object.setAddress(value);
            object.setContacto(value);
            object.setEmail(value);
            object.setName(value);
            object.setTelephone(value);
            ts = dao.getList(temp.getQuery(object, index));

        } else if (t instanceof Budget) {
            final Budget object = (Budget) t;
            final BudgetId id = new BudgetId();
            final BudgetDAO temp = new BudgetDAO();
            try {
                id.setId(Integer.parseInt(value));
                object.setSubtotal(Double.parseDouble(value));
                object.setTotal(Double.parseDouble(value));
            } catch (NumberFormatException numberFormatException) {
            }
            object.setId(id);
            object.setInvoice(value);

            ts = dao.getList(temp.getQuery(object, index));
        } else if (t instanceof Glasses) {
            final Glasses object = (Glasses) t;
            final GlassesId id = new GlassesId();
            final GlassesDAO temp = new GlassesDAO();
            try {
                id.setId(Integer.parseInt(value));
            } catch (NumberFormatException numberFormatException) {
            }
            object.setId(id);
            object.setState(GlassAttr.GlassState.getState(value).getId());
            ts = dao.getList(temp.getQuery(object, index));
        } else if (t instanceof Orderglass) {
            final Orderglass object = (Orderglass) t;
            object.setComments(value);
            try {
                object.setHeight(Integer.parseInt(value));
                object.setPrice(Double.parseDouble(value));
                object.setQty(Integer.parseInt(value));
                object.setThickness(Integer.parseInt(value));
                object.setWidth(Integer.parseInt(value));
            } catch (NumberFormatException numberFormatException) {
            }
            object.setType(value);
            object.setSupplied(index == 0);

        } else if (t instanceof Replacement) {
            final Replacement object = (Replacement) t;
            final ReplacementId id = new ReplacementId();

            object.setComment(value);
            try {
                object.setState(Integer.parseInt(value));
                id.setGlassesId(Integer.parseInt(value));
                object.setId(id);
            } catch (NumberFormatException numberFormatException) {
            }

        } else if (t instanceof Service) {

        }
        if (ts.size() > 0) {
            final CustomTableModel ctm = new CustomTableModel(ts);
            view.getTable().setModel(ctm);
        }

    }

    private void initCombo() {
        view.getComboFilters().removeAllItems();

        for (String filter : queryStrategy.getQueryFilters(t)) {
            view.getComboFilters().addItem(filter);
        }

    }

    public T getObject() {
        return t;
    }

    public void formatInput() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
