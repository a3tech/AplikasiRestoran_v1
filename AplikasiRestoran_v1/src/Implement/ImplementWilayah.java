/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entity.Entitas;
import Interface.InterfaceWilayah;
import Koneksi.KoneksiDB;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ImplementWilayah implements InterfaceWilayah{
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsWilayah;
    private List<Entitas> listWilayah;
    
    public ImplementWilayah(){
        koneksi = new KoneksiDB();
        koneksi.getkoneksi();
    }


    public boolean insertWilayah(Entitas w) {
    status = false;
    query = "insert into tarif_antar values ('"+w.getId_wilayah()+"','"+w.getNama_wilayah()+"','"
           +w.getTarif()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }

 
    public boolean updateWilayah(Entitas w) {
    status = false;
    query = "update tarif_antar set nama_wilayah ='"+w.getNama_wilayah()+"',tarif_kirim='"+w.getTarif()
            +"' where kd_wilayah ='"+w.getId_wilayah()+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }

    public boolean deleteWilayah(String kode) {
    status = false;
    query = "delete from tarif_antar where kd_wilayah ='"+kode+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }

    public List selectWilayah(String kode, String nama_wilayah) {
    query = "select * from tarif_antar "+
            "where kd_wilayah like'%"+kode+"%' or nama_wilayah like '%"+nama_wilayah+"%'"+
                " order by nama_wilayah ASC";
        status = koneksi.eksekusiQuery(query, true);
        if (status){
            rsWilayah = koneksi.getRs();
            listWilayah = new ArrayList<Entitas>();
            try{
                while (rsWilayah.next()){
                    Entitas w = new Entitas();
                    w.setId_wilayah(rsWilayah.getString(1));
                    w.setNama_wilayah(rsWilayah.getString(2));
                    w.setTarif(rsWilayah.getInt(3));
                    listWilayah.add(w);
                }
                rsWilayah.close();
                return listWilayah;
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
    query = "select max(right(kd_wilayah,4))as kode from tarif_antar";
    status = koneksi.eksekusiQuery(query, true);
    if(status){
        rsWilayah = koneksi.getRs();
        try{
            rsWilayah.next();
            angka = rsWilayah.getInt(1);
            if(angka<10){
                kode = "W000"+(angka+1);
            }else if(angka<100){
                kode = "W00"+(angka+1);
        }else if(angka<1000){
                kode = "W0"+(angka+1);}
        else{
            kode = "W"+String.valueOf(angka+1);
        }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
    }
    }
    return kode; 
    }
    
}
