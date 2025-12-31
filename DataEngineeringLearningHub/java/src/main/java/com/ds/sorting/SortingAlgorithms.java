package com.ds.sorting;

/**
 * COMPLETE JAVA SORTING ALGORITHMS REFERENCE
 * A comprehensive guide to all major sorting algorithms with implementations
 */

// ============================================================================
// 1. BUBBLE SORT
// ============================================================================
// Time Complexity: O(n²) average and worst case, O(n) best case
// Space Complexity: O(1)
// Stable: Yes
// Description: Repeatedly steps through the list, compares adjacent elements
// and swaps them if they're in the wrong order.

class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }
}

// ============================================================================
// 2. SELECTION SORT
// ============================================================================
// Time Complexity: O(n²) for all cases
// Space Complexity: O(1)
// Stable: No
// Description: Divides the array into sorted and unsorted regions. Repeatedly
// selects the minimum element from unsorted region and moves it to sorted region.

class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            // Find minimum element in unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            if(minIdx!=i) {
                // Swap minimum element with first unsorted element
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }
}

// ============================================================================
// 3. INSERTION SORT
// ============================================================================
// Time Complexity: O(n²) average and worst case, O(n) best case
// Space Complexity: O(1)
// Stable: Yes
// Description: Builds the final sorted array one item at a time. Takes each
// element and inserts it into its correct position in the sorted portion.

class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}

// ============================================================================
// 4. MERGE SORT
// ============================================================================
// Time Complexity: O(n log n) for all cases
// Space Complexity: O(n)
// Stable: Yes
// Description: Divide and conquer algorithm. Divides array into halves,
// recursively sorts them, then merges the sorted halves.

class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        
        // Merge temporary arrays back
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        // Copy remaining elements
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

// ============================================================================
// 5. QUICK SORT
// ============================================================================
// Time Complexity: O(n log n) average, O(n²) worst case
// Space Complexity: O(log n) due to recursion
// Stable: No
// Description: Picks a pivot element and partitions array around it, placing
// smaller elements before pivot and larger elements after.

class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition and get pivot index
            int pi = partition(arr, low, high);
            
            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose last element as pivot
        int i = low - 1; // Index of smaller element
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        // Swap arr[i+1] and arr[high] (pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
}

// ============================================================================
// 6. HEAP SORT
// ============================================================================
// Time Complexity: O(n log n) for all cases
// Space Complexity: O(1)
// Stable: No
// Description: Uses binary heap data structure. Builds a max heap, then
// repeatedly extracts maximum element and rebuilds heap.

class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        
        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;
        
        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;
        
        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            
            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }
}

// ============================================================================
// 7. COUNTING SORT
// ============================================================================
// Time Complexity: O(n + k) where k is the range of input
// Space Complexity: O(k)
// Stable: Yes
// Description: Non-comparison sort. Counts occurrences of each element,
// then uses count array to place elements in sorted order.

class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        
        // Find maximum element
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        
        // Create count array
        int[] count = new int[max + 1];
        int[] output = new int[n];
        
        // Store count of each element
        for (int i = 0; i < n; i++)
            count[arr[i]]++;
        
        // Change count[i] to contain actual position
        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];
        
        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        
        // Copy output array to arr
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
}

// ============================================================================
// 8. RADIX SORT
// ============================================================================
// Time Complexity: O(d * (n + k)) where d is number of digits
// Space Complexity: O(n + k)
// Stable: Yes
// Description: Non-comparison sort. Sorts numbers digit by digit starting
// from least significant digit using counting sort as subroutine.

class RadixSort {
    public static void radixSort(int[] arr) {
        // Find maximum number to know number of digits
        int max = getMax(arr);
        
        // Do counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSortByDigit(arr, exp);
    }
    
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        
        // Store count of occurrences
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        
        // Change count[i] to contain actual position
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        
        // Build output array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        
        // Copy output to arr
        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
}

// ============================================================================
// 9. BUCKET SORT
// ============================================================================
// Time Complexity: O(n + k) average case, O(n²) worst case
// Space Complexity: O(n + k)
// Stable: Yes
// Description: Distributes elements into buckets, sorts individual buckets,
// then concatenates them. Works well for uniformly distributed data.

class BucketSort {
    public static void bucketSort(float[] arr) {
        int n = arr.length;
        if (n <= 0) return;
        
        // Create n empty buckets
        @SuppressWarnings("unchecked")
        java.util.ArrayList<Float>[] buckets = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++)
            buckets[i] = new java.util.ArrayList<>();
        
        // Put array elements in different buckets
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * arr[i]);
            buckets[bucketIndex].add(arr[i]);
        }
        
        // Sort individual buckets
        for (int i = 0; i < n; i++)
            java.util.Collections.sort(buckets[i]);
        
        // Concatenate all buckets
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                arr[index++] = buckets[i].get(j);
            }
        }
    }
}

// ============================================================================
// 10. SHELL SORT
// ============================================================================
// Time Complexity: O(n log n) to O(n²) depending on gap sequence
// Space Complexity: O(1)
// Stable: No
// Description: Generalization of insertion sort. Compares elements separated
// by a gap, gradually reducing the gap.

class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        
        // Start with a large gap, then reduce it
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                
                // Shift earlier gap-sorted elements up
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                
                arr[j] = temp;
            }
        }
    }
}

// ============================================================================
// 11. COMB SORT
// ============================================================================
// Time Complexity: O(n²) worst case, O(n log n) average
// Space Complexity: O(1)
// Stable: No
// Description: Improvement over bubble sort. Uses gap greater than 1,
// shrinking by a factor of 1.3 each iteration.

class CombSort {
    public static void combSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        
        while (gap != 1 || swapped) {
            // Find next gap
            gap = getNextGap(gap);
            swapped = false;
            
            // Compare elements with current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
    
    private static int getNextGap(int gap) {
        gap = (gap * 10) / 13;
        return (gap < 1) ? 1 : gap;
    }
}

// ============================================================================
// 12. CYCLE SORT
// ============================================================================
// Time Complexity: O(n²)
// Space Complexity: O(1)
// Stable: No
// Description: In-place, unstable sorting algorithm optimal for situations
// where memory writes are costly. Minimizes number of writes.

class CycleSort {
    public static void cycleSort(int[] arr) {
        int n = arr.length;
        
        // Traverse array and put elements to correct position
        for (int cycleStart = 0; cycleStart < n - 1; cycleStart++) {
            int item = arr[cycleStart];
            
            // Find position where we put the item
            int pos = cycleStart;
            for (int i = cycleStart + 1; i < n; i++)
                if (arr[i] < item)
                    pos++;
            
            // If item is already in correct position
            if (pos == cycleStart)
                continue;
            
            // Skip duplicates
            while (item == arr[pos])
                pos++;
            
            // Put item to its correct position
            if (pos != cycleStart) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
            }
            
            // Rotate rest of the cycle
            while (pos != cycleStart) {
                pos = cycleStart;
                
                // Find position where we put element
                for (int i = cycleStart + 1; i < n; i++)
                    if (arr[i] < item)
                        pos++;
                
                // Skip duplicates
                while (item == arr[pos])
                    pos++;
                
                // Put item to correct position
                if (item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                }
            }
        }
    }
}

// ============================================================================
// 13. PANCAKE SORT
// ============================================================================
// Time Complexity: O(n²)
// Space Complexity: O(1)
// Stable: No
// Description: Sorting using only flip operation (reversing array from
// index 0 to k). Used to sort a disordered stack.

class PancakeSort {
    public static void pancakeSort(int[] arr) {
        int n = arr.length;
        
        for (int currSize = n; currSize > 1; currSize--) {
            // Find index of maximum element in arr[0..currSize-1]
            int maxIdx = findMax(arr, currSize);
            
            // Move maximum element to end if it's not already there
            if (maxIdx != currSize - 1) {
                // Flip to move max to beginning
                flip(arr, maxIdx);
                // Flip to move max to end
                flip(arr, currSize - 1);
            }
        }
    }
    
    private static int findMax(int[] arr, int n) {
        int maxIdx = 0;
        for (int i = 1; i < n; i++)
            if (arr[i] > arr[maxIdx])
                maxIdx = i;
        return maxIdx;
    }
    
    private static void flip(int[] arr, int k) {
        int start = 0;
        while (start < k) {
            int temp = arr[start];
            arr[start] = arr[k];
            arr[k] = temp;
            start++;
            k--;
        }
    }
}

// ============================================================================
// 14. TIM SORT (Used by Java's Arrays.sort() for objects)
// ============================================================================
// Time Complexity: O(n log n)
// Space Complexity: O(n)
// Stable: Yes
// Description: Hybrid sorting algorithm derived from merge sort and insertion
// sort. Divides array into runs and uses insertion sort for small runs.

class TimSort {
    private static final int RUN = 32;
    
    public static void timSort(int[] arr) {
        int n = arr.length;
        
        // Sort individual runs using insertion sort
        for (int i = 0; i < n; i += RUN)
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        
        // Merge sorted runs
        for (int size = RUN; size < n; size = 2 * size) {
            for (int start = 0; start < n; start += 2 * size) {
                int mid = start + size - 1;
                int end = Math.min(start + 2 * size - 1, n - 1);
                
                if (mid < end)
                    merge(arr, start, mid, end);
            }
        }
    }
    
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int len1 = mid - left + 1;
        int len2 = right - mid;
        int[] leftArr = new int[len1];
        int[] rightArr = new int[len2];
        
        for (int i = 0; i < len1; i++)
            leftArr[i] = arr[left + i];
        for (int i = 0; i < len2; i++)
            rightArr[i] = arr[mid + 1 + i];
        
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }
        
        while (i < len1)
            arr[k++] = leftArr[i++];
        while (j < len2)
            arr[k++] = rightArr[j++];
    }
}

// ============================================================================
// MAIN CLASS WITH TEST EXAMPLES
// ============================================================================

public class SortingAlgorithms {
    
    // Helper method to print array
    private static void printArray(int[] arr) {
        for (int value : arr)
            System.out.print(value + " ");
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Test array
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Original array:");
        printArray(arr);
        
        // Example: Using Quick Sort
        int[] testArr = arr.clone();
        QuickSort.quickSort(testArr, 0, testArr.length - 1);
        System.out.println("Sorted array (Quick Sort):");
        printArray(testArr);
        
        // Example: Using Merge Sort
        testArr = arr.clone();
        MergeSort.mergeSort(testArr, 0, testArr.length - 1);
        System.out.println("Sorted array (Merge Sort):");
        printArray(testArr);
    }
}

/*
 * ALGORITHM SELECTION GUIDE:
 * 
 * Use Merge Sort when:
 * - You need stable sorting
 * - Working with linked lists
 * - Need guaranteed O(n log n) performance
 * 
 * Use Quick Sort when:
 * - Average case performance is important
 * - Space is limited (in-place sorting)
 * - Working with arrays
 * 
 * Use Heap Sort when:
 * - You need O(n log n) with O(1) space
 * - Worst case performance matters
 * 
 * Use Insertion Sort when:
 * - Array is small (< 10-20 elements)
 * - Array is nearly sorted
 * - Online sorting (elements arrive one at a time)
 * 
 * Use Counting/Radix/Bucket Sort when:
 * - Elements are integers in a small range
 * - You need O(n) performance
 * - You have extra space available
 * 
 * Use Tim Sort when:
 * - You need stable sorting
 * - Data has some pre-existing order
 * - This is Java's default for object sorting
 */