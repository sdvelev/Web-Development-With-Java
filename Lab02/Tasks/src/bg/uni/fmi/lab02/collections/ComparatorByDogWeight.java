package bg.uni.fmi.lab02.collections;

import java.util.Comparator;

public class ComparatorByDogWeight implements Comparator<Dog> {


    @Override
    public int compare(Dog o1, Dog o2) {
        return Integer.compare(o1.getWeight(), o2.getWeight());
    }
}
