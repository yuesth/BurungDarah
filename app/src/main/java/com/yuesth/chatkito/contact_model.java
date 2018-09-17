package com.yuesth.chatkito;

public class contact_model {
    private int img_contact;
    private String nama_contact;
    private String nomor_contact;

    public contact_model(int img_contact, String nama_contact, String nomor_contact) {
        this.img_contact = img_contact;
        this.nama_contact = nama_contact;
        this.nomor_contact = nomor_contact;
    }

    public int getImg_contact() {
        return img_contact;
    }

    public String getNama_contact() {
        return nama_contact;
    }

    public String getNomor_contact() {
        return nomor_contact;
    }

    public void setImg_contact(int img_contact) {
        this.img_contact = img_contact;
    }

    public void setNama_contact(String nama_contact) {
        this.nama_contact = nama_contact;
    }

    public void setNomor_contact(String nomor_contact) {
        this.nomor_contact = nomor_contact;
    }
}
