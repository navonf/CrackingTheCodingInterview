/* Trees and Graphs page 100

Some facts about trees:

Each tree has a root node. (Actually, this isn't strictly necessary in graph theory, but it's usually how we
use trees in programming, and especially programming interviews.)

The root node has zero or more child nodes.

Each child node has zero or more child nodes, and so on.

No cycles in a tree, obviously */

// Simple Node class
// Name variable and array that hold the children
class Node {
  public String name;
  public Node[] children;
}

/* We can have a Tree class to wrap this node. But, I won't have that in this code

BST's has two properties, structural and and ordering property.

Structural: Each node has two children, left and right. Each node has one parent
except for the root node duhh

Ordering: left child value < root node or middle node value < right child value

If we have duplicate values we have to be consistent if we put them in on the
left or right

Tree with no nodes is known as an empty tree

Height of a tree with zero nodes id -1. Height of a tree with zero node is 0.
*/
