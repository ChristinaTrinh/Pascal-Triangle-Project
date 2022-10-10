import java.util.Scanner;
import java.util.*;
public class PascalTriangle
{
    public static void main (String[]args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of rows");
        n=sc.nextInt();
        pascal1(n);
        pascal2(n);
        pascal3(n);
        pascal4(n);
    }
    
    public static void print234(int[][]array)
    {
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[i].length; j++)
            {
                 System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void pascal1(int n)
    {
        System.out.println("Pascal Triangle 1");
        int [][]array= new int[n][2*n-1];
        array[0][n-1]=1;
        int r=1; 
        while(r<array.length)
        {
            if((r%2!=0 && n%2!=0) || (r%2==0 && n%2==0))
            {
                for(int c=0; c<=array[0].length-3; c+=2)
                {
                    array[r][c+1]=array[r-1][c]+array[r-1][c+2];
                }
                r++;
            }
            else if((r%2==0 && n%2!=0) || (r%2!=0 && n%2==0))
            {
                for(int c=1; c<=array[0].length-4; c+=2)
                {
                    array[r][c+1]=array[r-1][c]+array[r-1][c+2];
                }
                r++;
            }
        }
        array[array.length-1][0]=1;
        array[array.length-1][array[0].length-1]=1;
        
        printPascal1(array);
    }
    
    public static void printPascal1(int[][]array)
    {
        for(int i=0; i<array.length; i++)
        {
            for(int j=0; j<array[i].length; j++)
            {
                if(array[i][j]==0)
                 System.out.print(" ");
                else
                 System.out.print(array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void pascal2(int n)
    {
        System.out.println("Pascal Triangle 2");
        int[][]array= new int[n][];
        for(int i=0; i<array.length; i++)
        {
            array[i]=new int[i+1];
            array[i][0]=1;
            array[i][i]=1;
            for(int j=1; j<array[i].length-1; j++)
            {
                array[i][j]=array[i-1][j-1]+array[i-1][j];
            }
        }
        print234(array);
        printPascal2(array, n);
    }
    
    public static void printPascal2(int[][]array, int n)
    {
        int space=0;
        int position= n-1; // set the starting position in the middle 
        int count=-1;
        for(int i=0; i<array.length;i++)
        {
             if(i>0)  //make sure position doesn't change for the first loop
             {
               count+=2;
               if(array[i].length>1)
                space= count/(array[i].length-1);//original: (array[i].length-2)+1 bc I minus the 2 outer numbers to get the number of values we have inside & then +1(just a pattern) 
               position--;
             }
             for(int z=1; z<= position; z++) //print the spaces that is needed, the pattern is that after each row, there will be 1 less space
                    System.out.print(" ");  
            System.out.print(array[i][0]);
             for(int j=1; j<array[i].length;j++) //after printing all the spaces, we print the values that is stored in the array
             {
                for(int h=1; h<=space; h++)
                    System.out.print(" ");
                System.out.print(array[i][j]);
             }
             System.out.println();
        }    
        System.out.println();
    }
    
    public static void pascal3(int n)
    {
        System.out.println("Pascal Triangle 3");
        int[][]array= new int[n][];
        array[0]=new int[1];
        array[0][0]=1; //for all n
        if(n>1) //for n greater than 1 bc we don't want to construct second row if n=1
        array[1]=new int[2];
        if(n>2) //for n greater than 2 bc we don't want to construct anything in third row if n<=2
        {
        array[2]=new int[2];
        for(int i=1; i<=2; i++)
            array[i][0]=1;
        array[1][1]=1;
        array[2][1]=2;
        }
        else if(n==2) //for n =2 because we will need to specify the values to 1
        {
        array[1][0]=1;
        array[1][1]=1;
        }
        
        for(int i=3; i<array.length;i++)
        {
         if((i-1)%2==0) //previous row is even
         {
            array[i]=new int[array[i-1].length]; 
            array[i][0]=1;
            for(int j=1; j<array[i].length; j++)
              array[i][j]= array[i-1][j-1]+array[i-1][j];
         }
        
         else if((i-1)%2!=0) //previos row is odd
         {
            array[i]=new int[array[i-1].length+1];
            array[i][0]=1;
            for(int j=1; j<array[i].length-1; j++)
                  array[i][j]= array[i-1][j-1]+array[i-1][j];
            array[i][array[i].length-1]= 2*(array[i-1][array[i].length-2]);
         }
        }
        print234(array);
        printPascal3(array,n);
    }
    
    public static void printPascal3(int[][]array, int n)
    {
        int position= n-1;  // set the starting position in the middle
        for(int i=0; i<array.length;i++)
        {
             if(i>0)  //make sure position doesn't change for the first loop
               position--;
             
             for(int z=1; z<= position; z++) //print the spaces that is needed, the pattern is that after each row, there will be 1 less space
                    System.out.print(" ");  
                
             for(int j=0; j<array[i].length; j++)
             {
                 System.out.print(array[i][j]+" ");
                 if(n>2 && i>1 && j==array[i].length-1 && i%2==0)
                 {
                     for(int k=j-1; k>=0; k--)
                       System.out.print(array[i][k]+" ");
                 }
                 else if(n>2 && i>1 && j==array[i].length-1 && i%2!=0)
                 {
                     for(int k=j; k>=0; k--)
                       System.out.print(array[i][k]+" ");
                 }
             }
             System.out.println();
        }    
        System.out.println();
    }
    
    public static void pascal4(int n)
    {
        System.out.println("Pascal Triangle 4");
        if(n>2)
        {
        int[][]array=new int[n-2][];
        array[0]=new int[1];
        array[0][0]=2;
        for(int i=1; i<array.length; i++)
        {
            if((i-1)%2==0) //previous row is even
            {
                array[i]=new int[array[i-1].length];
                array[i][0]=array[i-1][0]+1;
                for(int j=1; j<array[i].length;j++)
                {
                    array[i][j]=array[i-1][j]+array[i-1][j-1];
                }
            }
            else if((i-1)%2!=0) //previous row is odd
            {
                array[i]= new int[array[i-1].length+1];
                array[i][0]=array[i-1][0]+1;
                for(int j=1; j<array[i].length-1;j++)
                     array[i][j]=array[i-1][j]+array[i-1][j-1];
                array[i][array[i].length-1]=2*(array[i-1][array[i-1].length-1]);  
            }
        }
        print234(array);
        printPascal4(array,n);
        }
        else
        {
            System.out.println("No values for first output form");
            if(n==1)
            System.out.println("1");
            else if(n==2)
            System.out.println(" 1\n1 1");
        }
    }
    
    public static void printPascal4(int[][]array, int n)
    {
        int position= n-3;  
        int count=-1;
        for(int z=1; z<=n-1; z++)
              System.out.print(" ");
         System.out.println("1");
        for(int z=1; z<=n-2; z++)
            System.out.print(" ");
         System.out.println("1 1");
        for(int i=0; i<array.length;i++)
        {
             if(i>0)  //make sure position doesn't change for the first loop
               position--;
             for(int z=1; z<= position; z++) //print the spaces that is needed, the pattern is that after each row, there will be 1 less space
                    System.out.print(" ");  
             System.out.print("1 ");
             for(int j=0; j<array[i].length; j++)
             {
                 System.out.print(array[i][j]+" ");
                 if(n>2 && j==array[i].length-1 && i%2==0)
                 {
                     for(int k=j-1; k>=0; k--)
                       System.out.print(array[i][k]+" ");
                 }
                 else if(n>2 && j==array[i].length-1 && i%2!=0)
                 {
                     for(int k=j; k>=0; k--)
                       System.out.print(array[i][k]+" ");
                 }
             }
             System.out.println("1");
        }    
        System.out.println();
    }
        
    }

