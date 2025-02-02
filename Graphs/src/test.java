import java.util.Arrays;

public class test {

	static long arrayManipulation(int n, int[][] queries) {
        int [] values = new int[n+1];
        Arrays.fill(values, 0);
        for (int query[] : queries) {
            int i = query[0], j = query[1], k = query[2];
            values[i] += k;
            if ((j+1) <= n)
                values[j+1] -= k;
        }
        long acc = 0, max = 0;
        for (int i = 1; i <=n; i++) {
            acc += values[i];
            if (max < acc)
                max = acc;
        }
        return max;
    }

    public static void main(String[] args) {
        int [][][] queries = {
            {{1,5,3}, 
             {4,8,7},
             {6,9,1}}
            
            ,{{1,2,100}, {2,5,100}, {3,4,100}}
            ,{{1,2,3}}
            ,{{1,2,3},
              {2,3,4}}
        };
        //System.out.println(arrayManipulation(10, queries[0]));
        //System.out.println(arrayManipulation(5, queries[1]));
        //System.out.println(arrayManipulation(5, queries[2]));
        System.out.println(arrayManipulation(5, queries[3]));
    }
    
}
