public class Tester{
  public static void main(String[] args){
    System.out.println(Radix.nth(12345, 0));
    System.out.println(Radix.nth(12345, 1));
    System.out.println(Radix.nth(12345, 2));
    System.out.println(Radix.nth(12345, 3));
    System.out.println(Radix.nth(12345, 4));
    System.out.println(Radix.nth(-78345, 3));
    System.out.println(Radix.nth(-78345, 4));
    System.out.println(Radix.nth(10, 0));
    System.out.println();

    System.out.println(Radix.length(12345));
    System.out.println(Radix.length(0));
    System.out.println(Radix.length(10));
    System.out.println(Radix.length(1));
    System.out.println(Radix.length(-12345));
    System.out.println(Radix.length(-0));
    System.out.println(Radix.length(-10));
    System.out.println();

/*
    MyLinkedList[]list = new MyLinkedList[10];
    for (int i = 0; i < list.length; i++){
      list[i] = new MyLinkedList();
    }

    list[0].add("test");
    list[3].add("test3");
    list[4].add("test4");
    list[7].add("test7");
    list[7].add("test7.0");
    list[9].add("test9");

    MyLinkedList list2 = new MyLinkedList();

    Radix.merge(list2, list);
    System.out.println(list2.toString());
    */

    SortableLinkedList test = new SortableLinkedList();
    for (int i = 0; i < 100; i++){
      int temp = (int)(Math.random() * (int)Math.pow(10, (int)(Math.random()*10)));
      if (Radix.length(temp) <= 3){
        test.add(temp);
      }
    }
    System.out.println(test.toString());
    Radix.radixSortSimple(test);
    System.out.println(test.toString());

    SortableLinkedList test1 = new SortableLinkedList();
    for (int i = 0; i < 100; i++){
      int temp = (int)(Math.random() * (int)Math.pow(10, (int)(Math.random()*10)));
      if (Radix.length(temp) <= 3){
        test1.add(temp);
      }
    }
    for (int i = 0; i < 100; i++){
      int temp = (int)(-1 * (Math.random() * (int)Math.pow(10, (int)(Math.random()*10))));
      if (Radix.length(temp) <= 3){
        test1.add(temp);
      }
    }
    System.out.println(test1.toString());
    Radix.radixSort(test1);
    System.out.println(test1.toString());
  }
}
