/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.DAO;

import com.jotase.crystalsystem.logic.QueryInterface;
import com.jotase.crystalsystem.models.Glasses;

/**
 *
 * @author JotaSe
 */
public class GlassesDAO extends DAO<Glasses> implements QueryInterface<Glasses> {

    public final int GET_GLASSES_BY_ID = 1;
    public final int GET_GLASSES_BY_STATE = 2;

    @Override
    public String getQuery(Glasses t, int query) {
        switch (query) {
            case GET_GLASSES_BY_ID:
                return "from Glasses where id =" + t.getId();
            case GET_GLASSES_BY_STATE:
                return "from glasses where state =" + t.getState();
            default:
                return "from glasses";
        }
    }

    @Override
    public Glasses getModelWithFilter(String filter, int query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
