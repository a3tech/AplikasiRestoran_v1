/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementDitempat;
import Interface.InterfaceDitempat;
public class FactoryDitempat {
    
    private static InterfaceDitempat ditempatDAO;

public static InterfaceDitempat getDitempatDAO() {
        ditempatDAO = new ImplementDitempat() {};
        return ditempatDAO;
    }
}
