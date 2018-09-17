package com.yuesth.chatkito;

public class explore_model {
    private int poster;
    private String judul, tanggal, waktu, tempat; int konten;

    public explore_model(int poster, String judul, String tanggal, String waktu, String tempat, int konten) {
        this.poster = poster;
        this.judul = judul;
        this.tanggal = tanggal;
        this.waktu = waktu;
        this.tempat = tempat;
        this.konten = konten;
    }

    public int getKonten() {
        return konten;
    }

    public void setKonten(int konten) {
        this.konten = konten;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }
}
