class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0;

        for(int j = 0; j < trainers.length; j++)
        {
            if( i == players.length) break;

            if(trainers[j] >= players[i]) i++;
        }
        return i;
    }
}