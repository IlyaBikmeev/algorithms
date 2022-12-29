package sorting_algorithms;

import java.util.Random;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] arr = new Random(12345).ints(1, 100)
                .limit(20)
                .toArray();

        System.out.println("Начальный массив: ");
        for(int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nОтсортированный массив: ");
        quickSort(arr, 0, arr.length - 1);
        for(int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        //Базовый случай - массив размера 1, либо пустой массив
        if(start >= end) {
            return;
        }

        int pIndex = partition(arr, start, end);
        //Слева от pIndex все элементы будут <= arr[pIndex], справа - >
        quickSort(arr, start, pIndex - 1);      //Делаем то же самое для левой половины
        quickSort(arr, pIndex + 1, end);        //Делаем то же самое для правой половины
    }

    //Упорядочиваем массив, на выходе индекс опорного элемента
    private static int partition(int[] arr, int start, int end) {
        /*
        Выбираем рандомный индекс, меняем этот элемент с последним
         */
        int index = new Random().nextInt(end - start + 1) + start;
        int tmp = arr[index];
        arr[index] = arr[end];
        arr[end] = tmp;

        int pivot = arr[end];

        int pIndex = start;     //Индекс позиции, куда можно вставить следующий элемент, меньший pivot

        for(int i = start; i < end; ++i) {
            if(arr[i] <= pivot) {
                //Меняем местами arr[i] и arr[pIndex]
                tmp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = tmp;
                ++pIndex;
            }
        }

        //Меняем местами arr[end] и arr[pIndex]
        //Теперь все элементы, меньшие pivot стоят слева от него, большие - справа
        tmp = arr[end];
        arr[end] = arr[pIndex];
        arr[pIndex] = tmp;

        //Возвращаем индекс опорного элемента
        return pIndex;
    }
}
