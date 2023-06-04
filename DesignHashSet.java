
/**
Design a HashSet without using any built-in hash table libraries.

Implement MyHashSet class:

void add(key) Inserts the value key into the HashSet.
bool contains(key) Returns whether the value key exists in the HashSet or not.
void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.


Underlying DS used is a BST
TC: 
- add, on average: 0(LogN)
- contains, on average: 0(LogN)
- remove, on average: 0(LogN)
 */


class MyHashSet {
    
    public class BST {
        private class Node {
            public int val;
            public Node left;
            public Node right;

            public Node(int key) {
                val = key;
                left = null;
                right = null;
            }
        }

        public Node root;

        public BST() {
            root = null;
        }
        public BST(int key) {
            root = new Node(key);
        }

        // Given the root of a BST and a key, correctly insert while maintaining BST properties
        public Node add(Node T, int key) {
            if (T == null) {
                return new BST(key).root;
            }
            if (key < T.val) { // Focus on left side of BST
                T.left = add(T.left, key);
            } else if (key > T.val) { // Focus on right side of BST
                T.right = add(T.right, key);
            }
            return T;
        }

        public Node remove(Node T, int key) {
            if(T != null) {
                if (T.val == key) {
                    if (T.left == null && T.right == null) T = null;
                    else if (T.right == null) T = T.left;
                    else if (T.left == null) T = T.right;
                    else T.val = findPredecessor(T.left).val;
                } else if (key < T.val) {
                    T.left = remove(T.left, key);
                } else if (key > T.val) {
                    T.right = remove(T.right, key);
                }
            }
            return T;

        }

        public boolean contains(Node T, int key) {
            if (T == null) return false;
            if (T.val == key) return true;
            if (key < T.val) return contains(T.left, key);
            return contains(T.right, key);
        }

        public void toString(Node cur) {
            if (cur != null) {
                System.out.print(cur.val + " ");
                toString(cur.left);
                toString(cur.right);
            }
        }

        private Node findPredecessor(Node cur) {
            if (cur.right == null) {
                Node pred = cur;
                cur = null;
                return pred;
            }
            return findPredecessor(cur.right);
        }
    }

    BST container;
    public MyHashSet() {
        container = new BST();
    }
    
    public void add(int key) {
        container.root = container.add(container.root, key);
    }
    
    public void remove(int key) {
        container.remove(container.root, key);
    }
    
    public boolean contains(int key) {
        return container.contains(container.root, key);

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
