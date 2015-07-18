/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.DAO;

import com.jotase.crystalsystem.logic.QueryInterface;
import com.jotase.crystalsystem.models.Orderglass;

/**
 *
 * @author JotaSe
 */
public class OrderGlassDAO extends DAO<Orderglass> implements QueryInterface<Orderglass> {

    public final int GET_ORDERGLASS_BY_ID = 1;
    public final int GET_ORDERGLASS_BY_BUDGET = 2;
    public final int GET_ORDERGLASS_BY_THICKNESS = 3;
    public final int GET_ORDERGLASS_BY_HEIGHT = 4;
    public final int GET_ORDERGLASS_BY_WIDTH = 5;
    public final int GET_ORDERGLASS_BY_SUPPLIED = 6;
    public final int GET_ORDERGLASS_BY_HEIGHT_GREATER_THAN = 7;
    public final int GET_ORDERGLASS_BY_HEIGHT_MINOR_THAN = 8;
    public final int GET_ORDERGLASS_BY_WIDTH_GREATHER_THAN = 9;
    public final int GET_ORDERGLASS_BY_WIDTH_MINOR_THAN = 10;
    public final int GET_ORDERGLASS_BY_THICKNESS_GREATHER_THAN = 11;
    public final int GET_ORDERGLASS_BY_THICKNESS_MINOR_THAN = 12;
    public final int GET_ORDERGLASS_BY_TYPE = 13;
    public final int GET_ORDERGLASS_BY_PRICE_GREATHER_THAN = 14;
    public final int GET_ORDERGLASS_BY_PRICE_MINOR_THAN = 15;
    public final int GET_ORDERGLASS_BY_PRICE = 16;
    public final int GET_ORDERGLASS_BY_FILTER = 17;
    final String first = "from orderglass where ";

    @Override
    public String getQuery(Orderglass t, int query) {
        switch (query) {
            case GET_ORDERGLASS_BY_ID:
                return first + "id =" + t.getId();
            case GET_ORDERGLASS_BY_BUDGET:
                return first + " budget_id=" + t.getBudget().getId();
            case GET_ORDERGLASS_BY_THICKNESS:
                return first + " thickness=" + t.getThickness();
            case GET_ORDERGLASS_BY_THICKNESS_GREATHER_THAN:
                return first + " thickness>" + t.getThickness();
            case GET_ORDERGLASS_BY_THICKNESS_MINOR_THAN:
                return first + " thickness<" + t.getThickness();
            case GET_ORDERGLASS_BY_HEIGHT:
                return first + " height=" + t.getHeight();
            case GET_ORDERGLASS_BY_HEIGHT_GREATER_THAN:
                return first + " height>" + t.getHeight();
            case GET_ORDERGLASS_BY_HEIGHT_MINOR_THAN:
                return first + " height<" + t.getHeight();
            case GET_ORDERGLASS_BY_WIDTH:
                return first + " width=" + t.getWidth();
            case GET_ORDERGLASS_BY_WIDTH_GREATHER_THAN:
                return first + " width>" + t.getWidth();
            case GET_ORDERGLASS_BY_WIDTH_MINOR_THAN:
                return first + " width<" + t.getWidth();
            case GET_ORDERGLASS_BY_SUPPLIED:
                return first + "supplied=" + t.getSupplied();
            case GET_ORDERGLASS_BY_PRICE:
                return first + " price=" + t.getPrice();
            case GET_ORDERGLASS_BY_PRICE_GREATHER_THAN:
                return first + " price>" + t.getPrice();
            case GET_ORDERGLASS_BY_PRICE_MINOR_THAN:
                return first + " price<" + t.getPrice();
            case GET_ORDERGLASS_BY_TYPE:
                return first + "type='" + t.getType() + "'";
            case GET_ORDERGLASS_BY_FILTER:
                return first + " comments LIKE %'" + t.getComments() + "'% or type LIKE %'" + t.getType() + "'%";
            default:
                return "from orderglass";
        }
    }

    @Override
    public Orderglass getModelWithFilter(String filter, int query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
