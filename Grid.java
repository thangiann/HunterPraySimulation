import java.util.Random;

public class Grid {
    
    //final fields
    private final int SIZE = 20;

    //fields
    private Cell[][] array = new Cell[SIZE][SIZE];

    //constructor
    public Grid() {
        for (int xAxisValue = 0; xAxisValue < SIZE; xAxisValue++) {

            for (int yAxisValue = 0; yAxisValue < SIZE; yAxisValue++) {

                //Cell cell = new Cell();
                Cell cell = new Cell(xAxisValue, yAxisValue);

                int firstRow = 0;
                int lastRow = SIZE - 1;
                int firstColumn = 0;
                int lastColumn = SIZE - 1;

                if (xAxisValue != firstRow) {
                    cell.addNeighbor(array[xAxisValue - 1][yAxisValue]);
                }

                if (yAxisValue != firstColumn) {
                    cell.addNeighbor(array[xAxisValue][yAxisValue - 1]);
                }

                if (yAxisValue != lastColumn) {
                    cell.addNeighbor(array[xAxisValue][yAxisValue + 1]);
                }

                if (xAxisValue != lastRow) {
                    cell.addNeighbor(array[xAxisValue + 1][yAxisValue]);
                }

                array[xAxisValue][yAxisValue] = cell;
            }
        }
    }

    //methods
    public void addAnimal(Animal animal){
        Random random = new Random();

        boolean emptyCell = true;        

        while (emptyCell) {

            int xAxisValue = random.nextInt(SIZE);
            int yAxisValue = random.nextInt(SIZE);

            Cell selectedCell = array[xAxisValue][yAxisValue];

            selectedCell.printCellInformation();

            if (selectedCell.isEmpty()){

                selectedCell.setAnimal(animal);
                animal.setCell(selectedCell);

                emptyCell = false;
            }
        }
        
    }
    
    //helper methods

    //setters and getters
    public Cell[][] getArray() {
        return array;
    }

    public void setArray(Cell[][] array) {
        this.array = array;
    }

    //toString
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 20; i++){

            for (int j = 0; j < 20; j++){
                sb.append(array[i][j].toString());
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Grid grid = new Grid();

        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());
        grid.addAnimal(new Fox());

        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());
        grid.addAnimal(new Rabbit());

        System.out.println(grid.toString());
    }
}
