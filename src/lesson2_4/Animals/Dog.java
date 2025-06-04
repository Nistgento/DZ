package lesson2_4.Animals;

class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MIN_SWIM_DISTANCE = 10;
    public Dog(String name) {
        super(name);
        dogCount++;
    }
    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println("Dog runs " + distance + " meters away");
        } else {
            System.out.println("Dog dont runs " + distance + " meters away");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance < MIN_SWIM_DISTANCE) {
            System.out.println("Dog swims " + distance + " meters away");
        } else {
            System.out.println("Dog dont swims " + distance + " meters away");
        }
    }
    public static int getDogCount() {
        return dogCount;
    }
}
