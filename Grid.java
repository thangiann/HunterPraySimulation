import java.util.Random;

public class Grid {
    
    //final fields
    private final int SIZE = 20;

    //fields
    private Cell[][] array = new Cell[SIZE][SIZE];

    //constructor
    public Grid() {
        
        createGrid();
        addNeighborsToEachCell();
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
    private void createGrid(){
        for (int row = 0; row < SIZE; row++){

            for (int column = 0; column < SIZE; column++){

                Cell cell = new Cell(row, column);
                array[row][column] = cell;
            }
        }
    }

    public void addNeighborsToEachCell(){
        for (int row = 0; row < SIZE; row++){

            for (int column = 0; column < SIZE; column++){

                Cell cell = this.array[row][column];

                int firstRow = 0;
                int lastRow = SIZE - 1;
                int firstColumn = 0;
                int lastColumn = SIZE - 1;

                if (row != firstRow) {
                    cell.addNeighbor(array[row - 1][column]);
                }

                if (column != firstColumn) {
                    cell.addNeighbor(array[row][column - 1]);
                }

                if (column != lastColumn) {
                    cell.addNeighbor(array[row][column + 1]);
                }

                if (row != lastRow) {
                    cell.addNeighbor(array[row + 1][column]);
                }
            }
        }
    }

    private void addAnimalInFixedSpot(Animal animal, int row, int column){
        Cell selectedCell = this.array[row][column];

        selectedCell.setAnimal(animal);
        animal.setCell(selectedCell);
    }
    
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
                sb.append(array[i][j].toString() + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Grid grid = new Grid();

        Fox fox = new Fox();
        grid.addAnimalInFixedSpot(fox, 1, 1);

        grid.addAnimalInFixedSpot(new Rabbit(), 1, 2);
        //grid.addAnimalInFixedSpot(new Fox(), 1, 2);
        //grid.addAnimalInFixedSpot(new Rabbit(), 1, 0);
        //grid.addAnimalInFixedSpot(new Fox(), 1, 0);
        //grid.addAnimalInFixedSpot(new Rabbit(), 0, 1);
        //grid.addAnimalInFixedSpot(new Fox(), 0, 1);

        System.out.println(grid.toString());

        for (int i = 0; i < 4; i++){
            fox.move();
            System.out.println(grid.toString());
        }
        
        
    }
}
