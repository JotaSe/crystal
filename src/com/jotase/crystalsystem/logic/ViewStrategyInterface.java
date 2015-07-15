/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jotase.crystalsystem.logic;

import com.jotase.crystalsystem.utils.UxUTils;

/**
 *
 * @author JotaSe
 */
public interface ViewStrategyInterface<T> {
    final UxUTils utils = new UxUTils();
    public void clean();
    public T get();
    public void set(T t);
    public void enable(boolean b);
    public void save();
    public void edit();
    public void delete();
    public void search();
    public void cancel();
    public void close();
}
