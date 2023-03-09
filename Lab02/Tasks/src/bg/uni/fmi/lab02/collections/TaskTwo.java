package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    public static void removeThirdElementFromList(List<String> list) {

        if (list.size() <= 3) {

            list.remove(2);
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
