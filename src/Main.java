public class Main {

    public static void main(String[] args) {
        //Solution32_LongestP p = new Solution32_LongestP();
        //System.out.println(p.longestValidParentheses("()(()"));

        //SolutionTest1 p = new SolutionTest1();
        //Solution52_TotalQueens p = new Solution52_TotalQueens();

        Solution54_SpiralMatrix p = new Solution54_SpiralMatrix();

        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        p.spiralOrder(matrix);
    }
}
