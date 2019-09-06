/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Factory;

import Implement.ImplementPelanggan;
import Interface.InterfacePelanggan;
public class FactoryPelanggan {
    private static InterfacePelanggan pelangganDAO;

public static InterfacePelanggan getPelangganDAO() {
        pelangganDAO = new ImplementPelanggan() {};
        return pelangganDAO;
    }
}
