class GraphNode:
    def __init__(self, data):
        self.data = data 
        self.children = []
    def __str__(self):
        return str(self.data)

    def addChild(self, newChild):
        self.children.append(newChild)
    def dfs(self, target):
        return self.dfsHelper(target, [])
    
    def dfsHelper(self, target, visited):
        for child in self.children: 
            if child not in visited:
                if child is target: 
                    return True 
                visited.append(child)
                self.dfsHelper(target, visited)
        return False 

    def bfs(self, target):
        queue = []
        visited = []
        queue.append(self) 
        visited.append(self) 
        while (len(queue) > 0):
            currentNode = queue.pop()
            if currentNode == target:
                return True 
            for child in currentNode.children:
                if child not in visited: 
                    visited.append(child)
                    queue.append(child)
        return False 
    def tracePathBfs(self, target):
        pathMap = {}
        queue = []
        queue.append(self)
        pathMap[self.data] = None 

        while queue: 
            currentNode = queue.pop() 
            if currentNode is target: 
                return self.getPathToTarget(target, pathMap)
            for child in currentNode.children:
                if child not in pathMap:
                    pathMap[child.data] = currentNode.data
                    queue.append(child) 
    def getPathToTarget(self,target, pathMap):
        path = []
        path.append(target.data)
        currentNode = pathMap[target.data]
        while currentNode is not None: 
            path.append(currentNode)
            currentNode = pathMap[currentNode]
        return path
sam = GraphNode("Sam")
jdog = GraphNode("JDog")
andy = GraphNode("andy")
gymGirl = GraphNode("gym girl")
otherGirl = GraphNode("other girl")

sam.addChild(gymGirl)
gymGirl.addChild(otherGirl)
jdog.addChild(andy)

assert sam.dfs(andy) is False 
assert sam.dfs(gymGirl) is True 

assert sam.bfs(andy) is False 
assert sam.bfs(gymGirl) is True 

print(sam.tracePathBfs(otherGirl))
# assert jdog
