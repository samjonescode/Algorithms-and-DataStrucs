def numberOfHours(matrix):
    soonToBeZombies = []
    oneLastSurvivor = True
    numberOfHours = 0
    while oneLastSurvivor:
        oneLastSurvivor = False
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                print(matrix[row][col])
                if isHuman(row, col, matrix):
                    oneLastSurvivor = True
                    checkNeighbors(
                        row, col, matrix, soonToBeZombies)
        convertToZombies(soonToBeZombies, matrix)
        if not oneLastSurvivor:
            break
        numberOfHours += 1
    return numberOfHours


def convertToZombies(soonToBeZombies, matrix):
    for item in soonToBeZombies:
        row, col = item
        matrix[row][col] = 1


def checkNeighbors(row, col, matrix, soonToBeZombies):
    dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]]
    for direction in dirs:
        neighborRow = row + direction[0]
        neighborCol = col + direction[1]

        if neighborRow >= 0 and neighborCol >= 0 and neighborRow < len(matrix) and neighborCol < len(matrix[0]):
            if not isHuman(neighborRow, neighborCol, matrix):
                soonToBeZombies.append([row, col])
    return soonToBeZombies


def isHuman(row, col, matrix):
    return matrix[row][col] == 0


matrix = [[0, 1, 1, 0, 1],
          [0, 1, 0, 1, 0],
          [0, 0, 0, 0, 1],
          [0, 1, 0, 0, 0]]

print(numberOfHours(matrix))
