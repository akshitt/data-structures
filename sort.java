
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

class sort
{
    static int[] mergesort(int[] a)
    {
        int n = a.length;
        int x = n/2;
        int y = n - n/2;
        int b[] = new int[x];
        int c[] = new int[y];

        for (int i=0;i<x ;i++ ) 
        {
            b[i]=a[i];
            // System.out.print(b[i]+" ");
        }
            // System.out.println();    
        for (int i=x;i<n;i++ ) 
        {
            c[i-x]=a[i];
            // System.out.print(c[i-x]+" ");
        }
            // System.out.println();    

        if(b.length>1 || c.length>1)
        {
            if(b.length>1)
                b = mergesort(b);
            if(c.length>1)   
                c = mergesort(c);
                        
            int i=0,j=0,k = 0;
            while (i < x && j < y)
            {
                if (b[i] <= c[j])
                {
                    a[k] = b[i];
                    i++;
                }
                else
                {
                    a[k] = c[j];
                    j++;
                }
                k++;
            }
            
            
            while (i < x)
            {
                a[k] = b[i];
                i++;
                k++;
            }
            
            
            while (j < y)
            {
                a[k] = c[j];
                j++;
                k++;
            }        

            return a;
        }

        else if(b.length==1 && c.length==1)
        {
            int[] d = new int[2];
            if(b[0]>c[0])
            {
                d[0]=c[0];
                d[1]=b[0];
            }
            else
            {
                d[0]=b[0];
                d[1]=c[0];
            }
            
            // System.out.println(d[0] + "d");            
            return d;
        }

        else if(b.length==0)
            return c;
        else
            return a;
    }
        
    static int[] quicksort(int[] arr,int low,int high)
    {
        System.out.println(high); 
        int pivot = arr[high];
        int i = (low-1); 
        for (int j=low; j<high; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
 
        if (low < i)
        {
            int pi = i+1;
    
            quicksort(arr, low, pi-1);
        }
        if(i+1<high)
            {
                int pi = i+1;
                        
                quicksort(arr, pi+1, high);
            }
        return arr;
    }
        

 
    public static void main (String[] args) throws IOException
    {
        Reader.init(System.in);
        int[] a = {3,8,1,2,5,2,4,11,14,0,56,23,17};
        int[] b = {3,8,1,2,5,2,4,11,14,0,56,23,17};
        
        a = (mergesort(a));
        b = quicksort(b,0,b.length-1);           
        for (int i=0;i<a.length;i++ ) 
        {
            System.out.print(b[i]+" ");    
        }

    }
 
}
    
    







 // int i = 0, j = 0;
 
     
        
    