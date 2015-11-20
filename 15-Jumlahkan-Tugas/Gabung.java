
public class Gabung extends Thread{
    private double data[];
    private Kelompok[] kelompok;
    public Gabung(double data[]){
        this.data=data;
        
        kelompok= new Kelompok[5];
        
        kelompok[0] = new Kelompok(0,data.length/5-1,data);
        Thread thread01= new Thread(kelompok[0]);
        kelompok[1] = new Kelompok(data.length/5,2*(data.length/5)-1,data);
        Thread thread02= new Thread(kelompok[1]);
        kelompok[2] = new Kelompok(2*(data.length/5),3*(data.length/5)-1,data);
        Thread thread03= new Thread(kelompok[2]);
        kelompok[3] = new Kelompok(3*(data.length/5),4*(data.length/5)-1,data);
        Thread thread04= new Thread(kelompok[3]);
        kelompok[4] = new Kelompok(4*(data.length/5),data.length-1,data);
        Thread thread05= new Thread(kelompok[4]);
        
        thread01.start();
        thread02.start();
        thread03.start();
        thread04.start();
        thread05.start();
    }
    
    public double hasil(){
        
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){
        }
        
        
        return kelompok[0].hasil()+kelompok[1].hasil()+kelompok[2].hasil()+kelompok[3].hasil()+kelompok[4].hasil();
    }
  
}