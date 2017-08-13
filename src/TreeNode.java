/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the class that creates each nodes for the tree
 */

public class TreeNode {

    private String label;
    private String message;
    private String prompt;

    // Recursive definition referencing to other TreeNode will be stored in an array of maximum 9 TreeNodes.
    // Therefore each node can reference to 9 different nodes.
    TreeNode[] children;

    /**
     * This is the constructor the treeNode
     *
     * @param label
     * @param message
     * @param prompt
     */
    public TreeNode(String label, String message, String prompt) {
        children = new TreeNode[9];
        this.label = label;
        this.message = message;
        this.prompt = prompt;
    }


    /**
     * Getter method for label
     *
     * @return label
     */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Getter method for message
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Getter method for prompt
     *
     * @return prompt
     */
    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }


    /**
     * This is the recursive method that does preorder traversal
     */
    public void preorder() {
        System.out.println(toString());
        for (int i = 0; i < children.length; i++) {
            if (children[i] != null)
                children[i].preorder();
        }
    }

    @Override
    public String toString() {
        return String.format("Label: %s\nPrompt: %s\nMessage: %s\n", label, prompt, message);
    }


}
