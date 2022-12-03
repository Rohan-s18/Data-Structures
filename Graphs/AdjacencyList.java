import java.util.*;

public class AdjacencyList {
	private Vertex[] graph;
	private int size;

	class Vertex implements Comparable<Vertex>{	
		String name;
		List<Edge> edges;

		Vertex(String name){
			this.name = name;
			this.edges = new ArrayList<Edge>();
		}

		@Override
		public int compareTo(AdjacencyList.Vertex o) {
			// -1 if it comes before alphabetically
			// +1 if it comes after alphabetically
			for(int i = 0; i < name.length() && i < o.name.length(); i++) {
				if(name.charAt(i) < o.name.charAt(i))
					return -1;
				else if(name.charAt(i) > o.name.charAt(i))
					return 1;
			}
			
			return 0;
		}
	}

	class Edge{
		String destString;
		int destIndex;
	}

	public AdjacencyList() {
		graph = new Vertex[10];
		size = 0;
	}

	public boolean addNode(String name) {
		Vertex temp = new Vertex(name);

		//Checking if it already exists
		if(indexOf(name) != -1)
			return false;

		int index = findIndexToInsert(temp);

		
		for(int i = size; i > index; i--) {
			graph[i] = graph[i-1];
		}

		graph[index] = temp;
		size++;

		//Updating the destIndex of the edges
		for(int i = 0; i < size; i++) {
			List<Edge> myList = graph[i].edges;
			for(int j = 0; j < myList.size(); j++) {
				
				//If the destIndex was after the pivot index, then increasing the destIndex by 1
				if(myList.get(j).destIndex > index)
					myList.get(j).destIndex++;

			}
		}

		return true;
	}

	public boolean addEdge(String from, String to) {
		int fromIndex = indexOf(from);
		int toIndex = indexOf(to);

		if(fromIndex == -1 || toIndex == -1)
			return false;

		List<Edge> toList = graph[toIndex].edges;
		List<Edge> fromList = graph[fromIndex].edges;

		//Add edge to toList, fromList 

		//While adding edges make sure that they are alphabetical using the compareTo method 

		graph[toIndex].edges = toList;
		graph[fromIndex].edges = fromList;
		return true;
	}


	//-----------------------------------------------Helper Methods------------------------------------------------------------------------

	

	//Helper function to find the index of the vertex with the same name int the array of vertices

	private int indexOf(String name) {
		for(int i = 0; i < size; i++) {
			if(graph[i].name.equals(name))
				return i;
		}
		return -1;
	}

	private void resize() {
		int oldsize = graph.length;
		Vertex[] oldgraph = graph;
		graph = new Vertex[2*oldsize];
		
		//Refilling the new graph
		for(int i = 0; i < size; i++) {
			graph[i] = oldgraph[i];
		}

	}

	private int findIndexToInsert(Vertex v) {
		int index = size;
		
		//Traversing till we reach the first vertex where it would be alphabetically before 
		for(int i = 0; i < graph.length; i++) {
			if(v.compareTo(graph[i]) < 0) {
				index = i;
				break;
			}	
		}
		
		return index;
	}

}

