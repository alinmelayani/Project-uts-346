/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appalin;

import com.appalin.model.purchaseorder;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class main {
    private purchaseorderDataSource datasource;
    
    public main() {
       datasource = new purchaseorderDataSource();
    }
    
    public static void main(String[] args) {
        new main().testDelete();
       
    }
    public void testGetAll (){
        List<purchaseorder> list = datasource.getAll();
        for(purchaseorder po : list){
            System.out.println("deskripsi: " + po.getDeskripsi() + "supplier: " + po.getSupplier());
        }
    }
    
    public void testgetByid (){
        purchaseorder purchaseorder = datasource.getById("112 ");
        if(purchaseorder != null){
            System.out.println("deskripsi: " + purchaseorder.getDeskripsi() + "supplier: " + purchaseorder.getSupplier());
        }
    }
    
    public void testInsert (){
        purchaseorder purchaseorder = new purchaseorder("114", "lampu", "2020-04-12", "PT.ADM",  Integer.BYTES);
        boolean hasil = datasource.insert(purchaseorder);
        if (hasil){
            System.out.println("tertambahksn");
        }
    }
    
    
    public void testUpdate (){
        purchaseorder purchaseorder = datasource.getById("112 ");
        purchaseorder.setSupplier("PT.HONDA");
           boolean hasil = datasource.update(purchaseorder);
        if (hasil){
            System.out.println("Update berhasil");
        }
    }
   
    
   public void testDelete (){
           boolean hasil = datasource.delete("111");
        if (hasil){
            System.out.println("delete data berhasil");
        }
    }
    
}
