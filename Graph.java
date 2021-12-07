package com.rohan.csds233.finalExam;

import java.util.*;

public class Graph {
	private Vertex[] vertices;
	private int numVertices;
	private int maxNum;
	PriorityQueue<Edge> pq;
	int[] dist;
	Boolean[] set;
	
	private class Vertex{
		private String id;
		private LinkedList<Edge> edges;
		private boolean encountered;
		@SuppressWarnings("unused")
		private boolean done;
		@SuppressWarnings("unused")
		private Vertex parent;
		private int cost;
		private Vertex(String id) {
			this.id = id;
			encountered = false;
			done = false;
			edges = new LinkedList<Edge>();
			@SuppressWarnings("unused")
			int cost = 0;
		}
	}
	
	private class Edge implements Comparator<Edge>, Comparable<Edge>{
		private int toIndex;
		private double cost;
		private Edge(int toIndex, double cost) {
			this.toIndex = toIndex;
			this.cost = cost;
		}
		@Override
		public int compare(Edge o1, Edge o2) {
			if(o1.cost < o2.cost)
				return -1;
			if(o2.cost < o1.cost)
				return 1;
			return 0;
		}
		@Override
		public int compareTo(Edge o) {
			if(this.cost < o.cost)
				return -1;
			if(this.cost > o.cost)
				return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		Graph myGraph = new Graph(2);
		myGraph.addVertex("San Francisco");
		myGraph.addVertex("Palo Alto");
		myGraph.addVertex("Cupertino");
		myGraph.addVertex("San Jose");
		myGraph.addVertex("Pleasanton");
		myGraph.addVertex("Dublinn");
		myGraph.addVertex("Berkeley");
		myGraph.addVertex("Saucolito");
		myGraph.addEdge("Pleasanton", "Dublinn", 15);
		myGraph.addEdge("Pleasanton", "San Francisco", 30);
		myGraph.addEdge("Saucolito", "Berkeley", 60);
		myGraph.addEdge("San Francisco", "Saucolito", 10);
		myGraph.addEdge("San Jose", "Palo Alto", 20);
		myGraph.addEdge("Palo Alto", "Pleasanton", 10);
		myGraph.addEdge("Pleasanton", "Cupertino", 40);
		myGraph.printGraph();
		System.out.println("\n");
		//myGraph.breadthFirstTraversal("Pleasanton");
		//int y = myGraph.unweightedShortestPath("Pleasanton", "Berkeley");
		//System.out.print(y);
		//myGraph.dijkstrasAlgorithm("Pleasanton");
		myGraph.dijkstraHeap("Pleasanton");
		myGraph.printSolution(myGraph.dist);
	}
	
	//ffp2
	
	public Graph(int maximum) {
		maxNum = maximum;
		vertices = new Vertex[maxNum];
		numVertices = 0;
		pq = new PriorityQueue<Edge>();
		dist = new int[1000];
		set = new Boolean[1000];
	}
	
	public boolean addVertex(String id) {
		if(numVertices >= maxNum) {
			Vertex[] old = vertices;
			maxNum = 2*maxNum;
			vertices = new Vertex[maxNum];
			for(int i = 0; i < old.length; i++) {
				vertices[i] = old[i];
			}
		}
		vertices[numVertices] = new Vertex(id);
		numVertices++;
		return true;
	}
	
	public boolean addEdge(String a, String b, double cost) {
		int i = -1;
		int j = -1;
		if(a.equals(b))
			return false;
		for(int index = 0; index < maxNum; index++) {
			if(vertices[index]!=null) {
				if(vertices[index].id.toLowerCase().equals(a.toLowerCase()))
					i = index;
				if(vertices[index].id.toLowerCase().equals(b.toLowerCase()))
					j = index;
			}
		}
		if(i == -1 || j == -1)
			return false;
		addEdgeHelper(i,j,cost);
		return true;	
	}
	
	public void addEdgeHelper(int i, int j, double cost) {
		vertices[i].edges.add(new Edge(j,cost));
		vertices[j].edges.add(new Edge(i,cost));
	}
	
	public void printGraph() {
		for(int i = 0; i < numVertices; i++) {
			String s = vertices[i].id;
			if(vertices[i].edges.size()!=0) {
				s += ": ";
				for(Edge e : vertices[i].edges) {
					s += vertices[e.toIndex].id;
					s+= ", ";
				}
				s = s.substring(0,s.length()-2);
			}
			System.out.println(s);
		}
	}
	
	public void depthFirstTraversal(String id) {
		int index = -1;
		for(int i = 0; i < numVertices; i++) {
			if(vertices[i].id.toLowerCase().equals(id.toLowerCase()))
				index = i;
		}
		if(index != -1)
			myDepthFirstTraversal(index,null);
	}
	
	public void myDepthFirstTraversal(int i, Vertex parent) {
		System.out.println(vertices[i].id);
		vertices[i].encountered = true;
		vertices[i].parent = parent;
		Iterator<Edge> edgeItr = vertices[i].edges.iterator();
		while(edgeItr.hasNext()) {
			int j = edgeItr.next().toIndex;
			if(!vertices[j].encountered) {
				myDepthFirstTraversal(j, vertices[i]);
			}
		}
	}
	
	public void breadthFirstTraversal(String id) {
		int index = -1;
		for(int i = 0; i < numVertices; i++) {
			if(vertices[i].id.toLowerCase().equals(id.toLowerCase()))
				index = i;
		}
		if(index == -1)
			return;
		LinkedList<Vertex> q = new LinkedList<Vertex>();
		q.add(vertices[index]);
		vertices[index].parent = null;
		vertices[index].encountered = true;
		while(!q.isEmpty()) {
			Vertex v = q.peek();
			System.out.println(v.id);
			for(Edge e : v.edges) {
				if(vertices[e.toIndex].encountered == false) {
					vertices[e.toIndex].encountered = true;
					vertices[e.toIndex].parent = v;
					q.add(vertices[e.toIndex]);
				}
			}
			q.poll();
		}
	}

	public int unweightedShortestPath(String source, String destination) {
		int i = -1;
		for(int index = 0; index < numVertices; index++) {
			if(vertices[index].id.toLowerCase().equals(source.toLowerCase()))
				i = index;
		}
		if(i == -1)
			return -1;
		Vertex v = vertices[i];
		v.parent = null;
		v.encountered = true;
		LinkedList<Vertex> q = new LinkedList<Vertex>();
		q.add(v);
		while(!q.isEmpty()) {
			v = q.peek();
			if(v.id.toLowerCase().equals(destination.toLowerCase()))
				return v.cost;
			for(Edge e : v.edges) {
				Vertex w = vertices[e.toIndex];
				if(w.encountered == false) {
					w.parent = v;
					w.cost = v.cost+1;
					w.encountered = true;
					q.add(w);
				}
			}
			q.poll();
		}
		return v.cost;
	}
	
	public int dijkstrasAlgorithm(String source) {
		int src = -1;
		for(int i = 0; i < numVertices; i++) {
			if(vertices[i].id.toLowerCase().equals(source.toLowerCase()))
				src = i;
		}
		if(src == -1)
			return -1;
		return dijkstrasHelper(src);
	}
	
	private int minDistance(int dist[], Boolean sptSet[]){
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < numVertices; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
	
	private int dijkstrasHelper(int source) {
		int dist1[] = new int[numVertices]; // The output array. dist[i] will hold
        // the shortest distance from src to i
 
        // sptSet[i] will true if vertex i is included in shortest
        // path tree or shortest distance from src to i is finalized
        Boolean sptSet[] = new Boolean[numVertices];
 
        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < numVertices; i++) {
            dist1[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
 
        // Distance of source vertex from itself is always 0
        dist[source] = 0;
 
        // Find shortest path for all vertices
        for (int count = 0; count < numVertices - 1; count++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. u is always equal to src in first
            // iteration.
            int u = minDistance(dist, sptSet);
 
            // Mark the picked vertex as processed
            sptSet[u] = true;
 
            // Update dist value of the adjacent vertices of the
            // picked vertex.
            Vertex w = vertices[u];
            Iterator<Edge> itr;
            for (itr = w.edges.iterator(); itr.hasNext() ;) {
            	Edge e = itr.next();
            	int v = e.toIndex;
                // Update dist[v] only if is not in sptSet, there is an
                // edge from u to v, and total weight of path from src to
                // v through u is smaller than current value of dist[v]
                if (!sptSet[v] && dist1[u] != Integer.MAX_VALUE && dist1[u] + e.cost < dist1[v])
                    dist1[v] = (int) (dist1[u] + e.cost);
            }
        }    
        // print the constructed distance array
        printSolution(dist1);
        return -1;
	}
	
	public void printSolution(int dist[]){
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < numVertices; i++) {
            System.out.println(vertices[i].id + " \t\t " + dist[i]);
        }
    }
	
	public void shortestPath(String source) {
		
	}

	public void dijkstraHeap(String source) {
		int src = -1;
		for(int i = 0; i < numVertices; i++) {
			if(vertices[i].id.toLowerCase().equals(source.toLowerCase()))
				src = i;
		}
		if(src==-1)
			return;
		dijkstraHeapHelper(src);
	}
	
	private void dijkstraHeapHelper(int source) {
		int numSet = 0;
		for(int i = 0; i < numVertices; i++) {
			dist[i] = Integer.MAX_VALUE;
			set[i] = false;
		}
		pq.add(new Edge(source,0));
		dist[source] = 0;
		numSet++;
		while(numSet < numVertices) {
			if(pq.isEmpty())
				return;
			int index = pq.remove().toIndex;
			if(set[index])
				continue;
			set[index] = true;
			processNeighbors(index);
		}
	}
	
	private void processNeighbors(int x) {
		int edgeDistance = -1;
        int newDistance = -1;
        Vertex v = vertices[x];
        Iterator<Edge> itr;
        for(itr = v.edges.iterator();itr.hasNext();) {
        	Edge e = itr.next();
        	int index = e.toIndex;
        	if(!set[index]) {
        		edgeDistance = (int) e.cost;
                newDistance = dist[x] + edgeDistance;
                if (newDistance < dist[index])
                    dist[index] = newDistance;
                pq.add(new Edge(index,dist[index]));
        	}
        }
	}
	
}









