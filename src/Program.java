import java.util.*;

public class Program {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 8, 10, 11, 11, 11, 11, 11, 13, 17};
        System.out.println(lowerBound(arr, 1100));

    }

    //Максимум в массиве. Временная сложность - O(n), n -> длина массива.
    private static int max(int[] arr) {
        int max = arr[0];
        for(int num : arr) {
            max = Math.max(max, num);
        }

        return max;
    }

    //Найти количество повторяющихся элементов в массиве
    private static int duplicates(int[] arr) {
        int cnt = 0;
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if(arr[i] == arr[j]) {
                    ++cnt;
                }
            }
        }
        return cnt;
    }

    //Найти элемент в массиве, вернуть его индекс либо -1, если его нет. Решить бинарным поиском.
    //arr - массив, в котором ищем, key - число, которое ищем
    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;    //Находим индекс середины

            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] > key) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //Дана строка из какого-то последовательного количества нулей и единиц.
    //Пример: 000000111111111, 0111111111, 000000001, 00000111111111
    private static int lastZeroPosition(String str) {
        //Инвариант: str.charAt(start) == '0', str.charAt(end) == '1'. Будем его поддерживать
        int start = 0;
        int end = str.length() - 1;

        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(str.charAt(mid) == '0') {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        //Мы имеем 2 рядом стоящих элемента start, end. str[start] == '0', str[end] == '1'.
        return start;
    }

    /*
    Дан отсортированный массив и число key.
    Если key нет в массиве, то вернуть максимальный индекс элемента, который < key.
    Иначе индекс первого элемента, который равен key

    [1, 2, 2, 2, 3, 3, 4, 5, 6, 7, 8, 9, 10, 10, 15], key = 2 -> Ответ: 1
    [1, 2, 5, 6, 7, 8, 10, 11, 11, 11, 11, 11, 13, 17], key = 11. Ответ: 6.
     */

    private static int lowerBound(int[] arr, int key) {
        /*
        Инвариант: arr[start] < key, arr[end] >= key
         */
        int start = -1;
        int end = arr.length;

        while(start + 1 < end) {
            int mid = (start + end) / 2;
            if(arr[mid] < key) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        //Если такого элемента нет, то end останется равным arr.length
        return end == arr.length ? -1 : end;
    }
}
