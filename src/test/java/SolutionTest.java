import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1(){
        List<Integer> maxHeights = new ArrayList<>(List.of(5,3,4,1,1));
        long expected = 13;
        long actual = new Solution().maximumSumOfHeights(maxHeights);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test2(){
        List<Integer> maxHeights = new ArrayList<>(List.of(6,5,3,9,2,7));
        long expected = 22;
        long actual = new Solution().maximumSumOfHeights(maxHeights);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test3(){
        List<Integer> maxHeights = new ArrayList<>(List.of(3,2,5,5,2,3));
        long expected = 18;
        long actual = new Solution().maximumSumOfHeights(maxHeights);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test4(){
        List<Integer> maxHeights = new ArrayList<>(List.of(1,1000000000));
        long expected = 1000000001;
        long actual = new Solution().maximumSumOfHeights(maxHeights);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test5(){
        List<Integer> maxHeights = new ArrayList<>(List.of(6,5,3,4,6,1,2,3,2,5));
        long expected = 25;
        long actual = new Solution().maximumSumOfHeights(maxHeights);

        Assert.assertEquals(expected, actual);
    }
}
