def makeWordCloud(phrase):
    splitPhrase = phrase.split(" ") # O (N) space
    splitPhrase = [word.lower() for word in splitPhrase] # O (N) time and overwrites O(N) space 
    # splitPhrase = [cleanPunctuation(word) for word in splitPhrase]
    cleandPhrase = cleanPunctuation(splitPhrase) # Runtime of O(N)
    # for word in splitPhrase:
        # word =
    return createCloud(cleandPhrase)

def createCloud(cleanedPhrase):
    cloud = {}
    for word in cleanedPhrase: 
        if word in cloud:
            cloud[word] += 1
        else:
            cloud[word] = 1
    return cloud

def cleanPunctuation(wordsList):
    punctuation = ",'./\!@#$%^&*(){}[]|" # O(1) constant space
    newWords = [] # O (N) space list with punctuation removed
    for word in wordsList: # O (N * wordLength) time, going through each letter of each word will take 
        # as long as the longest word * the number of words, if all words are same length.
        newWord = ""
        for c in word: 
            if c in punctuation:
                continue
            newWord += c
        newWords.append(newWord)
    return newWords

print(makeWordCloud("The bill came to five dollars."))