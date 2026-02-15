public class HW3 {

    public static void main(String[] args) {

        WordFreq[] arr = new WordFreq[] {
            new WordFreq("happy", 400),
            new WordFreq("satisfied", 100),
            new WordFreq("neutral", 300),
            new WordFreq("would buy again", 200),
            new WordFreq("terrible", 160),
            new WordFreq("inconvenient", 900),
            new WordFreq("difficult to use", 100),
            new WordFreq("easy to use", 140),
            new WordFreq("would recommend to friends", 800),
            new WordFreq("visit the store", 700)
        };

        buildMaxHeap(arr);

        System.out.println("Heapified Array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + ": " + arr[i].Word + " - " + arr[i].frequency);
        }
    }

    public static void buildMaxHeap(WordFreq[] A) {
        int n = A.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(A, n, i);
        }
    }

    public static void maxHeapify(WordFreq[] A, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && A[left].frequency > A[largest].frequency) {
            largest = left;
        }

        if (right < n && A[right].frequency > A[largest].frequency) {
            largest = right;
        }

        if (largest != i) {
            WordFreq temp = A[i];
            A[i] = A[largest];
            A[largest] = temp;

            maxHeapify(A, n, largest);
        }
    }
}
