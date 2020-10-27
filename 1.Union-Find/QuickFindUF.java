package Chapter01;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class QuickFindUF {

    private int[] id;
    private int count;


    /**
     *
     * @param n the number of elements
     */
     public QuickFindUF(int n){
         count = n;
         id = new int[n];
         for(int i=0;i<n;i++){
            id[i] = i;
         }
     }

     public int count(){
        return count;
     }

    /**
     * return the canonical element of the set containing element.
     * @param p
     * @return
     */
     public int find(int p){
         validate(p);
         return id[p];
     }

     //validate that p is a valid index
     private void validate(int p ){
         int n = id.length;
         if(p<0||p>=n){
             throw new IllegalArgumentException("index"+ p + "is not between 0"+(n-1));
         }
     }

    /**
     * return true if the two elements are in the same set
     */

    public boolean connected(int p, int q){
        validate(p);
        validate(q);
        return id[p]==id[q];
    }

    public void union(int p, int q){
        validate(p);
        validate(q);
        int pId = id[p];
        int qId = id[q];

        if(pId==qId) return;
        for(int i=0;i<id.length;i++){
            if(id[i]==pId) id[i] = qId;
        }
        count--;
    }



    public static void main(String[] args){
        QuickFindUF uf = null;
        //编写一个可以读取文件的流程
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/liuhongyang/Desktop/tinyUF.txt"));
            String str = bufferedReader.readLine();
            int n = Integer.parseInt(str);
            uf = new QuickFindUF(n);

            while((str=bufferedReader.readLine())!=null ){


                String[] value = str.split(" ");
                int p = Integer.parseInt(value[0]);
                int q =  Integer.parseInt(value[1]);

                if(uf.find(p)==uf.find(q)){
                    continue;
                }

                uf.union(p,q);
                StdOut.println(p+ " "+q );
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            StdOut.println(uf.count()+"components");
        }





    }
}
