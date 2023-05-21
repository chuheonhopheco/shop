/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author HungNguyen
 */
public class entityNhanVien {

    public byte[] getAnhNV() {
        return AnhNV;
    }

    public void setAnhNV(byte[] AnhNV) {
        this.AnhNV = AnhNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getSDTNV() {
        return SDTNV;
    }

    public void setSDTNV(int SDTNV) {
        this.SDTNV = SDTNV;
    }
    byte[] AnhNV;
    String tenNV;
    int SDTNV;
    
}
