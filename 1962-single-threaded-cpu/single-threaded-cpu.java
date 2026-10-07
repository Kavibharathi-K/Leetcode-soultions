class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] arr = new int[n][3];
        for(int i = 0; i < tasks.length; i++)
        {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<int[]> availableTasks = new PriorityQueue<>(
            (a, b) -> {
                if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            }
        );

        int[] result = new int[n];
        int resultIndex = 0;
        int currentTime = 0;
        int i = 0;
        while(resultIndex < n)
        {
            if(availableTasks.isEmpty() && currentTime < arr[i][0]){
                currentTime = arr[i][0];
            }

            while(i < n && arr[i][0] <= currentTime)
            {
                availableTasks.offer(arr[i]);
                i++;
            }

            int[] task = availableTasks.poll();
            result[resultIndex++] = task[2];
            currentTime += task[1];
        }
        return result;
    }
}