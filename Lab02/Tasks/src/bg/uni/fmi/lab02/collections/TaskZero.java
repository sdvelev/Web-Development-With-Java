package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskZero {

    public static void addElementFirstPlace(List<String> list, String element) {

        list.add(0, element);
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Two");
        list.add("Three");

        System.out.println(list);

        addElementFirstPlace(list, "One");

        System.out.println(list);
    }

}
