package lesson2_4.Animals;

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