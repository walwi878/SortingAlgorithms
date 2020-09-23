import java.util.Scanner;
import java.util.function.Function;

public class Tableau {

     private Cell smallest = null;


     public void addValue(Integer value) {
        
       Cell cell = smallest;
       if (smallest == null) {
            smallest = new Cell(value);
            return;
        }

        while (true) {
            value = addToRow(cell, value);

            if (value == null) {
                return;
            }

            if (cell.below == null) {
                cell.below = new Cell(value);
                cell.below.above = cell;
                return;
            }

            cell = cell.below;
        }
    }
   protected Integer addToRow(Cell curr, int value) {
        Cell lastcell=null; //Cell lastcell = null
        for(Cell cell=curr; cell!=null; cell=cell.right){ // weird, remember
            if(cell.value>value){
                int temp=cell.value;
                cell.value=value;
                return temp; // return temp
            }
            lastcell=cell; // lastcell = cell;
        }
        Cell newcell = new Cell(value);
        lastcell.right=newcell;
        newcell.left=lastcell;

        if (lastcell.above != null && lastcell.above.right != null) { // if
            newcell.above=lastcell.above.right;
            lastcell.above.right.below=newcell;
        }  
        return null;

    }

    protected void print(Function<Cell,Integer> f) {
        for (Cell i = smallest; i != null; i = i.below) {
            for (Cell j = i; j != null; j = j.right) {
                System.out.printf("[%2d]", f.apply(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Tableau t = new Tableau();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                t.addValue(input.nextInt());
            } else {
                String command = input.next();
                if ("p".equals(command)) {
                    t.print(cell -> cell.value);
                } else if ("c".equals(command)) {
                    t.print(cell -> cell.neighbours());
                }
            }
        }
    }

    protected static class Cell {
      int value;
      Cell above;
      Cell below;
      Cell left;
      Cell right;

        Cell(int value) {
            this.value = value;
        }

        int neighbours() {
            int count = left != null ? 1 : 0;
            count += right != null ? 1 : 0;
            count += above != null ? 1 : 0;
            count += below != null ? 1 : 0;
            return count;
        }
    }
    

}