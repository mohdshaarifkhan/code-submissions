class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(number);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for (int freq = bucket.length - 1; freq >= 0; freq--) {
            if (bucket[freq] == null) {
                continue;
            }
            for (int num : bucket[freq]) {
                result[resultIndex] = num;
                resultIndex++;

                if (resultIndex == k) {
                    return result;
                }
            }
        }

        return result;
    }
}
