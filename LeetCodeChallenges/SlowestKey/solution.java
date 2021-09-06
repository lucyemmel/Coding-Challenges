class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int maxDuration = releaseTimes[0];
        int solution = 0;
        
        for(int i = 1; i < releaseTimes.length; i++) {
            int duration = releaseTimes[i] - releaseTimes[i-1];
            if(duration > maxDuration) {
                maxDuration = duration;
                solution = i;
            }
            else if(duration == maxDuration && keysPressed.charAt(i) > keysPressed.charAt(solution)) {
                solution = i;
            }
        }
        return keysPressed.charAt(solution);
    }
}