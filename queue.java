
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

class queu
{
	static class node
	{
		int data;
		node next;
		node prev;
		node(int d)
		{
			data = d;
		}

		public int val()
		{
			return data;
		}
	}

	static class queue
	{
		node front=null;
		node rear=front;

		public void enqueue(int d)
		{
			node a = new node(d);
			if(front==null)
			{
				front=a;
				rear=a;
				front.next=rear;
				rear.prev=front;
			}
			else
			{
				node b= rear;
				rear.next=a;
				rear=a;
				rear.prev = b;
			}	
		}

		public int dequeue()
		{
			if(front==null)
				return 0;
			else
			{	
				node d = front;
				node c = front.next;
				front = c;
				front.prev=null;
				return d.data;
			}
		}

		public int fr()
		{
			return front.data;
		}
	}

    public static void main (String[] args) throws IOException
    {
        Reader.init(System.in);
        queue a = new queue();
		a.enqueue(12); 
		a.enqueue(11);
		a.enqueue(10);
		System.out.println(a.dequeue());
		System.out.println(a.fr());
		
		
		 
    }
}