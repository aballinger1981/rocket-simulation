public class U2 extends Rocket {

    public U2 () {
        super();
        cost = 120000000;
        weight = 18000;
        maxWeight = 29000;
        explosionChance = 4;
        crashChance = 8;
    }

    public boolean land() {
        double chance = (crashChance / 100) * (weight / maxWeight);
        double randomNumber = (Math.random() * 100);
        if (randomNumber < chance) {
            return false;
        }
        return true;
    }

    public boolean launch() {
        double chance = (explosionChance / 100) * (weight / maxWeight);
        double randomNumber = (Math.random() * 100);
        if (randomNumber < chance) {
            return false;
        }
        return true;
    }
}
