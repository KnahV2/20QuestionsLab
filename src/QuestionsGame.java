//Hank Henning and Alexis Rambaran
//Watson
//1/31/23
//20 Questions Lab

import java.util.*;
import java.io.*;

public class QuestionsGame {
<<<<<<< Updated upstream
    // This tree will hold questions and answers throughout the game
    QuestionNode overallRoot;
=======
    // Your code here
    private QuestionNode overallRoot;
    private Scanner reader;
>>>>>>> Stashed changes

    //This constructer with a parameter will initialize the tree with the parameter as a single leaf node 
    public QuestionsGame(String object)
    {
        overallRoot = new QuestionNode(object);

    }

    public QuestionsGame(Scanner input)
    {

        overallRoot = new QuestionNode(input.next());
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

    public void play()
    {
<<<<<<< Updated upstream
        
=======
        overallRoot = play(overallRoot);
    }

    private QuestionNode play(QuestionNode currentSpot)
    {
        if(isAnswer(currentSpot))
        {
            if(yesTo("Is your thing " + currentSpot.data + "?"))
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
                currentSpot.left = play(currentSpot.left);
            }
            else
            {
                currentSpot.right = play(currentSpot.right);
            }
        }
        return null;
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
>>>>>>> Stashed changes
    }

    private boolean isAnswer(QuestionNode node)
    {
        return (node.left == null || node.right == null);
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



    private static class QuestionNode {
        // Your code here
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
