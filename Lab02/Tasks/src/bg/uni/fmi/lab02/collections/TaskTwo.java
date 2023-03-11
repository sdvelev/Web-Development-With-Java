package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    private final static int THIRD_ELEMENT = 3;

    public static void removeThirdElementFromList(List<String> list) {

        if (list.size() >= THIRD_ELEMENT) {

            list.remove(THIRD_ELEMENT - 1);
        }

    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        removeThirdElementFromList(list);

        System.out.println(list);
    }
}
