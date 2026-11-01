/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;
import id.ac.uniska.pbo2.p07.Status;

public class Buku {

    private String kode;
    private String judul;
    private String penulis;
    private int tahunTerbit;
    private Status status;

    // Konstruktor
    public Buku(String kode, String judul,
                int tahunTerbit, String penulis) {

        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
        this.penulis = penulis;
        this.status = Status.TERSEDIA;
    }

    // Getter dan Setter Kode
    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    // Getter dan Setter Judul
    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    // Getter dan Setter Penulis
    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    // Getter dan Setter Tahun Terbit
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    // Getter dan Setter Status
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Method meminjam buku
    public void pinjam() {
        status = Status.DIPINJAM;
    }

    // Method mengembalikan buku
    public void kembalikan() {
        status = Status.TERSEDIA;
    }
}