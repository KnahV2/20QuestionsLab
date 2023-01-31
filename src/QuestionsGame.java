// This is a starter file for QuestionsGame.
//
// You should delete this comment and replace it with your class
// header comment.

public class QuestionsGame {
    // Your code here
<<<<<<< HEAD
    
    public QuestionsGame(String object)
    {

    }
=======
    System.out.println("hi");
>>>>>>> 3166d32f812ec2c36a7aac8daee9139d67ca36d9

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
