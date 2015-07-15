/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jotase.crystalsystem.test;

import com.jotase.crystalsystem.models.DAO.DAO;
import com.jotase.crystalsystem.models.DAO.ServiceDAO;
import com.jotase.crystalsystem.models.Service;

import com.jotase.crystalsystem.models.enums.GlassAttr;

/**
 *
 * @author JotaSe
 */
public class DBTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBTest test = new DBTest();
        test.fooTest();
        //test.createServices();
    }

    private void fooTest() {
        Foo foo = new Foo();
        foo.a();
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
    }

}
