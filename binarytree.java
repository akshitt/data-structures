
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

class binarytree{
    
	static class Node 
	{
    
    int data;
    Node left;
    Node right;

    public Node(int d)
    {
    	data = d;
    	left=null;
    	right=null;
    }

	}

	static void inOrder(Node a) 
	{
		if(a!= null)

		{
			inOrder(a.left);
			System.out.println(a.data+" ");
			inOrder(a.right);
		}
	}

	static void preOrder(Node a) 
	{
		if(a!= null)

		{
			System.out.println(a.data+" ");
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
			System.out.println(a.data+" ");
		}
	}

	static public int count (Node root) 
	{
		if (root==null)
			return 0;
		else
			return 1 + count (root.left) + count (root.right);
	}

	static public int height (Node root)
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

	static Node bstsearch(Node root,int val)
	{
		Node a = root;

		while(a!=null)
		{
		if (a.data == val)
			return a;
		else if (a.data > val) 
		{
			return bstsearch(a.left,val);  	
		}  

		else
			return bstsearch(a.right,val);
		}

		return null;
	}

	public static Node bstinsert (Node root, int value)
	{
	
	if (root == null)
		root = new Node (value);
	else {
	if (value < root.data)
		root.left = bstinsert (root.left, value);
	else
		root.right = bstinsert (root.right, value);
	}
	
	return root;
	}
	
	public static Node bstmin(Node root)
	{
		if(root.left!=null)
			return bstmax(root.left);
		else
			return root;
	}

	public static Node bstdelete(Node root,int value)
	{
		Node del = bstsearch(root,value);

		Node minsub = bstmax(del.right);

		del.data = maxsub.data;

		
		return root;
	}

	

    public static void main (String[] args) throws IOException
    {
        Node n = new Node(4);
        n.left = new Node(3);
        n.left.left= new Node(1);
        n.right= new Node(5) ;
        
        bstdelete(n,3);
        // System.out.println(height(n));
        inOrder(n);
    }
}