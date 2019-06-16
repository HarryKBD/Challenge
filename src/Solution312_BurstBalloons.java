import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution312_BurstBalloons {
    public void test(){
        int[][] map1 = {
                {1, 0 , 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1}
        };

        /*
            //Scanner
            Scanner s = new Scanner(System.in);
            int r = s.nextInt();
            int c = s.nextInt();

            int[][] map = new int[r][c];

            for(int i=0; i < r; i++){
                for(int j=0; j < c; j++){
                    map[i][j] = s.nextInt();
                }
            }*/

            solve(map1, 4, 5);
        }

        final static int ISLAND = 1;
        final static int WATER = 0;
        final static int VISITED = -100;


        public void solve(int[][] map, int r, int c){
            int y, x;
            List<Integer> result = new ArrayList<>();
            int size;
            for(y=0; y < r; y++){
                for(x=0; x < c; x++){
                    if(map[y][x] == ISLAND){
                        size = getIslandSize(map, x, y, c, r);
                        result.add(size);
                    }
                }
            }

            Collections.sort(result);

            if(result.size() == 0){
                System.out.println("-");
            }
            else{
                for(Integer i: result){
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }

        class MyPoint{
            public int mX;
            public int mY;
            public MyPoint(int x, int y){
                mX = x;
                mY = y;
            }
        }
        private int getIslandSize(int[][] map, int ix, int iy, int sx, int sy){
            List<MyPoint> list = new ArrayList<>();
            int size = 0;
            int x, y;
            map[iy][ix] = VISITED;
            list.add(new MyPoint(ix, iy));
            while(list.size() > 0){
                size++;
                MyPoint p = list.get(0);
                list.remove(0);
                x = p.mX;
                y = p.mY;

                if(x-1 >=0){
                    if(map[y][x-1] == ISLAND){
                        map[y][x-1] = VISITED;
                        list.add(new MyPoint(x-1, y));
                    }
                    if(y-1 >= 0 && map[y-1][x-1] == ISLAND){
                        map[y-1][x-1] = VISITED;
                        list.add(new MyPoint(x-1, y-1));
                    }
                    if(y+1 < sy && map[y+1][x-1] == ISLAND){
                        map[y+1][x-1] = VISITED;
                        list.add(new MyPoint(x-1, y+1));
                    }
                }
                if(x+1 < sx){
                    if(map[y][x+1] == ISLAND){
                        map[y][x+1] = VISITED;
                        list.add(new MyPoint(x+1, y));
                    }
                    if(y-1 >= 0 && map[y-1][x+1] == ISLAND){
                        map[y-1][x+1] = VISITED;
                        list.add(new MyPoint(x+1, y-1));
                    }
                    if(y+1 < sy && map[y+1][x+1] == ISLAND){
                        map[y+1][x+1] = VISITED;
                        list.add(new MyPoint(x+1, y+1));
                    }
                }

                if(y-1 >= 0 && map[y-1][x] == ISLAND){
                    map[y-1][x] = VISITED;
                    list.add(new MyPoint(x, y-1));
                }
                if(y+1 < sy && map[y+1][x] == ISLAND){
                    map[y+1][x] = VISITED;
                    list.add(new MyPoint(x, y+1));
                }
            }
            return size;
        }
}
