import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.String;

/**
 * Write a description of class kopiBerkas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge{
    
   public void merge ( String file1,String file2,String file3, String sasaran) throws IOException {
       FileInputStream file_1= null;
       FileInputStream file_2= null;
       FileInputStream file_3= null;
       FileInputStream masukan= null;
       FileOutputStream keluaran= null;
       try{
           file_1 = new FileInputStream (file1);
           keluaran= new FileOutputStream(sasaran);
           int karakter = file_1.read();
        while(karakter!=-1){
            keluaran.write(karakter);
            karakter=file_1.read();
        }
           file_2 = new FileInputStream (file2);
           keluaran= new FileOutputStream(sasaran,true);
           karakter = file_2.read();
        while(karakter!=-1){
            keluaran.write(karakter);
            karakter=file_2.read();
        }
           file_3 = new FileInputStream (file3);
           keluaran= new FileOutputStream(sasaran,true);
           karakter = file_3.read();
        while(karakter!=-1){
            keluaran.write(karakter);
            karakter=file_3.read();
        }
        keluaran.flush();
        }
    
       catch(IOException kesalahan){
           System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    
        finally {
            // Tutup stream masukan
            if (masukan != null)
                masukan.close();
            if(keluaran != null)
                keluaran.close();
            if (file_1 != null)
                file_1.close();
            if(file_2 != null)
                file_2.close();
            if (file_3 != null)
                file_3.close();
            if(keluaran != null)
                keluaran.close();
            }
               
    }
    
   
}

