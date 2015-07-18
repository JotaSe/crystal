/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.models.DAO;

import com.jotase.crystalsystem.logic.QueryInterface;
import com.jotase.crystalsystem.models.Replacement;

/**
 *
 * @author JotaSe
 */
public class ReplacementDAO extends DAO<Replacement> implements QueryInterface<Replacement> {

    public final int GET_REPLACEMENT_BY_ID = 1;
    public final int GET_REPLACEMENT_BY_STATE = 2;
    public final int GET_REPLACEMENT_BY_COMMENTS = 3;
    public final int GET_REPLACEMENT_BY_GLASS = 4;
    private final String first = "from Replacement where ";

    @Override
    public String getQuery(Replacement t, int query) {
        switch (query) {
            case GET_REPLACEMENT_BY_ID:
                return first + " id=" + t.getId();
            case GET_REPLACEMENT_BY_STATE:
                return first + " state=" + t.getState();
            case GET_REPLACEMENT_BY_COMMENTS:
                return first + " comment LIKE %'" + t.getComment() + "'%";
            case GET_REPLACEMENT_BY_GLASS:
                return first + " glasses_id=" + t.getGlasses().getId();
            default:
                return "from Replacement";
        }
    }

    @Override
    public Replacement getModelWithFilter(String filter, int query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



}
