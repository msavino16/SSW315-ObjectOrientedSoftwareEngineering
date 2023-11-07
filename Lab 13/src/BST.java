import java.util.ArrayList;

public class BST<E extends Comparable<E>> {
	protected TreeNode<E> root;
	protected int size = 0;

	/** Create a default binary search tree */
	public BST() {
		this.root = null;
	}

	/** Create a binary search tree from an array of objects */
	public BST(E[] objects) {
		for (int i = 0; i < objects.length; i++)
			insert(objects[i]);
	}

	/** Return true if the element is in the tree */
	public boolean search(E e) {
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				// element matches current.element
				return true; // Element is found
		}

		return false;
	}

	public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); 
        else {

            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false;
            
            if (e.compareTo(parent.element) < 0) {
                parent.left = createNewNode(e);
                parent.left.parent = parent;
            } else {
                parent.right = createNewNode(e);
                parent.right.parent = parent;
            }
        }

        size++;
        return true;
    }



	protected TreeNode<E> createNewNode(E e) {
		return new TreeNode<E>(e);
	}

	/** Inorder traversal from the root */
	public void inorder() {
		inorder(root);
	}

	/** Inorder traversal from a subtree */
	protected void inorder(TreeNode<E> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	/** Postorder traversal from the root */
	public void postorder() {
		postorder(root);
	}

	/** Postorder traversal from a subtree */
	protected void postorder(TreeNode<E> root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	/** Preorder traversal from the root */
	public void preorder() {
		preorder(root);
	}

	/** Preorder traversal from a subtree */
	protected void preorder(TreeNode<E> root) {
		if (root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	/** Inner class tree node */
	public static class TreeNode<E extends Comparable<E>> {
		public BST.TreeNode<E> parent;
		E element;
		TreeNode<E> left;
		TreeNode<E> right;

		public TreeNode(E e) {
			element = e;
		}
	}

	/** Get the number of nodes in the tree */
	public int getSize() {
		return size;
	}

	/** Returns the root of the tree */
	public TreeNode<E> getRoot() {
		return root;
	}

	/** Returns a path from the root leading to the specified element */
	public java.util.ArrayList<TreeNode<E>> path(E e) {
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
		TreeNode<E> current = root; // Start from the root

		while (current != null) {
			list.add(current); // Add the node to the list
			if (e.compareTo(current.element) < 0) {
				current = current.left;
			} else if (e.compareTo(current.element) > 0) {
				current = current.right;
			} else
				break;
		}

		return list;
	}

	public boolean delete(E e) {
	    TreeNode<E> parent = null;
	    TreeNode<E> current = root;
	    while (current != null) {
	        if (e.compareTo(current.element) < 0) {
	            parent = current;
	            current = current.left;
	        } else if (e.compareTo(current.element) > 0) {
	            parent = current;
	            current = current.right;
	        } else
	            break;
	    }

	    if (current == null)
	        return false;

	   if (current.left == null) {
	        if (parent == null) {
	            root = current.right;
	            if (root != null) root.parent = null;
	        } else {
	            if (e.compareTo(parent.element) < 0) {
	                parent.left = current.right;
	                if (parent.left != null) parent.left.parent = parent; // update parent reference
	            } else {
	                parent.right = current.right;
	                if (parent.right != null) parent.right.parent = parent; // update parent reference
	            }
	        }
	    } else {
	        TreeNode<E> parentOfRightMost = current;
	        TreeNode<E> rightMost = current.left;

	        while (rightMost.right != null) {
	            parentOfRightMost = rightMost;
	            rightMost = rightMost.right;
	        }

	        current.element = rightMost.element;

	        if (parentOfRightMost.right == rightMost) {
	            parentOfRightMost.right = rightMost.left;
	            if (parentOfRightMost.right != null) parentOfRightMost.right.parent = parentOfRightMost; // update parent reference
	        } else {
	            parentOfRightMost.left = rightMost.left;
	            if (parentOfRightMost.left != null) parentOfRightMost.left.parent = parentOfRightMost; // update parent reference
	        }
	    }

	    size--;
	    return true;
	}
	
	
	public java.util.Iterator<E> iterator() {
		return new InorderIterator();
	}

	// Inner class InorderIterator
	private class InorderIterator implements java.util.Iterator<E> {
		// Store the elements in a list
		private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
		private int current = 0; // Point to the current element in list

		public InorderIterator() {
			inorder(); // Traverse binary tree and store elements in list
		}

		/** Inorder traversal from the root */
		private void inorder() {
			inorder(root);
		}

		/** Inorder traversal from a subtree */
		private void inorder(TreeNode<E> root) {
			if (root == null)
				return;
			inorder(root.left);
			list.add(root.element);
			inorder(root.right);
		}

		/** Next element for traversing? */
		public boolean hasNext() {
			if (current < list.size())
				return true;

			return false;
		}

		/** Get the current element and move cursor to the next */
		public E next() {
			return list.get(current++);
		}

		/** Remove the current element and refresh the list */
		public void remove() {
			delete(list.get(current)); // Delete the current element
			list.clear(); // Clear the list
			inorder(); // Rebuild the list
		}
	}

	/** Remove all elements from the tree */
	public void clear() {
		root = null;
		size = 0;
	}
	
	public TreeNode<E> getNode(E e) {
	    TreeNode<E> current = root;

	    while (current != null) {
	        if (e.compareTo(current.element) < 0) {
	            current = current.left;
	        } else if (e.compareTo(current.element) > 0) {
	            current = current.right;
	        } else { // Element matches current.element
	            return current;
	        }
	    }

	    return null; // Element is not in the tree
	}
	
	public boolean isLeaf(E element) {
	    TreeNode<E> node = getNode(element);
	    return node != null && node.left == null && node.right == null;
	}
	
	public ArrayList<E> path(TreeNode<E> node) {
	    ArrayList<E> pathList = new ArrayList<E>();
	    TreeNode<E> current = node;

	    while (current != null) {
	        pathList.add(0, (E) current);
	        current = current.parent;
	    }

	    return pathList;
	}
	
}
