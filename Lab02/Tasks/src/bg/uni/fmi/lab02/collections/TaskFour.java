package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskFour {

    public static void sortArrayListDog(List<Dog> list) {

        list.sort(new ComparatorByDogWeight());
    }

    public static void main(String[] args) {

        List<Dog> list = new ArrayList<>();

        Dog one = new Dog(12, 13);
        Dog two = new Dog(7, 9);
        Dog three = new Dog(8, 2);

        list.add(one);
        list.add(two);
        list.add(three);

        sortArrayListDog(list);

        System.out.println(list);

        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(4);
        list2.add(13);

        list2.sort(Integer::compareTo);
        System.out.println(list2);

        List<String> list3 = new ArrayList<>();
        list3.add("El1");
        list3.add("El3");
        list3.add("El2");

        list3.sort(String::compareTo);

        System.out.println(list3);
    }
}
