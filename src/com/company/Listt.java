package com.company;



public class Listt <T> implements MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elementData ;
    private int capacity = 0;
    private int size = 0;

    public Listt() {
        capacity = DEFAULT_CAPACITY;
        elementData = new Object[capacity];
    }

    public Listt (int capacity) {
        this.capacity = capacity;
        elementData = new Object[capacity];
    }

    public void grow(){
        if(size==elementData.length){
            Object [] elementDataNew = new Object [size * 1 + 5];
            System.arraycopy(elementData, 0, elementDataNew, 0, size);
            elementData=elementDataNew;
            System.out.println ("размер массива после расширения" + " " + elementData.length);
        }
    }


    @Override
    public boolean add(T t) {

        if (size >= capacity) {
            grow();
        }
        elementData[size++] = t;
        return true;
    }


    @Override
    public void add(int index, T t) {

        if (size >= capacity) {
            grow();
        }
        System.arraycopy(elementData, index, elementData, index + 1, size - index);

        elementData[index] = t;
        size++;


    }

    @Override
    public T get(int index) {
        if ((index < size) && (index >= 0)) {
            return (T) elementData[index];
        }
        return null;
    }

    @Override
    public void set(int index, T t) {
        if ((index < size) && (index >= 0)) {
            Object oldValue = elementData[index];
            elementData[index] = t;


        }

    }

    @Override
    public void remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < elementData.length - 1; i++) {
                elementData[i] = elementData[i + 1];
            }
            size--;
        }

    }

    @Override
    public void remove(T t) {
        for(int i=0;i<elementData.length; i++){
            Object ob=elementData[i];
            if(ob.equals(t)){
                int numMoved = size - i - 1;
                if (numMoved > 0){
                    System.arraycopy(elementData, i+1, elementData, i,
                            numMoved);
                    size--;
                    elementData[size]=null;

                }
                break;
            }
        }

    }

    @Override
    public int size() {
    return size;
    }



    @Override
    public void sort() {

    }
}
