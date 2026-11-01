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

# p06 VALIDASI INPUT
# Evaluasi Heuristik Nielsen: FormAnggota

Objek evaluasi: Form Pendaftaran Anggota (aplikasi Java Swing, `FormAnggota.form`).

Skala skor: 0 = bukan masalah usability, 1 = masalah kosmetik, 2 = masalah minor, 3 = masalah mayor, 4 = bencana usability.

| No | Heuristik | Temuan | Skor 0-4 | Saran |
|---|---|---|---|---|
| 1 | Visibilitas status sistem | Ada `statusLabel` dan label pesan di bawah tiap field (nama, NPM, prodi, email, HP), jadi umpan balik tersedia. Namun `statusLabel` awalnya kosong dan berada di pojok kiri bawah, jauh dari tombol Daftar, sehingga mudah terlewat. | 1 | Beri warna berbeda untuk sukses dan gagal, dan tampilkan pesan "Pendaftaran berhasil" yang jelas setelah klik Daftar. |
| 2 | Kesesuaian dengan dunia nyata | Bahasa Indonesia dan istilah akrab bagi pengguna perpustakaan kampus. Namun NPM wajib diisi, padahal ada pilihan jenis anggota Dosen dan Umum yang umumnya tidak punya NPM. Penulisan "No.Hp" juga tanpa spasi. | 2 | Ubah label NPM menjadi NPM/NIDN/No. identitas sesuai jenis anggota, atau nonaktifkan NPM untuk Umum. Tulis "No. HP". |
| 3 | Kendali dan kebebasan pengguna | Ada tombol Batal dan penanganan penutupan jendela (`windowClosing`). Tidak ada tombol Reset khusus untuk mengosongkan isian. | 1 | Pastikan Batal atau penutupan jendela meminta konfirmasi bila isian sudah terisi. Tambahkan Reset bila perlu. |
| 4 | Konsistensi dan standar | Susunan label-field konsisten dan memakai komponen Swing standar. Pelabelan agak tidak seragam: ada penanda grup "Data Anggota" dan "Kontak", tetapi "Persetujuan" dan "Jenis Anggota" berdiri sendiri. Gaya penulisan label berbeda (No.Hp vs Nama Lengkap). | 1 | Samakan gaya penulisan label dan pengelompokan bagian form. |
| 5 | Pencegahan kesalahan | Cukup baik. Prodi memakai combo box, jenis anggota memakai radio, ada handler `keyTyped` dan `keyReleased` pada NPM (kemungkinan untuk membatasi input), dan ada centang persetujuan. Email dan No.Hp masih teks bebas. | 1 | Batasi No.Hp hanya angka dan panjang wajar. Nonaktifkan Daftar sampai persetujuan dicentang dan isian wajib terisi. |
| 6 | Mengenali, bukan mengingat | Label selalu terlihat di samping field. Tidak ada contoh atau petunjuk format (NPM, email, HP), dan tanda wajib isi hanya dijelaskan sebagai kalimat di header ("Semua isian wajib diisi, kecuali alamat"). | 2 | Tambahkan contoh format (misalnya placeholder atau tooltip) dan tanda bintang (*) pada field wajib. |
| 7 | Fleksibilitas dan efisiensi | Tidak ada mnemonic (Alt+huruf) pada tombol atau label, dan tidak terlihat pengaturan tombol default (Enter = Daftar). Fokus berpindah lewat `focusLost`, tetapi tidak ada pintasan lain. | 2 | Atur Daftar sebagai default button, tambahkan mnemonic, dan pastikan urutan tab (Tab) logis. |
| 8 | Desain estetis dan minimalis | Tata letak bersih, hanya field yang perlu, ada header dan pengelompokan bagian, serta margin yang teratur. Teks di header cukup panjang tetapi masih wajar. | 1 | Bedakan judul dan keterangan dengan ukuran dan bobot huruf. Jaga jarak antar bagian tetap seragam. |
| 9 | Membantu memperbaiki kesalahan | Ada label pesan tepat di bawah tiap field, sehingga lokasi kesalahan jelas. Isi pesannya tidak bisa dipastikan dari file .form. Field alamat dan jenis anggota tidak punya label pesan. | 1 | Tulis pesan yang spesifik dan memberi solusi (misalnya "NPM harus 8 digit angka"), bukan sekadar "Salah". |
| 10 | Bantuan dan dokumentasi | Tidak ada tombol bantuan atau petunjuk. Dua tooltip ada tetapi kosong (Nama Lengkap dan Alamat). | 2 | Isi tooltip pada tiap field dan tambahkan keterangan singkat tentang syarat pendaftaran atau tata tertib. |

Rata-rata skor: 1,4 dari 4.

Catatan: penilaian berdasarkan analisis desain pada file `.form` (komponen, teks, dan event handler), bukan pengujian saat program dijalankan.

# Form Pendaftaran Anggota

Aplikasi Java Swing (NetBeans) untuk pendaftaran anggota perpustakaan. Form berisi Nama Lengkap, NPM, Program Studi, Jenis Anggota, Email, No. HP, Alamat, dan persetujuan tata tertib.

## Temuan, Perbaikan, dan Commit

Temuan berasal dari evaluasi heuristik Nielsen terhadap `FormAnggota.form`. Kolom Perbaikan berisi rencana perbaikan, dan kolom Commit diisi dengan hash setelah perbaikan di-commit.

| No | Temuan | Perbaikan | Commit |
|---|---|---|---|
| 1 | NPM wajib diisi untuk Dosen dan Umum (heuristik 2) | Ubah label NPM sesuai jenis anggota atau nonaktifkan field NPM untuk Umum | `fix: sesuaikan field NPM dengan jenis anggota` (hash: ........) |
| 2 | Tidak ada contoh format dan tanda wajib isi (heuristik 6) | Tambahkan tanda bintang (*) pada field wajib dan tooltip berisi contoh format | `feat: tambah penanda wajib isi dan tooltip` (hash: ........) |
| 3 | Tombol Daftar belum jadi tombol default, tanpa mnemonic (heuristik 7) | Atur Daftar sebagai default button, tambahkan mnemonic Alt+huruf, rapikan urutan tab | `feat: tambah default button dan mnemonic` (hash: ........) |
| 4 | Tooltip kosong dan tidak ada bantuan (heuristik 10) | Isi tooltip Nama Lengkap dan Alamat serta tambahkan keterangan syarat pendaftaran | `docs: lengkapi tooltip dan petunjuk pengisian` (hash: ........) |
| 5 | No. HP dan email masih teks bebas (heuristik 5) | Batasi No. HP hanya angka, nonaktifkan Daftar sampai persetujuan dicentang | `fix: validasi input No.HP dan aktivasi tombol Daftar` (hash: ........) |
| 6 | Status sistem mudah terlewat (heuristik 1) | Beri warna sukses dan gagal pada `statusLabel`, tampilkan pesan berhasil setelah Daftar | `feat: perjelas pesan status pendaftaran` (hash: ........) |
| 7 | Label tidak seragam, "No.Hp" (heuristik 4) | Ubah menjadi "No. HP" dan samakan gaya penulisan label | `style: seragamkan penulisan label` (hash: ........) |

# SCREENSHOT KESALAHAN
<img width="1916" height="1012" alt="image" src="https://github.com/user-attachments/assets/86c5fd7b-eb59-432b-8b67-a5fcd033b29d" />

# SCREENSHOOT NAVIGATOR
<img width="1541" height="826" alt="image" src="https://github.com/user-attachments/assets/3d28e8a8-052c-4a73-8903-c2054b61517a" />

# EKSPERIMEN 4
1	Ketik huruf pada isian NPM	Tidak terjadi apa-apa: huruf tidak masuk ke isian dan tidak ada pesan. NPM juga dibatasi maksimal 10 digit. Teks yang ditempel (paste) tidak melewati filter ini.	npmFieldKeyTyped: baris 576 !Character.isDigit(evt.getKeyChar()), lalu baris 577 evt.consume(). Batas 10 digit di baris 574-575.
2	Isi email siti@, lalu Tab	Pesan muncul langsung saat fokus meninggalkan isian email. Isi pesan ditentukan Validator.email (belum diperiksa).	emailFieldFocusLost (baris 601-606) memanggil periksaEmail() karena isian tidak kosong. Pesan ditulis ke emailPesanLabel lewat tandai() (baris 60-64).
3	Klik isian Nama tanpa mengetik, lalu Tab	Tidak ada pesan kesalahan. Pesan untuk isian kosong baru muncul saat Daftar diklik.	namaFieldFocusLost (baris 587-592) hanya memeriksa jika isian tidak kosong (baris 589). Isian kosong diperiksa di daftar() (baris 72).
4	Centang persetujuan, klik Daftar dengan form kosong	Fokus pindah ke isian NPM. Status menampilkan jumlah isian yang perlu diperbaiki. Hasil ini mengasumsikan Validator.npm("") mengembalikan kesalahan untuk isian kosong.	daftar() memeriksa NPM, Nama, Prodi, Email, HP berurutan. Baris 86: salah.get(0).requestFocusInWindow(). Pesan status di baris 85.
5	Alt + N	Fokus pindah ke isian Nama Lengkap (namaField).	namaLabel.setDisplayedMnemonic('N') (baris 280) dan namaLabel.setLabelFor(namaField) (baris 281).
6	Isi beberapa isian, klik Batal, pilih No	Data tetap ada. Dialog konfirmasi hanya muncul jika adaIsian() bernilai true.	batal(): baris 115-117 menampilkan dialog, baris 119-120 return jika jawaban bukan Yes sehingga kosongkan() tidak dipanggil.


# DEKLARASI AI
saya menggunakan ai untuk mengisi tabel dan beberapa bantuan saat mengkoreksi code di source project nya AI yang saya gunakan ClaudeAI



# p07 TABEL DAN MENU


# EKSPERIMEN
1. Komentar fireTableRowsInserted(baris, baris);
Tabel tidak langsung berubah. Data sudah masuk ke list, tapi JTable tidak diberi tahu bahwa ada baris baru, jadi tampilannya tidak diperbarui. Baris baru baru muncul setelah ada hal lain yang memicu refresh (misalnya jendela di-resize). Method fireTableXxx adalah cara model memberi tahu tabel bahwa datanya berubah.

2. return kontakTable.getSelectedRow();
Method ini mengembalikan indeks baris di tampilan (view), bukan indeks di model. Saat tabel sedang difilter dengan kata “ah”, Ahmad Fauzi mungkin ada di baris view 0. Padahal di model, baris 0 adalah kontak pertama di daftar lengkap. Karena itu dialog konfirmasi menampilkan nama kontak yang salah, yaitu kontak di urutan pertama model, bukan Ahmad Fauzi. Cara yang benar adalah kontakTable.convertRowIndexToModel(kontakTable.getSelectedRow()).

3. super(pemilik, judul, true) menjadi false
Parameter ketiga menentukan dialog itu modal atau tidak. Dengan false, dialog menjadi non-modal, sehingga jendela utama tetap bisa diklik dan dialog bisa tertutup di belakangnya. Kode setelah setVisible(true) juga langsung jalan tanpa menunggu pengguna selesai mengisi. Akibatnya kontak yang ditambahkan biasanya tidak masuk ke tabel (hasil dialog masih kosong saat dibaca), atau baru masuk belakangan. Dengan true, eksekusi berhenti sampai dialog ditutup.

4. Kenapa Ctrl+E dan Ctrl+D tidak bekerja tanpa baris terpilih
Menu Edit dan Hapus di-disable otomatis saat tidak ada baris yang dipilih (lewat ListSelectionListener yang memanggil setEnabled(false)). Accelerator dari menu yang disabled tidak akan aktif. Ctrl+N tetap bekerja karena menu Tambah selalu aktif.

5. Accelerator hapusItem diganti menjadi Delete tanpa Ctrl
Baris yang berubah di initComponents() adalah pemanggilan hapusItem.setAccelerator(...). Dari KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK), berubah menjadi sesuatu seperti KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0). Modifier Ctrl hilang (jadi 0) dan tombolnya berganti ke VK_DELETE. Lihat sendiri barisnya di NetBeans, karena itu kode hasil generate (blok biru).

6. private KontakTableModel model; lalu model = new KontakTableModel(); setelah initComponents()
Akan muncul java.lang.NullPointerException, dengan pesan semacam because "this.model" is null. Penyebabnya, initComponents() berjalan dulu dan memakai model (misalnya untuk new JTable(model) atau setModel(model)), padahal saat itu model masih null. Objek baru dibuat setelahnya, terlalu terlambat. Itu sebabnya model harus diisi saat deklarasi (private KontakTableModel model = new KontakTableModel();) atau sebelum initComponents().


# DEKLARASI AI 
saya menggunakan AI untuk mengoreksi beberapa code di project

# LINK VIDEO
https://drive.google.com/file/d/1FN_zEvQ8CvTZ77Sj8H5osjDqQfXThx6r/view?usp=sharing




