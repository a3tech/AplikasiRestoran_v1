/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entity.Entitas;
import java.util.List;
public interface InterfaceKaryawan {
    boolean insertKaryawan(Entitas k);
    boolean updateKaryawan(Entitas k);
    boolean deleteKaryawan(String kode);
    List selectKaryawan(String kode, String nama_karyawan);
    String kodeBaru();
}
