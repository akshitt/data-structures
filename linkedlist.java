
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

class linkedlist
{
    class Node
    {
        public int data;
        public Node nextnode;

        public Node(int d)
        {
        	data = d;
        }
        public int shownode()
        {
        	return data;
        }
    }
        
        


    class Slist
    {

    	public Node first;

    	public Slist()
    	{
    		first=null;
    	}

    	public void insert(int data) {
            Node link = new Node(data);
            if(first==null)
            {
           link.nextnode = first;
    	    first = link;    	
            }
            
            else {
            Node currentLink = first;
           
           if(link.shownode()<first.shownode())
           {
            link.nextnode = first;
            first = link;       
           }     
           

        else{
            while(currentLink!=null) {
                

                if (currentLink.nextnode!=null && link.shownode()>currentLink.nextnode.shownode())
                	currentLink = currentLink.nextnode;
                else 
                	break;
            }
            if(currentLink.nextnode!=null && link.shownode()!=currentLink.nextnode.shownode() && link.shownode()!=currentLink.shownode())        
            {
            Node p = currentLink; 
            link.nextnode=currentLink.nextnode;
            currentLink.nextnode = link;}
            else if (currentLink.nextnode==null) {
                currentLink.nextnode = link;
                link.nextnode=null;
            }
        }}
    	    
        }	
    	    
         public void printlist() {
            Node abc = first;
            if (abc==null)
            	System.out.println(-1);
            while(abc!= null) {
            
                System.out.println(abc.shownode());
                abc = abc.nextnode;
            }
           
            
        	
        }
    }


    public static void main (String[] args) throws IOException
    {
        Reader.init(System.in);
    }
}