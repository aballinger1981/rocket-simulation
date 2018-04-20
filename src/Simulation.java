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

    public ArrayList<Item> loadU1(ArrayList<Item> items) {
        int weightU1 = 8;
        U1 rocket1 = new U1();
        for (Item item : items) {
            if (weightU1 - item.weight >= 0) {

            }
        }
    }

    public ArrayList<Item> loadU2(ArrayList<Item> items) {
        int weightU2 = 11;
        for (Item item : items) {
            if (weightU2 - item.weight >= 0) {

            }
        }
    }

    public runSimulation(ArrayList<Item> rockets) {

    }
}
