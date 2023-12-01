import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class SuperMarket {
    private int cashierNumber;
    private List<Integer> results;

    public SuperMarket(int cashierNumber) {
        this.cashierNumber = cashierNumber;
        this.results = new ArrayList<>();
    }

    public synchronized void getWithClient(int clienteId, int cashier) {
        // Simula el proceso de pago aleatorio
        int payment = new Random().nextInt(50) * 10;
        System.out.println("Client " + clienteId + " at cashier " + cashier + " pays " + payment + "€");

        // Registra el resultado
        results.add(payment);
    }

    public int getCashierNumber() {
        return cashierNumber;
    }

    public List<Integer> getResults() {
        return results;
    }
}
