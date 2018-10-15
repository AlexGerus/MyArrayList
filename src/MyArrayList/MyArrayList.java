package MyArrayList;

import java.util.*;

public class MyArrayList<E> implements List<E> {

    private int INIT_SIZE = 16;
    private int counter = 0;
    private Object[] objArray = new Object[INIT_SIZE];

    @Override
    public int size() {
        return counter;
    }

    @Override
    public boolean isEmpty() {
        if (counter == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) throws ClassCastException, NullPointerException{
        if (o == null) {
            for(int i = 0; i < counter; i++){
                if (objArray[i] == null){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        else{
            for (int i = 0; i < counter; i++) {
                if (o.equals(objArray[i])){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return objArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length < counter){
            return (T[]) Arrays.copyOf(objArray, counter, a.getClass());
        }
        System.arraycopy(objArray, 0, a, 0, counter);
        if(a.length > counter){
            a[counter] = null;
        }
        return a;
    }

    @Override
    public boolean add(Object o){
        if (counter == INIT_SIZE - 1){
            INIT_SIZE*=2;
            Object[] newobjArray = new Object[INIT_SIZE];
            System.arraycopy(objArray, 0 , newobjArray, 0, counter);
            objArray = newobjArray;
        }
        objArray[counter++] = o;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if(o==null){
            for (int i = 0; i < counter; i++) {
                if (objArray[i] == null){
                    for (int j = i; j < counter; j++) {
                        objArray[j] = objArray[j+1];
                    }
                    break;
                }
            }
        }
        else{
            for (int i = 0; i < counter; i++) {
                if (o.equals(objArray[i])){
                    for (int j = i; j < counter; j++) {
                        objArray[j] = objArray[j+1];
                    }
                    break;
                }
            }
        }
        objArray[counter--] = null;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count = 0;
        Object[] newC = c.toArray();
        for (int i = 0; i < newC.length; i++) {
            for (int j = 0; j < counter; j++) {
                if (newC[i] == null){
                    if (objArray[j] == null){
                        count++;
                    }
                }

                else{
                    if(newC[i].equals(objArray[j])){
                        count++;
                    }

                }
            }
        }
        if (count == c.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c){
        Object[] tempArr = c.toArray();
        int length = tempArr.length;
        System.arraycopy(tempArr, 0, objArray, counter, length);
        counter+=length;
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        Object[] tempArr = c.toArray();
        int length = tempArr.length;
        if (index == 0){
            System.arraycopy(tempArr, 0, objArray, counter + length, length);
        }
        else{
            System.arraycopy(tempArr, index, objArray, counter + length, counter + length);
        }
        counter+=length;
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] tempArr = c.toArray();
        int count = 0;
        for (int i = 0; i < tempArr.length; i++) {
            for (int j = 0; j < counter; j++) {
                if (tempArr[i] == null) {
                    if (objArray[j] == null) {
                        for (int k = j; k < counter; k++) {
                            objArray[k] = objArray[k + 1];
                        }
                        count++;
                    }
                }
                else {
                    if (tempArr[i].equals(objArray[j])){
                        for (int k = j; k < counter; k++) {
                            objArray[k] = objArray[k + 1];
                        }
                        count++;
                    }
                }
            }
        }
        for (int i = 0; i < count; i++) {
            objArray[counter] = null;
            counter--;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int k = 0;
        for (int i = 0; i < counter; i++) {
            if (!c.contains(objArray[i])){
                System.arraycopy(objArray, i + 1, objArray, i,counter - 1);
                counter--;
                k++;
            }
        }
        for (int i = 0; i < k - 1; i++) {
            objArray[counter--] = null;

        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < counter; i++) {
            objArray[i] = null;
        }
        counter = 0;

    }

    @Override
    public E get(int index) {
        return (E)objArray[index];
    }

    @Override
    public E set(int index, E element) {
        return (E)(objArray[index] = element);
    }

    @Override
    public void add(int index, E element) {
        boolean condition = false;
        while(condition){
            if (index >= INIT_SIZE - 1){
                INIT_SIZE*=2;
                Object[] newobjArray = new Object[INIT_SIZE];
                System.arraycopy(objArray, 0 , newobjArray, 0, counter);
                objArray = newobjArray;
            }
            else condition = true;
        }
        objArray[index] = element;
    }

    @Override
    public E remove(int index) {
        for (int i = index; i < counter; i++) {
            objArray[i] = objArray[i+1];
        }
        objArray[counter] = null;
        counter--;
        return null;
    }


    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < counter; i++) {
            if (o == null){
                if (objArray[i] == null){
                    return i;
                }
            }
            else{
                if (o.equals(objArray[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int lastIndex = -1;
        for (int i = 0; i < counter; i++) {
            if (o == null){
                if (objArray[i] == null){
                    lastIndex = i;
                }
            }
            else{
                if (o.equals(objArray[i])){
                    lastIndex = i;
                }
            }
        }
        return lastIndex;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }


    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


}
