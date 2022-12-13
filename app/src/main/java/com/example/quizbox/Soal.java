package com.example.quizbox;

public class Soal {
    private String id_soal, soal, pilihan_1, pilihan_2, pilihan_3, pilihan_4, jawaban, id_kategori;

    public Soal() {
    }

    public Soal(String id_soal, String soal, String pilihan_1, String pilihan_2, String pilihan_3, String pilihan_4, String jawaban, String id_kategori) {
        this.id_soal = id_soal;
        this.soal = soal;
        this.pilihan_1 = pilihan_1;
        this.pilihan_2 = pilihan_2;
        this.pilihan_3 = pilihan_3;
        this.pilihan_4 = pilihan_4;
        this.jawaban = jawaban;
        this.id_kategori = id_kategori;
    }

    public String getId_soal() {
        return id_soal;
    }

    public void setId_soal(String id_soal) {
        this.id_soal = id_soal;
    }

    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getPilihan_1() {
        return pilihan_1;
    }

    public void setPilihan_1(String pilihan_1) {
        this.pilihan_1 = pilihan_1;
    }

    public String getPilihan_2() {
        return pilihan_2;
    }

    public void setPilihan_2(String pilihan_2) {
        this.pilihan_2 = pilihan_2;
    }

    public String getPilihan_3() {
        return pilihan_3;
    }

    public void setPilihan_3(String pilihan_3) {
        this.pilihan_3 = pilihan_3;
    }

    public String getPilihan_4() {
        return pilihan_4;
    }

    public void setPilihan_4(String pilihan_4) {
        this.pilihan_4 = pilihan_4;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getId_kategori() {
        return id_kategori;
    }

    public void setId_kategori(String id_kategori) {
        this.id_kategori = id_kategori;
    }
}
