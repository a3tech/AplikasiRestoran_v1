/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Entitas;
public interface InterfaceDelivery {
    boolean insertDelivery(Entitas dv);
    boolean insertDetailDelivery(Entitas dv);
    String kodeBaru();
    
}
