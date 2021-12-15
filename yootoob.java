int[] pathCosts = new int[numvertices];
		boolean[] finalizedSet = new boolean[numvertices];
		PriorityQueue<Road> foo = new PriorityQueue<Road>();
		int numFinalized = 0;
		
		int src = indexOf(source);
		if(src == -1)
			return null;
		
		for(int i = 0; i < numvertices; i++) {
			pathCosts[i] = Integer.MAX_VALUE;
			finalizedSet[i] = false;
		}
		foo.add(new Road(src,0));
		pathCosts[src] = 0;
		vertices[src].parent = null;
		
		while(numFinalized < numvertices) {
			if(foo.isEmpty())
				break;
			
			Road r = foo.poll();
			int index = r.toIndex;
			Vertex v = vertices[index];
			if(finalizedSet[index])
				continue;
			finalizedSet[index] = true;
			
			Iterator<Road> itr = v.roads.iterator();
			while(itr.hasNext()) {
				Road temp = itr.next();
				int j = temp.toIndex;
				if(!finalizedSet[j]) {
					int newCostEstimate = pathCosts[index] + temp.cost;
					if(newCostEstimate < pathCosts[j]) {
						pathCosts[j] = newCostEstimate;
						vertices[j].parent = v;
					}
					foo.add(new Road(j,pathCosts[j]));
				}
			}
		}
		
		return pathCosts;
