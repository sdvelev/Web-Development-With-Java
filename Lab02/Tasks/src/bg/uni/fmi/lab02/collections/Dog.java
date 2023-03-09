package bg.uni.fmi.lab02.collections;

public class Dog {

    private int breed;
    private int weight;

    public Dog(int breed, int weight) {
        this.breed = breed;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
            "breed=" + breed +
            ", weight=" + weight +
            '}';
    }

    public int getBreed() {
        return breed;
    }

    public int getWeight() {
        return weight;
    }
}
