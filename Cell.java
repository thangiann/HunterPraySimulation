import java.util.ArrayList;
import java.util.Collections;

public class Cell {
    
    //fields
    private ArrayList<Cell> neighbors;
    private Animal animal;

    //only for debugging
    private int xAxisValue;
    private int yAxisValue;

    //constructors
    public Cell(){
        this.neighbors = new ArrayList<>();
    }

    public Cell(int xAxisValue, int yAxisValue){
        this.xAxisValue = xAxisValue;
        this.yAxisValue =  yAxisValue;
        this.neighbors = new ArrayList<>();
    }

    //methods
    public void addNeighbor(Cell cell){
        this.neighbors.add(cell);
    }

    public Cell getRandomEmptyNeighbor(){
        Collections.shuffle(neighbors);

        for (Cell cell:neighbors){
            if (cell != null && !cell.isEmpty() ){
                return cell;
            }
        }

        return null;
    }

    public Cell getRandomRabbitNeighbor(){
        Collections.shuffle(neighbors);

        for (Cell cell:neighbors){
            if (cell.containsRabbit()) {
                return cell;
            }
        }

        return null;
    }

    public void removeAnimal(){
        this.animal = null;
    }

    public boolean isEmpty(){
        return animal == null;
    }

    public boolean containsRabbit(){
        return this.animal.isRabbit();
    }

    //helper methods
    private void printCoordiantes(){
        System.out.println("x axis value: " + this.xAxisValue);
        System.out.println("y axis value: " + this.yAxisValue);
    }

    private void printNeighbors(){
        for (Cell cell:this.neighbors){
            if (cell != null) {
                System.out.println(cell.toString());
            }
        }
    }

    public void printCellInformation(){
        printCoordiantes();
        printNeighbors();
    }

    //setters and getters
    public ArrayList<Cell> getNeighbors() {
    return neighbors;
    }

    public void setNeighbors(ArrayList<Cell> neighbors) {
        this.neighbors = neighbors;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }   

    public int getXAxisValue() {
        return xAxisValue;
    }

    public void setXAxisValue(int xAxisValue) {
        this.xAxisValue = xAxisValue;
    }


    public int getYAxisValue() {
        return yAxisValue;
    }

    public void setYAxisValue(int yAxisValue) {
        this.yAxisValue = yAxisValue;
    }

    //toString
    @Override
    public String toString(){
        if (animal == null) {
            return "_";
        }
        else{ return this.animal.toString();}
    }
}
