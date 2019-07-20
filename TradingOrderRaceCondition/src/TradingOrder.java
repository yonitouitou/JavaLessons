import java.util.UUID;

public class TradingOrder {

    private String id;
    private double price;
    private double amount;
    private Bank counterParty;

    public TradingOrder(double price, double amount, Bank counterParty) {
        this.id = UUID.randomUUID().toString();
        this.price = price;
        this.amount = amount;
        this.counterParty = counterParty;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public double getAmount() {
        return amount;
    }

    public Bank getCounterParty() {
        return counterParty;
    }

    @Override
    public String toString() {
        return "TradingOrder{" +
                "id='" + id + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", counterParty=" + counterParty +
                '}';
    }
}
