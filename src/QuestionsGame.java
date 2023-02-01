//Hank Henning
//Watson
//1/31/23
//20 Questions Lab
import java.util.*;
import java.io.*;

public class QuestionsGame {
    // Your code here
    QuestionNode overallRoot;

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

    }

    private boolean isAnswer(QuestionNode node)
    {
        return (node.left == null || node.right == null);
    }

    private static class QuestionNode {
        // Your code here
        String data;
        QuestionNode left;
        QuestionNode right;

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
