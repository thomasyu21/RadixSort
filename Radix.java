public class Radix{
  public static int nth(int n, int col){
    int temp = n / (int)Math.pow(10, col);
    return Math.abs(temp%10);
  }

  public static int length(int n){
    if (n == 0){
      return 1;
    }
    int count = 0;
    while (n != 0){
      n = n / 10;
      count++;
    }
    return count;
  }

  public static void merge(MyLinkedList original,MyLinkedList[]buckets){
    for (int i = 0; i < 10; i++){
      original.extend(buckets[i]);
    }
  }
}
