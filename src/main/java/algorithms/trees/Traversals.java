package algorithms.trees;

public class Traversals {
  public static void main(String[] args) {
    Node root = new Node(1);
    root.leftChild = new Node(2);
    root.rightChild = new Node(3);
    root.leftChild.leftChild = new Node(4);
    root.leftChild.rightChild = new Node(5);
    System.out.println("InOrder Traversal: ");
    inOrderTraversal(root);
    System.out.println("");
    System.out.println("PreOrder Traversal: ");
    preOrderTraversal(root);
    System.out.println("");
    System.out.println("PostOrder Traversal: ");
    postOrderTraversal(root);

  }

  private static void preOrderTraversal(Node root) {
    if (root == null)
      return;
    System.out.print(root.value);
    preOrderTraversal(root.leftChild);
    preOrderTraversal(root.rightChild);
  }

  private static void postOrderTraversal(Node root) {
    if (root == null)
      return;
    postOrderTraversal(root.leftChild);
    postOrderTraversal(root.rightChild);
    System.out.print(root.value);
  }

  private static void inOrderTraversal(Node root) {
    if (root == null)
      return;
    inOrderTraversal(root.leftChild);
    System.out.print(root.value);
    inOrderTraversal(root.rightChild);
  }

}
