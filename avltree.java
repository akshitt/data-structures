
import java.util.*;
import java.lang.*;
import java.io.*;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class avltree
{
    static class Node
    {
        long data;
        Node left;
        Node right;
        
        Node(long data)
        {
            this.data = data;
            left=null;
            right=null;
        }

        Node()
        {
            this.data = 0;
            left=null;
            right=null;
        } 
    }

    static void inOrder(Node a) 
    {
        if(a!= null)

        {
            inOrder(a.left);
            System.out.print(a.data+" ");
            inOrder(a.right);
        }
    }

    static void preOrder(Node a) 
    {
        if(a!= null)

        {
            System.out.print(a.data+" ");
            preOrder(a.left);
            preOrder(a.right);
        }
    }

    static void postOrder(Node a) 
    {
        if(a!= null)

        {
            postOrder(a.left);
            postOrder(a.right);
            System.out.print(a.data+" ");
        }
    }

    static public int count (Node root) 
    {
        if (root==null)
            return 0;
        else
            return 1 + count (root.left) + count (root.right);
    }

    static public int height (buildNode root)
    {
        if (root==null)
            return 0;
        else
        {
            int l = height(root.left);
            int r = height(root.right);
            int max;
        if(l>r)
            max=l;
        else
            max=r;
        return max+1;

        }   
    }


    static Node rotateLeft(Node n) {
        Node r = n.right;
        n.right = r.left;
        r.left = n;
        n.ht = Math.max(height(n.left), height(n.right));
        r.ht = Math.max(height(r.left), height(r.right));
        return r;
    }

    static Node rotateRight(Node n) {
        Node r = n.left;
        n.left = r.right;
        r.right = n;
        n.ht = Math.max(height(n.left), height(n.right));
        r.ht = Math.max(height(r.left), height(r.right));
        return r;
    }

    static int leftRightDiff(Node node) {
        if(node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

     static Node insert(Node root,int val)
    {
        if(root == null) {
            return buildNode(val);
        }
        if(root.val < val) { // Insert on right
            root.right = insert(root.right, val);
        } else { // Insert on left
            root.left =  insert(root.left, val);
        }
        root.ht = Math.max(height(root.left), height(root.right));
        int heightDiff = leftRightDiff(root);
        if(heightDiff < -1) {
            if (leftRightDiff(root.right) > 0) {
                root.right = rotateRight(root.right);
            }
            return rotateLeft(root);
        } else if (heightDiff > 1) {
            if(leftRightDiff(root.left) < 0) {
                root.left = rotateLeft(root.left);
            }
            return rotateRight(root);
        }
        return root;
    }



    static Node buildNode(int val) {
        Node node = new Node();
        node.val = val;
        node.ht = 0;
        return node;
    }

    static Node avlsearch(Node root,long val)
    {
        Node a = root;

        while(a!=null)
        {
        if (a.data == val)
            return a;
        else if (a.data > val) 
        {
            return avlsearch(a.left,val);   
        }  

        else
            return avlsearch(a.right,val);
        }

        return null;
    }

    
    public static void main (String[] args) throws IOException
    {
        Reader.init(System.in);
        buildNode n = new buildNode(1);
        n = insert(n,2);
        n = insert(n,3);        
        n = insert(n,4);        
        n = insert(n,5);        
        // n = avldelete(n,1);
        inOrder(n);
        System.out.println();
        preOrder(n);
    }
}