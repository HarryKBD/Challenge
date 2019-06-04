import java.util.ArrayList;
import java.util.List;

public class Solution54_SpiralMatrix {
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;
    private static final int UP = 4;
    private static final int VISITED = 0xFFFF;
    private static final int dir[] = {RIGHT, DOWN, LEFT, UP};

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> r = new ArrayList<>();

        int idx = 0;
        int size = dir.length;
        int total = matrix[0].length;
        int cnt = 0;
        int cy = 0;
        int cx = 0;
        int sizeX = matrix[0].length;
        int sizeY = total / sizeX;
        int direction;

        r.add(matrix[cy][cx]);

        while(true) {
            if (r.size() == total) {
                break;
            }
            direction = dir[idx % 4];

            switch (direction) {
                case RIGHT:
                    if (cx + 1 >= sizeX || matrix[cy][cx + 1] == VISITED) {
                        idx++;
                    } else {
                        cx++;
                        r.add(matrix[cy][cx]);
                        matrix[cy][cx] = VISITED;
                    }
                    break;
                case DOWN:
                    if (cy + 1 >= sizeY || matrix[cy + 1][cx] == VISITED) {
                        idx++;
                    } else {
                        cy++;
                        r.add(matrix[cy][cx]);
                        matrix[cy][cx] = VISITED;
                    }
                    break;
                case LEFT:
                    if (cx - 1 >= 0 || matrix[cy][cx - 1] == VISITED) {
                        idx++;
                    } else {
                        cx--;
                        r.add(matrix[cy][cx]);
                        matrix[cy][cx] = VISITED;
                    }
                    break;
                case UP:
                    if (cy - 1 >= 0 || matrix[cy - 1][cx] == VISITED) {
                        idx++;
                    } else {
                        cy--;
                        r.add(matrix[cy][cx]);
                        matrix[cy][cx] = VISITED;
                    }
                    break;
            }
        }

        for(Integer i: r){
            System.out.println(i + " ");
        }
        return r;
    }

}
