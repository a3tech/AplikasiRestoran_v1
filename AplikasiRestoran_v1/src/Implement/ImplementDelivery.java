/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entity.Entitas;
import Interface.InterfaceDelivery;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ImplementDelivery implements InterfaceDelivery {
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsDelivery;
    
     public ImplementDelivery(){
        koneksi = new KoneksiDB();
        koneksi.getkoneksi();
    }


    public boolean insertDelivery(Entitas dv) {
    status = false;
    query = "insert into transaksi_delivery values ('"+dv.getNode()+"','"+dv.getId_pelanggan()+"','"
           +dv.getId_wilayah()+"','"+dv.getTgl()+"')";
    status = koneksi.eksekusiQuery(query, false);
    return status; 
    }


    public boolean insertDetailDelivery(Entitas dv) {
    status = false;
    query = "insert into item_menu_delivery values ('"+dv.getNode()+"','"+dv.getKd_menu()+"','"
           +dv.getAlamat()+"','"+dv.getHarga_menu()+"','"+dv.getJml()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }


    public String kodeBaru() {
      String kode = "";
    int angka = 0;
    query = "select max(right(node,4))as kode from transaksi_delivery";
    status = koneksi.eksekusiQuery(query, true);
    if(status){
        rsDelivery = koneksi.getRs();
        try{
            rsDelivery.next();
            angka = rsDelivery.getInt(1);
            if(angka<10){
                kode = "D000"+(angka+1);
            }else if(angka<100){
                kode = "D00"+(angka+1);
        }else if(angka<1000){
                kode = "D0"+(angka+1);}
        else{
            kode = "D"+String.valueOf(angka+1);
        }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
    }
    }
    return kode; 
    }
    
    
}
