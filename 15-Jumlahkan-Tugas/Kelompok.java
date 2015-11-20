
public class Kelompok implements Runnable {
    private int awal;
    private int akhir;
    private double data[];
    private double nilaiHasil;
    
    public Kelompok(int awal,int akhir,double data[]) {
        this.awal=awal;
        this.akhir=akhir;
        this.data=data;      
        

    }
    
    public double hasil(){
        return nilaiHasil;
    }
    
    public void hitung(){
       nilaiHasil=0;
        for(int sukses=awal;sukses<=akhir;sukses++)
            nilaiHasil+= data[sukses];
    }
    
    public void run(){
       hitung();
    }
}