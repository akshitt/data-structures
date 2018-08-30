
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

class Main
{
	static class stack
    {
    	int[] a;
    	int top;
    	int size;

    	public stack()
    	{
    		a = new int[10^5];
    		top = -1;
    		size = 0;
    	}

    	public int push(int val)
    	{
    	
    		top+=1;
    		a[top]=val;
    		return val;
    	}
    		
    	public String pop()
    	{
    		if(top>0)
    		{
    			top-=1;
    			return Integer.toString(a[top]);
    		}
    		else	
    		{
    			top=-1;
    			return "EMPTY";
    		}

    	} 

    	public String inc(int x,int d)
    	{
    		for(int i=0;i<x;i++)
    		{
    			a[i]+=d;
    		}
    		if(top>=0)
    		{
    			return Integer.toString(a[top]);
    		}
    		else
    			return "EMPTY";	
    	}
 		

    }

    public static void main (String[] args) throws IOException
    {
        Reader.init(System.in);
    }
}