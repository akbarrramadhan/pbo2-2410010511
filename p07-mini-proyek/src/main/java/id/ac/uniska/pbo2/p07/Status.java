/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

/**
 *
 * @author Akbar
 */
public enum Status {
    TERSEDIA("Tersedia"),
    DIPINJAM("Dipinjam");

    private final String keterangan;

    Status(String keterangan) {
        this.keterangan = keterangan;
    }

    @Override
    public String toString() {
        return keterangan;
    }
}
