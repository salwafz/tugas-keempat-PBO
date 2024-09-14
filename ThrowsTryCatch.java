/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKeempat;

/**
 *
 * @author Salwa Faizah
 */
public class ThrowsTryCatch {

    // Method 1: Menangani pengecualian ArithmeticException menggunakan try-catch sendiri
    public static void iniTryCatch(int a, int b) {
        try {
            int hasil = a / b;
            System.out.println("Hasil pembagian: " + hasil);
        } catch (ArithmeticException e) {
            System.err.println("Kesalahan dari method try-catch sendiri: Pembagian dengan nol tidak diperbolehkan.");
        }
    }

    // Method 2: Melempar pengecualian ArithmeticException menggunakan throws
    public static void iniThrows(int a, int b) throws ArithmeticException {
        int hasil = a / b;
        System.out.println("Hasil pembagian: " + hasil);
    }

    public static void main(String[] args) {
        // 1. Memanggil method dengan try-catch sendiri
        iniTryCatch(10, 0);  // Pembagian dengan nol, pengecualian ditangani di dalam method

        // 2. Memanggil method yang menggunakan throws dan menangkap pengecualian di main
        try {
            iniThrows(10, 3);  // Pembagian dengan nol, pengecualian dilempar ke main
        } catch (ArithmeticException e) {
            // Menangkap pengecualian dan menampilkan pesan kesalahan
            System.err.println("Kesalahan dari method throws yang ditangkap di main: Pembagian dengan nol tidak diperbolehkan.");
        }

        System.out.println("Program selesai.");
    }
}
