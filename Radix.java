public class Radix{
  public static int nth(int n, int col){
    return Math.abs((n / (int)Math.pow(10, col))%10);
  }


  public static int length(int n){
    if (n == 0){
      return 1;
    }
    return (int)Math.log10(Math.abs(n)) + 1;
  }

  public static void merge(SortableLinkedList original, SortableLinkedList[]buckets){
    for (int i = 0; i < buckets.length; i++){
      original.extend(buckets[i]);
    }
  }

  public static void radixSortSimple(SortableLinkedList data){
    int mostDigits = 1;
    SortableLinkedList[]buckets = new SortableLinkedList[10];
    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new SortableLinkedList();
    }
    int size = data.size();
    for (int i = 0; i < mostDigits; i++){
      for (int j = 0; j < size; j++){
        int temp = data.remove(0);
        if (i == 0){
          mostDigits = Math.max(length(temp), mostDigits);
        }
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
