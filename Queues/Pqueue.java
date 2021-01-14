import java.util.*;

class Main{
    public static void main(String[] args) {
        Pqueue queue=new Pqueue();
        queue.add(5);
        queue.add(3);
        queue.add(6);
        queue.add(1);
        queue.add(4);
        
        System.out.println(queue);

        while(!queue.isEmpty())
            System.out.println(queue.remove());

    }
}

class Pqueue {
    private int items[]=new int[5];
    private int count;

    public void add(int item){
        if(isFull()){
            int newItems[]=new int[count*2];
            for (int j = 0; j < count; j++) {
                newItems[j]=items[j];
            }
            items=newItems;
        }

        //  Shifting
        int i = shiftItemsToInsert(item);

        // Adding at right position
        items[i]=item;
        count++;
    }

    public boolean isFull() {
        return count == items.length;
    }

    public int shiftItemsToInsert(int item) {
        int i;
        for(i=count-1;i>=0;i--){
            if(items[i] > item)
                items[i+1]=items[i];
            else
                break;
        }
        return i+1;
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Arrays.toString(items);
    }
 }