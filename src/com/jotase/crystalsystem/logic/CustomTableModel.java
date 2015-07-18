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
import java.util.List;
import javax.swing.event.TableModelListener;

/**
 *
 * @author JotaSe
 */
public class CustomTableModel<T> implements javax.swing.table.TableModel {

    final List<T> source;
    private String[] columns;

    public CustomTableModel(List<T> objects) {
        source = objects;
        init();
    }

    private void init() {
        final T temp = source.get(0);
        if (temp instanceof Customers) {
            String[] c = {"ID","Nombre","Telefono","RIF","Direccion","Email","Contacto"};
            setColumns(c);
        }else if(temp instanceof Budget){
            String[] c = {"ID","Cliente","Fecha Creacion","Fecha de Entrega","Sub total","Total", "Nro Factura"};
            setColumns(c);
        }else if (temp instanceof Glasses){
            String[] c = {"ID","Estado","Fecha Terminado"};
            setColumns(c);
        }else if(temp instanceof Orderglass){
            String[] c = {"ID","Cantidad","Altura","Ancho","Espesor","Tipo","Comentario","Presupuesto"};
            setColumns(c);
        }else if(temp instanceof Replacement){
            String[] c = {"ID","Estado","Comentario"};
            setColumns(c);
        }else if(temp instanceof Service){
            String[] c = {"ID","Nombre","Espesor","Tipo de precio","Costo"};
            setColumns(c);
        }
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }
    
    @Override
    public int getRowCount() {
        return source.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int columnIndex
    ) {
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex
    ) {
        return null;

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener l
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener l
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public T getValueAt(int rowIndex) {
        return source.get(rowIndex);
    }
}
