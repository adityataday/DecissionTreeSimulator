/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the class that creates a tree for the program.
 */

import java.util.Scanner;

public class Tree {


    TreeNode root;
    TreeNode cursor;

    public Tree() {
        root = null;
    }

    /**
     * This is the method that adds a pariticular nodes with given parameters
     * into the tree. The user must enter the following parameters through the
     * driver class.
     *
     * @param label
     * @param prompt
     * @param message
     * @param parentLabel
     * @return false if node was not added.
     */
    public boolean addNode(String label, String prompt, String message, String parentLabel) {
        TreeNode node;

        boolean done = false;

        String[] splitLabel = label.split("-");


        if (root == null) {
            node = new TreeNode(label, message, prompt);
            root = node;
            done = true;
        } else {
            cursor = root;
            while (!done) {
                if (parentLabel.equalsIgnoreCase(cursor.getLabel())) {
                    cursor.children[Integer.parseInt(splitLabel[splitLabel.length - 1]) - 1] = new TreeNode(label, message, prompt);
                    done = true;

                } else {
                    for (int i = 0; i < splitLabel.length - 1; i++) {
                        cursor = cursor.children[Integer.parseInt(splitLabel[i]) - 1];

                    }

                }
            }
        }


        if (done)
            return true;

        return false;
    }

    /**
     * This method carries out preorder traversal.
     * Visits root, left, middle, then right nodes.
     *
     * @throws Exception : If the tree is empty.
     */
    public void preOrder() throws Exception {
        if (root == null)
            throw new Exception("The tree is empty");
        System.out.println("Traversing in preorder:");
        TreeNode cursor = root;
        cursor.preorder();
    }

    /**
     * This method does the help session for the tree.
     * The user is given an option to choose as the user
     * selects an option the tree advances resulting in a decision at the end.
     * <p>
     * It also goes to previous option if you input -1.
     * Limitations: It only can go back one menu option.
     *
     * @throws Exception : If the tree is empty.
     */
    public void beginSession() throws Exception {
        if (root == null)
            throw new Exception("The tree is empty");

        Scanner input = new Scanner(System.in);
        int choice = 0;
        TreeNode cursorBack = root; // Cursor to go back

        cursor = root;


        while (cursor != null) {
            System.out.println(cursor.getMessage());
            for (int i = 0; i < cursor.children.length; i++) {
                if (cursor.children[i] != null)
                    System.out.printf("%d) %s\n", i, cursor.children[i].getPrompt());

            }
            System.out.printf("-1) Previous menu\n");
            System.out.printf("-2) Exit Session\n");
            System.out.printf("\nSelect an Operation: ");
            choice = input.nextInt();

            if (choice == -2)
                break;
            if (choice == -1) {
                cursor = cursorBack;
            } else {
                cursorBack = cursor;
                cursor = cursor.children[choice];
            }
            System.out.println();

        }


    }

}
