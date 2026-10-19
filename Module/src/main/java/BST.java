public record BST<T>(T value, BST<T> left, BST<T> right) {

    public T getValue(){
        return value;
    }

    public BST <T> getLeft(){
        return left;
    }

    public BST <T> getRight(){
        return right;
    }

    /** Accepts a binary tree and returns a count of the number of nodes it contains */
    public static <T> int countNodes(BST<T> tree){
        if (tree==null){
            return 0;
        } else {
            return 1 + countNodes(tree.right) + countNodes(tree.left);
        }
    }

    /** Accepts a binary tree and returns its mirror image */
    public static <T> BST<T> mirror(BST<T> tree){
        if (tree == null){
            return null;
        }
        BST<T> mirrorL = mirror(tree.left);
        BST<T> mirrorR = mirror(tree.right);
        return new BST<>(tree.value, mirrorR, mirrorL);
    }

    /** Accepts a BST and returns a LinkedList of all the elements in preorder */
    public static <T> LinkedList<T> preorder(BST<T> tree) {
        LinkedList<T> result = new LinkedList<>(null, null);
        preorderHelper(tree, result);
        return result;
    }

    /** Copies a BST's elements onto the LinkedList provided */
    public static <T> void preorderHelper(BST<T> tree, LinkedList<T> result) {
        if (tree == null) {
            return;
        }
        result.add(tree.getValue());
        preorderHelper(tree.getLeft(), result);
        preorderHelper(tree.getRight(), result);
    }

    /** Accepts a BST and returns true if it contains */
    public static <T> boolean contains(BST<T> tree, T element){
        if (tree==null){
            return false;
        } else
        if (tree.value.equals(element)){
            return true;
        } else
        if (contains(tree.left, element)){
            return true;
        } else
        if (contains(tree.right, element)){
            return true;
        } else {
            return false;
        }
    }

    /** Accepts a binary tree and a value and if the tree contains the value, returns a linked list of "left"s and "right"s representing the path from the root to the located value */
    public static <T> LinkedList<String> findPath(BST<T> tree, T target) {
        if (tree == null) {
            return null;
        }
        if (tree.getValue().equals(target)) {
            return new LinkedList<>(null, null);
        }
        LinkedList<String> leftPath = findPath(tree.getLeft(), target);
        if (leftPath != null) {
            return new LinkedList<>("left", leftPath);
        }
        LinkedList<String> rightPath = findPath(tree.getRight(), target);
        if (rightPath != null) {
            return new LinkedList<>("right", rightPath);
        }
        return null;
    }
}