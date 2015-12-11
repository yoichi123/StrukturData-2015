

import java.net.*; 
import java.io.*; 
import java.util.*;
public class socketget { 

    public static void main(String[] args) throws Exception { 
        try { 

            Socket socket = new Socket("google.co.id",80); 

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))); 
            out.println("GET index.html"); 
            out.println(); 
            out.flush(); 

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); 

            String inputLine; 
            int count = 0; 

            while ((inputLine = in.readLine()) != null) { 
                count++; 
                System.out.println(count); 
                System.out.println(inputLine); 
            } 

            in.close(); 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
}
