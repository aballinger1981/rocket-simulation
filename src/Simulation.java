import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems(String fileName) throws Exception {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> list = new ArrayList<>();
        if (file.exists() && file.canRead()) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String name = line.substring(0, line.indexOf("="));
                int weight = Integer.parseInt(line.substring(line.indexOf("=") + 1));
                Item item = new Item(name, weight);
                list.add(item);
            }
        }
        return list;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Rocket> rocketList = new ArrayList<Rocket>();
        U1 rocket = new U1();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketList.add(rocket);
                itemList.clear();
                rocket = new U1();
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                }
            }
            itemList.add(item);
        }
        if (itemList.size() > 0) {
            rocket = new U1();
            rocketList.add(rocket);
        }
        return rocketList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Item> itemList = new ArrayList<Item>();
        ArrayList<Rocket> rocketList = new ArrayList<Rocket>();
        U2 rocket = new U2();
        for (Item item : items) {
            if (rocket.canCarry(item)) {
                rocket.carry(item);
            } else {
                rocketList.add(rocket);
                itemList.clear();
                rocket = new U2();
                if (rocket.canCarry(item)) {
                    rocket.carry(item);
                }
            }
            itemList.add(item);
        }
        if (itemList.size() > 0) {
            rocket = new U2();
            rocketList.add(rocket);
        }
        return rocketList;
    }

    public long runSimulation(ArrayList<Rocket> rockets) {
        long totalBudget = 0;
        for (Rocket rocket : rockets) {
            boolean launched = rocket.launch();
            boolean landed = rocket.land();
            while (!launched || !landed) {
                launched = rocket.launch();
                landed = rocket.land();
                totalBudget += rocket.cost;
            }
            totalBudget += rocket.cost;
        }
        return totalBudget;
    }
}
