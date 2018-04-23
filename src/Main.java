import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> phase2 = simulation.loadItems("phase-2.txt");
        ArrayList<Rocket> fleet1 = simulation.loadU1(phase1);
        ArrayList<Rocket> fleet2 = simulation.loadU1(phase2);
        long phase1Budget = simulation.runSimulation(fleet1);
        long phase2Budget = simulation.runSimulation(fleet2);
        long total = phase1Budget + phase2Budget;
        System.out.println("U1 Phase 1: $" + phase1Budget + ", U1 Phase 2: $" + phase2Budget + ". Total: $" + total);
        fleet1 = simulation.loadU2(phase1);
        fleet2 = simulation.loadU2(phase2);
        phase1Budget = simulation.runSimulation(fleet1);
        phase2Budget = simulation.runSimulation(fleet2);
        System.out.println("U2 Phase 1: $" + phase1Budget + ", U2 Phase 2: $" + phase2Budget + ". Total: $" + total);
    }
}
