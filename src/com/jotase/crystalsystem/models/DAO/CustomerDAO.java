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
public class CustomerDAO extends DAO<Customers> implements QueryInterface<Customers>{

   
    public final int GET_CUSTOMER_BY_ID=1;
    public final int GET_CUSTOMER_BY_RIF=2;
    public final int GET_CUSTOMERS_BY_FILTERS=3;
    
    @Override
    public String getQuery(Customers t, int query) {
                switch (query) {
            case GET_CUSTOMER_BY_ID:
                return "from Customers where id="+t.getId();
            case GET_CUSTOMER_BY_RIF:
                return "from Customers where RIF='"+t.getRif()+"'";
            case GET_CUSTOMERS_BY_FILTERS:
                return "from Customers where RIF LIKE %'"+t.getRif()+"'% or name LIKE %'"+t.getName()+"'% ";
            default:
                return "from Costumers";
        }
    }
    
}
