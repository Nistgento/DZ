package lesson2_3;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Park {
    private String parkName;
    private List<Attraction> attractions;

    public Park(String parkName) {
        this.parkName = parkName;
        this.attractions = new ArrayList<>();
    }

    public class Attraction {
        private String name;
        private LocalTime startTime;
        private LocalTime endTime;
        private double price;
        public Attraction(String name, LocalTime startTime, LocalTime endTime, double price) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }
        public String getName() {
            return name;
        }
        public LocalTime getStartTime() {
            return startTime;
        }
        public LocalTime getEndTime() {
            return endTime;
        }
        public double getPrice() {
            return price;
        }
        @Override
        public String toString() {
            return String.format("%s (Work time: %s - %s, Price: %.2f $)", name, startTime, endTime, price);
        }
    }
    public void addAttraction(String name, LocalTime startTime, LocalTime endTime, double price) {
        attractions.add(new Attraction(name, startTime, endTime, price));
    }
    public void printAttractions() {
        System.out.println("Park: " + parkName);
        System.out.println("Attractions: ");
        for (Attraction attraction : attractions) {
            System.out.println("* " + attraction);
        }
    }
    public static void main(String[] args) {
        Park IMXO = new Park("IMXO");

        IMXO.addAttraction("American mounts",
                LocalTime.of(10,0),
        LocalTime.of(22,0),
        400.99);

        IMXO.addAttraction("Ferris wheel",
                LocalTime.of(11,0),
                LocalTime.of(23,0),
        500.00);

        IMXO.addAttraction("Swing",
                LocalTime.of(8,0),
                LocalTime.of(20,0),
        200.00);

        IMXO.printAttractions();
    }
}
