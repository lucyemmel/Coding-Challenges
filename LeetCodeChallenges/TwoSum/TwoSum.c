

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize){
    for(int i = 0; i < numsSize; i++) {
        for(int j = 0; j < numsSize; j++) {
            if (i != j && (nums[i] + nums[j]) == target) {
                int * solution = (int *)malloc(sizeof(int) * 2);
                solution[0] = i;
                solution[1] = j;
                *returnSize = 2;
                return solution;
            }
        }
    }
    assert(false && "No solution was found");
}