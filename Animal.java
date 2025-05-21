
public abstract class Animal {
    
    //fields
    private Cell cell;

    //constructors
    
    //abstract methods
    public abstract boolean isRabbit();

    public abstract boolean breedingTime(int steps);

    public abstract Animal giveBirth();

    //methods
    public void die(){
        this.cell.setAnimal(null);
    }

    public Animal move(){
        Cell cellToMoveTo = this.cell.getRandomEmptyNeighbor();

        if (cellToMoveTo != null) {
            this.cell.setAnimal(null);
            this.cell = cellToMoveTo;
            cellToMoveTo.setAnimal(this);
            cellToMoveTo.printCoordiantes();
        }

        return null;
    }

    public Animal breed(int steps){

        if (!breedingTime(steps)) {

            return null;
        }

        Cell cellToGiveBirthIn = this.cell.getRandomEmptyNeighbor();

        if (cellToGiveBirthIn != null) {
            Animal offspring = giveBirth();

            cellToGiveBirthIn.setAnimal(offspring);
            offspring.setCell(cellToGiveBirthIn);

            return offspring;
        }
        else {return null;}
        
    }

    //helper methods

    // Setters and Getters
    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    //toString
    @Override
    public String toString(){
        return "*";
    }
}
