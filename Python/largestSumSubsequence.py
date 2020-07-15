def largestSumSubsequence(nums):
    dp = [None for num in nums]
    dp[0] = nums[0]
    for i in range(1, len(nums)):
        dp[i] = max(nums[i], dp[i - 1] + nums[i])
    return max(dp)


numbers = [2, -8, 3, -2, 4, -10]
nums2 = [4, 8, 20, 25]
nums3 = [-9, -2, -3, -20, -1, 0]
print(largestSumSubsequence(numbers))
print(largestSumSubsequence(nums2))
print(largestSumSubsequence(nums3))


def largestSumSubsequence2(nums):
    dp = [None for num in nums]
    dp[0] = nums[0]
    for i in range(1, len(nums)):
        dp[i] = max(nums[i], nums[i] + dp[i - 1])
    return max(dp)
