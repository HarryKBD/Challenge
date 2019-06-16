public class Solution_ParensN {

    public void test(){
        int n = 4;
        char[] arr = new char[n*2];

        int left = n;
        int right = n;
        int idx = 0;
        solveProblem(arr, left, right, idx, n);
    }

    void printArray(char[] arr){
        for(int i=0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public void solveProblem(char[] arr, int left, int right, int idx, int n){
        if(left == 0){
            if(right > 0){
                for(int i=idx; i < n; i++){
                    arr[i] = ')';
                }
            }
            printArray(arr);
            return;
        }

        arr[idx] = '(';
        arr[idx+1] = ')';
        solveProblem(arr, left - 1, right - 1, idx + 2, n);
        if(left - 1 > 0) {
            solveProblem(arr, left - 1, right, idx + 1, n);
        }

        if(left < right){
            arr[idx] = ')';
            solveProblem(arr, left , right - 1, idx + 1, n);
        }
    }
}
