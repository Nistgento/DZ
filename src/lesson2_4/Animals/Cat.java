package lesson2_4.Animals;

class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean isFed = false;
    public Cat(String name) {
        super(name);
        catCount++;
    }
    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println("Cat run" + distance + " meters away");
        } else {
            System.out.println("Cat dont run " + distance + " meters away");
        }
    }
    @Override
    public void swim(int distance) {
        System.out.println("Not smim!");
    }
    public void eatFromBowl(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isFed = true;
            System.out.println("Eat from bowl " + amount + " meters away");
        } else {
            System.out.println("Not eat from bowl " + amount + " meters away");
        }
    }
    public boolean isFed() {
        return isFed;
    }
}
