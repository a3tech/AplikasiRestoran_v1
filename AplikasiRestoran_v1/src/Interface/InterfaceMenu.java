/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Entitas;
import java.util.List;
public interface InterfaceMenu {
    boolean insertMenu(Entitas m);
    boolean updateMenu(Entitas m);
    boolean deleteMenu(String kode);
    List selectMenu(String kode, String nama_menu);  
    String kodeBaru();
}
