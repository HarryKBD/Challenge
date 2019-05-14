import java.util.Stack;

public class Solution32_LongestP {
    public int longestValidParentheses(String s) {
        int len = s.length();
        Stack<Integer> stack = new Stack<>();
        int idx, vs, ve;
        char c;
        int longest = 0;
        int candidate = 0;
        int tmp;
        vs = 1111111;
        ve = -1;
        idx = 0;

        while (idx < len) {
            c = s.charAt(idx);
            if ('(' == c) {
                stack.push(idx);
            } else {
                //check error
                try {
                    tmp = stack.pop();
                    if (vs > tmp) {
                        vs = tmp;
                    }
                    ve = idx;
                } catch (Exception e) {
                    candidate = ve - vs + 1;
                    if (candidate > longest) longest = candidate;
                    vs = 1111111;
                }
            }
            idx++;
        }
        candidate = ve - vs + 1;
        return (candidate > longest) ? candidate : longest;
    }
}
