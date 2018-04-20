public class U1 extends Rocket {

    public U1 () {
        super();
        cost = 100000000;
        weight = 10000;
        maxWeight = 18000;
        explosionChance = 5;
        crashChance = 1;
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
