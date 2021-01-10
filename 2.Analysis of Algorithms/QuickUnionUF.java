package Chapter01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class QuickUnionUF {
    private int[] parent; //parent of i
    private int count; //number of components

    /**
     * Initialize an empty union-find data structure with n elements
     * 0 through n-1
     * @param n
     */
    public QuickUnionUF(int n){
        parent = new int[n];
        count = n;
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int count(){
        return count;
    }

    /**
     * Return the canonical element of the set containing element p
     * @param p
     * @return
     */

    public int find(int p){
        validate(p);
        while(p!=parent[p]){
            p = parent[p];
        }
        return p;
    }

    /**
     * validate that p is a valid index
     * @param p
     */
    private void validate(int p){
        int n= parent.length;
        if(p<0||p>=n){
            throw new IllegalArgumentException("index"+p+"is not between 0 and"+(n-1));
        }
    }

    /**
     * Return true if the two elements are in the same set
     */

    public boolean connected(int p,int q){
        return find(p)==find(q);
    }

    /**
     * merge the set containg the element
     */

    public void union(int p,int q){
       int rootP = find(p);
       int rootQ = find(q);
       if(rootP==rootQ) return;
       parent[rootP] = rootQ;
       count--;
    }

    public static void main(String[] args) {
        QuickUnionUF uf = null;

        try {
            BufferedReader bf = new BufferedReader(new FileReader(args[0]));
            String str = bf.readLine();
            int n = Integer.parseInt(str);
            uf = new QuickUnionUF(n);

            while ( (str=bf.readLine())!=null){
                String[] value = str.split(" ");
                int p = Integer.parseInt(value[0]);
                int q = Integer.parseInt(value[1]);

                if(uf.find(p)==uf.find(q)){
                    continue;
                }

                uf.union(p,q);
                StdOut.printf(p+" "+q);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }


}
