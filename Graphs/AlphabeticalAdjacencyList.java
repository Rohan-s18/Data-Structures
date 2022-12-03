//If you are looking for the code for Assignment 6, well then I guess you lucked out lol!

//Author: Rohan Singh
//Adjacency List implementation of an alphabetically-ordered graph

//DO NOT USE LINKEDLISTS!!!!!!
import java.util.*;

public class AlphabeticalAdjacencyList {

	//Creating an array of Vertices for the graph
	private Vertex[] graph;

	//This integer will count the number of nodes currently in the graph
	private int size;

	//Vertex implements Comparable because we want to sort them alphabetically
	class Vertex implements Comparable<Vertex>{	

		//Name of the vertex
		String name;

		//List of edges for the vertex
		ArrayList<Edge> edges;

		Vertex(String name){
			this.name = name;
			this.edges = new ArrayList<Edge>();
		}

		@Override
		public int compareTo(AdjacencyList.Vertex o) {
			// -1 if it comes before alphabetically
			// +1 if it comes after alphabetically
			for(int i = 0; i < name.length() && i < o.name.length(); i++) {
				if(name.toLowerCase().charAt(i) < o.name.toLowerCase().charAt(i))
					return -1;
				else if(name.charAt(i) > o.name.charAt(i))
					return 1;
			}
			
			return 0;
		}
	}

	//Class for edge (Just holds the name and indedx of the vertex it is pointing to)
	class Edge{
		String destString;
		int destIndex;
		
		Edge(String destString, int destIndex){
			this.destIndex = destIndex;
			this.destString = destString;
		}
	}

	//Constructor
	public AlphabeticalAdjacencyList() {
		graph = new Vertex[10];
		size = 0;
	}


	//Adding a node to the graph
	public boolean addNode(String name) {
		Vertex temp = new Vertex(name);
		
		//Resizing if needed
		if(size >= graph.length)
			resize();

		//Checking for duplicates
		//Checking if it already exists
		if(indexOf(name) != -1)
			return false;

		//Calls helper method to find the index for insertion: Since it is alphabetical
		int index = findIndexToInsert(temp);

		//Shifting everything after 'index' by one to make room for the new vertex
		for(int i = size; i > index; i--) {
			graph[i] = graph[i-1];
		}

		//Adding the vertex at the location
		graph[index] = temp;
		size++;

		//Updating the destIndex of the edges that were moved by one spot
		for(int i = 0; i < size; i++) {
			ArrayList<Edge> myList = graph[i].edges;
			for(int j = 0; j < myList.size(); j++) {
				
				//If the destIndex was after the pivot index, then increasing the destIndex by 1
				if(myList.get(j).destIndex >= index)
					myList.get(j).destIndex++;

			}
		}

		return true;
	}
	
	//Method to remove a node from the graph
	public boolean removeNode(String name) {

		//Getting the index of the node
		int index = indexOf(name);

		//Checking if it even exists
		if(index == -1)
			return false;
		
		//Shifting everything after 'index' to the left by one spot
		for(int i = index; i < size; i++) 
			graph[i] = graph[i+1];
		
		//Decreasing size
		size--;
		
		//Updating the destIndex of the edges that were moved left by subtracting one from them
		//Removing all edges pointing to the deleted node
		for(int i = 0; i < size; i++) {
			ArrayList<Edge> myList = graph[i].edges;
			int removeIndex = -1;
			for(int j = 0; j < myList.size(); j++) {
				
				//If the destIndex was after the pivot index, then decreasing the destIndex by 1
				if(myList.get(j).destIndex > index)
					myList.get(j).destIndex--;
				

				if(myList.get(j).destString.equals(name)) {
					removeIndex = j;
				}
			}

			//Removing the edge pointing to the reomved node
			if(removeIndex != -1)
				myList.remove(removeIndex);
			
			graph[i].edges = myList;
		}
		
		
		return true;
	}

	//Method to add an edge 
	public boolean addEdge(String from, String to) {
		//Getting the indices
		int fromIndex = indexOf(from);
		int toIndex = indexOf(to);

		//If one of the nodes doesn't exists or they are both the same
		if(fromIndex == -1 || toIndex == -1 || toIndex == fromIndex)
			return false;

		ArrayList<Edge> toList = graph[toIndex].edges;
		ArrayList<Edge> fromList = graph[fromIndex].edges;
		
		//Checking if the edge already exists
		for(int i = 0; i < toList.size(); i++) {
			if(toList.get(i).destIndex == fromIndex)
				return false;
		}

		//Add edge to toList, fromList: using getAdjacency helper method
		toList.add(getAdjacencyIndex(toList,fromIndex), new Edge(from,fromIndex));
		fromList.add(getAdjacencyIndex(fromList,toIndex), new Edge(to,toIndex));

		graph[toIndex].edges = toList;
		graph[fromIndex].edges = fromList;
		return true;
	}
	
	//MEthod to remove an edge
	public boolean removeEdge(String from, String to) {
		int fromIndex = indexOf(from);
		int toIndex = indexOf(to);

		//If the nodes don't exist
		if(fromIndex == -1 || toIndex == -1 || toIndex == fromIndex)
			return false;
		
		ArrayList<Edge> toList = graph[toIndex].edges;
		ArrayList<Edge> fromList = graph[fromIndex].edges;
		
		boolean exists = false;
		for(int i = 0; i < toList.size(); i++) {
			//If we find an edge in the "to" list that points to the 'from index'
			if(toList.get(i).destIndex == fromIndex) {
				//Remving the edge
				toList.remove(i);
				exists = true;
			}
				
		}
		
		for(int i = 0; i < fromList.size(); i++) {
			//If we find an edge in the "from" list that points to the 'to index'
			if(fromList.get(i).destIndex == toIndex) {
				fromList.remove(i);
				exists = true;
			}
				
		}
		
		graph[toIndex].edges = toList;
		graph[fromIndex].edges = fromList;
		
		return exists;
	}
	
	//Method to print out the graph
	public void printgraph() {
		
		//Going through the array of Vertices
		for(int i = 0; i < size; i++) {
			//Getting the name of the pVertex
			String line = graph[i].name;
			line += " : ";
			
			//Adding all of it's neighbors
			for(int j = 0; j < graph[i].edges.size(); j++) {
				line += graph[graph[i].edges.get(j).destIndex].name;
				line += " -> ";
			}
			
			line = line.substring(0,line.length()-3);
			System.out.println(line);
		}
		
	}


	//-----------------------------------------------Helper Methods------------------------------------------------------------------------

	

	//Helper function to find the index of the vertex with the same 'name' in the array of vertices
	private int indexOf(String name) {

		//Traversing through the graphs
		for(int i = 0; i < size; i++) {
			if(graph[i].name.equals(name))
				return i;
		}
		return -1;
	}

	//Helper method to resize the graph array if it gets filled
	private void resize() {
		int oldsize = graph.length;
		Vertex[] oldgraph = graph;
		graph = new Vertex[2*oldsize];
		
		//Refilling the new graph
		for(int i = 0; i < size; i++) {
			graph[i] = oldgraph[i];
		}

	}
	
	//Helper method to find the index in the adjacency list where the edge should be inserted alphabetically
	private int getAdjacencyIndex(List<Edge> edges, int vertexIndex) {
		Vertex v = graph[vertexIndex];
		Vertex temp;

		//Going through the list of edges and comparing them alphabetically
		for(int i = 0; i < edges.size(); i++) {
			temp = graph[edges.get(i).destIndex];
			if(v.compareTo(temp) < 0)
				return i;
		}
		return edges.size();
	}

	//Helper method to find the index where the Vertex should be inserted in the graph
	private int findIndexToInsert(Vertex v) {
		int index = size;
		
		//Traversing till we reach the first vertex where it would be alphabetically before 
		for(int i = 0; i < size; i++) {
			if(v.compareTo(graph[i]) < 0) {
				index = i;
				break;
			}	
		}
		
		return index;
	}

}

