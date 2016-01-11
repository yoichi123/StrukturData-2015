import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Iterator;


public class ProcessClientThread implements Runnable {
    String Mobil[] = new String[10];
    String Motor[] = new String[12];
    String Becak[] = new String[10];

    String Kirim= null;
    OutputStream keluaran =null;
    BufferedWriter keluaranBuf = null;
    public ProcessClientThread(Socket koneksiKiriman) {
        koneksi = koneksiKiriman;
    }

    public void run() {
        try{
            if (koneksi != null)
                prosesPermintaanClient(koneksi);
        }   
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }

    private void prosesPermintaanClient(Socket koneksi) 
    throws InterruptedException, IOException {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("\nDari: " + ip);

        Calendar kalender = Calendar.getInstance();
        String waktuStr = kalender.getTime().toString();

        // Ambil dan tampilkan masukan
        //for(;;){
        InputStream masukan = koneksi.getInputStream();
        BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
        String baris = masukanReader.readLine();
        baris = baris.trim().toUpperCase();
        String[] terima = baris.split("-");

        OutputStream keluaran = koneksi.getOutputStream();
        BufferedWriter keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
        
        if(terima[0].compareTo("MOBIL") == 0){ 
            //iter=0;
            if(iter1<= Mobil.length-1){

                synchronized(this){
                    if(isi == false){
                        System.out.println("Kendaraan : "+terima[0]);
                        kode1++;
                        String KodeKD1 = "M"+kode1;
                        Mobil[iter1]= KodeKD1;
                        isi = true;
                        //++jumlahMobil;
                        iter1++;
                        System.out.println("Plat : "+terima[1]);
                        System.out.println("Kendaraan Ke : "+KodeKD1);
                        System.out.println("Waktu Masuk : "+waktuStr);
                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        keluaranBuf.write("OKE");
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                        String baris2 = masukanReader.readLine();
                        baris2 = baris2.trim().toUpperCase();
                        if(baris2.compareTo("STOP")==0){
                            iter1--;
                            //kode--;
                            System.out.println("STOP");
                            System.out.println("Mobil Plat "+terima[1]+" Telah Keluar");
                            Calendar kaalender = Calendar.getInstance();
                            kaalender.add(Calendar.HOUR_OF_DAY, 0);
                            String WaktuKeluar = kaalender.getTime().toString();
                            System.out.println("Waktu Keluar : "+WaktuKeluar);
                            
                        }
                    }else {
                        iter1++;
                    }
                }
            }else{
                String Penuh="FULL";
                keluaranBuf.write(Penuh);
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }
        }

        //baris = baris.trim().toUpperCase();
        else if(terima[0].compareTo("MOTOR") == 0){ 
            //iter=0;
            if(iter2<= Motor.length-1){

                synchronized(this){
                    if(isi == false){
                        System.out.println("Kendaraan : "+terima[0]);
                        kode2++;
                        String KodeKD2 = "MT"+kode2;
                        Motor[iter2] = KodeKD2;
                        isi = true;
                        //++jumlahMotor;
                        iter2++;
                        System.out.println("Plat : "+terima[1]);
                        System.out.println("Kendaraan Ke : "+KodeKD2);
                        System.out.println("Waktu Masuk : "+waktuStr);
                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        keluaranBuf.write("OKE");
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                        String baris2 = masukanReader.readLine();
                        baris2 = baris2.trim().toUpperCase();
                        if(baris2.compareTo("STOP")==0){
                            iter2--;
                            System.out.println("STOP");
                            System.out.println("Motor Plat "+terima[1]+" Telah Keluar");
                            Calendar kaalender = Calendar.getInstance();
                            kaalender.add(Calendar.HOUR_OF_DAY, 0);
                            String Waktu = kaalender.getTime().toString();
                            System.out.println("Waktu Keluar : "+Waktu);

                        }
                    }else {
                        iter2++;
                    }
                }
            }else{
                String Penuh="FULL";
                keluaranBuf.write(Penuh);
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }
        }

       // baris = baris.trim().toUpperCase();
        else if(terima[0].compareTo("BECAK") == 0){ 
            //iter=0;
            if(iter3<= Becak.length-1){

                synchronized(this){
                    if(isi == false){
                        System.out.println("Kendaraan : "+terima[0]);
                        kode3++;
                        String KodeKD3 = "B"+kode3;
                        Becak[iter3] = KodeKD3;
                        isi = true;
                        //++jumlahBecak;
                        iter3++;
                        System.out.println("Plat : "+terima[1]);
                        System.out.println("Kendaraan Ke : "+KodeKD3);
                        System.out.println("Waktu Masuk : "+waktuStr);
                        keluaran = koneksi.getOutputStream();
                        keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
                        keluaranBuf.write("OKE");
                        keluaranBuf.newLine();
                        keluaranBuf.flush();
                        String baris2 = masukanReader.readLine();
                        baris2 = baris2.trim().toUpperCase();
                        if(baris2.compareTo("STOP")==0){
                            iter3--;
                            System.out.println("STOP");
                            System.out.println("Becak Kode "+terima[1]+" Telah Keluar");
                            Calendar kaalender = Calendar.getInstance();
                            kaalender.add(Calendar.HOUR_OF_DAY, 0);
                            String Waktu = kaalender.getTime().toString();
                            System.out.println("Waktu Keluar : "+Waktu);

                        }
                    }else {
                        iter3++;
                    }
                }
            }else{
                String Penuh="FULL";
                keluaranBuf.write(Penuh);
                keluaranBuf.newLine();
                keluaranBuf.flush();
            }
        }else if((terima[0].compareTo("MOBIL") == 0)&& (terima[0].compareTo("MOTOR") == 0) && (terima[0].compareTo("BECAK") == 0)){
            String salah="Input Salah";
                keluaranBuf.write(salah);
                keluaranBuf.newLine();
                keluaranBuf.flush();
        }

        keluaranBuf.newLine();
        keluaranBuf.flush();
        //}
        //Iterator myAlias = arlis.iterator();
        System.out.print("\nTampilkan List : ");
        Scanner list = new Scanner(System.in);
        String input = list.next();
        input = input.trim().toUpperCase();
        if(input.compareTo("TOTAL") == 0)
        {
            // while(myAlias.hasNext())
            //{
            System.out.println("\nMobil :"+kode1+" Motor :"+kode2+" Becak : "+kode3+"\n");
            //}

            /*while(true)
            {
                if(myAlias.hasNext())
                {
                    System.out.println(myAlias.next());
                }

            }*/
        }
    }

    private void prosesPermintaanClient() {
        try {
            // IP address asal koneksi                                                                   
            String ip = koneksi.getInetAddress().getHostAddress();
            // Tampilkan pesan
            System.out.println("Dari: " + ip);

            // Baca dari socket
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan)); 
            String baris = masukanReader.readLine();
            while (baris != null) {
                System.out.println(baris);
                baris = masukanReader.readLine();
            }

            // Tunggu 2 detik
            System.out.println("Tunggu...");
            Thread.sleep(2000);
            System.out.println("Selesai tunggu...");

            koneksi.close();
        }
        catch(IOException err) {
            System.out.println(err);
        }
        catch(InterruptedException err) {
            System.out.println(err);
        }
    }
    static int iter1 =0;
    static int iter2 =0;
    static int iter3 =0;
    static int kode1 = 0;
    static int kode2 = 0;
    static int kode3 = 0;
    boolean isi= false;

   // ArrayList<String> arlis = new ArrayList<String>();
    private Socket koneksi; 

}
/*Kelompok  : 2
   PUTRA ARIFAH : 1408107010060
   STEVEN lIUNARDI  : 1408107010048
 */