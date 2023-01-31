// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

import java.util.*;

public class QuestionsGame {
    // Your code here
    public QuestionsGame(String object)
    {

    }

    public QuestionsGame(Scanner input)
    {

    }

    public void saveQuestions(PrintStream output)
    {

    }

    public void play()
    {

    }

    private static class QuestionNode {
        // Your code here
        int data;
        QuestionNode left;
        QuestionNode right;

        public QuestionNode(int data)
        {
            this(data, null, null);
        }

        public QuestionNode(int data, QuestionNode left, QuestionNode right)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
