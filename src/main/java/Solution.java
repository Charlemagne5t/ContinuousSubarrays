import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public long continuousSubarrays(int[] nums) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        long res = 0L;
        int start = 0;
        int end = 0;
        for(; end < nums.length; end++) {
            if(max.isEmpty()){
                max.addFirst(end);
            }else{
                while(!max.isEmpty() && nums[end] >= nums[max.peekLast()] ){
                    max.removeLast();
                }
                max.addLast(end);
            }

            if(min.isEmpty()){
                min.addFirst(end);
            }else {
                while(!min.isEmpty() && nums[end] <= nums[min.peekLast()]) {
                    min.removeLast();
                }
                min.addLast(end);
            }

            while(nums[max.peekFirst()] - nums[min.peekFirst()] > 2) {
                start++;
                if(max.peekFirst() < start) {
                    max.removeFirst();
                }
                if(min.peekFirst() < start) {
                    min.removeFirst();
                }
            }
            res += end - start + 1;
        }


        return res;
    }
}