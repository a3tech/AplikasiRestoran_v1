/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementKaryawan;
import Interface.InterfaceKaryawan;
public class FactoryKaryawan {
    
    private static InterfaceKaryawan karyawanDAO;

public static InterfaceKaryawan getKaryawanDAO() {
        karyawanDAO = new ImplementKaryawan() {};
        return karyawanDAO;
    }
}
