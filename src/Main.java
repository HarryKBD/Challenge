public class Main {

    public static void main(String[] args) {
        //Solution32_LongestP p = new Solution32_LongestP();
        //System.out.println(p.longestValidParentheses("()(()"));

        //SolutionTest1 p = new SolutionTest1();
        //Solution312_BurstBalloons p = new Solution312_BurstBalloons();
        //Solution_ParensN p = new Solution_ParensN();
        //p.test();
        //Solution52_TotalQueens p = new Solution52_TotalQueens();

        Solution54_SpiralMatrix p = new Solution54_SpiralMatrix();
        Solution160_IntersectionLinkedList p2 = new Solution160_IntersectionLinkedList();

        p2.getIntersectionNodeBest(null, null);
        int matrix[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        p.spiralOrder(matrix);
    }
}
