# p03-komponen-gui
# mode terang
<img width="575" height="502" alt="Cuplikan layar 2026-10-15 215823" src="https://github.com/user-attachments/assets/aa6439a8-01b3-4a81-a229-7e7f5958c33e" />
# mode gelap
<img width="565" height="501" alt="Cuplikan layar 2026-10-15 215830" src="https://github.com/user-attachments/assets/48a9db95-957f-4152-b6d7-8261b9a427e8" />
# desain dan navigator
<img width="1920" height="1080" alt="Screenshot (262)" src="https://github.com/user-attachments/assets/fba98c14-6d9d-4559-be9f-c76ba3c41960" />
# pertanyaan refleksi
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/c5dffd9f-b10c-4643-92d5-bd89dee84eec" />




# po4-layout manager
# desain dan navigator
<img width="1920" height="1080" alt="Screenshot (259)" src="https://github.com/user-attachments/assets/c5971472-743e-4a57-9c60-d5c0386f68ae" />
# tampilan awal 
<img width="1920" height="1080" alt="Screenshot (260)" src="https://github.com/user-attachments/assets/b752787b-f00e-4282-b025-7154589dde82" />
# tampilan lebar 
<img width="1920" height="1080" alt="Screenshot (261)" src="https://github.com/user-attachments/assets/169ac62e-483f-4e79-b35f-a9f740b059d6" />
# penilaian dari Teman (Akbar Ihsan Nugraha)
<img width="867" height="297" alt="Cuplikan layar 2026-10-15 214514" src="https://github.com/user-attachments/assets/e0858c76-5009-43e1-ab6f-950b13c2b632" />
# tabel rancangan
<img width="628" height="222" alt="Cuplikan layar 2026-10-15 214635" src="https://github.com/user-attachments/assets/eccb72ef-aede-4e1e-ad2a-37b0b34d3499" />

# Deklarasi AI
https://github.com/akbarrramadhan/pbo2-2410010511/blob/main/p04-layout-manager/Deklarasi%20Ai.txt
# Eksperimen 4
https://github.com/akbarrramadhan/pbo2-2410010511/blob/main/p04-layout-manager/Eksperimen%204.txt
# Eksperimen praktikum 2
https://github.com/akbarrramadhan/pbo2-2410010511/blob/main/p04-layout-manager/Eksperimen%20Praktikum%202.txt
# Pertanyaan refleksi 
https://github.com/akbarrramadhan/pbo2-2410010511/blob/main/p04-layout-manager/Pertanyaaan%20Refleksi.txt

# p05-event-handling
# tabel pengamatan
<img width="1082" height="541" alt="image" src="https://github.com/user-attachments/assets/a42370e5-b661-4265-99f0-9676668353a0" />

# ekperimen 3

**1. Menghapus pemeriksaan `getStateChange() == ItemEvent.SELECTED`**

Pesan "item berubah" tercetak **2 kali** setiap pilihan diganti. Satu perubahan pilihan memicu dua `ItemEvent`: `DESELECTED` untuk item lama dan `SELECTED` untuk item baru. Tanpa pemeriksaan itu, handler jalan untuk keduanya. Dengan pemeriksaan, hanya event `SELECTED` yang diproses, sehingga tercetak 1 kali.

**2. Mengganti `keyReleased` dengan `keyPressed`**

Hasil terlambat satu karakter karena `keyPressed` dipanggil saat tombol ditekan, **sebelum** karakter itu masuk ke isian. Saat `konversi()` memanggil `getText()`, isi isian masih teks sebelum huruf terbaru. Contohnya, setelah mengetik "25", yang dikonversi baru "2". `keyReleased` dipanggil saat tombol dilepas, ketika karakter sudah masuk, jadi hasilnya sesuai.

**3. Menghapus blok `try` dan `catch` di `konversi()`**

Di jendela Output muncul pesan error dengan stack trace, seperti `Exception in thread "AWT-EventQueue-0" java.lang.NumberFormatException: For input string: "a"`. Kalau isian kosong (misalnya setelah menekan Backspace), pesannya `NumberFormatException: empty String`. Penyebabnya, `Double.parseDouble()` tidak bisa mengubah huruf atau teks kosong menjadi angka. Program tidak langsung tertutup karena exception terjadi di thread GUI, tetapi hasil konversi tidak diperbarui. Blok `try` dan `catch` tadi yang menangkap error itu supaya program tetap rapi, misalnya dengan menampilkan pesan "input tidak valid".

# eksperimen 4
Dua listener di satu tombol: pesan “kali” tercetak 2 kali, karena tombol punya lambda di konstruktor dan listener dari tab Events. Satu tombol sebaiknya hanya satu cara agar logikanya tidak berjalan dobel.
Tombol %: di tab Design, tambah JButton, ubah teks dan nama variabel, lalu atur posisinya. Di tab Source, NetBeans otomatis menambah deklarasi, inisialisasi, dan method event, tinggal kamu isi perhitungan angka1 % angka2.
Kursor ke isian pertama: handler Hapus mengosongkan isian lalu memanggil requestFocus() pada isian pertama, jadi pengguna bisa langsung mengetik lagi.

# peta event
### Peta Event pada `FormAnggotaPerpustakaan`

| Komponen | Jenis Event | Listener / Method | Hasil |
|---|---|---|---|
| `simpanButton` | ActionEvent (klik) | `simpanData()` | Validasi Nama, NPM, dan persetujuan, lalu menampilkan ringkasan data |
| `batalButton` | ActionEvent (klik) | `resetForm()` | Mengosongkan semua isian dan fokus kembali ke `namaField` |
| JFrame | WindowEvent (tutup) | `EXIT_ON_CLOSE` | Program berhenti saat jendela ditutup |
| `namaField`, `npmField`, `emailHpField` | - | Belum ada listener | Nilai dibaca saat Simpan |
| `programCombo` | - | Belum ada listener | Pilihan dibaca saat Simpan |
| `mahasiswaRadio`, `dosenRadio`, `umumRadio` | - | Belum ada listener | Nilai dibaca saat Simpan |
| `alamatText` | - | Belum ada listener | Nilai dibaca saat Simpan |
| `setujuCheck` | - | Belum ada listener | Status diperiksa saat Simpan |

# Tangkapan layar jendela Properties bagian Events untuk tombol Daftar
<img width="1920" height="1080" alt="Screenshot (265)" src="https://github.com/user-attachments/assets/09a7d882-2608-42b2-83ca-dce1423b5a41" />

# Tangkapan layar dialog ringkasan
<img width="442" height="575" alt="image" src="https://github.com/user-attachments/assets/1f4d46c2-afe4-45d2-8fa4-1c820a2b5031" />

# Tangkapan layar dialog konfirmasi keluar
<img width="437" height="575" alt="image" src="https://github.com/user-attachments/assets/44d00f9c-e45c-41e3-8a20-3a039dfda682" />

# Deklarasi penggunaan AI: alat yang dipakai dan untuk keperluan apa, atau pernyataan tidak memakai AI.
AI yang saya gunakan adalah Claude AI untuk mengoreksi beberapa coe saya 






