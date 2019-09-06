/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementDelivery;
import Interface.InterfaceDelivery;
public class FactoryDelivery {
    private static InterfaceDelivery deliveryDAO;

public static InterfaceDelivery getDeliveryDAO() {
        deliveryDAO = new ImplementDelivery() {};
        return deliveryDAO;
    }
    
}
