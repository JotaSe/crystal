/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.DAO;

import com.jotase.crystalsystem.logic.QueryInterface;
import com.jotase.crystalsystem.models.Budget;
import com.jotase.crystalsystem.models.Customers;

/**
 *
 * @author JotaSe
 */
public class BudgetDAO extends DAO<Budget> implements QueryInterface<Budget> {

    public final int GET_BUDGET_BY_ID = 1;
    public final int GET_BUDGET_BY_INVOICE = 2;
    public final int GET_BUDGET_BY_CUSTOMERS_NAME = 3;
    public final int GET_BUDGET_BY_CUSTOMERS_ID = 4;
    public final int GET_BUDGET_BY_FILTERS = 5;

    @Override
    public String getQuery(Budget t, int query) {
        final CustomerDAO dao = new CustomerDAO();
        switch (query) {
            case GET_BUDGET_BY_ID:
                return "from budget where id = " + t.getId();
            case GET_BUDGET_BY_INVOICE:
                return "from budget where invoice ='" + t.getInvoice() + "'";
            case GET_BUDGET_BY_CUSTOMERS_ID:
                return "from budget where customers_id=" + t.getCustomers().getId();
            case GET_BUDGET_BY_CUSTOMERS_NAME:

                return "from budget where customers_id=" + dao.get(t.getCustomers(), dao.getQuery(t.getCustomers(), GET_BUDGET_BY_CUSTOMERS_NAME));
            case GET_BUDGET_BY_FILTERS:
                return "from budget where invoice LIKE%'" + t.getInvoice() + "'% or "
                        + " customers_id=" + dao.get(t.getCustomers(), dao.getQuery(t.getCustomers(), GET_BUDGET_BY_CUSTOMERS_NAME));
            default:
                return "from budget";

        }
    }

    @Override
    public Budget getModelWithFilter(String filter, int query) {
        Budget t = new Budget();
        Customers c = new Customers();
        t.setInvoice(filter);
        c.setName(filter);
        t.setCustomers(c);
        return t;
    }



}
