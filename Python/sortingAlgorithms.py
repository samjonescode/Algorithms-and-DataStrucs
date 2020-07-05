def quickSort():
    pass 
def mergeSort():
    pass 
def insertionSort():
    pass 
def selectionSort(array): 

    indexOfSmallest = 0
    for i in range(len(array)):
        j = i + 1
        currentMinValue = array[i]
        for j in range(len(array)):
            if array[j] < currentMinValue:
                indexOfSmallest = j 
                currentMinValue = array[indexOfSmallest]
        swap(array, i, indexOfSmallest) 
    return array
def swap(array,i,j):
    array[i], array[j] = array[j], array[i]

print(selectionSort([3,4,1,5,2,4,2]))