#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue May 10 13:50:58 2022
@author: rohansingh
"""



#%%
class Graph:
    
    #initializing the graph
    def __init__(self):
        self.Matrix = []        #List of vertices will be represented by "Matrix"
        self.tempPQ = []
        self.finalized = []
    
    #function to add a vertex to the graph
    def addVertex(self, name):
        #Checking to see if the graph already has a vertex with the same name
        if (self.getIndex(name) != -1):
            return
        #Appending a new vertex to the list of Vertices
        self.Matrix.append(Vertex(name))
        
    """   
    Printing the contents of the graph in the following format:
    sourceVertex -> destinationvertex1 destinationVertex2 destinationVertex3
    """
    def printGraph(self):
        for i in range (0, len(self.Matrix)):        #Going to each node of the graph
            str = ""
            str += self.Matrix[i].name + " -> "
            for j in range (0, len(self.Matrix[i].myList)):      #Going through the list of neighbors
                toIndex = self.Matrix[i].myList[j].index
                str += self.Matrix[toIndex].name + " "
            print(str + "\n")
            
    def addEdge(self, fromVertex, toVertex, cost):
        #Finding the indices of the vertices provided
        fromIndex = self.getIndex(fromVertex)
        toIndex = self.getIndex(toVertex)
        #Leaving if the vertex doesn't exist
        if((fromIndex==-1)or(toIndex==-1)):
            return
        self.Matrix[fromIndex].addEdge(toIndex,cost)
        
        
    def dijkstrasAlgo(self,fromVertex):
        dj = []
        self.finalized = []
        self.tempQ = []
        numFinalized = 0
        startIndex = self.getIndex(fromVertex)
        
        #initialization
        for i in range (0, len(self.Matrix)):
            self.finalized.append(False)
            dj.append(9223372036854775807)
            self.Matrix[i].parents.append(startIndex)
            
        
        self.tempPQ.append(Edge(startIndex,0))
        dj[startIndex] = 0
        
        while ((len(self.tempPQ) > 0) and (numFinalized < len(self.Matrix))):
            e = self.findSmallest(self.tempPQ)
            currIndex = e.index
            if(self.finalized[currIndex] == True):
                continue
            self.finalized[currIndex] = True
            numFinalized += 1
            for i in range (0, len(self.Matrix[currIndex].myList)):
                tempIndex = self.Matrix[currIndex].myList[i].index
                if(self.finalized[tempIndex] == False):
                    tempCost = dj[currIndex] + self.Matrix[currIndex].myList[i].cost
                    if(tempCost < dj[tempIndex]):
                        dj[tempIndex] = tempCost
                        self.Matrix[tempIndex].parents.append(currIndex)
                        self.tempPQ.append(Edge(tempIndex,tempCost))
            
        
        print("From the Vertex " + fromVertex + ":\n")
        self.printDijkstrasDistance(dj)
        print("\n\n")
        self.printDijkstrasPath()
        
    def printDijkstrasPath(self):
        for i in range(0,len(self.Matrix)):
            tempu = self.Matrix[i].parents
            str1 = ""
            for j in range (0,len(tempu)):
                str1 += (self.Matrix[tempu[j]].name + " -> ")
            printStr = self.Matrix[i].name + ": Path is " + str1 + self.Matrix[i].name + "\n"
            print(printStr)
            
    def printDijkstrasDistance(self, arr):
        for i in range (0, len(self.Matrix)):
            printStr = self.Matrix[i].name + "\t\t\t" + str(arr[i]) + "\n"
            print(printStr)
      
            
      
    #Helper method to find the lowest edge cost  
    def findSmallest(self, arr):
        if(len(arr) == 0):
            return
        smallest = arr[0]
        smallestIndex = 0
        for i in range (0, len(arr)):
            if(arr[i].cost < smallest.cost):
                smallest = arr[i]
                smallestIndex = i
        tempu = arr[smallestIndex]
        del arr[smallestIndex]
        return tempu
    
    #Helper method to find the index of the vertex with the given name
    def getIndex(self, vertexName):
        for i in range (0, len(self.Matrix)):
            if(vertexName == self.Matrix[i].name):
                return i
        return -1
        
            
        


#%%

class Vertex:
    
    def __init__(self,name):
        self.name = name
        self.myList = []
        self.parents = []
        
    def addEdge(self,index,cost):
        self.myList.append(Edge(index,cost))
        
        


#%%

class Edge:
    
    def __init__(self,index,cost):
        self.index = index
        self.cost = cost
 
    
 
#%%

def main():
    g = Graph()
    
    g.addVertex("A")
    g.addVertex("B")
    g.addVertex("C")
    g.addVertex("D")
    g.addVertex("E")
    g.addVertex("F")
    g.addVertex("G")
    
    g.addEdge("A","B",5)
    g.addEdge("A","C",3)
    g.addEdge("B","C",2)
    g.addEdge("B","E",3)
    g.addEdge("B","G",1)
    g.addEdge("C","D",7)
    g.addEdge("C","E",7)
    g.addEdge("D","A",1)
    g.addEdge("D","F",6)
    g.addEdge("E","D",2)
    g.addEdge("E","F",1)
    g.addEdge("G","E",1)
    
    g.printGraph()
    
    print("\n\n")
    
    g.dijkstrasAlgo("A")
    
    
    
    
#%%

if __name__ == "__main__":
    main()
    
    
    
#%%