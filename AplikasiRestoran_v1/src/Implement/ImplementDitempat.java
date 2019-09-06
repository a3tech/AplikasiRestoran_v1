/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;
import Entity.Entitas;
import Interface.InterfaceDitempat;
import Koneksi.KoneksiDB;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ImplementDitempat implements InterfaceDitempat{
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsDitempat;
    
     public ImplementDitempat(){
        koneksi = new KoneksiDB();
        koneksi.getkoneksi();
    }
    public boolean insertDitempat(Entitas dt) {
    status = false;
    query = "insert into transaksi_ditempat values ('"+dt.getNonota()+"','"+dt.getId_pelanggan()+"','"
           +dt.getTgl()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }


    public boolean insertDetailDitempat(Entitas dt) {
    status = false;
    query = "insert into item_menu_ditempat values ('"+dt.getNonota()+"','"+dt.getKd_menu()+"','"
           +dt.getMeja()+"','"+dt.getHarga_menu()+"','"+dt.getJml()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

    public String kodeBaru() {
    String kode = "";
    int angka = 0;
    query = "select max(right(nota,4))as kode from transaksi_ditempat";
    status = koneksi.eksekusiQuery(query, true);
    if(status){
        rsDitempat = koneksi.getRs();
        try{
            rsDitempat.next();
            angka = rsDitempat.getInt(1);
            if(angka<10){
                kode = "N000"+(angka+1);
            }else if(angka<100){
                kode = "N00"+(angka+1);
        }else if(angka<1000){
                kode = "N0"+(angka+1);}
        else{
            kode = "N"+String.valueOf(angka+1);
        }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
    }
    }
    return kode;   
}}
