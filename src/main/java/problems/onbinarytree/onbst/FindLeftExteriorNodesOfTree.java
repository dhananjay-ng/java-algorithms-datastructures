package problems.onbinarytree.onbst;

import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class FindLeftExteriorNodesOfTree {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();                 // Reading input from STDINbs
        while (t-- > 0) {
            int n = s.nextInt();                 // Reading input from STDINbs
            websites.he.tree.BST<Integer> bst = new websites.he.tree.BST<>();
            for (int i = 0; i < n; i++) {
                bst.add(s.nextInt());
            }
            System.out.println(bst.findLeftExteriorNodes());

        }
    }

    }

