package exam02;

public class Fruit implements Comparable<Fruit>{
    protected int price;

    @Override
    public int compareTo(Fruit o) {
        return price - o.price;
    }
}
