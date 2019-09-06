/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entity.Entitas;
import Interface.InterfaceKaryawan;
import Koneksi.KoneksiDB;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ImplementKaryawan implements InterfaceKaryawan{
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsKaryawan;
    private List<Entitas> listKaryawan;
    
     public ImplementKaryawan(){
        koneksi = new KoneksiDB();
        koneksi.getkoneksi();
    }


    public boolean insertKaryawan(Entitas k) {
    status = false;
    query = "insert into karyawan values ('"+k.getId_karyawan()+"','"+k.getNama_karyawan()+"','"
           +k.getUser()+"','"+k.getPw()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }


    public boolean updateKaryawan(Entitas k) {
    status = false;
    query = "update karyawan set nama_karyawan ='"+k.getNama_karyawan()+"',username='"+k.getUser()
            +"',password='"+k.getPw()+"' where id_karyawan ='"+k.getId_karyawan()+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }


    public boolean deleteKaryawan(String kode) {
    status = false;
    query = "delete from karyawan where id_karyawan ='"+kode+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }


    public List selectKaryawan(String kode, String nama_karyawan) {
    query = "select * from karyawan "+
            "where id_karyawan like'%"+kode+"%' or nama_karyawan like '%"+nama_karyawan+"%'"+
                " order by nama_karyawan ASC";
        status = koneksi.eksekusiQuery(query, true);
        if (status){
            rsKaryawan = koneksi.getRs();
            listKaryawan = new ArrayList<Entitas>();
            try{
                while (rsKaryawan.next()){
                    Entitas k = new Entitas();
                    k.setId_karyawan(rsKaryawan.getString(1));
                    k.setNama_karyawan(rsKaryawan.getString(2));
                    k.setUser(rsKaryawan.getString(3));
                    k.setPw(rsKaryawan.getString(4));
                    listKaryawan.add(k);
                }
                rsKaryawan.close();
                return listKaryawan;
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
    query = "select max(right(id_karyawan,4))as kode from karyawan";
    status = koneksi.eksekusiQuery(query, true);
    if(status){
        rsKaryawan = koneksi.getRs();
        try{
            rsKaryawan.next();
            angka = rsKaryawan.getInt(1);
            if(angka<10){
                kode = "K000"+(angka+1);
            }else if(angka<100){
                kode = "K00"+(angka+1);
        }else if(angka<1000){
                kode = "K0"+(angka+1);}
        else{
            kode = "K"+String.valueOf(angka+1);
        }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
    }
    }
    return kode; 
    }
    
}
