class Solution:
    def twoSumFast(self, nums, target):
        numberCache = defaultdict(set)
        for i, val in enumerate(nums):
            numberCache[val].add(i)
        
        for j, val in enumerate(nums):
            if (indexSet := numberCache.get(target - val)) is not None:
                for entry in indexSet:
                    if entry != j:
                        return j, entry
    
    def twoSumSlow(self, nums, target):
        for i, val1 in enumerate(nums):
            for j, val2 in enumerate(nums):
                if i != j and (val1 + val2) == target:
                    return [i, j]
    
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return self.twoSumFast(nums, target)