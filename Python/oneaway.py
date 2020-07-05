# Space is O (A + B) time is O (A + B) where A and B are lengths of the strings
def oneAway(strA, strB):
    strADict = makeDict(strA)  # O (len strA ) space& time
    strBDict = makeDict(
        strB
    )  # O (len strB ) space & time ... O Str A + StrB time so far
    diffCounter = 0
    longerDict = strADict if len(strADict) > len(strBDict) else strBDict  # O strA space
    shorterDict = strBDict if strADict is longerDict else strADict  # O strB space
    # O of longer string time
    for keyA in longerDict:
        if diffCounter > 1:
            return False
        if keyA in shorterDict:
            if longerDict[keyA] != shorterDict[keyA]:
                diffCounter += 1
            else:
                continue
        else:
            diffCounter += 1
    return True


def makeDict(string):
    newDict = {}
    for letter in string:
        if letter in newDict:
            newDict[letter] += 1
        else:
            newDict[letter] = 1
    return newDict


print(oneAway("sam", "ma"))
print(oneAway("sam", "masa sushi"))
print(oneAway("pale", "elp"))
print(oneAway("pale", "bale"))
print(oneAway("pale", "bake"))

