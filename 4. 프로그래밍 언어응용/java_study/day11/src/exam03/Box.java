package exam03;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {       // 지네릭클래스 - T는 인스턴스가 생성될 때 결정
    private List<T> items = new ArrayList<>();      // List -> T[]

    public void add(T item){
        items.add(item);
    }

    public List<T> getItems(){
        return items;
    }
 }
