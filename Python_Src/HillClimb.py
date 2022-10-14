#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Sat May 21 12:07:59 2022
@author: rohansingh
Using HillClimbing for Discrete Optimization
"""




#%%
import Graph

def HillClimb(graph, start):
    print("HelloWorld!")
    


#%%

from Graph.py import Graph as gr

def HillClimbDemo():
    g = gr()
    
    #Adding the Vertices 
    g.addVertex("A",1)
    g.addVertex("B",3)
    g.addVertex("C",5)
    g.addVertex("D",7)
    g.addVertex("E",4)
    g.addVertex("F",7)
    g.addVertex("G",10)
    g.addVertex("H",20)
    g.addVertex("I",15)
    
    g.addEdge("A","B",0)
    g.addEdge("A","C",0)
    
    g.addEdge("B","C",0)
    
    g.addEdge("C","D",0)
    g.addEdge("C","F",0)
    
    g.addEdge("D","F",0)
    g.addEdge("D","G",0)
    g.addEdge("D","I",0)
    
    g.addEdge("F","E",0)
    
    g.addEdge("G","D",0)
    g.addEdge("G","H",0)
    
    g.addEdge("H","F",0)
    
    g.printGraph()
    
    
    
    
    
    
    
    
#%%