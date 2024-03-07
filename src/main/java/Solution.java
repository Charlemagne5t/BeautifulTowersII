import java.util.*;

public class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];
        Deque<Integer> ms = new ArrayDeque<>();
        long cur = 0L;
        for(int i = 1; i < n; i++){
            int peakVal = maxHeights.get(i);
            while(!ms.isEmpty() && maxHeights.get(ms.peek()) > peakVal){
                int j = ms.pop();

            }
            if(ms.isEmpty()){
                left[i] = (long) i * peakVal;
            }else left[i] = left[ms.peek()] + (long) (i - ms.peek()) * maxHeights.get(ms.peek());
            ms.push(i);
        }
        ms = new ArrayDeque<>();
        for(int i = n - 2; i >= 0; i--){
            int peakVal = maxHeights.get(i);
            while(!ms.isEmpty() && maxHeights.get(ms.peek()) > peakVal){
                ms.pop();
            }
            if(ms.isEmpty()){
                right[i] = (long) (n - 1 - i) * peakVal;
            }else right[i] = right[ms.peek()] + (long) (n - i - 1 - ms.peek()) * maxHeights.get(ms.peek());

            ms.push(i);
        }
        System.out.println(maxHeights);
        System.out.println("---------------");
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        long max = 0L;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, right[i] + left[i] + maxHeights.get(i));

        }
        return max;
    }
}
