// you can also use imports, for example:

import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        HashMap<Integer, Set<Integer>> sums = new HashMap<>();
        HashMap<Integer, Integer> zeros = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int diff = A[j] - A[i];
                if (diff == 0) {
                    if (zeros.containsKey(A[i])) continue;
                    int count = 1;
                    while (j < A.length && A[i] == A[j]) {
                        count++;
                        j++;
                    }
                    zeros.put(A[i], count);
                    continue;
                }
                if (!sums.containsKey(diff)) {
                    sums.put(diff, new HashSet<>());
                    sums.get(diff).add(A[i]);
                }
                sums.get(diff).add(A[j]);
            }
        }

        int max = 0;
        for (Set<Integer> set : sums.values()) {
            max = Math.max(max, set.size());
        }
        for (int counter : zeros.values()) {
            max = Math.max(max, counter);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{1,2,4,4,4,4,5}));
        System.out.println(solution.solution(new int[]{1,3,7,4,9,4,5}));
    }
}
