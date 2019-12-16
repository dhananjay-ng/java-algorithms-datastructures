package websites.he;
import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\main\\java\\testingsystem\\misccode\\input.txt"));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[N-1][2];
            for(int i_edges=0; i_edges<N-1; i_edges++)
            {
                String[] arr_edges = br.readLine().split(" ");
                for(int j_edges=0; j_edges<arr_edges.length; j_edges++)
                {
                    edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
                }
            }

            int[] out_ = solve(edges,N);
            for(int i_out_=0; i_out_<out_.length; i_out_++)
            {
                System.out.print(out_[i_out_] + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }
    static class TreeNode {
        public int val;
        public int noParent;
        public int noChild;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

    }
    static int[] solve(int[][] edges, int N){
        TreeNode root = new TreeNode(1);
        HashMap<Integer, TreeNode> nodes = new HashMap<>();
        nodes.put(1, root);
        root.noParent=0;
        for(int i=0;i<edges.length;i++) {
            TreeNode from = nodes.get(edges[i][0]);
            TreeNode to = nodes.get(edges[i][1]);
            if(!nodes.containsKey(edges[i][0])){
                nodes.put(edges[i][0], new TreeNode(edges[i][0]));
                from = nodes.get(edges[i][0]);
            }
            if(!nodes.containsKey(edges[i][1])){
                nodes.put(edges[i][1], new TreeNode(edges[i][1]));
                to = nodes.get(edges[i][1]);
            }
            if(from.left == null) {
                from.left = to;
                to.noParent = from.noParent+1;
            }
            else{
                from.right = to;
                to.noParent = from.noParent+1;
            }
        }
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 0;
        dfs(root,res);
        return res;
    }

    private static int dfs(TreeNode root, int[] res) {
        if (root == null || root.left == null || root.right == null) return 0;
        int left = dfs(root.left, res) + 1 ;
        int right = dfs(root.right, res) + 1;
        root.noChild = Math.max(left, right);
        int radius = Math.min(root.noParent, root.noChild);
        if ((radius > res[1]) || (radius == res[1] && res[0] > root.val)) {
            res[1]= radius;
            res[0] = root.val;
        }
        return root.noChild;
    }
}