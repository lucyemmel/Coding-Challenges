/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
function twoSumSlow(nums, target) {
     for(let i = 0; i < nums.length; i++) {
        for(let j = 1; j < nums.length; j++) {
            if(i !== j && (nums[i] + nums[j]) == target) {
                return [i,j];
            }
        }
    }
    throw new Error("No solution found");
}

function twoSumFast(nums, target) {
    const numCache = new Map();
    
    for(let i = 0; i < nums.length; i++) {
        const elem = nums[i];
        if(!numCache.has(elem)) {
            numCache.set(elem, new Set([i]));
        }
        else {
            numCache.get(elem).add(i);
        }
    }
    
    for(let j = 0; j < nums.length; j++) {
        const required = target - nums[j];
        if(numCache.has(required)) {
            for(let index of numCache.get(required)) {
                if(j !== index) {
                    return [j, index];
                }
            }
        }
    }
    throw new Error("No solution found");
}

var twoSum = function(nums, target) {
   return twoSumFast(nums, target);
};