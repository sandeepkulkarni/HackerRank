package hackerank.datastructures.trees.LowestCommonAncestor;

import java.util.LinkedList;

class Node{
	int data;
	Node left;
	Node right;

	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}

class Tree{
	Node root;		//required as we start traversal from root.
	public Tree(){	//initialize tree as empty
		root = null;
	}

	//Lowest common ancestor
	/*Method 1:
	1) Find path from root to n1 and store it in LinkedList<Node>.
	2) Find path from root to n2 and store it in another LinkedList<Node>.
	3) Traverse both paths till the values in list are same. Return the common node just before the mismatch.
	 */
	public Node findLCA_Simple(Node root, int node1, int node2){

		//To store the paths from root to node1 and node2
		LinkedList<Node> pathToNode1 = new LinkedList<Node>();
		LinkedList<Node> pathToNode2 = new LinkedList<Node>();

		boolean pathToNode1Exists = findPath(root, pathToNode1, node1);
		boolean pathToNode2Exists = findPath(root, pathToNode2, node2);

		if(!pathToNode1Exists || !pathToNode2Exists){
			return null;
		}

		System.out.println("Path to Node 1:");
		for(Node n : pathToNode1){
			System.out.print(n.data + " ");
		}
		System.out.println("\nPath to Node 2:");
		for(Node n : pathToNode2){
			System.out.print(n.data + " ");
		}

		//Traverse both paths till the values in list are same. Return the common node just before the mismatch.
		int i;
		for(i=0; i < pathToNode1.size() && i < pathToNode2.size(); i++){
			if(pathToNode1.get(i) != pathToNode2.get(i)){
				break;
			}
		}

		Node lca = pathToNode1.get(i-1);
		return lca;
	}

	private boolean findPath(Node root, LinkedList<Node> pathToNode, int nodeValue){
		if(root == null) { 		//base condition
			return false;
		}
		//Store the node in list. Node will be removed if if not in path
		pathToNode.add(root);

		//Check if root is same as nodeValue
		if(root.data == nodeValue){
			return true;
		}

		//Check if node is found in Left or Right sub-tree
		if((root.left != null && findPath(root.left, pathToNode, nodeValue))
				|| (root.right != null && findPath(root.right, pathToNode, nodeValue))){
			return true;
		}

		//If still node is not found, remove the added node from list and return false
		pathToNode.removeLast();
		return false;
	}


	//Lowest common ancestor
	/*Method 2:
		1) Traverse the tree starting from root. If any of the given nodes (n1 and n2) matches with root, then root is LCA.
		2) If root doesn’t match with any of the nodes, we recur for left and right subtrees. The node which has n1 present in its one subtree and the n2 present in other subtree is the LCA. 
		3) If both nodes lie in left subtree, then left subtree has LCA, otherwise LCA lies in right subtree.
	 */
	public Node findLCA(Node node, int n1, int n2) {		
		//Base case
		if(node == null){		
			return null;
		}		
		//If either n1 or n2 is the ancestor of other, then that becomes the LCA
		if(node.data == n1 || node.data == n2){
			return node;
		}

		//Look in Left and right subtrees
		Node leftLCA = findLCA(node.left, n1, n2);
		Node rightLCA = findLCA(node.right, n1, n2);

		//If both of the above nodes are not null, 
		//then one node is present in once subtree and other is present in other. So this node is the LCA
		if(leftLCA != null && rightLCA != null){
			return node;
		}

		//If both nodes are in a left subtree of right subtree. Return one which is not null
		return (leftLCA != null) ? leftLCA : rightLCA;		
	}

}


public class LowestCommonAncestor {

	public static void main(String[] args){
		Tree tree = new Tree();		//create tree

		//Create the Binary Tree shown below:
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		tree.root = root;

		System.out.println("LCA(4,5) is :");
		System.out.println("By Method 1");
		Node lca = tree.findLCA_Simple(tree.root, 4, 5);
		System.out.println("\nLCA= "+lca.data);

		System.out.println("\nBy Method 2");
		Node lca2 = tree.findLCA(tree.root, 4, 5);
		System.out.println("LCA= "+lca2.data);

		System.out.println("\n\nLCA(3,4) is :");
		System.out.println("By Method 1");
		Node lca3 = tree.findLCA_Simple(tree.root, 3, 4);
		System.out.println("\nLCA= "+lca3.data);

		System.out.println("\nBy Method 2");
		Node lca4 = tree.findLCA(tree.root, 3, 4);
		System.out.println("LCA= "+lca4.data);

	}


}
