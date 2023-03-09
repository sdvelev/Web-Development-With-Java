package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskThree {

    public static int searchElement(List<String> list, String toFind) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals(toFind)) {

                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");

        System.out.println(searchElement(list, "Three"));
    }
}
