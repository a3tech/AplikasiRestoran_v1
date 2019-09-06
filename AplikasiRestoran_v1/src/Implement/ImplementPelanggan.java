/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Entity.Pelanggan;
import Interface.InterfacePelanggan;
import Koneksi.KoneksiDB;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class ImplementPelanggan implements InterfacePelanggan {
    private String query;
    private KoneksiDB koneksi;
    private boolean status;
    private ResultSet rsPelanggan;
    private List<Pelanggan> listPelanggan;
    
     public ImplementPelanggan(){
        koneksi = new KoneksiDB();
        koneksi.getkoneksi();
    }


    public boolean insertPelanggan(Pelanggan p) {
   status = false;
   query = "insert into pelanggan values ('"+p.getId_pelanggan()+"','"+p.getNama_pelanggan()+"','"
           +p.getNo_telp()+"')";
        status = koneksi.eksekusiQuery(query, false);
        return status;
    }


    public boolean updatePelanggan(Pelanggan p) {
    status = false;
    query = "update pelanggan set nama_pelanggan ='"+p.getNama_pelanggan()+"',no_telp='"+p.getNo_telp()
            +"' where id_pelanggan ='"+p.getId_pelanggan()+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }


    public boolean deletePelanggan(String kode) {
    status = false;
    query = "delete from pelanggan where id_pelanggan ='"+kode+"'";
    status = koneksi.eksekusiQuery(query, false);
    return status;
    }

 
    public List selectPelanggan(String kode, String nama_pelanggan) {
    query = "select * from pelanggan "+
            "where id_pelanggan like'%"+kode+"%' or nama_pelanggan like '%"+nama_pelanggan+"%'"+
                " order by nama_pelanggan ASC";
        status = koneksi.eksekusiQuery(query, true);
        if (status){
            rsPelanggan = koneksi.getRs();
            listPelanggan = new ArrayList<Pelanggan>();
            try{
                while (rsPelanggan.next()){
                    Pelanggan p = new Pelanggan();
                    p.setId_pelanggan(rsPelanggan.getString(1));
                    p.setNama_pelanggan(rsPelanggan.getString(2));
                    p.setNo_telp(rsPelanggan.getString(3));
                    listPelanggan.add(p);
                }
                rsPelanggan.close();
                return listPelanggan;
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
    query = "select max(right(id_pelanggan,4))as kode from pelanggan";
    status = koneksi.eksekusiQuery(query, true);
    if(status){
        rsPelanggan = koneksi.getRs();
        try{
            rsPelanggan.next();
            angka = rsPelanggan.getInt(1);
            if(angka<10){
                kode = "P000"+(angka+1);
            }else if(angka<100){
                kode = "P00"+(angka+1);
        }else if(angka<1000){
                kode = "P0"+(angka+1);}
        else{
            kode = "P"+String.valueOf(angka+1);
        }
    }catch(SQLException ex){
            System.out.println(ex.getMessage());
            return null;
    }
    }
    return kode; 
    }
    }
     
