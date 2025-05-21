public class Fox extends Animal{
    
    //fields
    int stepsSinceLastEaten;

    //constructor
    public Fox(){
        this.stepsSinceLastEaten = 0;
    }

    //abstract methods
    public boolean isRabbit(){
        return false;
    }

    public boolean breedingTime(int steps){
        return steps == 8;
    }

    public Fox giveBirth(){
        return new Fox();
    }

    //methods
    @Override
    public Animal move(){
        
        Cell cellToEatFrom = this.getCell().getRandomRabbitNeighbor();

        if (cellToEatFrom != null) {
            
            return foxEatAnimal(cellToEatFrom);
        }
        
        stepsSinceLastEaten++;

        boolean foxDies = stepsSinceLastEaten == 3;
        if (foxDies) {
            this.die();

            return this;
        }
        else {

            foxMove();
            return null;
        }
    }

    //helper methods
    private Animal foxEatAnimal(Cell cellToEatFrom){

        Animal animalEaten = cellToEatFrom.getAnimal();
        animalEaten.die();
        stepsSinceLastEaten = 0;

        return animalEaten;
    }

    private void foxMove(){

        Cell cellToMoveTo = this.getCell().getRandomEmptyNeighbor();

        if (cellToMoveTo != null) {
            
            this.getCell().setAnimal(null);
            this.setCell(cellToMoveTo); 
            cellToMoveTo.setAnimal(this);
        }
    }

    //setters and getters 
    public int getStepsSinceLastEaten() {
        return stepsSinceLastEaten;
    }

    public void setStepsSinceLastEaten(int stepsSinceLastEaten) {
        this.stepsSinceLastEaten = stepsSinceLastEaten;
    }
    
    //toString
    @Override
    public String toString(){
        return "X";
    }
}
