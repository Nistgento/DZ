package lesson2_4.Animals;

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