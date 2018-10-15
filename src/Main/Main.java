package Main;

import MyArrayList.MyArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        for (int i = 0; i < 100; i++){
            list.add(i);
        }
        for (int i = 0; i < 100; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        Collection<Integer> collection = new MyArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            collection.add(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(((MyArrayList<Integer>) collection).get(i) + " ");
        }
        System.out.println();

        list.retainAll(collection);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
//        System.out.println(list.size());
//        System.out.println(list.contains(1));

//        Collection<Integer> col = new MyArrayList<>();
//        col.add(10);
//        col.add(26);
//        col.add(37);
//        col.add(41);
//        col.add(54);
//        for (int i = 0; i < col.size(); i++) {
//            System.out.print(((MyArrayList<Integer>) col).get(i) + " ");
//        }
//        System.out.println();

//        for (int i = 0; i < 5; i++) {
//            System.out.print(((MyArrayList<Integer>) collection).get(i) + " ");
//        }
//        System.out.println();
//        list.addAll(collection);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();

//        System.out.println(list.size());
//        list.addAll(col);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(list.get(i) + " ");
//        }
//        System.out.println();
//        System.out.println(list.containsAll(col));
//        System.out.println(list.isEmpty());
//        System.out.println(list.get(5));
//        list.add(null);
//        System.out.println(list.size());
//        list.remove(null);
//        list.remove("5");
//        list.remove(7);
//        System.out.println(list.size());
//        list.add(7, null);
//        System.out.println(list.get(7));
//        System.out.println(list.size());
//        list.remove(7);
//        System.out.println(list.size());
//        System.out.println(list.get(7));
//        Object[] newList = list.toArray();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(newList[i]+" ");
//        }
//        System.out.println();
//        Object newList2[] = new Object[list.size()];
//        newList2 = list.toArray(newList2);
//        for (int i = 0; i < list.size(); i++) {
//            System.out.print(newList2[i] + " ");
//        }
//        System.out.println();
//        list.clear();
//        System.out.println(list.size());
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//
//        }



    }
}
