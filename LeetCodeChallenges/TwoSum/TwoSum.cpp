class Solution {
    
public:
    vector<int> twoSumSlow(vector<int>& nums, int target) {
        for(int i = 0; i < nums.size(); i++) {
            for(int j = 1; j < nums.size(); j++) {
                if(i != j && (nums[i] + nums[j]) == target)  {
                    return vector{i, j};
                }
            }
        }
        // Indicates that no solution was found
        assert(false && "No solution was found");
    }
    
    vector<int> twoSumFast(vector<int>& nums, int target) {
        unordered_map<int, unordered_set<int>> numCache;
        for(int i = 0; i < nums.size(); i++) {
            // automatically calls set default constructor if nums[i] is not in numCache
            auto & indexSet = numCache[nums[i]];
            indexSet.insert(i);
        }
        
        for(int j = 0; j < nums.size(); j++) {
            int required = target - nums[j];
            if(numCache.find(required) != numCache.end()) {
                auto & indexSet = numCache[required];
                for(int index: indexSet) {
                    if(index != j) {
                        return vector{j, index};
                    }
                }
            }
        }
        
        // Indicates that no solution was found
        assert(false && "No solution was found");
    }
    
    vector<int> twoSum(vector<int>& nums, int target) {
        return twoSumFast(nums, target);
    }
};