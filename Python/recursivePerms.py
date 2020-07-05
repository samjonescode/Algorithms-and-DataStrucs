
def caller(string):
    listOfPerms = []
    recursivePerms(string, 0, 0, listOfPerms)
    return set(listOfPerms)

def recursivePerms(string,i, j, listOfPerms):
    charAti = string[i]
    # newStr += string[i]
    # if j >= len(string) -1:
    charAtj = string[j]
    
    newStr = ""
    for index in range(len(string)):
        if index == i:
            newStr += charAtj 
        elif index == j:
            newStr += charAti 
        else:
            newStr += string[index] 
    listOfPerms.append(newStr)   
    # print("List of perms: ", listOfPerms)
    for i in range(len(string)):
        # for j in range(len(string)):
        if not j + 1 > len(string) -1:
            recursivePerms(string, i, j + 1, listOfPerms)
        # else:
        #     print(charAtj)
    # return listOfPerms

# recursivePerms("Sam", 0, 0) # given
# recursivePerms("Sam", 0, 1)
# recursivePerms("Sam", 0, 2)

# recursivePerms("Sam", 1, 0)
# recursivePerms("Sam", 1, 1) # given 
# recursivePerms("Sam", 1, 2)

# recursivePerms("Sam", 2, 0)
# recursivePerms("Sam", 2, 1)
# recursivePerms("Sam", 2, 2) # given 

print(caller("cats"))