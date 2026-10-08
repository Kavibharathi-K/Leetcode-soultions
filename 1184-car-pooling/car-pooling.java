class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a, b) -> Integer.compare(a[1], b[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[2], b[2])
        );

        int currentPass = 0;
        int i = 0;
        while(i < trips.length)
        {
            int[] currentTrip = trips[i];
            while(!pq.isEmpty() && pq.peek()[2] <= currentTrip[1])
            {
                currentPass -= pq.poll()[0];
            }

            currentPass += currentTrip[0];
            if(currentPass > capacity) return false;
            pq.offer(currentTrip);
            i++;
        }
        return true;
    }
}