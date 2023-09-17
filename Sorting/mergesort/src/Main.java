import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(0);
        list.add(2);
        list.add(15);
        list.add(7);
        list.add(5);
        list.add(3);

        mergesort(list, 0, list.size());
        print(list);

    }

    private static void print(List<Integer> list) {
        for(Integer el: list) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    private static void mergesort(List<Integer> arr, int inicio, int fim) {

        if (fim - inicio > 1) {
            int meio = (fim + inicio) / 2;

            mergesort(arr, inicio, meio);
            mergesort(arr, meio, fim);

            merge(arr, inicio, meio, fim);
        }
    }

    private static void merge(List<Integer> arr, int inicio, int meio, int fim) {
        List<Integer> left = arr.subList(inicio, meio);
        List<Integer> right = arr.subList(meio, fim);

        int i = 0, j = 0;

        for (int k = inicio; k < fim; k++){
            if (i >= left.size()) {
                arr.remove(k);
                arr.add(k, right.get(j));
                j++;
            } else if ((j >= right.size())) {
                arr.remove(k);
                arr.add(k, left.get(i));
                i++;
            }
            else if (left.get(i) > right.get(j)) {
                arr.remove(k);
                arr.add(k, right.get(j));
                j++;
            }  else if ((left.get(i) < right.get(j))) {
                arr.remove(k);
                arr.add(k, left.get(i));
                i++;
            }
        }
    }
}