public class Rocket implements SpaceShip {
    long cost;
    int weight;
    int maxWeight;
    int explosionChance;
    int crashChance;

    public Rocket() {

    }

    // Will get overridden in U1 and U2 class
    public boolean launch() {
        return true;
    }

    // Will get overridden in U1 and U2 class
    public boolean land() {
        return true;
    }

    // Check if rocket can carry item
    public boolean canCarry(Item item) {
        if (weight + item.weight <= maxWeight) {
            return true;
        }
        return false;
    }

    // Add weight of item to rocket
    public void carry(Item item) {
        weight += item.weight;
    }
}
