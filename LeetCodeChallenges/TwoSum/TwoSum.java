class Solution {
    private int[] twoSumSlow(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = 1; j < nums.length; j++) {
                if(i != j && (nums[i] + nums[j]) == target) {
                    int [] solution = {i, j};
                    return solution;
                }
            }
        }
        throw new IllegalStateException("No solution found");
    }
    
    private int[] twoSumFast(int [] nums, int target) {
        Map<Integer, Set<Integer>> numCache = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int elem = nums[i];
            if(!numCache.containsKey(elem)) {
                numCache.put(elem, new HashSet<Integer>(Arrays.asList(i)));
            }
            else {
                numCache.get(elem).add(i);
            }
        }
        
        for(int j = 0; j < nums.length; j++) {
            int required = target - nums[j];
            if(numCache.containsKey(required)) {
                for(int index: numCache.get(required)) {
                    if(index != j) {
                        int [] sol = {j, index};
                        return sol;
                    }
                }
            }
        }
        throw new IllegalStateException("No solution found");
    }
    
    public int[] twoSum(int[] nums, int target) {
        return twoSumFast(nums, target);
    }
}