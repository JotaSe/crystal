/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.controller;

import com.jotase.crystalsystem.logic.ControllerStrategy;

import com.jotase.crystalsystem.models.Customers;
import com.jotase.crystalsystem.view.CustomersView;
import javax.swing.JOptionPane;

/**
 *
 * @author JotaSe
 */
public class CustomerController extends ControllerStrategy<Customers, CustomersView> implements ControllerInterface<Customers> {

    public CustomerController(CustomersView view) {
        this.view = view;
        t = new Customers();
    }

    @Override
    public Customers retrieveObject() {
        Customers customers = new Customers();
        customers.setRif(view.getjTextField1().getText());
        customers.setAddress(view.getjTextArea1().getText());
        customers.setName(view.getjTextField2().getText());
        customers.setEmail(view.getjTextField4().getText());
        customers.setTelephone(view.getjTextField3().getText());
        return customers;
    }

    @Override
    public void load() {
        view.getjTextArea1().setText(t.getAddress());
        view.getjTextField1().setText(t.getRif());
        view.getjTextField2().setText(t.getName());
        view.getjTextField3().setText(t.getTelephone());
        view.getjTextField4().setText(t.getEmail());

    }

}
