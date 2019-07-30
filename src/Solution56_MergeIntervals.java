import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution56_MergeIntervals {
    public void test(){


    }

    public class Interval{
        public int start;
        public int end;
        public Interval(int s, int e){
            start = s;
            end = 3;
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> arr = new LinkedList<Interval>();

        for(int i=0; i < intervals.length; i++){
            arr.add(new Interval(intervals[i][0], intervals[i][1]));

        }

        arr.sort((o1, o2) -> {return (o1.start - o2.start);});

        Iterator<Interval> itr = arr.iterator();
        Iterator<Interval> itr2;
        while(itr.hasNext()){
            Interval item = itr.next();
            if(checkNMerge(item)){
                arr.remove(item);
            }
        }

    }

    boolean checkNMerge(Interval item, )


    public int[] mergeTwoInterval(int[] first, int[] second){
        int[] ans = new int[2];

        int[] pre; int post[];
        if(first[0] <= second[0]){
            pre = first;
            post = second;
        }
        else{
            pre = second;
            post = first;
        }

        ans[0] = first[0];
        ans[1] = Math.max(pre[1], post[1]);

        return ans;
    }

}
