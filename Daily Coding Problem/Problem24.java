// Daily Coding Problem
// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Google.
//
// Implement locking in a binary tree. A binary tree node can be locked or
// unlocked only if all of its descendants or ancestors are not locked.
//
// Design a binary tree node class with the following methods:
//
// is_locked, which returns whether the node is locked
// lock, which attempts to lock the node. If it cannot be locked, then it
// should return false. Otherwise, it should lock it and return true.
// unlock, which unlocks the node. If it cannot be unlocked, then it should
// return false. Otherwise, it should unlock it and return true.
// You may augment the node to add parent pointers or any other property you
// would like. You may assume the class is used in a single-threaded program,
// so there is no need for actual locks or mutexes. Each method should run in
// O(h), where h is the height of the tree.


public class Problem24
{

	class BLTNode<E> 
	{
		private boolean lock;
		private E data;
		private int numLockedDescendants;
		private BLTNode<E> parent;
		private BLTNode<E> left;
		private BLTNode<E> right;

		//	TODO create more constructors
		BLTNode(E data)
		{
			this.lock = false;
			this.data = data;
			this.numLockedDescendants = 0;
			this.parent = null;
			this.left = null;
			this.right = null;
		}

		public BLTNode<E> getLeftChild() { return this.left; }
		public BLTNode<E> getRightChild() { return this.right; }
		public BLTNode<E> getParent() { return this.parent; }
		public int getNumLockedDescendants() { return this.numLockedDescendants; }

		public void setLeftChild(BLTNode<E> left) { this.left = left; }
		public void setRightChild(BLTNode<E> right) {this.right = right; }
		public void setParent(BLTNode<E> parent) {this.parent = parent; }
		public void incNumLockedDescendants() { this.numLockedDescendants += 1; }
		public void decNumLockedDescendants() { this.numLockedDescendants -= 1; }

		public boolean isLocked() { return this.lock; }

		public boolean lock()
		{
			// check ancestors
			BLTNode<E> curr = this;
			while (curr != null)
			{
				if (curr.isLocked()) 
					return false;
				curr = curr.getParent();
			}

			// check descendants 
			if (this.getNumLockedDescendants() != 0)
				return false;
			this.lock = true;

			curr = this;
			while (curr != null)
			{
				curr = curr.getParent();
				curr.incNumLockedDescendants();
			}
			return true;
		}

		public boolean unlock() 
		{ 
			this.lock = false;
			BLTNode<E> curr = this;
			while (curr != null)
			{
				curr = curr.getParent();
				curr.decNumLockedDescendants();
			}
		}
	}

	public static void main(String []args)
	{
		// TODO create some tests
		
	}
}