package leetcode.dfs.problem17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    ArrayList<Character>[] nums = new ArrayList[9];
    List<String> ans = new ArrayList<String>();
    StringBuffer cur = new StringBuffer();
    char[] digits;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new ArrayList<>();
        }
        this.digits = digits.toCharArray();
        nums[1].add('a');
        nums[1].add('b');
        nums[1].add('c');
        nums[2].add('d');
        nums[2].add('e');
        nums[2].add('f');
        nums[3].add('g');
        nums[3].add('h');
        nums[3].add('i');
        nums[4].add('j');
        nums[4].add('k');
        nums[4].add('l');
        nums[5].add('m');
        nums[5].add('n');
        nums[5].add('o');
        nums[6].add('p');
        nums[6].add('q');
        nums[6].add('r');
        nums[6].add('s');
        nums[7].add('t');
        nums[7].add('u');
        nums[7].add('v');
        nums[8].add('w');
        nums[8].add('x');
        nums[8].add('y');
        nums[8].add('z');
        backtracking(0);
        return ans;
    }

    public void backtracking(int curIndex) {
        if (curIndex == digits.length) {
            ans.add(cur.toString());
            return;
        }
        for (char num : nums[digits[curIndex] - '1']) {
            System.out.println(num);
            cur.append(num);
            backtracking(curIndex + 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}