class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for(int right = 0; right < nums.length; right++){

            if(!deque.isEmpty() && deque.peekFirst() < right - k + 1){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.removeLast();
            }

            deque.addLast(right);

            if(right >= k - 1){
                result[index++] = nums[deque.peekFirst()];
            }

        }
        return result;
    }
}
