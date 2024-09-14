/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKeempat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Salwa Faizah
 */
public class CRUD {
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/PBO";
    String user = "postgres";
    String password = "kuanlinee";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        
        new CRUD().tampil();
        System.out.println("");
        
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); // Nonaktifkan otomatis commit

            String sql = "INSERT INTO siswa (id_siswa, nama_siswa, tanggal_lahir, jenis_kelamin, alamat) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA SISWA ");
                System.out.print("ID siswa : ");
                String id_siswa = input.readLine().trim();
                System.out.print("Nama : ");
                String nama_siswa = input.readLine().trim();
                System.out.print("Tanggal lahir (YYYY-MM-DD): ");
                String tanggal_lahir = input.readLine().trim();
                System.out.print("Jenis kelamin : ");
                String jenis_kelamin = input.readLine().trim();
                System.out.print("Alamat : ");
                String alamat = input.readLine().trim();

                pstmt.setString(1, id_siswa);
                pstmt.setString(2, nama_siswa);
                pstmt.setDate(3, java.sql.Date.valueOf(tanggal_lahir)); // Pastikan formatnya benar
                pstmt.setString(4, jenis_kelamin);
                pstmt.setString(5, alamat);
                pstmt.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data siswa lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            System.out.println("Sukses dalam satu penambahan data.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        new CRUD().tampil();
    }

    public void tampil() {
        try {
            Class.forName(driver);
            String sql = "SELECT * FROM siswa";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getDate(3) + " " + rs.getString(4) + " " + rs.getString(5));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void hapus() {
        
        new CRUD().tampil();

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);

            System.out.print("Masukkan ID siswa yang akan dihapus : ");
            String IdSiswa = input.readLine().trim();

            String deleteSql = "DELETE FROM siswa WHERE nomor_induk_siswa = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, IdSiswa);
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Penghapusan berhasil untuk ID siswa " + IdSiswa + "!");
            } else {
                System.out.println("ID Siswa " + IdSiswa + " tidak ada.");
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        new CRUD().tampil();
    }

    public void update() {
        
        new CRUD().tampil();
        
        try {
            Class.forName(driver);
            String sql = "UPDATE siswa SET nama_siswa = ?, tanggal_lahir = ?, jenis_kelamin = ?, alamat = ? WHERE id_siswa = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);

            System.out.print("Masukkan ID siswa yang akan diupdate : ");
            String IdSiswa = input.readLine().trim();
            System.out.print("Nama siswa baru : ");
            String namaSiswaBaru = input.readLine().trim();
            System.out.print("Tanggal lahir baru (YYYY-MM-DD): ");
            String tanggalLahirBaru = input.readLine().trim();
            System.out.print("Jenis kelamin baru : ");
            String jenisKelaminBaru = input.readLine().trim();
            System.out.print("Alamat baru : ");
            String alamatBaru = input.readLine().trim();
            
            pstmt.setString(1, namaSiswaBaru);
            pstmt.setDate(2, java.sql.Date.valueOf(tanggalLahirBaru)); // Pastikan formatnya benar
            pstmt.setString(3, jenisKelaminBaru);
            pstmt.setString(4, alamatBaru);
            pstmt.setString(5, IdSiswa);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        new CRUD().tampil();
    }

    public void menu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\n========= MENU UTAMA =========");
            System.out.println("1. Input Data");
            System.out.println("2. Tampil Data");
            System.out.println("3. Hapus Data");
            System.out.println("4. Update Data");
            System.out.println("0. Keluar");
            System.out.print("PILIHAN> ");

            try {
                int pilihan = Integer.parseInt(input.readLine());
                switch (pilihan) {
                    case 0:
                        exit = true; // Set exit menjadi true untuk keluar dari loop
                        break;
                    case 1:
                        tambah();
                        break;
                    case 2:
                        tampil();
                        break;
                    case 3:
                        hapus();
                        break;
                    case 4:
                        update();
                        break;
                    default:
                        System.out.println("Pilihan salah!");
                }
            } catch (IOException | NumberFormatException ex) {
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Input tidak valid. Silakan coba lagi.");
            }
        }
        System.out.println("Program telah selesai."); // Pesan saat keluar dari program
    }

    public static void main(String[] args) {
        new CRUD().menu();
    }
}


