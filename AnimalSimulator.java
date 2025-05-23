import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class AnimalSimulator {
    
    //final fields
    private final int NUM_OF_FOXES = 5;
    private final int NUM_OF_RABBITS = 100;
    
    //fields
    HashSet<Animal> animals;

    //constructor
    public AnimalSimulator(){
        this.animals = new HashSet<>();
    }

    //methods
    public void populate(Grid grid){

        for (int i = 0; i < NUM_OF_FOXES; i++){

            Animal animalToAdd = new Fox();
            
            grid.addAnimal(animalToAdd);
            this.animals.add(animalToAdd);
        }

        for (int i = 0; i < NUM_OF_RABBITS; i++){

            Animal animalToAdd = new Rabbit();

            grid.addAnimal(animalToAdd);
            this.animals.add(animalToAdd);
        }
    }

    public void moveAndBreedAnimals(int timeStep){

        ArrayList<Animal> iterableAnimalList = new ArrayList<>(this.animals);
        Collections.shuffle(iterableAnimalList);

        for (Animal animal:iterableAnimalList){
            animal.move();
        }       
    }

    //helper methods

    //setters and getters

    //toString

    public static void main(String[] args) {
        AnimalSimulator as = new AnimalSimulator();
        Grid grid = new Grid();

        as.populate(grid);

        System.out.println(grid.toString());

        as.moveAndBreedAnimals(0);
        System.out.println(grid.toString());

    }
}
