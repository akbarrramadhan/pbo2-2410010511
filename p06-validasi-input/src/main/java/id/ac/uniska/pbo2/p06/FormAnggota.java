/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.uniska.pbo2.p06;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Akbar
 */
  

    public class FormAnggota extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAnggota.class.getName());

        static Color warnaKesalahan() {
            return FlatLaf.isLafDark() ? new Color(0xFF8A80) : new Color(0xC62828);
        }

        private boolean periksaNpm() {
            return tandai(npmField, npmPesanLabel, Validator.npm(npmField.getText()));
        }

        private boolean periksaNama() {
            return tandai(namaField, namaPesanLabel, Validator.nama(namaField.getText()));
        }

        private boolean periksaProdi() {
            String kesalahan = null;
            if (prodiCombo.getSelectedIndex() == 0) {
                kesalahan = "Pilih salah satu program studi";
            }
            return tandai(prodiCombo, prodiPesanLabel, kesalahan);
        }

        private boolean periksaEmail() {
            return tandai(emailField, emailPesanLabel, Validator.email(emailField.getText()));
        }

        private boolean periksaHp() {
            return tandai(hpField, hpPesanLabel, Validator.nomorHp(hpField.getText()));
        }

        /**
         * Menandai isian dengan garis merah dan pesan. Mengembalikan true jika
         * isian valid.
         */
        private boolean tandai(JComponent isian, JLabel pesan, String kesalahan) {
            isian.putClientProperty("JComponent.outline", (kesalahan == null) ? null : "error");
            pesan.setText((kesalahan == null) ? " " : kesalahan);
            return kesalahan == null;
        }

        private void daftar() {
// Semua isian diperiksa agar pengguna melihat seluruh kesalahan sekaligus
            List<JComponent> salah = new ArrayList<>();
            if (!periksaNpm()) {
                salah.add(npmField);
            }
            if (!periksaNama()) {
                salah.add(namaField);
            }
            if (!periksaProdi()) {
                salah.add(prodiCombo);
            }
            if (!periksaEmail()) {
                salah.add(emailField);
            }
            if (!periksaHp()) {
                salah.add(hpField);
            }
            if (!salah.isEmpty()) {
                statusLabel.setText(salah.size() + " isian perlu diperbaiki");
                salah.get(0).requestFocusInWindow(); // arahkan pengguna ke kesalahan pertama
                return;
            }

            statusLabel.setText(" ");
            String pesan = "Pendaftaran berhasil."
                    + "\n\nNPM: " + npmField.getText()
                    + "\nNama: " + namaField.getText().trim()
                    + "\nJenis anggota: " + jenisAnggota();

            JOptionPane.showMessageDialog(this, pesan, "Pendaftaran Berhasil",
                    JOptionPane.INFORMATION_MESSAGE);
            kosongkan();

        }

        private String jenisAnggota() {
            if (dosenRadio.isSelected()) {
                return "Dosen";
            }
            if (umumRadio.isSelected()) {
                return "Umum";
            }
            return "Mahasiswa";
        }

        private void batal() {
// Aksi yang menghapus data meminta konfirmasi terlebih dahulu
            if (adaIsian()) {
                int jawab = JOptionPane.showConfirmDialog(this,
                        "Data yang sudah diisi akan dihapus. Lanjutkan?", "Konfirmasi",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

                if (jawab != JOptionPane.YES_OPTION) {
                    return;
                }
            }
            kosongkan();
        }

        private boolean adaIsian() {
            return !npmField.getText().isBlank() || !namaField.getText().isBlank()
                    || !emailField.getText().isBlank() || !hpField.getText().isBlank()
                    || !alamatArea.getText().isBlank();
        }

        private void kosongkan() {
            for (JTextField isian : List.of(npmField, namaField, emailField, hpField)) {
                isian.setText("");
            }
            alamatArea.setText("");
            prodiCombo.setSelectedIndex(0);
            mahasiswaRadio.setSelected(true);
            setujuCheck.setSelected(false);
            tandai(npmField, npmPesanLabel,
                    null);
            tandai(namaField, namaPesanLabel,
                    null);
            tandai(prodiCombo, prodiPesanLabel,
                    null);
            tandai(emailField, emailPesanLabel,
                    null);
            tandai(hpField, hpPesanLabel,
                    null);
            statusLabel.setText(" ");
            npmField.requestFocusInWindow();
        }

        /**
         * Creates new form FormAnggotaPerpustakaan
         */
        public FormAnggota() {
            initComponents();
            // Gaya huruf dan placeholder FlatLaf
            judulLabel.putClientProperty("FlatLaf.styleClass", "h2");
            keteranganLabel.putClientProperty("FlatLaf.style", "foreground: $Label.disabledForeground");
            dataAnggotaLabel.putClientProperty("FlatLaf.styleClass", "h4");
            kontakLabel.putClientProperty("FlatLaf.styleClass", "h4");
            npmField.putClientProperty("JTextField.placeholderText", "Contoh: 2410010123");

            emailField.putClientProperty("JTextField.placeholderText", "nama@contoh.com");
            hpField.putClientProperty("JTextField.placeholderText", "08xxxxxxxxxx");
// Label pesan kesalahan: huruf kecil dan warna merah yang mengikuti tema
            for (JLabel pesan : List.of(npmPesanLabel, namaPesanLabel, prodiPesanLabel, emailPesanLabel,
                    hpPesanLabel)) {
                pesan.putClientProperty("FlatLaf.styleClass", "small");
                pesan.setForeground(warnaKesalahan());
            }
            statusLabel.setForeground(warnaKesalahan());
            getRootPane().setDefaultButton(daftarButton);
            pack();
            setMinimumSize(getSize());
            setLocationRelativeTo(null);
        }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        anggotaGroup = new javax.swing.ButtonGroup();
        tombolPane = new javax.swing.JPanel();
        daftarButton = new javax.swing.JButton();
        batalButton = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        isiPane = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        namaLabel = new javax.swing.JLabel();
        npmLabel = new javax.swing.JLabel();
        programLabel = new javax.swing.JLabel();
        anggotaLabel = new javax.swing.JLabel();
        persetujuanLabel = new javax.swing.JLabel();
        alamatLabel = new javax.swing.JLabel();
        namaField = new javax.swing.JTextField();
        npmField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        prodiCombo = new javax.swing.JComboBox<>();
        JScrollPane = new javax.swing.JScrollPane();
        alamatArea = new javax.swing.JTextArea();
        setujuCheck = new javax.swing.JCheckBox();
        namaPesanLabel = new javax.swing.JLabel();
        npmPesanLabel = new javax.swing.JLabel();
        prodiPesanLabel = new javax.swing.JLabel();
        emailPesanLabel = new javax.swing.JLabel();
        hpField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        noHpLabel = new javax.swing.JLabel();
        hpPesanLabel = new javax.swing.JLabel();
        jenisPanel = new javax.swing.JPanel();
        mahasiswaRadio = new javax.swing.JRadioButton();
        dosenRadio = new javax.swing.JRadioButton();
        umumRadio = new javax.swing.JRadioButton();
        kontakLabel = new javax.swing.JLabel();
        dataAnggotaLabel = new javax.swing.JLabel();
        headerPane = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        keteranganLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout(8, 8));

        tombolPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 16, 16));

        daftarButton.setText("Daftar");
        daftarButton.addItemListener(this::daftarButtonItemStateChanged);
        daftarButton.addActionListener(this::daftarButtonActionPerformed);

        batalButton.setText("Batal");
        batalButton.addActionListener(this::batalButtonActionPerformed);

        statusLabel.setText(" ");

        javax.swing.GroupLayout tombolPaneLayout = new javax.swing.GroupLayout(tombolPane);
        tombolPane.setLayout(tombolPaneLayout);
        tombolPaneLayout.setHorizontalGroup(
            tombolPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tombolPaneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
                .addComponent(daftarButton)
                .addGap(18, 18, 18)
                .addComponent(batalButton)
                .addGap(2, 2, 2))
        );
        tombolPaneLayout.setVerticalGroup(
            tombolPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tombolPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(tombolPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(daftarButton)
                    .addComponent(batalButton)
                    .addComponent(statusLabel)))
        );

        getContentPane().add(tombolPane, java.awt.BorderLayout.PAGE_END);

        isiPane.setLayout(new java.awt.BorderLayout());

        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        formPanel.setLayout(new java.awt.GridBagLayout());

        namaLabel.setDisplayedMnemonic('N');
        namaLabel.setLabelFor(namaField);
        namaLabel.setText("Nama Lengkap");
        namaLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 8);
        formPanel.add(namaLabel, gridBagConstraints);

        npmLabel.setDisplayedMnemonic('P');
        npmLabel.setLabelFor(npmField);
        npmLabel.setText("NPM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(npmLabel, gridBagConstraints);

        programLabel.setDisplayedMnemonic('R');
        programLabel.setLabelFor(prodiCombo);
        programLabel.setText("Program Studi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(programLabel, gridBagConstraints);

        anggotaLabel.setDisplayedMnemonic('J');
        anggotaLabel.setLabelFor(dosenRadio);
        anggotaLabel.setText("Jenis Anggota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(anggotaLabel, gridBagConstraints);

        persetujuanLabel.setDisplayedMnemonic('T');
        persetujuanLabel.setLabelFor(setujuCheck);
        persetujuanLabel.setText("Persetujuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(persetujuanLabel, gridBagConstraints);

        alamatLabel.setDisplayedMnemonic('L');
        alamatLabel.setLabelFor(alamatArea);
        alamatLabel.setText("Alamat");
        alamatLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        formPanel.add(alamatLabel, gridBagConstraints);

        namaField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(namaField, gridBagConstraints);

        npmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                npmFieldFocusLost(evt);
            }
        });
        npmField.addActionListener(this::npmFieldActionPerformed);
        npmField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                npmFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                npmFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(npmField, gridBagConstraints);

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(emailField, gridBagConstraints);

        prodiCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teknik Informatika", "Manajemen Informatika", "Sistem Informatika" }));
        prodiCombo.addItemListener(this::prodiComboItemStateChanged);
        prodiCombo.addActionListener(this::prodiComboActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(prodiCombo, gridBagConstraints);

        JScrollPane.setName(""); // NOI18N

        alamatArea.setColumns(20);
        alamatArea.setRows(5);
        JScrollPane.setViewportView(alamatArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 4, 0);
        formPanel.add(JScrollPane, gridBagConstraints);

        setujuCheck.setText("Setuju dengan tata tertib perpustakaan");
        setujuCheck.addItemListener(this::setujuCheckItemStateChanged);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(setujuCheck, gridBagConstraints);

        namaPesanLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(namaPesanLabel, gridBagConstraints);

        npmPesanLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(npmPesanLabel, gridBagConstraints);

        prodiPesanLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(prodiPesanLabel, gridBagConstraints);

        emailPesanLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(emailPesanLabel, gridBagConstraints);

        hpField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hpFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 0);
        formPanel.add(hpField, gridBagConstraints);

        emailLabel.setDisplayedMnemonic('E');
        emailLabel.setLabelFor(emailField);
        emailLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(emailLabel, gridBagConstraints);

        noHpLabel.setDisplayedMnemonic('E');
        noHpLabel.setLabelFor(emailField);
        noHpLabel.setText("No.Hp");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(noHpLabel, gridBagConstraints);

        hpPesanLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(hpPesanLabel, gridBagConstraints);

        jenisPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 12));

        anggotaGroup.add(mahasiswaRadio);
        mahasiswaRadio.setSelected(true);
        mahasiswaRadio.setText("Mahasiswa");
        mahasiswaRadio.addItemListener(this::mahasiswaRadioItemStateChanged);
        jenisPanel.add(mahasiswaRadio);

        anggotaGroup.add(dosenRadio);
        dosenRadio.setText("Dosen");
        jenisPanel.add(dosenRadio);

        anggotaGroup.add(umumRadio);
        umumRadio.setText("Umum");
        jenisPanel.add(umumRadio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(jenisPanel, gridBagConstraints);

        kontakLabel.setText("Kontak");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(kontakLabel, gridBagConstraints);

        dataAnggotaLabel.setText("Data Anggota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(dataAnggotaLabel, gridBagConstraints);

        isiPane.add(formPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(isiPane, java.awt.BorderLayout.CENTER);

        headerPane.setMaximumSize(new java.awt.Dimension(238, 56));
        headerPane.setMinimumSize(new java.awt.Dimension(238, 56));
        headerPane.setLayout(new javax.swing.BoxLayout(headerPane, javax.swing.BoxLayout.Y_AXIS));

        judulLabel.setText("Pendaftaran Anggota");
        headerPane.add(judulLabel);

        keteranganLabel.setText("Semua isian wajib diisi, kecuali alamat");
        headerPane.add(keteranganLabel);

        getContentPane().add(headerPane, java.awt.BorderLayout.NORTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButtonActionPerformed
        // TODO add your handling code here:
        daftar();
    }//GEN-LAST:event_daftarButtonActionPerformed

    private void npmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmFieldActionPerformed

    private void npmFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npmFieldKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_npmFieldKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void prodiComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prodiComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prodiComboActionPerformed

    private void npmFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npmFieldKeyTyped
        boolean penuh = npmField.getText().length() >= 10
                && npmField.getSelectedText() == null;
        if (!Character.isDigit(evt.getKeyChar()) || penuh) {
            evt.consume(); // karakter tidak dimasukkan ke isian
        }
    }//GEN-LAST:event_npmFieldKeyTyped

    private void npmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_npmFieldFocusLost
        if (!npmField.getText().isBlank()) {
            periksaNpm();
        }
    }//GEN-LAST:event_npmFieldFocusLost

    private void namaFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaFieldFocusLost
        // TODO add your handling code here:
        if (!namaField.getText().isBlank()) {
            periksaNama();
        }
    }//GEN-LAST:event_namaFieldFocusLost

    private void mahasiswaRadioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_mahasiswaRadioItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            periksaProdi();
        }
    }//GEN-LAST:event_mahasiswaRadioItemStateChanged

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        // TODO add your handling code here:
        if (!emailField.getText().isBlank()) {
            periksaEmail();
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void hpFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hpFieldFocusLost
        // TODO add your handling code here:
        if (!hpField.getText().isBlank()) {
            periksaHp();
        }
    }//GEN-LAST:event_hpFieldFocusLost

    private void daftarButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_daftarButtonItemStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_daftarButtonItemStateChanged

    private void setujuCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_setujuCheckItemStateChanged
        // TODO add your handling code here:
        daftarButton.setEnabled(setujuCheck.isSelected());

    }//GEN-LAST:event_setujuCheckItemStateChanged

    private void prodiComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prodiComboItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            periksaProdi();
        }
    }//GEN-LAST:event_prodiComboItemStateChanged
    

  
    /**
         * Merah yang mudah dibaca: lebih gelap di tema terang, lebih terang di
         * tema gelap.
         */
        /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        FlatLightLaf.setup();

        java.awt.EventQueue.invokeLater(() -> new FormAnggota().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private javax.swing.JTextArea alamatArea;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.ButtonGroup anggotaGroup;
    private javax.swing.JLabel anggotaLabel;
    private javax.swing.JButton batalButton;
    private javax.swing.JButton daftarButton;
    private javax.swing.JLabel dataAnggotaLabel;
    private javax.swing.JRadioButton dosenRadio;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailPesanLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel headerPane;
    private javax.swing.JTextField hpField;
    private javax.swing.JLabel hpPesanLabel;
    private javax.swing.JPanel isiPane;
    private javax.swing.JPanel jenisPanel;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JLabel keteranganLabel;
    private javax.swing.JLabel kontakLabel;
    private javax.swing.JRadioButton mahasiswaRadio;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel namaPesanLabel;
    private javax.swing.JLabel noHpLabel;
    private javax.swing.JTextField npmField;
    private javax.swing.JLabel npmLabel;
    private javax.swing.JLabel npmPesanLabel;
    private javax.swing.JLabel persetujuanLabel;
    private javax.swing.JComboBox<String> prodiCombo;
    private javax.swing.JLabel prodiPesanLabel;
    private javax.swing.JLabel programLabel;
    private javax.swing.JCheckBox setujuCheck;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel tombolPane;
    private javax.swing.JRadioButton umumRadio;
    // End of variables declaration//GEN-END:variables
}
