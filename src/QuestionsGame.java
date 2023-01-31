//Hank Henning
//Watson
//1/31/23
//20 Questions Lab
import java.util.*;
import java.io.*;

import java.util.*;

public class QuestionsGame {
    // Your code here
    QuestionNode overallRoot;

    public QuestionsGame(String object)
    {
        overallRoot = new QuestionNode(object);
    }

    public QuestionsGame(Scanner input)
    {

    }

    public void saveQuestions(PrintStream output)
    {
        if(output == null)
        {
            throw new IllegalArgumentException();
        }
    }

    public void play()
    {

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
