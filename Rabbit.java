public class Rabbit extends Animal {
    
    //fields

    //constructor
    
    //asbtract methods
    public boolean isRabbit(){
        return true;
    }

    public boolean breedingTime(int steps){
        return steps % 3 == 0;
    }

    public Animal giveBirth(){
        return new Rabbit();
    }

    //methods

    //helper methods

    //setters and getters

    //toString
    @Override
    public String toString(){
        return "o";
    }

}
