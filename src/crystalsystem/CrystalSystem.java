/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crystalsystem;

import com.jotase.crystalsystem.view.CustomersView;
import com.jotase.crystalsystem.view.Home;

/**
 *
 * @author JotaSe
 */
public class CrystalSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomersView view = new CustomersView();
        Home home = new Home();
        home.setVisible(true);
        home.add(view);
        view.setVisible(true);
    }
    
}
