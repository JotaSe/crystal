/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.logic;

import com.jotase.crystalsystem.models.Budget;
import com.jotase.crystalsystem.models.Customers;
import com.jotase.crystalsystem.models.Glasses;
import com.jotase.crystalsystem.models.Orderglass;
import com.jotase.crystalsystem.models.Replacement;
import com.jotase.crystalsystem.models.Service;

/**
 *
 * @author JotaSe
 */
public class QueryStrategy {

    //estado,espesor,precio
    public String[] getQueryFilters(Object t) {
        if (t instanceof Customers) {
            String[] queries = {"Todo", "ID", "RIF", "Nombre", "Contacto", "Email", "Filtro"};
            return queries;
        } else if (t instanceof Budget) {
            String[] queries = {"Todo", "Factura","Nombre de cliente", "ID Cliente", "Filtro"};
            return queries;
        } else if (t instanceof Glasses) {
            String[] queries = {"Todo", "ID", "Estado"};
            return queries;
        } else if (t instanceof Orderglass) {
            String[] queries = {"Todo", "Presupuesto", "Espesor", "Altura", "Ancho", "Suministrado", "Altura mayor a", "Altura menor a", "Ancho mayor a",
                "Ancho menor a", "Espesor mayor a", "Espesor menor a", "Tipo", "Precio mayor a", "Precio menor a", "Precio", "Filtro"};
            return queries;
        } else if (t instanceof Replacement) {
            String[] queries = {"Todo", "ID", "Estado", "Comentario", "Vidrio"};
            return queries;
        } else if (t instanceof Service) {
            String[] queries = {"Todo", "ID", "Tipo de precio", "Espesor", "Nombre", "Filtro"};
            return queries;
        } else {
            return null;
        }
    }

    private int returnType(int index, int[] _integer, int[] _double, int[] _text, int[] _boolean) {
        if (_integer != null) {
            if (isInside(index, _integer)) {
                return FormatStrategy.INTEGER;
            }
        } else if (_double != null) {
            if (isInside(index, _double)) {
                return FormatStrategy.DOUBLE;
            }

        } else if (_text != null) {
            if (isInside(index, _text)) {
                return FormatStrategy.TEXT;
            }
        } else if (_boolean != null) {
            if (isInside(index, _boolean)) {
                return FormatStrategy.BOOLEAN;
            }
        }

        return -1;

    }

    private boolean isInside(int index, int[] values) {
        for (int i : values) {
            if (i == index) {
                return true;
            }
        }
        return false;
    }

    private void asd() {
        boolean direction;
        int value;

    }

    public int filterType(Object t, int index) {
        //int index, int[] _integer, int[] _double, int[] _text, int[] _boolean
        if (t instanceof Customers) {
            // {"Todo", "ID", "RIF", "Nombre", "Contacto", "Email", "Filtro"};
            return returnType(index, new int[]{1}, null, new int[]{6, 2, 3, 4, 5}, null);
        } else if (t instanceof Budget) {
            //  String[] queries = {"Todo", "Factura",nombrecliente, "ID Cliente", "Filtro"};
            return returnType(index, new int[]{3}, null, new int[]{1,2, 4}, null);
        } else if (t instanceof Glasses) {
            // String[] queries = {"ID", "Estado"};
            return returnType(index, new int[]{1, 2}, null, null, null);
        } else if (t instanceof Orderglass) {
            /* String[] queries = {"Todo", "Presupuesto", "Espesor", "Altura", "Ancho", "Suministrado", "Altura mayor a", "Altura menor a", "Ancho mayor a",
             "Ancho menor a", "Espesor mayor a", "Espesor menor a", "Tipo", "Precio mayor a", "Precio menor a", "Precio", "Filtro"};*/
            return returnType(index, new int[]{1, 2, 3, 4, 6, 7, 8, 9, 10}, new int[]{13, 14, 15}, new int[]{16}, new int[]{5});
        } else if (t instanceof Replacement) {
            // String[] queries = {"Todo", "ID", "Estado", "Comentario", "Vidrio"};
            return returnType(index, new int[]{1, 2, 4}, null, new int[]{3}, null);
        } else if (t instanceof Service) {
            // String[] queries = {"Todo", "ID", "Tipo de precio (A,B,C)", "Espesor", "Nombre", "Filtro"};
            return returnType(index, new int[]{1, 3}, null, new int[]{4, 5}, null);
        } else {
            return -1;
        }
    }

}
