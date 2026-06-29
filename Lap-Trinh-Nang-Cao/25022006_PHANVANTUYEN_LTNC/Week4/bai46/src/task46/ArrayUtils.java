package task46;

public final class ArrayUtils {
    private ArrayUtils(){}

    public static <T extends Comparable<T>> void sort(T[] array){
        int n = array.length;

        for (int i = 0; i < n-1; i++){
            boolean tk = false;
            for (int j = 0; j < n-1-i; j++){
                if (array[j].compareTo(array[j+1]) > 0){
                    T temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    tk = true;
                }
            }
            if (tk == false){
                break;
            }
        }
    }

}
