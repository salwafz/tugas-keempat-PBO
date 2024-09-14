/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TugasKeempat;

/**
 *
 * @author Salwa Faizah
 */
public class TugasException {
    public static void main(String[] args) {
        int bilangan=10;
        String b[] = {"a","b","c"};
        try{
            System.out.println(bilangan/2);
            System.out.println(b[4]);
        }catch (ArithmeticException e) {
            System.out.println("Eror Arithmetic");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("eror kapasitas array melebihi kapasitas");
        }catch (Exception e) {
            System.out.println("terdapat eror");
        }
    
    }
}
