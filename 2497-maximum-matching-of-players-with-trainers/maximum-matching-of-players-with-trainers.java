class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int count = 0;
        int p1 = 0;
        int p2 = 0;

        while(p1 < players.length && p2 < trainers.length)
        {
            if(players[p1] <= trainers[p2]) 
            {
                count++;
                p1++;
                p2++;
            }
            else p2++;
        }
        return count;
    }
}