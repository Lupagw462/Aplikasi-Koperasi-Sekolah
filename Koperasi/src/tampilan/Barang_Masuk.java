/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tampilan;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.HashMap;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import koneksi.koneksi;

/**
 *
 * @author Yuki
 */
public class Barang_Masuk extends javax.swing.JFrame {

    private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;

    String Tanggal;
    Date date = new Date();
    SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * Creates new form Barang_Masuk
     */

    private void autonumber() {
        String sql = "select * from barangmasuk order by NoFaktur DESC";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            if (hasil.next()) {
                String NoFaktur = hasil.getString("NoFaktur").substring(2);

                int newNumber = Integer.parseInt(NoFaktur) + 1;
                String PG = String.valueOf(newNumber);

                String Nol = "";
                switch (PG.length()) {
                    case 1:
                        Nol = "000";
                        break;
                    case 2:
                        Nol = "00";
                        break;
                    case 3:
                        Nol = "0";
                        break;
                    case 4:
                        Nol = "";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid NoFaktur length");
                }

                ttransaksi.setText("PG" + Nol + PG);
            } else {
                ttransaksi.setText("PG0001");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error parsing NoFaktur to number: " + e.getMessage());
            ttransaksi.setText("PG0001");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            ttransaksi.setText("PG0001");
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            ttransaksi.setText("PG0001");
        }
    }

    public void loaddata() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{
            ttransaksi.getText(),
            tid.getText(),
            nmbrg.getText(),
            tharga.getText(),
            tjml.getText(),});
    }

    public void utama() {
        ttransaksi.setText("");
        tid.setText("");
        nmbrg.setText("");
        tharga.setText("");
        tjml.setText("");
        tbayar.setText(("Rp. 0"));
        autonumber();
    }

    public void clear() {
        tid.setText("");
        nmbrg.setText("");
        tharga.setText("");
        tjml.setText("");
    }

    public void kosong() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

    public void updateTotalBayar() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            double rowTotal = (Double) model.getValueAt(i, 5);
            total += rowTotal;
        }
        tbayar.setText(String.format("Rp.%.2f", total));
    }

    public Barang_Masuk() {
        initComponents();
        setSize(825, 725);
        setLocationRelativeTo(null);
        this.setResizable(false);
        setTitle("Data Barang Masuk");
        ttanggal.setText(s.format(date));
        tbayar.setText("Rp. 0");
        nmbrg.requestFocus();
        DefaultTableModel model = new DefaultTableModel();
        jTable1.setModel(model);

        model.addColumn("No Transaksi");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga");
        model.addColumn("Total");

        autonumber();
        utama();
        nmbrg.requestFocus();

        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        ttanggal.setText(s.format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tid = new javax.swing.JTextField();
        nmbrg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tjml = new javax.swing.JTextField();
        tharga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ttanggal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bsimpan = new javax.swing.JButton();
        bclear = new javax.swing.JButton();
        bkembali = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        ttransaksi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bcari = new javax.swing.JButton();
        btambah = new javax.swing.JButton();
        bhapus2 = new javax.swing.JButton();
        tbayar = new javax.swing.JTextField();
        bprint = new javax.swing.JButton();
        blaporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("ID Barang");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nama Barang");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Jumlah");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Harga Barang");

        ttanggal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Tanggal");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        bsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon Save.png"))); // NOI18N
        bsimpan.setText("Simpan");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bclear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon edit.png"))); // NOI18N
        bclear.setText("Clear");
        bclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bclearActionPerformed(evt);
            }
        });

        bkembali.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon kembali.png"))); // NOI18N
        bkembali.setText("Kembali");
        bkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkembaliActionPerformed(evt);
            }
        });

        bkeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon Exit.png"))); // NOI18N
        bkeluar.setText("Keluar");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        ttransaksi.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("No.Pengadaan");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("DATA BARANG MASUK");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo_80x80-removebg-preview.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo_80x80__1_-removebg-preview.png"))); // NOI18N
        jLabel9.setText("jLabel9");

        bcari.setText("Cari");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        btambah.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btambah.setText("Tambah");
        btambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btambahActionPerformed(evt);
            }
        });

        bhapus2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        bhapus2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon delete.png"))); // NOI18N
        bhapus2.setText("Hapus");
        bhapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapus2ActionPerformed(evt);
            }
        });

        tbayar.setBackground(new java.awt.Color(255, 51, 51));
        tbayar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        bprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon print.png"))); // NOI18N
        bprint.setText("Print");
        bprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bprintActionPerformed(evt);
            }
        });

        blaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icon print.png"))); // NOI18N
        blaporan.setText("Cetak Laporan Barang Masuk");
        blaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blaporanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(ttransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(55, 55, 55)
                        .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(213, 213, 213)
                        .addComponent(jLabel3)
                        .addGap(54, 54, 54)
                        .addComponent(tjml, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bsimpan)
                                    .addComponent(bkeluar))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bclear)
                                        .addGap(18, 18, 18)
                                        .addComponent(bkembali))
                                    .addComponent(blaporan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bhapus2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bprint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(nmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bcari)
                                .addGap(144, 144, 144)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(ttransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel5))
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(nmbrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(bcari))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel4))
                    .addComponent(tharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btambah, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bhapus2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(bprint, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bsimpan)
                            .addComponent(bclear)
                            .addComponent(bkembali))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(blaporan, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bkeluar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkembaliActionPerformed
        // TODO add your handling code here:
        this.toBack();
        menu mainmenu = new menu();
        mainmenu.setVisible(true);
        mainmenu.toFront();
        this.dispose();
    }//GEN-LAST:event_bkembaliActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        // TODO add your handling code here:
        String sql = "select * from databarang where Nama_Barang like'%" + nmbrg.getText() + "%'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                String a = hasil.getString("ID_Barang");
                String b = hasil.getString("Harga_Jual");
                tid.setText(a);
                tharga.setText(b);
                tid.setEnabled(false);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bcariActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        // TODO add your handling code here:
        String noTransaksi = ttransaksi.getText();
        String tanggal = ttanggal.getText();
        String total = tbayar.getText();
        String sql = "INSERT INTO barangmasuk(NoFaktur, Tanggal, Total) VALUES(?, ?, ?)";
        try {
            // Memulai transaksi
            conn.setAutoCommit(false);

            // Menyimpan data ke tabel penjualan
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, noTransaksi);
            stat.setString(2, tanggal);
            stat.setString(3, total);

            int result = stat.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data Berhasil DiSimpan.");
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal DiSimpan.");
                conn.rollback();
                return; // Keluar dari method jika gagal
            }

            // Menyimpan data ke tabel penjualanrinci
            int baris = jTable1.getRowCount();
            sql = "INSERT INTO barangmasuk2(NoFaktur, ID_Barang, Nama_Barang, Jumlah, Harga, Total) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statDetail = conn.prepareStatement(sql);

            for (int i = 0; i < baris; i++) {
                statDetail.setString(1, noTransaksi); // Menggunakan NoFaktur dari transaksi
                statDetail.setString(2, jTable1.getValueAt(i, 1).toString());
                statDetail.setString(3, jTable1.getValueAt(i, 2).toString());
                statDetail.setInt(4, Integer.parseInt(jTable1.getValueAt(i, 3).toString()));
                statDetail.setDouble(5, Double.parseDouble(jTable1.getValueAt(i, 4).toString()));
                statDetail.setDouble(6, Double.parseDouble(jTable1.getValueAt(i, 5).toString()));

                int detailResult = statDetail.executeUpdate();
                if (detailResult == 0) {
                    JOptionPane.showMessageDialog(null, "Data Gagal DiSimpan untuk baris " + (i + 1));
                    conn.rollback();
                    return;
                }
            }

            // Komit transaksi jika semua data tersimpan
            conn.commit();

            // Membersihkan form dan mengatur ulang nomor faktur
            utama();
            autonumber();
            kosong();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            e.printStackTrace();
            try {
                conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.setAutoCommit(true); // Kembali ke mode autocommit
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_bsimpanActionPerformed

    private void btambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btambahActionPerformed
        // TODO add your handling code here:
        String noTransaksi = ttransaksi.getText();
        String idBarang = tid.getText();
        String namaBarang = nmbrg.getText();
        String hargaStr = tharga.getText();
        String jumlahStr = tjml.getText();

        double harga = Double.parseDouble(hargaStr);
        int jumlah = Integer.parseInt(jumlahStr);
        double total = harga * jumlah;

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addRow(new Object[]{noTransaksi, idBarang, namaBarang, jumlah, harga, total});

        updateTotalBayar();
        nmbrg.requestFocus();
        clear();
    }//GEN-LAST:event_btambahActionPerformed

    private void bhapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapus2ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int row = jTable1.getSelectedRow();

        if (row >= 0) {
            model.removeRow(row);
            double totalBayar = 0;
            for (int i = 0; i < model.getRowCount(); i++) {
                double rowTotal = (Double) model.getValueAt(i, 5);
                totalBayar += rowTotal;
            }
            tbayar.setText(String.format("Rp. %.2f", totalBayar));
        }
    }//GEN-LAST:event_bhapus2ActionPerformed

    private void bclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bclearActionPerformed
        // TODO add your handling code here:
        utama();
    }//GEN-LAST:event_bclearActionPerformed

    private void bprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bprintActionPerformed
        // TODO add your handling code here:
        try {
            String namaFile = "src/Laporan/Laporan Barang Masuk.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conn);
            JasperViewer.viewReport(jasperPrint, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bprintActionPerformed

    private void blaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blaporanActionPerformed
        // TODO add your handling code here
        try {
            String namaFile = "src/Laporan/Laporan Barang Masuk.jasper";
            Connection conn = new koneksi().connect();
            HashMap parameter = new HashMap();
            File report_file = new File(namaFile);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report_file.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameter,conn);
            JasperViewer.viewReport (jasperPrint, false);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_blaporanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Barang_Masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang_Masuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bcari;
    private javax.swing.JButton bclear;
    private javax.swing.JButton bhapus2;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bkembali;
    private javax.swing.JButton blaporan;
    private javax.swing.JButton bprint;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton btambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nmbrg;
    private javax.swing.JTextField tbayar;
    private javax.swing.JTextField tharga;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tjml;
    private javax.swing.JTextField ttanggal;
    private javax.swing.JTextField ttransaksi;
    // End of variables declaration//GEN-END:variables
}
