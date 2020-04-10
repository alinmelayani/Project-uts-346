/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appalin.model;

/**
 *
 * @author Hp
 */
public class purchaseorder {
    private String IdPO;
    private String Deskripsi;
    private String TanggalPO;
    private String Supplier;
    private Integer TotalPO;

    public purchaseorder() {
    }

    public purchaseorder(String IdPO, String Deskripsi, String TanggalPO, String Supplier, Integer TotalPO) {
        this.IdPO = IdPO;
        this.Deskripsi = Deskripsi;
        this.TanggalPO = TanggalPO;
        this.Supplier = Supplier;
        this.TotalPO = TotalPO;
    }

    public String getIdPO() {
        return IdPO;
    }

    public void setIdPO(String IdPO) {
        this.IdPO = IdPO;
    }

    public String getDeskripsi() {
        return Deskripsi;
    }

    public void setDeskripsi(String Deskripsi) {
        this.Deskripsi = Deskripsi;
    }

    public String getTanggalPO() {
        return TanggalPO;
    }

    public void setTanggalPO(String TanggalPO) {
        this.TanggalPO = TanggalPO;
    }

    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public Integer getTotalPO() {
        return TotalPO;
    }

    public void setTotalPO(Integer TotalPO) {
        this.TotalPO = TotalPO;
    }
    
}
