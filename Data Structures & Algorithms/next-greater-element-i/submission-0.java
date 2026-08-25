class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                int smallerNumber = stack.pop();
                map.put(smallerNumber, nums2[i]);
            }
            stack.push(nums2[i]);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
        
    }
}