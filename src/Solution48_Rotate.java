public class Solution48_Rotate {

    private int[][] matrix;
    int[] data  = { 5, 1, 9,11, 2, 4, 8,10, 13, 3, 6, 7, 15,14,12,16};

    public Solution48_Rotate(int size) {
        matrix = new int[size][size];

        int idx = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //matrix[i][j] = idx++;
                matrix[i][j] = data[idx++];
            }
        }
    }

    public void process() {
        rotate(matrix);
    }


    public void rotate(int[][] matrix) {
        int size = matrix[0].length;
        printMatrix(matrix);

        int idx = 0;
        while(size > 1){
            rotateMatrix(idx, size, matrix);
            idx++;
            size = size - 2;
        }
        printMatrix(matrix);
    }

    void printMatrix(int[][] matrix) {
        int size = matrix[0].length;
        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < size; i++) {
            if (buf.length() > 0) buf.delete(0, buf.length());
            buf.append("{ ");
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] < 10) {
                    buf.append(" ");
                }
                buf.append(matrix[i][j]);
                if (j + 1 < size) buf.append(" ,");
            }
            buf.append(" },");
            System.out.println(buf.toString());
        }
        System.out.println("");
    }

    void rotateMatrix(int idx, int size, int[][] m) {

        int s = idx;
        int e = idx + size - 1;
        int i;
        int back[] = new int[size];


        if(size == 1) return;

        int t1, t2, t3, t4;
        //process 4 vertex
        t1 = m[s][s];
        t2 = m[s][e];
        t3 = m[e][e];
        t4 = m[e][s];

       if(size > 2) {
           //backup
           for (i = 0; i < size; i++) {
               back[i] = m[s + i][e];
               m[s + i][e] = m[s][s + i];
           }

           for (i = 0; i < size; i++) {
               int v = back[i];
               back[i] = m[e][e - i];
               m[e][e - i] = v;
           }

           for (i = 0; i < size; i++) {
               int v = back[i];
               back[i] = m[e - i][s];
               m[e - i][s] = v;
           }
           for (i = 0; i < size; i++) {
               m[s][s + i] = back[i];
           }
       }
        m[s][e] = t1;
        m[e][e] = t2;
        m[e][s] = t3;
        m[s][s] = t4;
    }
}
