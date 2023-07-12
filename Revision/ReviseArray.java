public class ReviseArray {
    public static void main(String[] args) {
        Array arr = new Array(1);
        arr.insert(100);
        arr.insert(300);
        arr.insert(400);
        arr.insert(500);
        arr.insert(600);
        arr.insertAt(1, 200);
        // System.out.println(arr.indexOf(300));
        // arr.removeAt(1);
        // System.out.println(arr.max());
        // arr.reverse();
        arr.print();
    }
}

class Array{
    private int items[];
    private int count;

    public Array(int length){
        items = new int[length];
    }

    public void reverse(){
        for (int i = count-1 ; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }

    public int max(){
        int max = -1;
        for (int item : items) {
            if(item > max)
                max = item;
        }
        return max;
    }
    
    public void print(){
        for(int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

    public void insert(int element){
        if(items.length==count){
            int newItems[]=new int[count*2];
            for (int i = 0; i < count; i++) {
                newItems[i]=items[i];
            }
            items=newItems;
        }
        items[count++]=element;
    }

    public void insertAt(int index, int element){
        if(items.length==count){
            int newItems[]=new int[count*2];
            for (int i = 0; i < count; i++) {
                newItems[i]=items[i];
            }
            items=newItems;
        }
        items[index]=element;
        count++;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];

        count--;
    }

    public int indexOf(int value){
        for (int i = 0; i < count; i++) {
            if(items[i] == value)
                return i;
        }
        return -1;
    }
}
