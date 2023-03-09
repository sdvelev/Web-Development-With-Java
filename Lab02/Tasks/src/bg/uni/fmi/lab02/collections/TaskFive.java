package bg.uni.fmi.lab02.collections;

import java.util.ArrayList;
import java.util.List;

public class TaskFive {

    public static void replaceSecondElement(List<String> list, String toReplace) {

        if (list.size() >= 2) {

            list.set(1, toReplace);
        }
    }

    public static void main(String[] args) {

        List<String> list3 = new ArrayList<>();
        list3.add("El1");
        list3.add("El2");
        list3.add("El3");

        replaceSecondElement(list3, "New element");

        System.out.println(list3);
    }
}
