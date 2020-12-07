package our.company;

import java.util.ArrayList;

public class Box<T extends Fruits> {
    private ArrayList<T> list;

    public Box() {
        this.list = new ArrayList<>(5);
    }

    public float getWeightBox(){
        if (!list.isEmpty()) {
            return list.size() * list.get(0).getWeight();
        } else {
            return 0;
        }
    }

    public void add(T t){
        list.add(t);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public boolean compare(Box<?> secondBox){
        return this.getWeightBox() == secondBox.getWeightBox();
    }
}
