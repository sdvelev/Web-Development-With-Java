package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskOne {

    public static String retrieveElementFromList(List<String> list, int index) {

        if (index > list.size() - 1) {

            return "No such element";
        }

        return list.get(index);
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Two");
        list.add("Three");


        System.out.println(retrieveElementFromList(list, 1));
    }

}
