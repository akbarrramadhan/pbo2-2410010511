/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p01.halo.java;

/**
 *
 * @author Akbar
 */

    public class KartuMahasiswa {
    // Atribut (properti) mahasiswa
    private String nama;
    private String npm;
    private String prodi;
    private int semester;
    private String alasan;

    // Constructor
    public KartuMahasiswa(String nama, String npm, String prodi, int semester, String alasan) {
        this.nama = nama;
        this.npm = npm;
        this.prodi = prodi;
        this.semester = semester;
        this.alasan = alasan;
    }

    // Method untuk menampilkan kartu
    public void tampilkanKartu() {
        System.out.println("================================");
        System.out.println(" KARTU MAHASISWA PBO 2");
        System.out.println("================================");
        System.out.println(" Nama    : " + nama);
        System.out.println(" NPM     : " + npm);
        System.out.println(" Prodi   : " + prodi);
        System.out.println(" Semester: " + semester);
        System.out.println(" Alasan  : " + alasan);
        System.out.println("================================");
    }

    public static void main(String[] args) {
        // Membuat objek mahasiswa dengan data
        KartuMahasiswa mhs1 = new KartuMahasiswa(
            "Akbar Ramadhan",
            "2410010511",
            "Teknik Informatika",
            5,
            "Ingin membuat inventaris toko"
        );

        // Menampilkan kartu
        mhs1.tampilkanKartu();
    }
}

