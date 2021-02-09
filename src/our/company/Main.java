package our.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] ar = {"1", "2", "3", "4", "5", "6"};
        //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
        ar = shiftElementInArray(ar, 2, 4);

        // 2. Написать метод, который преобразует массив в ArrayList;
        ArrayList<Object> list = convertToArrayList(ar);
        writeArray(list);

        // 3. a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        //b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        //c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        //d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f,
        // не важно в каких это единицах);
        //e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра,
        // true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
        //f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки
        // высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
        //g. Не забываем про метод добавления фрукта в коробку.
        Box<Apple> box = new Box();
        box.add(new Apple());
        box.add(new Apple());
        box.add(new Apple());
        box.add(new Apple());
        box.add(new Apple());
        box.add(new Apple());
        System.out.println(box.getWeightBox());
        Box<Orange> box2 = new Box<>();
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        box2.add(new Orange());
        //box2.add(new Orange());
        System.out.println(box2.getWeightBox());
        System.out.println(box.compare(box2));

        Box<Apple> boxApple = new Box<>();
        boxApple.add(new Apple());
        boxApple = transferToAnotherBox(box, boxApple);
        writeArray(boxApple.getList());
        writeArray(box.getList());
    }

    public static <T> void writeArray(List<T> array) {
        for (T o : array) {
            System.out.println(o);
        }
    }

    public static <T> ArrayList<T> convertToArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }

    public static <T> T[] shiftElementInArray(T[] array, int firstIndex, int secondIndex) {
        T intermediateValue = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = intermediateValue;
        return array;
    }

    public static <T extends Fruits> Box<T> transferToAnotherBox(Box<T> fromBox, Box<T> whereBox) {
        if (fromBox.getList().size() != 0) {
            for (T o : fromBox.getList()) {
                whereBox.add(o);
            }
            fromBox.getList().clear();
            return whereBox;
        } else {
            System.out.println("Коробка из которой нужно пересыпать фрукты - пуста!");
            return fromBox;
        }
    }

}
