package bg.uni.fmi.lab02.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskSix {

    public static int sizeMap(Map<Integer, String> map) {

        return map.size();
    }

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "El1");
        map.put(3, "El3");
        map.put(2, "El2");

        System.out.println(sizeMap(map));
    }
}
