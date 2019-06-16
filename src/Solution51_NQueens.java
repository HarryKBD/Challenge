import java.util.ArrayList;
import java.util.List;

public class Solution51_NQueens {
    private List<List<String>> result  = new ArrayList<>();
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

        /*
        for(List<String> l: result){
            for(String s: l){
                System.out.println(s);
            }
            System.out.println("-------------------------------");
        }
        */
        return result;
    }

    int solveQueen(char[][] map, int start, int n){

        if(start == n){
            //good
            //printMap(map, n);
            addMap(map, n);
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
        int max = map[0].length;

        for(i=level-1; i >= 0; i--){
            if(map[i][pos] == 'Q'){
                return false;
            }
            d++;
            if(d > 0){
                if((pos -d) >= 0) {
                    if(map[i][pos-d] == 'Q') return false;
                }
                if((pos +d) < max) {
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

   private void addMap(char [][] map, int n){
       List<String> line = new ArrayList<>();
       StringBuffer tmp;

       for(int i=0; i < n; i++){
           tmp = new StringBuffer();
           for(int j=0; j < n;  j++){
               if(map[i][j] == 0){
                   tmp.append(".");
               }
               else {
                   tmp.append(map[i][j]);
               }
           }
           line.add((tmp.toString()));
       }
       result.add(line);
    }
}

