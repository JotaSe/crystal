/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.DAO;

import com.jotase.crystalsystem.logic.QueryInterface;
import com.jotase.crystalsystem.models.Service;

/**
 *
 * @author JotaSe
 */
public class ServiceDAO extends DAO<Service> implements QueryInterface<Service> {

    
    public final int GET_SERVICE = 1;


    @Override
    public String getQuery(Service t, int query) {
        switch (query) {
            case GET_SERVICE:
                return "from Service s where s.name ='" + t.getName() + "'"
                        + " and s.thickness = " + t.getThickness() + " and s.priceType =" + t.getPriceType();
            default:
                return "from Service";
        }
    }

}
