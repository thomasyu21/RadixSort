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

  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < 10; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int mostDigits = 0;
    for (int i = 0; i < data.size(); i++){
       mostDigits = Math.max(length(data.get(i)), mostDigits);
    }
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new SortableLinkedList();
    }
    int size = data.size();
    for (int i = 0; i < mostDigits; i++){
      for (int j = 0; j < size; j++){
        int temp = data.remove(0);
        buckets[nth(temp, i)].add(temp);
      }
      merge(data, buckets);
    }
  }

  public static void radixSort(SortableLinkedList data){
    int dataLength = data.size();
    SortableLinkedList positive = new SortableLinkedList();
    SortableLinkedList negative = new SortableLinkedList();
    for (int i = 0; i < dataLength; i++){
      int temp = data.remove(0);
      if (temp >= 0){
        positive.add(temp);
      }else{
        negative.add(temp);
      }
    }
    radixSortSimple(negative);
    int negativeLength = negative.size();
    for (int i = 0; i < negativeLength; i++){
      data.add(negative.remove(negative.size()-1));
    }
    radixSortSimple(positive);
    data.extend(positive);
  }
}
