/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.controller;

import java.util.List;

/**
 *
 * @author JotaSe
 */
public interface ControllerInterface<T> {

    /**
     *
     * @param b
     */
    public void enable(boolean b);

    public void edit();

    public void save(T t);

    public void delete(T t);

    public List<T> getList(String query);

    public void set(T t);

    public T get();

    public void clean();

    public void search();

    public void setEditFirst();

}
