//Hank Henning and Alexis Rambaran
//Watson
//1/31/23
//20 Questions Lab: This lab will output to the user to answer y/n questions if not guessed by computer it will get smarter as one keeps playing

import java.util.*;
import java.io.*;

public class QuestionsGame {
    //This tree will hold questions and answers throughout the game
    QuestionNode overallRoot;
    //This scanner will hold the user's input
    Scanner reader;

    //This default constructor will fill in a starter answer for the tree
    public QuestionsGame()
    {
        overallRoot = new QuestionNode("computer");
        reader = new Scanner(System.in);
    }

    //This constructer with a parameter will initialize the tree with the parameter as a single leaf node and make initiate the scanner
    public QuestionsGame(String object)
    {
        overallRoot = new QuestionNode(object);
        reader = new Scanner(System.in);
    }

    //This constructor will take the input from the scanner and read the input from the scanner and make initiate the scanner
    public QuestionsGame(Scanner input)
    {
        read(input);
        reader = new Scanner(System.in);
    }

    //Will read each line in the scanner parameter and make it equal to the tree root/leaves
    public void read(Scanner input) {
        while(input.hasNextLine()) {
           overallRoot = readHelper(input); 
        }
     }
     // A helper method that reads entire lines of input to construct a tree based on a file. 
     private QuestionNode readHelper(Scanner input) {
        String type = input.nextLine();
        String data = input.nextLine();
        QuestionNode root = new QuestionNode(data);  
    
        if (type.contains("Q:")) {
           root.left = readHelper(input);
           root.right = readHelper(input);   
        }
        return root; 
     }

    public void saveQuestions(PrintStream output)
    {
        if(output == null)
        {
            throw new IllegalArgumentException();
        }
        saveQuestions(overallRoot, output);
    }

    private void saveQuestions(QuestionNode root, PrintStream output)
    {
        if(isAnswer(root))
        {
            output.println("A:");
            output.println(root.data);
        }
        else
        {
            output.println("Q:");
            output.println(root.data);
            saveQuestions(root.left, output);
            saveQuestions(root.right, output);
        }
    }

    public String readTree(){
        if(overallRoot == null) {
			return "No Tree";
		}
		return readTree(overallRoot);
	}
	
	private String readTree(QuestionNode root) {
		String total = "";
		
		if(root.left == null && root.right == null) {
			total = total + root.data + " ";
			return total;
		}
		
		else {
            total = total + root.data + " ";
            
			if(root.left != null) {
				total = total + readTree(root.left);
			}
			
			if(root.right != null) {
				total = total + readTree(root.right);
			}
		}
		
		return total;
    }

    public void play(Scanner file)
    {
        overallRoot = play(overallRoot, file);
    }

    private QuestionNode play(QuestionNode currentSpot, Scanner file)
    {

        if(isAnswer(currentSpot))
        {
            if(yesTo(currentSpot.data))
            {
                System.out.println("I got it right you suck xd");
            }
            else
            {
                System.out.println("What is your thing? ");
                QuestionNode answer = new QuestionNode(reader.nextLine());
                System.out.println("Give me a yes/no question that");
                System.out.println("distinguishes your thing from mine");
                String question = reader.nextLine();
                if(yesTo("And what is the answer for your thing"))
                {
                    currentSpot = new QuestionNode(question, answer, currentSpot);
                }
                else
                {
                    currentSpot = new QuestionNode(question, currentSpot, answer);
                }
            }
        }
        else
        {
            if(yesTo(currentSpot.data))
            {
                currentSpot.left = play(currentSpot.left, file);
            }
            else
            {
                currentSpot.right = play(currentSpot.right, file);
            }
        }
        return currentSpot;
    }

    public boolean yesTo(String prompt)
    {
        System.out.print(prompt + " (y/n)?");
        String response = reader.nextLine().trim().toLowerCase();
        while(!response.startsWith("y") && !response.startsWith("n"))
        {
            System.out.println("Please answer yes or no");
            System.out.println(prompt + " (y/n)? ");
            response = reader.nextLine().trim().toLowerCase();
        }
        return response.startsWith("y");
    }

    private boolean isAnswer(QuestionNode node)
    {
        return (node.left == null || node.right == null);
    }

    //Will create the nodes for the tree in order for the tree to have a left/right and data for each node
    public static class QuestionNode {
        public String data;
        public QuestionNode left;
        public QuestionNode right;

        public QuestionNode(String data)
        {
            this(data, null, null);
        }

        public QuestionNode(String data, QuestionNode left, QuestionNode right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
