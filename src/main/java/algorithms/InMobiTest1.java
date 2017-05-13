package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InMobiTest1 {

  public static void main(String[] args) {
    int N = 6;
    int P = 2;
    Scanner s = new Scanner(System.in);
    int array[] = new int[N];
    for (int i = 0; i < N; i++) {
      array[i] = s.nextInt();
    }
    System.out.println(getResult(array, P));
    s.close();
  }

  private static int getResult(int[] array, int P) {
    Arrays.sort(array);
    int[] difArray = new int[array.length - 1];
    for (int i = 0; i < array.length - 1; i++) {
      difArray[i] = array[i + 1] - array[i];
    }
    Arrays.sort(difArray);
    return difArray[P - 1];
  }
}
