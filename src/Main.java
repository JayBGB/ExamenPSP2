import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        int numberOfClients = Integer.parseInt(JOptionPane.showInputDialog("How many clients are there?"));
        int numberOfCashiers = Integer.parseInt(JOptionPane.showInputDialog("How many cashiers are there?"));

        SuperMarket supermarket = new SuperMarket(numberOfCashiers);

        // Creamos hilos para representar a los clientes
        Thread[] clients = new Thread[numberOfClients];
        for (int i = 0; i < numberOfClients; i++) {
            clients[i] = new Client(i + 1, supermarket);
        }

        // Iniciamos los hilos de los clientes
        for (Thread client : clients) {
            client.start();
        }

        // Esperamos a que todos los clientes terminen
        for (Thread client : clients) {
            try {
                client.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Mostramos los resultados
        List<Integer> results = supermarket.getResults();
        System.out.println("FINAL RESULTS:");
        for (int i = 0; i < results.size(); i++) {
            System.out.println("CLIENT " + (i + 1) + ": " + results.get(i)+"€");
        }

        // Por darle un añadido, mostramos el total de todas las compras
        int total = 0;
        for(int i = 0; i < results.size(); i++){
            int euros = results.get(i);
            total += euros;
        }
        System.out.println("TOTAL: " + total + "€");


    }
}