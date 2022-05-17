package leetcode.stackandqueue.problem946;

public class Solution2 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = popped.length;
        int left = -1;
        int right = 0;

        for(int i : popped){
            if(left >= 0 && i == pushed[left]){
                left--;
                continue;
            }
            if(right < n && i == pushed[right]){
                right++;
                continue;
            }

            while(right < n && i != pushed[right]){
                pushed[++left] = pushed[right++];
            }
            if(right == n){
                return false;
            }
            right++;
        }
        return true;
    }
}