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

    public String[] getQueryFilters(Object t) {
        if (t instanceof Customers) {
            String[] queries = {"ID", "RIF", "Nombre", "Contacto", "Email", "Filtro"};
            return queries;
        } else if (t instanceof Budget) {
            String[] queries = {"Todo", "Factura", "ID Cliente", "Filtro"};
            return queries;
        } else if (t instanceof Glasses) {
            String[] queries = {"ID", "Estado"};
            return queries;
        } else if (t instanceof Orderglass) {
            String[] queries = {"Todo", "Presupuesto", "Espesor", "Altura", "Ancho", "Suministrado", "Altura mayor a", "Altura menor a", "Ancho mayor a",
                "Ancho menor a", "Espesor mayor a", "Espesor menor a", "Tipo", "Precio mayor a", "Precio menor a", "Precio", "Filtro"};
            return queries;
        } else if (t instanceof Replacement) {
            String[] queries = {"Todo", "ID", "Estado", "Comentario", "Vidrio"};
            return queries;
        } else if (t instanceof Service) {
            String[] queries = {"Todo", "ID", "Tipo de precio (A,B,C)", "Espesor", "Nombre", "Filtro"};
            return queries;
        } else {
            return null;
        }
    }
    
    
}
