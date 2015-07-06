/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.logic;

import com.jotase.crystalsystem.models.DAO.DAO;
import com.jotase.crystalsystem.utils.UxUTils;
import com.jotase.crystalsystem.utils.Validate;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author JotaSe
 */
public class DataStrategy<T> {

    final DAO<T> dao = new DAO<>();
    final Validate validate = new Validate();
    boolean enabled;
    private boolean EDITABLE;

    public boolean save(T t) {

        if (!validate.validate(t)) {
            return false;
        }
        if (enabled) {
            if (EDITABLE) {

                dao.update(t);
                return true;

            } else {
                dao.insert(t);
                return true;

            }
        } else {
            setEditFirst();
            return false;
        }
    }

    public void delete(T t) {
        if (EDITABLE) {
            dao.delete(t);
        } else {
            setEditFirst();
        }
    }

    private void setEditFirst() {
        JOptionPane.showMessageDialog(null, "Debe seleccionar editar primero !", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public List<T> getList(String from, String query) {
        return dao.getList("from " + from + " " + query);
    }

    public void edit() {
        enabled = true;
    }
}
