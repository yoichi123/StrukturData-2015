import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

/**
 * Write a description of class kopiBerkas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KopiBerkasBuffer{
    
   public void kopi( String sumber, String sasaran) throws IOException {
       FileInputStream masukan= null;
       BufferedInputStream masukanBuffer = null;
       FileOutputStream keluaran= null;
       BufferedOutputStream keluaranBuffer = null;
       try{
           masukan= new FileInputStream(sumber);
           masukanBuffer = new BufferedInputStream(masukan);
           keluaran= new FileOutputStream(sasaran);
           keluaranBuffer = new BufferedOutputStream(keluaran);
           
           int karakter = masukanBuffer.read();
           
        while(karakter!=-1){
            keluaranBuffer.write(karakter);
            karakter=masukanBuffer.read();
        }
        keluaranBuffer.flush();
        }
    
       catch(IOException kesalahan){
           System.out.printf("Terjadi kesalahan: %s", kesalahan);
        
        
        }
    
        finally {
            // Tutup stream masukan
            if (masukanBuffer != null)
                masukanBuffer.close();
                
            if(keluaranBuffer != null)
                keluaranBuffer.close();
            }
               
    }
    
   
}

