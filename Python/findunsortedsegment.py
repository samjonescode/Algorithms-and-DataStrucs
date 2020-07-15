def subsort(nums):
    start, end = -1, -1
    for i in range(len(nums)):
        if i + 1 >= len(nums):
            break
        if start == -1 and nums[i] > nums[i + 1]:
            start = i
        elif start != -1 and nums[start] >= nums[i]:
            end = i
    # if no end was set, either no start was found and everything is sorted
    # or no end was found, meaning all elements from start onwards are out of order

    # end = (len(nums) - 1) if end == -1 else end

    #
    for k in range(len(nums[: start - 1])):
        if nums[k] in nums[start:]:
            start = k
            break
    return [start, end]


print(subsort([1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]))
print(subsort([1, 2, 3, 5, 6, 7, 3]))
print(subsort([1, 2, 3, 5, 6]))


def findUnsortedSeq(nums):
    start = 0
    end = None
    for i in range(len(nums)):
        if end is None and i + 1 <= len(nums) - 1 and nums[i] > nums[i + 1]:
            end = i + 1
        if end is not None:
            start = end - 1
            print("end", end)
            while start >= 0 and nums[start] > nums[end]:
                print(nums[end])
                start -= 1
            break
    i = end
    temp = nums[end]
    while i <= len(nums) - 1:
        if nums[i] <= temp:
            end = i
        i += 1
    return [start, end]


def findUnsortedSegment(array):
    start = None
    end = None

    for i in range(len(array)):
        if i + 1 == len(array):
            break
        if start is None and array[i] > array[i + 1]:
            start = i + 1
            continue
        if start is not None:
            if array[i] <= array[start]:
                end = i
        if end is None:
            end = len(array) - 1
    print("start: ", array[start])
    for i in range(len(array)):
        if array[i] == array[start]:
            start = i
            break
    j = end
    k = start
    # if end != len(array) - 1:
    while j < len(array) and array[k] >= array[j]:
        if array[k] >= array[j]:
            j += 1
        elif array[k] == array[j]:
            k += 1
            j += 1
        # print(array[k], array[j])
        # k += 1
        # j += 1
        # start+=1
        # end+=1
        if end == len(array) - 1:
            end = len(array) - 1
            break
        # j+=1

        start = k - 1
        end = j - 1
    return [start, end]


# print(findUnsortedSeq([1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]))

