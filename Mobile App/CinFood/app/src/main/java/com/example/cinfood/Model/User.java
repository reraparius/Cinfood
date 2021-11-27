package com.example.cinfood.Model;

public class User {

   private int id_user;
   private String nm_depan;
   private String nm_belakang;
   private boolean jns_klmn;
   private int tgl_lahir;
   private String no_hp;
   private String email_user;
   private String password;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNm_depan() {
        return nm_depan;
    }

    public void setNm_depan(String nm_depan) {
        this.nm_depan = nm_depan;
    }

    public String getNm_belakang() {
        return nm_belakang;
    }

    public void setNm_belakang(String nm_belakang) {
        this.nm_belakang = nm_belakang;
    }

    public boolean isJns_klmn() {
        return jns_klmn;
    }

    public void setJns_klmn(boolean jns_klmn) {
        this.jns_klmn = jns_klmn;
    }

    public int getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(int tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
