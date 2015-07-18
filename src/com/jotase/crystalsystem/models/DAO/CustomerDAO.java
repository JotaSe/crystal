/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.DAO;

import com.jotase.crystalsystem.logic.QueryInterface;
import com.jotase.crystalsystem.models.Customers;

/**
 *
 * @author JotaSe
 */
public class CustomerDAO extends DAO<Customers> implements QueryInterface<Customers> {

    public final int GET_CUSTOMER_BY_ID = 1;
    public final int GET_CUSTOMER_BY_RIF = 2;
    public final int GET_CUSTOMER_BY_NAME = 3;
    public final int GET_CUSTOMER_BY_CONTACT = 4;
    public final int GET_CUSTOMER_BY_EMAIL = 5;
    public final int GET_CUSTOMERS_BY_FILTERS = 6;

    @Override
    public String getQuery(Customers t, int query) {
        switch (query) {
            case GET_CUSTOMER_BY_ID:
                return "from Customers where id=" + t.getId();
            case GET_CUSTOMER_BY_RIF:
                return "from Customers where RIF='" + t.getRif() + "'";
            case GET_CUSTOMERS_BY_FILTERS:
                return "from Customers where RIF LIKE %'" + t.getRif() + "'% or name LIKE %'" + t.getName() + "'% or Contacto LIKE %'" + t.getContacto() + "'% "
                        + "or telephone LIKE %'" + t.getName() + "'% or address LIKE %'" + t.getName() + "'%";
            case GET_CUSTOMER_BY_NAME:
                return "from Customers where name ='" + t.getName() + "'";
            case GET_CUSTOMER_BY_CONTACT:
                return "from Customers where Contacto ='" + t.getContacto() + "'";
            case GET_CUSTOMER_BY_EMAIL:
                return "from Customers where email ='" + t.getContacto() + "'";
            case 0:
            default:
                return "from Costumers";
        }
    }

    @Override
    public Customers getModelWithFilter(String filter, int query) {
        Customers t = new Customers();
        t.setContacto(filter);
        t.setEmail(filter);
        t.setName(filter);
        t.setRif(filter);
        t.setTelephone(filter);
        return t;
    }


}
