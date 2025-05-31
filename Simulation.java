// Athanasios Giannopoulos AM 5672
import java.util.Scanner;

public class Simulation {
    
    //final fields
    private static final int SIMULATION_STEPS = 1000;

    //fields

    //constructor

    //methods

    //helper methods
    private static void printGridAndPopualtion(Grid grid, AnimalSimulator as){
        System.out.println(grid.toString());
        as.printPopulations();
    }

    //toString

    public static void main(String[] args) {
        AnimalSimulator as = new AnimalSimulator();
        Grid grid = new Grid();
        Scanner in = new Scanner(System.in);

        as.populate(grid);

        printGridAndPopualtion(grid, as);

        for (int step = 1; step < SIMULATION_STEPS; step++){
            String input = in.nextLine();

            if (!input.isEmpty()) {
                break;
            }

            as.moveAndBreedAnimals(step);

            printGridAndPopualtion(grid, as);
        }
        
        in.close();
    }
}
