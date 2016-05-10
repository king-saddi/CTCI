package treesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class Question {
	public enum State {
		Unvisited, Visited, Visiting;
	} 

	public static void main(String a[])
	{
		Graph g = createNewGraph();
		Node[] n = g.getNodes();
		Node start = n[0];
		Node end = n[5];
		System.out.println(search(g, start, end));
	}
	
	public static Graph createNewGraph()
	{
		Graph g = new Graph();        
		Node[] temp = new Node[6];

		temp[0] = new Node("a", 3);
		temp[1] = new Node("b", 0);
		temp[2] = new Node("c", 0);
		temp[3] = new Node("d", 1);
		temp[4] = new Node("e", 1);
		temp[5] = new Node("f", 0);

		temp[0].addAdjacent(temp[1]);
		temp[0].addAdjacent(temp[2]);
		temp[0].addAdjacent(temp[3]);
		temp[3].addAdjacent(temp[4]);
		temp[4].addAdjacent(temp[5]);
		for (int i = 0; i < 6; i++) {
			g.addNode(temp[i]);
		}
		return g;
	}
	
	public static boolean search(Graph g,Node start,Node end) {  
		LinkedList<Node> queue = new LinkedList<Node>();
		start.state = State.Visiting;
		queue.add(start);
		while(!queue.isEmpty()){
			Node r = queue.poll();
			if(r != null){
				for (Node n: r.getAdjacent()){
					if(n == end){
						return true;
					}					
					if(n.state == State.Unvisited){
						n.state = State.Visiting;
						queue.add(n);
						System.out.println(n.getVertex());
					}
				}
				r.state = State.Visited;
			}
		}
		
		return false;
	}


}
