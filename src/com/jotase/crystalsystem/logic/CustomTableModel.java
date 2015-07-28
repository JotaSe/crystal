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
import com.jotase.crystalsystem.models.enums.GlassAttr;
import java.util.List;
import javax.swing.event.TableModelListener;

/**
 *
 * @author JotaSe
 */
public class CustomTableModel<T> implements javax.swing.table.TableModel {

    final List<T> source;
    private String[] columns;
     T temp;

    public CustomTableModel(List<T> objects) {
        source = objects;
        try {
            temp = source.get(0);
        } catch (Exception e) {
        }
        init();
    }

    private void init() {

        if (temp instanceof Customers) {
            String[] c = {"ID", "Nombre", "Telefono", "RIF", "Direccion", "Email", "Contacto"};
            setColumns(c);
        } else if (temp instanceof Budget) {
            String[] c = {"ID", "Cliente", "Fecha Creacion", "Fecha de Entrega", "Sub total", "Total", "Nro Factura"};
            setColumns(c);
        } else if (temp instanceof Glasses) {
            String[] c = {"ID", "Estado", "Fecha Terminado"};
            setColumns(c);
        } else if (temp instanceof Orderglass) {
            String[] c = {"ID", "Cantidad", "Altura", "Ancho", "Espesor", "Tipo", "Comentario", "Presupuesto"};
            setColumns(c);
        } else if (temp instanceof Replacement) {
            String[] c = {"ID", "Estado", "Comentario"};
            setColumns(c);
        } else if (temp instanceof Service) {
            String[] c = {"ID", "Nombre", "Espesor", "Tipo de precio", "Costo"};
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
        return source.get(0).getClass();
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex
    ) {
        return false;
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex
    ) {
        //ID", "Nombre", "Telefono", "RIF", "Direccion", "Email", "Contacto
        if (temp instanceof Customers) {
            final Customers object = (Customers) temp;
            switch (columnIndex) {
                case 0:
                    return object.getId();
                case 1:
                    return object.getName();
                case 2:
                    return object.getTelephone();
                case 3:
                    return object.getRif();
                case 4:
                    return object.getAddress();
                case 5:
                    return object.getEmail();
                case 6:
                    return object.getContacto();
                default:
                    return null;
            }
        } else if (temp instanceof Budget) {
            final Budget object = (Budget) temp;
            switch (columnIndex) {
                //"ID", "Cliente", "Fecha Creacion", "Fecha de Entrega", "Sub total", "Total", "Nro Factura"};
                case 0:
                    return object.getId().getId();
                case 1:
                    return object.getCustomers().getName();
                case 2:
                    return object.getDate().toString();
                case 3:
                    return object.getSubtotal();
                case 4:
                    return object.getTotal();
                case 5:
                    return object.getInvoice();

            }
        } else if (temp instanceof Glasses) {
            final Glasses object = (Glasses) temp;
            //{"ID", "Estado", "Fecha Terminado"};
            switch (columnIndex) {
                case 0:
                    return object.getId();
                case 1:
                    return GlassAttr.GlassState.getState(object.getState()).getId();
                case 2:
                    return object.getFinishedDate().toGMTString();
                default:
                    return null;
            }
        }else if(temp instanceof Orderglass){
            
        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex
    ) {
        //System.out.println("ADDD");
    }

    @Override
    public void addTableModelListener(TableModelListener l
    ) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l
    ) {

    }

    public T getValueAt(int rowIndex) {
        return source.get(rowIndex);
    }
}
