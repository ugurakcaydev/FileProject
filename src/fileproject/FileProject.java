/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fileproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author 202103011043
 */
public class FileProject {

    public static String url = "C:\\Users\\202103011043\\source\\repos\\Scripts\\NetBeansProjects\\FileProject\\src\\fileproject";

    public static void CreateFile() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Dosya Adini Gir = ");
        String fName = input.nextLine() + ".txt";
        String absolutePath = url + fName;
        File file = new File(absolutePath);

        try {
            if (file.exists()) {
                System.out.println(fName + " adli dosya zaten  var ");

            } else {
                System.out.println(fName + " adli dosya olusturuldu ");
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("HATA!!!!!");
        }

    }

    public static void DeleteFile() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.print("Silmek istedigin dosya adi = ");
        String fName = input.nextLine() + ".txt";
        String absolutePath = url + fName;
        File file = new File(absolutePath);

        try {
            if (!file.exists()) {
                System.out.println("Dosya Olmadigindan Silinemedi");
            } else {
                file.delete();
                System.out.println(fName + " Adli Dosya Basariyla Silindi");
            }
        } catch (Exception e) {
            System.out.println("HATA!!!!!");
        }

    }

    public static void ReadFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Okumak istediginiz dosya adi = ");
        String fName = input.nextLine() + ".txt";
        String absolutePath = url + fName;
        try {
            FileReader file = new FileReader(absolutePath);
            BufferedReader binput = new BufferedReader(file);
            String line = binput.readLine();
            while (line != null) {
                System.out.println(line);
                line = binput.readLine();
            }
        } catch (IOException e) {
            System.out.println("HATA!!!!!");
        }
    }

    public static void WriteFile() {
        Scanner input = new Scanner(System.in);
        System.out.print("Yazmak istediginiz dosya adi = ");
        String fName = input.nextLine() + ".txt";
        String absolutePath = url + fName;

        // Dosya içine metin yazalım 
        try {
            System.out.print("Ne Yazmak İstersin = ");
            String text = input.nextLine();

            FileWriter file = new FileWriter(absolutePath);
            try (BufferedWriter output = new BufferedWriter(file)) {
                output.write(text);
            }

        } catch (IOException e) {
            System.out.println("HATA!!!!!");
        }
    }

    public static void main(String[] args) throws IOException {
        boolean bool = true;
        Scanner input = new Scanner(System.in);
        System.out.println("İşlemler \n 1)Dosya Açma \n 2)Dosya Silme \n 3)Dosya Okuma \n 4)Dosyaya Yazma \n 5)Çıkış \n");

        while (bool) {
            System.out.print("Seçenek = ");
            int options = input.nextInt();
            switch (options) {
                case 1 ->
                    CreateFile();
                case 2 ->
                    DeleteFile();
                case 3 ->
                    ReadFile();
                case 4 ->
                    WriteFile();
                case 5 ->
                    bool = false;
                default ->
                    throw new AssertionError();
            }
        }

    }

}
