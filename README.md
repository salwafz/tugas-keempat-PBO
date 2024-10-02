
# JAVA CRUD dan EXCEPTION HANDLING
Penugasan Mata Kuliah Pemrograman Berorientasi Objek pertemuan keempat kali ini yaitu membuat Java CRUD dan Exception Handling yang terdiri dari Try-Catch, Throw, dan Custom Exception.

## Daftar Isi
1. [ Try-Catch dan Throw](https://github.com/salwafz/tugas-keempat-PBO/blob/main/ThrowsTryCatch.java)
2. [ Custom Exception](https://github.com/salwafz/tugas-keempat-PBO/blob/main/TugasException.java)
3. [ CRUD](https://github.com/salwafz/tugas-keempat-PBO/blob/main/CRUD.java)

---
## 1. Try-Catch dan Throw
Proyek ini merupakan contoh implementasi penanganan exception di Java menggunakan `try-catch` dan `throw`. Exception adalah kondisi abnormal yang terjadi selama eksekusi program, yang dapat menyebabkan program tidak berjalan dengan semestinya, dengan menggunakan exception handling, pesan kesalahan yang sesuai akan ditampilkan, sehingga memungkinkan program untuk melanjutkan tanpa terhenti.
Dengan `try catch`, kita bisa menangkap kesalahan dan melakukan tindakan yang lebih terkendali, seperti menampilkan pesan kesalahan yang informatif dan dapat dipahami pengguna.
`Throw` digunakan ketika kita ingin memberi sinyal kondisi kesalahan dan meneruskannya ke metode pemanggil.
### Contoh 
```` java
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
````
---
## 2. Custom Exception
Custom exception adalah eksepsi yang bisa kita buat sendiri untuk menangani kondisi spesifik dalam kode kita. Untuk membuat custom exception, kita perlu membuat kelas yang mewarisi dari kelas Exception.

### Contoh
````java
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
````
---
## 3. CRUD
proyek pengelolaan database menggunakan operasi CRUD (Create, Read, Update, Delete) yang terhubung dengan database menggunakan NetBeans. Proyek ini bertujuan untuk memberikan pemahaman dasar tentang cara mengelola data dengan menggunakan JDBC. Pada proyek ini saya menggunakan database siswa. Dengan begitu, pada program ini kita bisa menampilkan data siswa, menambahkan data siswa, menghapus data siswa dan juga mengupdate data siswa.

Contohnya https://github.com/salwafz/tugas-keempat-PBO/blob/main/CRUD.java

Output dari source code pada link diatas yaitu:
1. Input
   
   ![image](https://github.com/user-attachments/assets/7cbaa962-a45b-4da5-91a4-94ff5ad4bef5)
2. Update
   
   ![image](https://github.com/user-attachments/assets/755c4044-2e91-420c-8ff4-bd57c351c068)
3. Delete
   
   ![image](https://github.com/user-attachments/assets/22ec543a-d1ae-4565-9fef-008e59bdeb31)

---


Sekian dari saya, semoga repository ini dapat membantu dan menjelaskan tentang tugas PBO pertemuan keempat kali ini, TERIMAKASIH!!!


