package sort;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by tamdx on 9/18/18.
 */
public class QuickSort {
    private Integer[] data;

    public QuickSort() {
    }

    public QuickSort(Integer[] data) {
        this.data = data;
    }

    public static void main(String[] args) {
        Integer[] data = {3,9,8,4,6,7,1,2,5};
        Date date11 = new Date();

        QuickSort quickSort = new QuickSort(data);
        quickSort.quicksort(0, data.length - 1);
        Date date12 = new Date();
        System.out.println(date12.getTime() - date11.getTime());
        quickSort.print();

        Integer[] data2 = {3,9,8,4,6,7,1,2,5};
        Date date21 = new Date();
        Arrays.sort(data2);
        Date date22 = new Date();
        System.out.println(date22.getTime() - date21.getTime());
        for(int i = 0; i < data2.length; i++){
            System.out.print(data2[i] + " ");
        }

    }
    public void print(){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public void quicksort(int minIndex, int maxIndex){
        //Lay gia tri trung vi
        int pivot = minIndex + (maxIndex - minIndex)/2;
        int i = minIndex;
        int j = maxIndex;
        while (i<=j){
            while(data[i]<data[pivot]){
                i++;
            }

            while (data[j]>data[pivot]){
                j--;
            }
            if(i<=j){
                change(i,j);
                i++;
                j--;
            }
            System.out.println("*i:"+i +"-j:"+j);
        }
        System.out.println("i:"+i +"-j:"+j);
        if(minIndex < j) {
            quicksort(minIndex, j);
        }
        if(maxIndex > i) {
            quicksort(i, maxIndex);
        }
    }

    public void change(int x, int y){
        Integer temp = data[x];
        data[x] = data[y];
        data[y]= temp;
    }


}
