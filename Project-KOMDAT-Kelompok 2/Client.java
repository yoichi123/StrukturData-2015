import java.net.Socket;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;

import java.util.Scanner;

public class Client {
    public void chat() 
    throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);
        //String ketikanSatuBaris ="Mobil BL 123 KD";
        Reader masukan=null;
        BufferedReader masukanBuff=null;
        int a=0;
        try {
            // for(;;){
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Petunjuk :Tipe_;Kendaraan-plat/kode");
            System.out.print("Pesan: ");
            String ketikanSatuBaris = keyboard.nextLine();
            ketikanSatuBaris = ketikanSatuBaris.trim().toUpperCase();        
            // Tulis ke socket
            Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(ketikanSatuBaris);
            keluaranBuff.write("\n");
            keluaranBuff.flush();

            // Baca dari Server
            System.out.print("Dari server: ");
            masukan = new InputStreamReader(socket.getInputStream()); 
            masukanBuff = new BufferedReader(masukan);
            String baris = masukanBuff.readLine();
            System.out.println(baris);

            if(baris.compareTo("FULL")==0){
                
            }
            else if(baris.compareTo("OKE")==0){
                System.out.println("Ketik STOP untuk Keluar pakiran");
                for(;;){
                    System.out.print("Pesan: ");

                    String ketikanSatuBaris2 = keyboard.nextLine();
                    ketikanSatuBaris2 = ketikanSatuBaris2.trim().toUpperCase();  
                    if(ketikanSatuBaris2.compareTo("STOP")==0){
                        keluaranBuff.write(ketikanSatuBaris2);
                        keluaranBuff.write("\n");
                        keluaranBuff.flush();break;
                    }
                    else{
                        System.out.println("Input Salah");continue;
                    }
                }
            }else {
                System.out.print("Input salah");
            }
        }

        // }
        catch(IOException salah) {
            System.out.println(salah);
        }
        finally {
            if (socket != null)
                socket.close();
        }
    }
}
