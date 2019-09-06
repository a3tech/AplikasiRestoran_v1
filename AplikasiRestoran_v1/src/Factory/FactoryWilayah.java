/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementWilayah;
import Interface.InterfaceWilayah;
public class FactoryWilayah {
    
private static InterfaceWilayah wilayahDAO;

public static InterfaceWilayah getWilayahDAO() {
        wilayahDAO = new ImplementWilayah() {};
        return wilayahDAO;
    }
    
}
