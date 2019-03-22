import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

    protected int size = 10;

    protected T[] array;
    protected int top;


    public ArrayStack(){
        top = -1;
        array = (T[]) new Object[size];
    }



    public void push(T item){

        if(top == array.length -1){
            growArray(); //grow the array
        }

        array[++top] = item;

    }

    public T pop(){

        if(empty()){
            throw new ArrayIndexOutOfBoundsException("Index out of bounds");
        }

        return array[top--];

    }

    public T peek(){

        if(empty()){
            throw new NoSuchElementException("ERROR: Stack is empty");
        }

        return array[top];
    }

    public boolean empty() {

        if(top == -1){
            return true;
        }
        return false;
    }

    private void growArray(){

        T[] temp = (T[]) new Object[array.length * 2];

        for(int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }

        array = temp;

    }



}
