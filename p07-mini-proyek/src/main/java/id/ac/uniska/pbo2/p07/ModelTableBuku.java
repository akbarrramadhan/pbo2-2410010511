/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

/**
 *
 * @author Akbar
 */
import id.ac.uniska.pbo2.p07.Status;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModelTableBuku extends AbstractTableModel {

    private final String[] namaKolom = {
        "Kode", "Judul", "Penulis",
        "Tahun Terbit", "Status"
    };

    private final ArrayList<Buku> daftarBuku =
            new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftarBuku.size();
    }

    @Override
    public int getColumnCount() {
        return namaKolom.length;
    }

    @Override
    public String getColumnName(int column) {
        return namaKolom[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Buku buku = daftarBuku.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return buku.getKode();
            case 1:
                return buku.getJudul();
            case 2:
                return buku.getPenulis();
            case 3:
                return buku.getTahunTerbit();
            case 4:
                return buku.getStatus();
            default:
                return null;
        }
    }

    // Mengambil objek buku
    public Buku getBukuAt(int rowIndex) {
        return daftarBuku.get(rowIndex);
    }

    // Menambahkan buku
    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        int baris = daftarBuku.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    // Mengubah buku
    public void ubahBuku(int rowIndex, Buku buku) {
        daftarBuku.set(rowIndex, buku);
        fireTableRowsUpdated(rowIndex, rowIndex);
    }

    // Menghapus buku
    public void hapusBuku(int rowIndex) {
        daftarBuku.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    // Jumlah buku
    public int getJumlahBuku() {
        return daftarBuku.size();
    }

    // Jumlah buku tersedia
    public int getJumlahTersedia() {
        int jumlah = 0;

        for (Buku buku : daftarBuku) {
            if (buku.getStatus() == Status.TERSEDIA) {
                jumlah++;
            }
        }

        return jumlah;
    }

    // Data contoh
    public void isiDataContoh() {

        tambahBuku(new Buku(
            "BK001", "Pemrograman Java",
            2022, "Abdul Kadir"
        ));

        tambahBuku(new Buku(
            "BK002", "Belajar Python",
            2023, "Budi Raharjo"
        ));

        tambahBuku(new Buku(
            "BK003", "Basis Data",
            2021, "Rosa A.S."
        ));

        tambahBuku(new Buku(
            "BK004", "Algoritma Pemrograman",
            2020, "Sutrisno"
        ));

        Buku buku5 = new Buku(
            "BK005", "Pemrograman Web",
            2024, "Andi Pratama"
        );

        buku5.pinjam();
        tambahBuku(buku5);
    }
}