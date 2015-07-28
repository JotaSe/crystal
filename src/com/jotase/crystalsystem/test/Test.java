/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.test;

import com.jotase.crystalsystem.models.Customers;
import com.jotase.crystalsystem.models.DAO.OrderGlassDAO;
import com.jotase.crystalsystem.models.DAO.ServiceDAO;
import com.jotase.crystalsystem.models.Service;
import com.jotase.crystalsystem.models.enums.GlassAttr;
import com.jotase.crystalsystem.view.SearchView;
import java.lang.reflect.Field;

/**
 *
 * @author JotaSe
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Test test = new Test();
        // test.fooTest();
        test.searchTest();
        //test.createServices();
    }

    private void fooTest() {
        Foo foo = new Foo();
        foo.a();
    }
    
    private void searchTest() {
        Customers t = new Customers();
        
        final SearchView sv = new SearchView(t);

        sv.setVisible(true);

         t = (Customers) sv.controller.getObject();
    }

    private void createServices() {
        ServiceDAO dao = new ServiceDAO();
        for (int i = 0; i < GlassAttr.GlassService.values().length; i++) {

            for (int j = 0; j < GlassAttr.GlassThickness.values().length; j++) {

                for (int k = 0; k < GlassAttr.PriceType.values().length; k++) {
                    Service service = new Service(GlassAttr.GlassService.values()[i].getName(),
                            GlassAttr.GlassThickness.values()[j].getThickness(),
                            GlassAttr.PriceType.values()[k].getId(),
                            0d,
                            null);
                    //dao.insert(service);

                    System.out.println("Service =" + dao.get(service, dao.getQuery(service, dao.GET_SERVICE)).toString());
                }
            }
        }

    }

    class Foo extends Foo2 {

        @Override
        public void a() {
            System.out.println("a!");
        }
    }

    class Foo2 {

        public void a() {
            System.out.println("A");
        }

        public void b() {
            a();
        }

        public void asd(final int a) {

        }
    }

}
