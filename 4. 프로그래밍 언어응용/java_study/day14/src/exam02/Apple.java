package exam02;

public class Apple extends Fruit{
    
    public Apple(int price){
        this.price = price;
    }
    
    public String toString(){
        return "사과 : "+price;
    }

}
