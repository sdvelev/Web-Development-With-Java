package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskOne {

    public static String retrieveElementFromList(List<String> list, int index) {

        if (index < list.size() && index >= 0) {
            return list.get(index);
        }

        return "No such element";
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");

        System.out.println(retrieveElementFromList(list, 1));
    }

}
