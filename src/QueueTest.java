/**
 * 队列
 */
public class QueueTest {
    public static class ArrayStack{
        private Integer[] arr;
        private Integer size;

        public ArrayStack() {
            arr = new Integer[10];
            size = 0;
        }
        public void push(int num){
            if(arr.length == size){
                throw new ArrayIndexOutOfBoundsException("yuejie");
            }
            arr[size++] = num;
        }
        public Integer pop(){
            if(arr.length <= 0){
                throw new ArrayIndexOutOfBoundsException("");
            }
            return arr[--size];
        }
        public Integer peep(){
            if(size == 0){
                return null;
            }else{
                return arr[size-1];
            }
        }
    }
    public static class ArrayQueue{
        private Integer arr[];
        private Integer size;
        private Integer firstIndex;
        private Integer lastIndex;

        public ArrayQueue() {
            arr = new Integer[10];
            firstIndex = 0;
            lastIndex = 0;
            size = 0;
        }
        public Integer peek(){
            if(size <= 0){
                return null;
            }else{
                return arr[firstIndex];
            }
        }
        public void push(int num){
            if(arr.length == size){
                throw new ArrayIndexOutOfBoundsException("");
            }
            arr[lastIndex] = num;
            size++;
            //加到满时回到起始点
            lastIndex = lastIndex == arr.length-1 ? 0  : lastIndex + 1;
        }
        public  Integer poll(){
            if (size == 0){
                throw new ArrayIndexOutOfBoundsException("");
            }
            size--;
            int temp = firstIndex;
            //删除到0时回到起始点
            firstIndex = firstIndex == arr.length -1 ? 0 : firstIndex + 1;
            return arr[temp];

        }

    }

    public static void main(String[] args) {
//        ArrayStack a = new ArrayStack();
//        a.push(1);
//        a.push(2);
//        a.push(3);
//        a.push(4);
//        a.push(5);
//        System.out.println(a.pop());
//        System.out.println(a.peep());
        ArrayQueue b = new ArrayQueue();
        b.push(1);
        b.push(2);
        b.push(3);
        b.push(4);
        b.push(5);
        b.push(6);
        b.push(7);
        b.push(8);
        b.push(9);

        System.out.println(b.lastIndex);
        System.out.println(b.poll());
//        for(int i = 0; i<9;i++){
//            b.poll();
//        }
//        System.out.println(b.arr.length);


    }
}
