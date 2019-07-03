public class heapSortTest {
    public static void heapSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }
        for (int i=0; i<arr.length; i++){
            heapInsert(arr, i);
        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+"  ");
        }
        System.out.println();
        int size = arr.length;
        swap(arr, 0 , --size);
        while(size >0){
            heapify(arr,0,size);
            swap(arr, 0,--size);
        }

    }


    public static void swap(int[] arr ,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void heapInsert(int[] arr, int index){
        while(arr[index] > arr[(index - 1) / 2]){
            swap(arr, index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
    public static void heapify(int[] arr ,int index ,int size){
        int left = index *2 +1;
        while(left < size ){
            //当左边的同时成立返回右节点，否则都返回左节点
            int maxChild = left+1 < size && arr[left + 1] > arr[left] ? left+1 : left;//必须这么写,当左边的同时
            maxChild = arr[maxChild] > arr[index] ? maxChild : index ;
            if(maxChild == index){
                break;
            }
            swap(arr, maxChild , index);
            index  = maxChild;
            left = index *2 +1;
        }
    }

//    public static void heapify(int[] arr, int index, int size) {
//        int left = index * 2 + 1;
//        while (left < size) {
//            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
//            largest = arr[largest] > arr[index] ? largest : index;
//            if (largest == index) {
//                break;
//            }
//            swap(arr, largest, index);
//            index = largest;
//            left = index * 2 + 1;
//        }
//    }

    public static void main(String[] args) {
       int [] arr = {10,20,30,23,41,27};
       heapSort(arr);
       for(int i=0; i<arr.length; i++){
           System.out.print(arr[i]+"  ");
       }

    }

}
