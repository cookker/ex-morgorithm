package morgorithm.ex.tree;

public class Tree {

    private String key;
    private int value;
    private Tree left;
    private Tree right;

    public Tree(String key, int value, Tree left, Tree right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "key='" + key + '\'' +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public Tree update(String key, int newValue, Tree tree){
        if(tree == null){
            return new Tree(key, newValue, null, null);
        }

        return key.compareTo(tree.key) < 0 ?
                new Tree(tree.key, tree.value, update(key, newValue, tree.left), tree.right)
                :
                new Tree(tree.key, tree.value, tree.left, update(key, newValue, tree.right));
    }

    public static void main(String[] args) {
        Tree lefttree = new Tree("1", 1, null, null);
        Tree righttree = new Tree("2", 2, null, null);
        Tree tree = new Tree("3", 3, lefttree, righttree);

        final Tree update1 = tree.update("2", 1000, tree);
        final Tree update2 = tree.update("2", 500, update1);
//        System.out.println(tree);
        System.out.println(update2);
    }
}
