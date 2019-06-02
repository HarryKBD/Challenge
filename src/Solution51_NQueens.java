import java.util.ArrayList;
import java.util.List;

public class Solution51_NQueens {
    public List<List<String>> solveNQueens(int n) {

        char[][] map = new char[n][n];

        for(int i=0; i < n; i++){
            for(int j=0; j < 0 ; j++){
                map[i][j] = 0;
            }
        }

        for(int i=0; i < n; i++){
            map[0][i] = 'Q';
            solveQueen(map, 1, n);
            map[0][i] = 0;
        }
        return null;
    }

    int solveQueen(char[][] map, int start, int n){

        if(start == n){
            //good
            printMap(map, n);
            return 1;
        }
        for(int i=0; i < n; i++){
            if (isValid(map, start, i)) {
                map[start][i] = 'Q';
                solveQueen(map, start + 1, n);
                map[start][i] = 0;
            }
        }

        return 0;
    }

    boolean isValid(char[][] map, int level, int pos){
        int i;
        int d = 0;

        for(i=level-1; i >= 0; i--){
            if(map[i][pos] == 'Q'){
                return false;
            }
            d++;
            if(d > 0){
                if((pos -d) >= 0) {
                    if(map[i][pos-d] == 'Q') return false;
                }
                if((pos +d) < 4) {
                    if (map[i][pos + d] == 'Q') return false;
                }

            }
        }
        return true;
    }

    void printMap(char[][] map, int n){
        for(int i=0; i < n; i++){
            for(int j=0; j < n ; j++){
                System.out.print(map[i][j] + ", " );
            }
            System.out.println();
        }
        System.out.println();
    }

   private List<List<String>> convertMap(char [][] map, int n){

       List<ArrayList<String>> m  = new ArrayList<ArrayList<String>>();

       List<String> line;

       line = new ArrayList<>();
       line.add("[");
       m.add(line);


       for
       line = new ArrayList<>();



       line = new List<String>();
       line.add("]");
       m.add(line);

    }
}

