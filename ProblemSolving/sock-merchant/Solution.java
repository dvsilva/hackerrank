import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {


    private static final Scanner scanner = new Scanner(System.in);

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int pairs = 0;

        // order array by using buble sort
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - 1; j++) {
                if(ar[j] > ar[j + 1]){
                    int aux = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = aux;
                }
            }
        }

        // compare elements
        for (int i = 1; i < n; i++) {
            //if encontered
            if(ar[i - 1] == ar[i]){
                pairs += 1; // increment pairs               
                i += 1; //  pass one more
            }
        }

       return pairs;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
