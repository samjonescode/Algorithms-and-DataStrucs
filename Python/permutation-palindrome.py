def isPalindrome(word):
    #make a hastable 
    hashtable = {}
    for c in word: 
        if c in hashtable:
            hashtable[c] += 1
        else:
            hashtable[c] = 1
    # seen = []
    counterOfCounts = 0
    for key in hashtable: 
        if hashtable[key] == 1:
            counterOfCounts += 1
    return counterOfCounts <= 1

print(isPalindrome("civic"))
print(isPalindrome("ccivi"))
print(isPalindrome("civil"))
print(isPalindrome("livci"))
