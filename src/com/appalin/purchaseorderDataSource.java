/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appalin;

import com.appalin.model.purchaseorder;
import com.appalinutility.DatabaseUtility;
import static java.nio.file.Files.list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class purchaseorderDataSource {
    private Connection connection;
    private purchaseorder purchaseorder;
    
    public purchaseorderDataSource () {
        connection = DatabaseUtility.getConnection();
    }
    
    public List<purchaseorder> getAll () {
     List<purchaseorder> list = new ArrayList<>();
     String sql ="SELECT * FROM purchaseorder";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            purchaseorder purchaseorder;
            while (rs.next()){
                purchaseorder = new purchaseorder();
                purchaseorder.setIdPO(rs.getString("IdPO"));
                purchaseorder.setDeskripsi(rs.getString("Deskripsi"));
                purchaseorder.setTanggalPO(rs.getString("TanggalPO"));
                purchaseorder.setSupplier (rs.getString("Supplier"));
                purchaseorder.setTotalPO(rs.getInt("TotalPO"));
                list.add(purchaseorder);
                
            }
        } catch (Exception e) {
        }
     return list;
    }
    
     public purchaseorder getById (String Id) {
         purchaseorder purchaseorder = null ;
     String sql = "SELECT * FROM purchaseorder WHERE IdPO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, Id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                purchaseorder = new purchaseorder();
                purchaseorder.setIdPO(rs.getString("IdPO"));
                purchaseorder.setDeskripsi(rs.getString("Deskripsi"));
                purchaseorder.setTanggalPO(rs.getString("TanggalPO"));
                purchaseorder.setSupplier (rs.getString("Supplier"));
                purchaseorder.setTotalPO(rs.getInt("TotalPO"));
                
                
            }
        } catch (Exception e) {
        }
     return purchaseorder;
    }
    
    public boolean insert (purchaseorder purchaseorder) {
     String sql = "INSERT INTO purchaseorder VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, purchaseorder.getIdPO());
            statement.setString(2, purchaseorder.getDeskripsi());
            statement.setString(3, purchaseorder.getTanggalPO());
            statement.setString(4, purchaseorder.getSupplier());
            statement.setInt(5, purchaseorder.getTotalPO());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
     return false;
    }
    
    public boolean update (purchaseorder purchaseorder) {
     String sql = "UPDATE purchaseorder SET Deskripsi=?,TanggalPO=?,Supplier=?,TotalPO=? "
             + "WHERE IdPO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, purchaseorder.getDeskripsi());
            statement.setString(2, purchaseorder.getTanggalPO());
            statement.setString(3, purchaseorder.getSupplier());
            statement.setInt(4, purchaseorder.getTotalPO());
            statement.setString(5, purchaseorder.getIdPO());
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
     return false;
    }
    
    public boolean delete (String id) {
     String sql = "DELETE FROM purchaseorder WHERE IdPO=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            int result = statement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
     return false;
    }
}

