/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Entitas;
import java.util.List;
public interface InterfaceWilayah {
    boolean insertWilayah(Entitas w);
    boolean updateWilayah(Entitas w);
    boolean deleteWilayah(String kode);
    List selectWilayah(String kode, String nama_wilayah); 
    String kodeBaru();
}
