package lesson2_4;

abstract class Animal {
    private static int animalCount = 0;
    private final String name;
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    public String getName() {
        return name;
    }
    public abstract void run(int distance);
    public abstract void swim(int distance);
    public static int getAnimalCount() {
        return animalCount;
    }

}

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
    public static int getCatCount() {
        return catCount;
    }
}
class Bowl {
    private int foodAmount;
    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }
    public boolean decreaseFood(int amount) {
        if (amount <= 0) return false;
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Added food " + amount + " meters away. Now: " + foodAmount);
        }
    }
    public int getFoodAmount() {
        return foodAmount;
    }
}
public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Chappi");
        Cat cat = new Cat("Snowy");

        dog.run(150);
        dog.run(600);
        dog.swim(8);
        dog.swim(11);

        cat.run(100);
        cat.run(210);
        cat.swim(10);

        Bowl bowl = new Bowl(30);

        Cat[] cats = {
                new Cat("Murzik"),
                new Cat("Pudge"),
                new Cat("Pizza"),
                new Cat("Bebezyka")
        };
        for (Cat c : cats) {
            c.eatFromBowl(bowl, 10);
        }

        System.out.println("Hunger:");
        for (Cat c : cats) {
            System.out.println(c.getName() + ":" + (c.isFed() ? "Fed" : "Not Fed"));
        }
        bowl.addFood(20);
        cats[3].eatFromBowl(bowl, 10);
    }
}