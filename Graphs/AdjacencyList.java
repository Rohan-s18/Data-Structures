import java.util.*;

public class AdjacencyList {
	private Vertex[] graph;
	private int size;

	class Vertex implements Comparable<Vertex>{	
		String name;
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

	class Edge{
		String destString;
		int destIndex;
		
		Edge(String destString, int destIndex){
			this.destIndex = destIndex;
			this.destString = destString;
		}
	}

	public AdjacencyList() {
		graph = new Vertex[10];
		size = 0;
	}

	public boolean addNode(String name) {
		Vertex temp = new Vertex(name);
		
		if(size >= graph.length)
			resize();

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
			ArrayList<Edge> myList = graph[i].edges;
			for(int j = 0; j < myList.size(); j++) {
				
				//If the destIndex was after the pivot index, then increasing the destIndex by 1
				if(myList.get(j).destIndex >= index)
					myList.get(j).destIndex++;

			}
		}

		return true;
	}
	
	public boolean removeNode(String name) {
		int index = indexOf(name);
		if(index == -1)
			return false;
		
		for(int i = index; i < size; i++) 
			graph[i] = graph[i+1];
		
		size--;
		
		//Updating the destIndex of the edges
		for(int i = 0; i < size; i++) {
			ArrayList<Edge> myList = graph[i].edges;
			int removeIndex = -1;
			for(int j = 0; j < myList.size(); j++) {
				
				//If the destIndex was after the pivot index, then increasing the destIndex by 1
				if(myList.get(j).destIndex > index)
					myList.get(j).destIndex--;
				
				if(myList.get(j).destString.equals(name)) {
					removeIndex = j;
				}
			}
			if(removeIndex != -1)
				myList.remove(removeIndex);
			
			graph[i].edges = myList;
		}
		
		
		return true;
	}

	public boolean addEdge(String from, String to) {
		int fromIndex = indexOf(from);
		int toIndex = indexOf(to);

		if(fromIndex == -1 || toIndex == -1 || toIndex == fromIndex)
			return false;

		ArrayList<Edge> toList = graph[toIndex].edges;
		ArrayList<Edge> fromList = graph[fromIndex].edges;
		
		//Checking if the edge already exists
		for(int i = 0; i < toList.size(); i++) {
			if(toList.get(i).destIndex == fromIndex)
				return false;
		}

		//Add edge to toList, fromList
		toList.add(getAdjacencyIndex(toList,fromIndex), new Edge(from,fromIndex));
		fromList.add(getAdjacencyIndex(fromList,toIndex), new Edge(to,toIndex));

		graph[toIndex].edges = toList;
		graph[fromIndex].edges = fromList;
		return true;
	}
	
	public void printgraph() {
		
		for(int i = 0; i < size; i++) {
			String line = graph[i].name;
			line += " : ";
			
			for(int j = 0; j < graph[i].edges.size(); j++) {
				line += graph[graph[i].edges.get(j).destIndex].name;
				line += " -> ";
			}
			
			line = line.substring(0,line.length()-3);
			System.out.println(line);
		}
		
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
	
	private int getAdjacencyIndex(List<Edge> edges, int vertexIndex) {
		Vertex v = graph[vertexIndex];
		Vertex temp;
		for(int i = 0; i < edges.size(); i++) {
			temp = graph[edges.get(i).destIndex];
			if(v.compareTo(temp) < 0)
				return i;
		}
		return edges.size();
	}

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

