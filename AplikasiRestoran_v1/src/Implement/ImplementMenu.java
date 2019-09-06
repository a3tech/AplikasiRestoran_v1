/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entity.Entitas;
import Interface.InterfaceMenu;
import Koneksi.KoneksiDB;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ImplementMenu implements InterfaceMenu{
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsMenu;
    private List<Entitas> listMenu;
    
    public ImplementMenu(){
        koneksi = new KoneksiDB();
        koneksi.getkoneksi();
    }

    public boolean insertMenu(Entitas m) {
    status = false;
    query = "insert into menu values ('"+m.getKd_menu()+"','"+m.getNama_menu()+"','"
           +m.getHarga_menu()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    public boolean updateMenu(Entitas m) {
    status = false;
    query = "update menu set nama_menu ='"+m.getNama_menu()+"',harga_menu='"+m.getHarga_menu()
            +"' where kd_menu ='"+m.getKd_menu()+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }

    public boolean deleteMenu(String kode) {
    status = false;
    query = "delete from menu where kd_menu ='"+kode+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }

    public List selectMenu(String kode, String nama_menu) {
     query = "select * from menu "+
            "where kd_menu like'%"+kode+"%' or nama_menu like '%"+nama_menu+"%'"+
                " order by kd_menu ASC";
        status = koneksi.eksekusiQuery(query, true);
        if (status){
            rsMenu = koneksi.getRs();
            listMenu = new ArrayList<Entitas>();
            try{
                while (rsMenu.next()){
                    Entitas m = new Entitas();
                    m.setKd_menu(rsMenu.getString(1));
                    m.setNama_menu(rsMenu.getString(2));
                    m.setHarga_menu(rsMenu.getInt(3));
                    listMenu.add(m);
                }
                rsMenu.close();
                return listMenu;
            }catch(SQLException ex){
                return null;
            }
        }
        return null;
    }

    @Override
    public String kodeBaru() {
     String kode = "";
    int angka = 0;
    query = "select max(right(kd_menu,4))as kode from menu";
    status = koneksi.eksekusiQuery(query, true);
    if(status){
        rsMenu = koneksi.getRs();
        try{
            rsMenu.next();
            angka = rsMenu.getInt(1);
            if(angka<10){
                kode = "M000"+(angka+1);
            }else if(angka<100){
                kode = "M00"+(angka+1);
        }else if(angka<1000){
                kode = "M0"+(angka+1);}
        else{
            kode = "M"+String.valueOf(angka+1);
        }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
    }
    }
    return kode; 
    }
    
}
