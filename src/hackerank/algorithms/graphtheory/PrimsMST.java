package hackerank.algorithms.graphtheory;

import java.util.Scanner;

class Graph{
	int[][] weightMatrix;	//store the weights if each edge
	boolean[] visited;		//stores if vertex is visited or not
	int[] dist;				// shortest known distance to MST
	//int[] prec;				// preceding node in tree
	int noOfVertices;

	public Graph(int noOfVertices){
		//initialize the graph
		weightMatrix = new int[noOfVertices][noOfVertices];	//here adjMatrix is the weight matrix
		visited = new boolean[noOfVertices];
		dist = new int[noOfVertices];
		//prec = new int[noOfVertices];
		this.noOfVertices = noOfVertices;

		//initialize the weight Matrix with 0
		for(int i=0; i < noOfVertices; i++) {
			for(int j=0; j < noOfVertices; j++) {
				weightMatrix[i][j] = 0;
			}
		}
		//initialize preceding node distance to 0 and visited to false
		//and shortest known distance to Integer MAX (any large value) with which we can compare later
		for(int i=0; i < noOfVertices; i++){
			//prec[i] = 0;
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
		}		
	}

	//Methods
	public void addEdge(int start, int end, int weight){
		weightMatrix[start][end] = weight;
		weightMatrix[end][start] = weight;
	}

	//just to see how graph looks are vertices and edges added
	public void printMatrix(){
		for(int i=0; i < weightMatrix.length; i++){
			for(int j=0; j < weightMatrix.length; j++){
				System.out.print(weightMatrix[i][j]+ " ");
			}
			System.out.println();
		}
	}

	/**
	 * PRIMS ALGORITHM for MSE
	 */
	public int prims(int current){
		int mincost;
		dist[current] = 0; 
		int count = 1; 
		visited[current] = true; 

		while(count != noOfVertices){

			for (int i=0; i < noOfVertices; i++) { 
				if(weightMatrix[current][i] != 0 && visited[i] == false){ 
					//check with current value we recorded in dist array - dist will be greater as we init with MAX_VALUE
					if(dist[i] > weightMatrix[current][i])	{ 
						dist[i] = weightMatrix[current][i]; 
						//prec[i] = current; 
					}
				}
			}//end for

			mincost=Integer.MAX_VALUE;
			for (int i = 0 ; i < noOfVertices; i++) {
				if (visited[i] == false) {
					if (dist[i] < mincost) {
						mincost = dist[i];
						current = i;
					}
				}
			}
			visited[current]=true;
			count++;
		}//end while
		
		//Loop distance array and compute total mincost
		mincost=0;
        for(int i=0; i< noOfVertices; i++){
        	mincost = mincost + dist[i];
        }

        //System.out.println("Minimum cost= "+ mincost);
//        System.out.println("Minimum Spanning tree is");

//        for(int i=0; i < noOfVertices; i++){
//        	System.out.println("vertex " + i +" is connected to " + prec[i]);
//        }
        
        return mincost;

	}
}

public class PrimsMST { 
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);	

		int noOfVertices = s.nextInt();
		int noOfEdges = s.nextInt();

		Graph graph = new Graph(noOfVertices);

		for(int i=0; i < noOfEdges; i++){
			int start = s.nextInt();
			int end = s.nextInt();
			int weight = s.nextInt();

			graph.addEdge(start-1, end-1, weight);			
		}

		int startNode = s.nextInt();

		System.out.println("Graph :");
		graph.printMatrix();
		
		int mincost = graph.prims(startNode-1);
		System.out.println(mincost);
		
		s.close();
	} 
}