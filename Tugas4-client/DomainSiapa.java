import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;

public class DomainSiapa {    
    public void whois(String namaDomain) 
                throws UnknownHostException, IOException {
        // 0. Buka socket
        koneksi = new Socket("localhost", 33333);

        // Kirim perintah untuk informasi namaDomain
        kirimPerintah(namaDomain);
        
        // Baca balasannya
        bacaBalasan();

        // Tutup socket-nya => dengan sendirinya menutup semua stream
        koneksi.close();
    }
    
    public void kirimPerintah(String namaDomain) throws IOException {
        // 1 & 2. Minta socket untuk ditulis dan Langsung dibuka
        OutputStream keluaran = koneksi.getOutputStream();
        // Note: Karena protokol-nya berbasis teks pakai writer aja.
        Writer keluaranWriter = new OutputStreamWriter(keluaran); 
        // 3. Selagi ada data kirim
        keluaranWriter.write(namaDomain);
        // Syarat protokol-nya, semua perintah diakhiri dengan: CR & LF
        keluaranWriter.write("\r\n"); 
        keluaranWriter.flush(); // Paksa kirim data yang belum terkirim
    }
    
    public void bacaBalasan() throws IOException {
        System.out.print("Dari Server: ");
            InputStreamReader masukan = new InputStreamReader(koneksi.getInputStream()); 
            BufferedReader masukanBuff = new BufferedReader(masukan);
            String baris = masukanBuff.readLine();
            System.out.println(baris);    
            baris = baris.toUpperCase();
            Writer keluaranWriter = new OutputStreamWriter(koneksi.getOutputStream()); 
            BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
            keluaranBuff.write(baris);
            keluaranBuff.flush();
            System.out.println("Pesan Upper Berhasil Terkirim");
            System.out.println();
    }
    private Socket koneksi = null;
}