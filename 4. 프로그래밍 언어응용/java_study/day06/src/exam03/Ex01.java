package exam03;

public class Ex01 {
    public static void main(String[] args) {
        Order order = new Order();
        order.sell();
        order.buy();
        order.order(); // Sell::order ? Buy::order ?

        Buy buy = order;
        Sell sell = order;
    }
}
