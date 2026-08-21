class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            int distanceA = a[0] * a[0] + a[1] * a[1];
            int distanceB = b[0] * b[0] + b[1] * b[1];

            return Integer.compare(distanceB, distanceA);
        });

        for(int[] n: points){
            heap.offer(n);
            if(heap.size() > k){
                heap.poll();
            }
        }

        int[][] result = new int[k][2];
        for(int i=0; i<k; i++){
            result[i] = heap.poll();
        }
        return result;
    }
}
