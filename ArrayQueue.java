import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private int head, tail;
    private int size = 10;

    private T[] array;

    public ArrayQueue(){
        head = 0;
        tail = 0;
        array = (T[]) new Object[size]; //array of object type T
    }

    public T dequeue(){

        if(empty()){
            throw new NoSuchElementException("ERROR: Queue is empty. ");    //throws error if queue is empty & trying to return top of queue
        }

        T temp = array[head];
        head = (head + 1) % array.length;

        return temp;


    }

    public void enqueue(T item){

        if(size == array.length){
                growArray();    //grows the array rather than throwing exception
        }

        array[tail] = item;
        tail = (tail + 1) % array.length;
        size++;
    }


    public boolean empty(){

        if(head == tail){
            return true;
        }

        return false;

    }

    private void growArray(){   //grows the array to prevent error from enqueue function

        T[] temp = (T[]) new Object[array.length * 2];

        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }

        array = temp;

    }




}
