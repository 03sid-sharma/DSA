package Java;
 
class DynamicArray {

    public static void main(String[] args) {
        Array numbers=new Array(4);
        numbers.insert(100);
        numbers.insert(200);
        numbers.insert(300);
        numbers.insert(400);
        numbers.insert(500);
        
        // numbers.removeAt(3);
        // numbers.print();
        // System.out.println(numbers.indexOf(300));
        // System.out.println(numbers.max());
        //numbers.reverse();
        numbers.insertAt(0,99);
        numbers.print();

    }
}


class Array {
    private int items[];
    private int count;
    
    public Array(int length){
        items=new int[length];
    }

    public int max(){
        int max=-1;
        for (int i = 0; i < count; i++) {
            if(items[i]>max){
                max=items[i];
            }
        }
        return max;
    }

    public void print() {
        for (int i = 0; i <count;i++) {
            System.out.println(items[i]);
        }
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

    public void removeAt(int index){
        if(index<0 || index>=count){
            throw new IllegalArgumentException();
        }
        else{
            for (int i = index; i < count; i++) {
                items[i]=items[i+1];
            }
            count--;
        }
    }

    public int indexOf(int item){
        for (int i = 0; i < count; i++) {
            if(item==items[i]){
                return i;
            }
        }
        return -1;
    }

    public void reverse(){
        int j=0;
        int nya[]= new int[count];
        for (int i = count-1; i>=0; i--) {
            nya[j++]=items[i];
        }
        for (int i = 0; i<count; i++) {
            items[i]=nya[i];
        }
    }

    public void insertAt(int index,int item){
        items[index]=item;
    }
}