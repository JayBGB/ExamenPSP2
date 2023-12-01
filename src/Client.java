import java.util.Random;

class Client extends Thread {
    private int id;
    private SuperMarket supermarket;

    public Client(int id, SuperMarket supermarket) {
        this.id = id;
        this.supermarket = supermarket;
    }

    @Override
    public void run() {
        // Simula el tiempo de compra
        try {
            Thread.sleep(new Random().nextInt(15000));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Selecciona aleatoriamente una caja
        int chosenCashier = new Random().nextInt(supermarket.getCashierNumber());
        supermarket.getWithClient(id, chosenCashier);
    }
}
