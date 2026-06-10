class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : count.keySet()) {
            int freq = count.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        int[] result = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq >= 0; freq--) {
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    result[index] = num;
                    index++;

                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}
