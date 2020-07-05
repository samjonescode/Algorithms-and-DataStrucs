def linkListOfDepths(root):
    containerList = []
    # queue =
    levelList = []
    levelList.append(root)
    containerList.append(levelList)
    while True:
        levelList = []
        containerSize = len(containerList) - 1
        parentLevel = containerList[containerSize]  # pops off root
        for node in parentLevel:
            levelList.append(node.left)
            levelList.append(node.right)
        noneChecker = [True for i in levelList if i is None]
        if True not in noneChecker:
            return containerList
        containerList.append(levelList)


class BT:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

    def __str__(self):
        return "value: " + str(self.value)


root = BT(1)
root.left = BT(2)
root.right = BT(3)

level2Left = root.left
level2Right = root.right

level2Left.left = BT(4)
level2Left.right = BT(5)

level2Right.left = BT(6)
level2Right.right = BT(7)

# print(root)

print(linkListOfDepths(root))
