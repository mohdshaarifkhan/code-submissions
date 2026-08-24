class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int s: stones){
            heap.offer(s);
        }

        while(heap.size() > 1){
            int heaviest = heap.poll();
            int secondHeaviest = heap.poll();

            if(heaviest != secondHeaviest){
                heap.offer(heaviest - secondHeaviest);
            }
        }

        return heap.isEmpty() ? 0 : heap.peek();
    }
}
