public class QuickSort {
    static int counter = 0;

    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        counter++;
        int i = (low - 1); // index of smaller element
        counter++;
        for (int j = low; j < high; j++) {
            counter++;
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                counter++;

                i++;

                counter++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                counter++;
                arr[i] = arr[j];
                counter++;
                arr[j] = temp;
                counter++;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        counter++;
        arr[i + 1] = arr[high];
        counter++;
        arr[high] = temp;
        counter++;

        counter++;

        return i + 1;
    }

    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    void sort(int arr[], int low, int high) {
        counter++;
        if (low < high) {
            counter++;
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);
            counter++;

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi - 1);
            counter++;
            sort(arr, pi + 1, high);
            counter++;
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = { 10, 7, 8, 9, 1, 5 };
        counter++;
        int n = arr.length;
        counter++;

        QuickSort ob = new QuickSort();
        counter++;
        ob.sort(arr, 0, n - 1);
        counter++;

        System.out.println("sorted array");
        counter++;
        printArray(arr);
        System.out.println(counter);

    }
}
 