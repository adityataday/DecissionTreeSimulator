/**
 * Name: Aditya Mayur Taday
 * ID: 109550833
 * Recitation - R02
 * Grading TA Name: Aynoor Saleem
 * <p>
 * This is the Driver class for decision tree simulation .
 * <p>
 * The user has various options that they can carry out in this simulation.
 * The user must load a tree from a file first. Once the tree is loaded
 * then the user can carry out a help session or see the preorder traversal.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class TreeDriver {

    public static void main(String[] args) {

        //local variables
        Scanner input = new Scanner(System.in);
        String choice = new String();

        //Instantiating tree object
        Tree tree = new Tree();

        do {
            try {

                //options
                System.out.printf("L) Load a Tree\n");
                System.out.printf("H) Begin a Help Session\n");
                System.out.printf("T) Traverse the tree in preorder\n");
                System.out.printf("Q) Quit\n\n");

                System.out.printf("Select an Operation: ");
                choice = input.nextLine();

                if (choice.equalsIgnoreCase("L")) {
                    String line;


                    System.out.print("Please enter a File name: ");
                    String fileName = input.nextLine();

                    // Reading file
                    BufferedReader reader = new BufferedReader(new FileReader(fileName));

                    String label = reader.readLine().trim();
                    String prompt = reader.readLine().trim();
                    String message = reader.readLine().trim();

                    tree.addNode(label, prompt, message, label);

                    while ((line = reader.readLine()) != null) {
                        String[] split = line.split(" ");
                        String parentLabel = split[0];

                        for (int i = 0; i < Integer.parseInt(split[1]); i++) {
                            label = reader.readLine().trim();
                            prompt = reader.readLine().trim();
                            message = reader.readLine().trim();
                            tree.addNode(label, prompt, message, parentLabel);

                        }

                    }

                    // closing file
                    reader.close();

                    System.out.println("\nTree created successfully!");

                } else if (choice.equalsIgnoreCase("T")) {
                    tree.preOrder();
                } else if (choice.equalsIgnoreCase("H")) {
                    tree.beginSession();
                }


                System.out.println();

            } catch (Exception e) {
                //catching all exceptions
                System.out.println(e.getMessage());
                System.out.println();
            }

        } while (!choice.equalsIgnoreCase("Q"));

        System.out.println("Thank you for using our automated help services!");
        System.exit(0);

    }

}

