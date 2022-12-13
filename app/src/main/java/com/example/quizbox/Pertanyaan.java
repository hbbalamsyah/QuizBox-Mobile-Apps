package com.example.quizbox;

public class Pertanyaan {
    private String pertanyaannya, pilihan1, pilihan2, pilihan3, pilihan4;
    private int correctAnsNo;

    public Pertanyaan(String pertanyaannya, String pilihan1, String pilihan2, String pilihan3, String pilihan4, int correctAnsNo) {
        this.pertanyaannya = pertanyaannya;
        this.pilihan1 = pilihan1;
        this.pilihan2 = pilihan2;
        this.pilihan3 = pilihan3;
        this.pilihan4 = pilihan4;
        this.correctAnsNo = correctAnsNo;
    }

    public String getPertanyaannya() {
        return pertanyaannya;
    }

    public void setPertanyaannya(String pertanyaannya) {
        this.pertanyaannya = pertanyaannya;
    }

    public String getPilihan1() {
        return pilihan1;
    }

    public void setPilihan1(String pilihan1) {
        this.pilihan1 = pilihan1;
    }

    public String getPilihan2() {
        return pilihan2;
    }

    public void setPilihan2(String pilihan2) {
        this.pilihan2 = pilihan2;
    }

    public String getPilihan3() {
        return pilihan3;
    }

    public void setPilihan3(String pilihan3) {
        this.pilihan3 = pilihan3;
    }

    public String getPilihan4() {
        return pilihan4;
    }

    public void setPilihan4(String pilihan4) {
        this.pilihan4 = pilihan4;
    }

    public int getCorrectAnsNo() {
        return correctAnsNo;
    }

    public void setCorrectAnsNo(int correctAnsNo) {
        this.correctAnsNo = correctAnsNo;
    }
}
