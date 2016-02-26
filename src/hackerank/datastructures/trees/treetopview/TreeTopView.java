package hackerank.datastructures.trees.treetopview;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Node{
	int data;
	Node left;
	Node right;	
	public Node(int data){
		this.data = data;
	}
}

//Another inner class LevelNode class which acts like a wrapper over Node
//and stores the level from root for each root. This level is required to print topview
class LevelNode{
	Node node;
	int level;
	public LevelNode(Node node, int level){
		this.node = node;
		this.level = level;
	}
}

class Tree{
	Node root;
	public Tree(){
		root = null;
	}

	//Print Top-view of Tree
	public void printTopView() {
		//edge case
		if(root == null){
			return;
		}

		//Do BFS, so using linkedlist as queue
		LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
		//Using treemap as keys are sorted by natural order
		TreeMap<Integer, LevelNode> map = new TreeMap<Integer, LevelNode>(); 

		//add root wrapped as LevelNode to queue. Add root as level 0
		queue.add(new LevelNode(root,0));
		while(!queue.isEmpty()){

			LevelNode levelNode = queue.remove();
			int level = levelNode.level;

			if(!map.containsKey(level)){	//add to map
				map.put(level, levelNode);				
			}
			//Add left node as level - 1
			if(levelNode.node.left != null){
				queue.add(new LevelNode(levelNode.node.left, level - 1));
			}
			//Add right node as level + 1
			if(levelNode.node.right != null){
				queue.add(new LevelNode(levelNode.node.right, level + 1));
			}
		}

		//Loop through map and print Nodes
		for(Map.Entry<Integer, LevelNode> entry : map.entrySet()){
			Node node = entry.getValue().node;
			System.out.print(node.data + " ");
		}

	}
}

public class TreeTopView {
	/** Input:
	 3
   /   \
  5     2
 / \   / \
1   4 6   7
 \       /
  9     8

  Output: 1 5 3 2 7
	 */
	public static void main(String[] args) {
		//Create tree as shown above
		Tree tree = new Tree();
		//Left Sub-tree
		Node root = new Node(3);
		root.left = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(4);
		root.left.left.right = new Node(9);
		//Right Sub-tree
		root.right = new Node(2);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);
		tree.root = root;

		//Print Top-view of Tree
		tree.printTopView();

	}

}
