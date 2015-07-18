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

    public final int GET_SERVICE = 6;
    public final int GET_SERVICE_BY_PRICE_TYPE = 2;
    public final int GET_SERVICE_BY_THICKNESS = 3;
    public final int GET_SERVICE_BY_NAME = 4;
    public final int GET_SERVICE_BY_FILTER = 5;
    public final int GET_SERVICE_BY_ID = 1;

    @Override
    public String getQuery(Service t, int query) {
        switch (query) {
            case GET_SERVICE:
                return "from Service s where s.name ='" + t.getName() + "'"
                        + " and s.thickness = " + t.getThickness() + " and s.priceType =" + t.getPriceType();
            case GET_SERVICE_BY_ID:
                return "from Service s where s.id = " + t.getId();
            case GET_SERVICE_BY_NAME:
                return "from Service s where s.name ='" + t.getName() + "'";
            case GET_SERVICE_BY_PRICE_TYPE:
                return "from Serviec s where s.priceType =" + t.getPriceType();
            case GET_SERVICE_BY_THICKNESS:
                return "from Service s where s.thickness = " + t.getThickness();
            case GET_SERVICE_BY_FILTER:
                return "from Service s wher s.name LIKE %'" + t.getName() + "'%";
            default:
                return "from Service";
        }
    }

    @Override
    public Service getModelWithFilter(String filter, int query) {
        Service t = new Service(filter);
        return t;
    }


}
