import java.util.Arrays;

public class TableauApp {

    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {6, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(TableauApp.rowLengthsDecrease(valid));
        System.out.println(TableauApp.rowValuesIncrease(valid));
        System.out.println(TableauApp.isSetOf1toN(valid));
        System.out.println(TableauApp.isTableau(valid));         
    }

    public static boolean isTableau(int[][] t){
        return (rowLengthsDecrease(t) &&
                rowValuesIncrease(t) &&
                columnValuesIncrease(t) &&
                isSetOf1toN(t));
    }

    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static boolean rowLengthsDecrease(int[][] t){
        for (int i = 0; i<t.length-1; i++){
            if (t[i].length < t[i+1].length){
                return false;
            }            
        }
        return true;
    }
    
    public static boolean rowValuesIncrease(int[][] t){
        for (int i = 0; i<t.length; i++){
            for (int j = 0; j<t[i].length-1; j++){
                if (t[i][j] > t[i][j+1]){
                    return false;                
                }
            }
        }
        return true;
    }
    
    public static boolean columnValuesIncrease(int[][] t){
        for (int i = 1; i<t.length; i++){
            for (int j=0; j<t[i].length; j++){
                if (t[i][j]< t[i-1][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSetOf1toN(int[][] t){
        int len = 0;
        for (int[] row:t){
            len+=row.length;
        }
        
        int[] flat = new int[len];
        int cur=0;
        for (int[] row:t){
            System.arraycopy(row,0,flat,cur,row.length);
            cur+=row.length;
        }
        
        Arrays.sort(flat);
        for (int j = 1;j<len;j++){
          if (flat[j]!=(flat[j-1]+1)){
            return false;
          }
        }
        return true;
    }
}