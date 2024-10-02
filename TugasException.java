/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKeempat;

/**
 *
 * @author Salwa Faizah
 */
public class TugasException extends ArithmeticException {

    public TugasException(String message) {
        super(message);
    }

    public static void cekAngka(int angka) throws TugasException {
        if (angka < 0) {
            // Jika angka negatif, lemparkan custom exception
            throw new TugasException("Anda memasukkan bilangan negatif!");
        }
        System.out.println("Angka valid: " + angka);
    }

    public static void main(String[] args) {
        // TODO code application logic here

        int angka = -3; // Angka negatif
        try {
            cekAngka(angka);
        } catch (TugasException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
