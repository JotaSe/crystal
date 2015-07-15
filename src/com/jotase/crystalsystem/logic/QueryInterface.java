/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.crystalsystem.logic;

/**
 *
 * @author JotaSe
 * @param <T>
 */
public interface QueryInterface <T> {

    public final int GET_DEFAULT =0;
    public String getQuery(T t,int query);
    
}
