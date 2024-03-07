import java.util.*;

public class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
        long[] left = new long[n];
        long[] right = new long[n];
        Deque<Integer> ms = new ArrayDeque<>();
        ms.push(0);

        for(int i = 1; i < n; i++){
            int j = -1;
            int peakVal = maxHeights.get(i);
            while(!ms.isEmpty() && maxHeights.get(ms.peek()) > peakVal){
                j = ms.pop();
            }
            if(ms.isEmpty()){
                left[i] = (long) i * peakVal;
            }else if(j == -1){
                left[i] = left[i - 1] + maxHeights.get(i - 1);
            }else{
                left[i] = left[ms.peek() + 1] + (long) (i - ms.peek() - 1) * peakVal;;
            }

            ms.push(i);
        }
        ms = new ArrayDeque<>();

        List<Integer> rev = reverse(maxHeights);

        ms.push(0);
        for(int i = 1; i < n; i++){
            int j = -1;
            int peakVal = rev.get(i);
            while(!ms.isEmpty() && rev.get(ms.peek()) > peakVal){
                j = ms.pop();
            }
            if(ms.isEmpty()){
                right[i] = (long)i * peakVal;
            }else if(j == -1){
                right[i] = right[i - 1] + rev.get(i - 1);
            }else{
                right[i] = right[ms.peek() + 1] + (long) (i - ms.peek() - 1) * peakVal;
            }

            ms.push(i);
        }
        reverseArr(right);
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

    List<Integer> reverse(List<Integer> arr){
        List<Integer> rev = new ArrayList<>();
        for (int i = arr.size() - 1; i >= 0; i--) {
            rev.add(arr.get(i));
        }
        return rev;
    }
    void reverseArr(long[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            long temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }
}
