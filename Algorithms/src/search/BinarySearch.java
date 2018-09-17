package search;

/**
 * Created by tamdx on 9/18/18.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Integer[] data = {1,3,5,6,8,10,12,23};
        BinarySearch search = new BinarySearch();
        System.out.println(search.binarySearch(data,8));
    }
    public int binarySearch(Integer[] data, Integer key){
        int i = 0;
        int j = data.length - 1;
        int tem;
        while(i <= j){
            tem = (i+j)/2;
            if(data[tem] == key){
                return tem;
            }
            if(data[tem] < key){
                i = tem+1;
            } else {
                j = tem-1;
            }
        }
        return -1;
    }
}
