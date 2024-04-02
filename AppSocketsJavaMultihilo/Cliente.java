import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente {

    public static void main(String [] args){
        //Establece el puerto a utilizar
        int puerto = 6060;

        try{
            Socket cs = new Socket("localhost", puerto);

            PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));

            String lineaRecibida;

            while(!(lineaRecibida = in.readLine()).equalsIgnoreCase("EOF")){
                System.out.println("Servidor: " + lineaRecibida);
            }

            out.println("Recepción de datos correcta...");

            out.close();
            in.close();
            cs.close();

        } catch(IOException exception){
            System.out.println(exception);
        }
    }
    
}
