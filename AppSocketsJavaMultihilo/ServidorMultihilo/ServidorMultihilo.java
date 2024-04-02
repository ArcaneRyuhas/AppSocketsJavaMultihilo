package ServidorMultihilo;

import java.io.IOException;
import java.net.ServerSocket;

public class ServidorMultihilo{
    
    public static void main(String [] args){
        // Establece el puerto a utilizar
        int puerto = 6060;
        int cont = 1;

        // Crea un socket de servidor
        try(ServerSocket serverSocket = new ServerSocket(puerto)){
            System.out.println("Servidor escuchando en el puerto: " + puerto + "...");

            while(true){
                HiloHandler cliente = new HiloHandler(serverSocket.accept(), cont);
                Thread h1 = new Thread(cliente);
                h1.start();
                cont++;
            }
        } catch (IOException exception){
            System.out.println(exception);
        }
    }
}