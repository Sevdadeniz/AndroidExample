package com.example.lenovo.fragmentyapisi.models;

public class Diets {
    String kalori;
    String besinAdi;
    int resim;

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }

    public String getBesinAdi() {
        return besinAdi;
    }

    public void setBesinAdi(String besinAdi) {
        this.besinAdi = besinAdi;
    }

    public int getResim() {
        return resim;
    }

    public void setResim(int resim) {
        this.resim = resim;
    }

    public Diets(String kalori, String besinAdi, int resim) {
        this.kalori = kalori;
        this.besinAdi = besinAdi;
        this.resim = resim;

    }
}
