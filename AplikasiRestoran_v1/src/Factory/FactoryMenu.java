/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementMenu;
import Interface.InterfaceMenu;
public class FactoryMenu {
    
private static InterfaceMenu menuDAO;

public static InterfaceMenu getMenuDAO() {
        menuDAO = new ImplementMenu() {};
        return menuDAO;
    }
    
}
