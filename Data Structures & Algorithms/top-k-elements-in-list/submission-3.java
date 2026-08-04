class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        // count frequency
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        //put it into the bucket
        List<Integer>[] list = new List[nums.length + 1];

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int number = entry.getKey();
            int frequency = entry.getValue();

            if(list[frequency] == null){
                list[frequency] = new ArrayList<>();
            }
            list[frequency].add(number);
        }

        int[] result = new int[k];
        int resultIndex = 0;

        for(int frequency = list.length - 1; frequency >= 0; frequency--){ //backward? Because higher bucket indexes mean higher frequencies.
            if(list[frequency]== null){
                continue;
            }

            for(int number: list[frequency]){
                result[resultIndex] = number;
                resultIndex++;

                if(resultIndex == k){
                    return result;
                }
            }
        }
        return result;
    }
}
