import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BSTtest<E> {
	
	
	public static class TreeNode<E extends Comparable<E>> {
		public BST.TreeNode<E> parent;
		E element;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}
	

	@Test
	void getTest() {
		BST<Integer> tree = new BST<Integer>();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		BST.TreeNode<Integer> node = tree.getNode(20);
		assertEquals(node.element,20);


	}
	@Test
	void LeafTest() {
		BST<Integer> tree = new BST<Integer>();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		
		assertTrue(tree.isLeaf(20));
		assertFalse(tree.isLeaf(30));


	}
	@Test
	void pathTest() 
	{
		BST<Integer> tree = new BST<Integer>(new Integer[]{50, 25, 75, 10, 40, 60, 90, 35, 45, 55, 65, 85, 95});
	    ArrayList<BST.TreeNode<Integer>> path = tree.path(55);
	    ArrayList<Integer> e = new ArrayList<Integer>(Arrays.asList(50, 75, 60, 55));
	    ArrayList<Integer> a = new ArrayList<Integer>();
	    for (BST.TreeNode<Integer> node : path) {
	        a.add(node.element);
	    }
	    assertEquals(e, a);
	}
	@Test
	void test()
	{
		BST<Integer> tree = new BST<Integer>(new Integer[]{45,54,67,56,50,45,23,59,23,67});
		tree.delete(45);
		int[] leaf1 = new int[3];
		int[] leaf2 = new int[5];
		
		int[] leaf1soln = new int[] {23,54,50};
		int[] leaf2soln = new int[] {23, 54, 67, 56, 59};
		
		int i = 0;
		for (BST.TreeNode<Integer> I : tree.path(50))
		{
			leaf1[i] = I.element;
			i++;
		}
		i = 0;
		for (BST.TreeNode<Integer> I : tree.path(59))
		{
			leaf2[i] = I.element;
			i++;
		}
		assertArrayEquals(leaf1,leaf1soln);
		assertArrayEquals(leaf2,leaf2soln);
		
		
	}

}
