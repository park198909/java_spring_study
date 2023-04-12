package exam02;

public class Box<T extends Fruit> {

//    private T[] items = new T[3];     // new가 객체의 공간(크기)을 할당하지 못함 = 배열 생성시 자료형이 명확해야 함

    private T item;     // 컴파일 시 T의 타입을 Fruit을 포함한 하위클래스로 한정

    public void setItem(T item){    // 컴파일 시 T의 타입을 Fruit을 포함한 하위클래스로 한정
        this.item = item;
    }

    public T getItem(){  // 컴파일 시 T의 타입을 Fruit을 포함한 하위클래스로 한정
        return item;
    }

    public void printInfo(){
        item.info();
    }
}
