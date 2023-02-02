import java.io.IOException;
import java.io.PrintStream;
import java.io.File;
import java.util.Scanner;

public class questionTreeTester
{
    QuestionNode overallRoot;
    Scanner reader;
    public static void main(String[] args) throws IOException{
        questionTreeTester tester = new questionTreeTester();
        BinaryTreePrinter printer = new BinaryTreePrinter();

        Scanner file = new Scanner(new File("spec-questions.txt"));
        printer.printPreOrder(System.out, tester.treeMaker(file)); 
    }

    public QuestionNode treeMaker(Scanner input) 
    {
        //Paste your QuestionGame constructor code here and return your overall Root once the tree is made.
        overallRoot = new QuestionNode(input.nextLine());
        reader = input;

        return overallRoot;
    }
}
class QuestionNode
{
    //Paste your QuestionNode code here
        /* My code is assuming nodes have data, left and right */
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

class BinaryTreePrinter {

    public BinaryTreePrinter() {}
    
    //Assumes your nodes have data, left and right
	private String traversePreOrder(QuestionNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        
        String pointerRight ="[R]--";
        String pointerLeft = (root.right != null) ? "[L]--" : "[L]--";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }
    private void traverseNodes(StringBuilder sb, String padding, String pointer, QuestionNode node, boolean hasRightSibling) {

        if (node != null) {

            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("|    ");
            } else {
                paddingBuilder.append("     ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "[R]--";
            String pointerLeft = (node.right != null) ? "[L]--" : "[L]--";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);

        }

    }

    public void printPreOrder(PrintStream os, QuestionNode overallRoot) {
        os.print(traversePreOrder(overallRoot));
    }


}