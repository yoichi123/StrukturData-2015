
/**
 * Write a description of class Mobil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mobil implements Kendaraan
{
    private String plat;
    
    public Mobil(String plat){
        this.plat = plat;
    }
    public String plat(){
        return plat;
    }
    public String tipe(){
        String tipe = new String("Mobil");
        return tipe;
    }
}
