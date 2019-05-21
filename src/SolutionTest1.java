
public class SolutionTest1 {
    private static final int DIGIT_DEPTH = 30;
    private static int tryCnt = 0;
    private static int matchCnt = 0;
    private boolean isPruning = true;

    public void solveThis(){
        int[] arr = new int[DIGIT_DEPTH];
        createSeqence(0, arr, 0, 0, DIGIT_DEPTH/2);
        System.out.println("Tried: " + tryCnt + ", Matched: " + matchCnt + " Useful: " + ((double)matchCnt/tryCnt)*100.0);
    }

    private void createSeqence(int idx, int[] list, int zeros, int ones, int half){
        if(idx == DIGIT_DEPTH){
            //if(isGoodResult(list)) {
            tryCnt++;
            if(zeros == ones) {
                matchCnt++;
                //printArray(list);
            }
            return;
        }

        if(isPruning){
            if(zeros < half){
                list[idx] = 0;
                createSeqence(idx + 1, list, zeros + 1, ones, half);
            }
            if(ones < half) {
                list[idx] = 1;
                createSeqence(idx + 1, list, zeros, ones + 1, half);
            }
        }
        else{
            list[idx] = 0;
            createSeqence(idx + 1, list, zeros + 1, ones, half);
            list[idx] = 1;
            createSeqence(idx + 1, list, zeros, ones + 1, half);
        }
        return;
    }

    private boolean isGoodResult(int[] list){
        int zeros = 0;
        int ones = 0;
        for(int i=0; i < list.length; i++){
            if(list[i] == 0) zeros++;
            else ones++;
        }

        return (ones == zeros);
    }

    private void printArray(int[] list){
        for(int i=0; i < list.length; i++){
            System.out.print(list[i]);
        }
        System.out.println();
    }
}
