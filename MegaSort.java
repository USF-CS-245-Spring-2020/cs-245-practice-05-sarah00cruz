import java.util.*;
import java.io.*;

public class MegaSort {
    public static void megaSort(int[] arr){
    	//create arr, size of original arr + copy everything + sorts everything
        int[] finalArr = new int[findMax(arr) + 1];
        for(int i=0; i<arr.length; i++){
            finalArr[arr[i]] += 1;
        }
        int counter = 0;
        for(int j = 0; j < finalArr.length; j++){
            while(finalArr[j] > 0){
                arr[counter++] = j;
                finalArr[j] -= 1;
            }
        }
    }
	//find max to input in temporary arr
    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }return max;
    }
    public static void main(String[] args) throws FileNotFoundException{
        //gets file and initializes array
        int[] arr = new int[1000000];
        File infile = new File("1m-ints.txt");
        Scanner scanner = new Scanner(infile);
        int i = 0;
        //makes str into int
        while(scanner.hasNextLine()){
            String str = scanner.nextLine();
            int nums = Integer.parseInt(str);
            //puts all integers into int array
            arr[i++] = nums;
        }
        megaSort(arr);
        //outputs everything to terminal
        for(int j = 0; j < arr.length; j++){
            System.out.println(arr[j]);
        }
    }

}
