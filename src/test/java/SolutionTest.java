import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void test1() {
        int[] nums= {5,4,2,4};
        long expected = 8;
        long actual = new Solution().continuousSubarrays(nums);

        Assert.assertEquals(expected, actual);
    }
}
