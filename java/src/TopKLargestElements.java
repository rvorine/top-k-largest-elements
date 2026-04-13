import java.util.PriorityQueue;

/**
 * Find the top K largest elements from an array using a min-heap (PriorityQueue).
 *
 * Approach:
 *   - Maintain a min-heap of size K.
 *   - For each element in the array:
 *       * If the heap has fewer than K elements, add the element.
 *       * Else if the element is larger than the heap's minimum, replace the minimum.
 *   - At the end the heap contains the K largest elements.
 *
 * Time Complexity : O(n log k)
 * Space Complexity: O(k)
 */
public class TopKLargestElements {

    /**
     * Returns an array containing the top {@code k} largest elements from {@code nums}.
     * The returned array is not guaranteed to be sorted.
     *
     * @param nums the input array
     * @param k    the number of largest elements to return
     * @return an int array of the k largest elements
     * @throws IllegalArgumentException if k <= 0 or k > nums.length
     */
    public static int[] topKLargest(int[] nums, int k) {
        if (k <= 0 || k > nums.length) {
            throw new IllegalArgumentException(
                    "k must be between 1 and " + nums.length + " (inclusive).");
        }

        // Min-heap: the root is always the smallest element in the heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (minHeap.peek() != null && num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        // Copy heap contents into a result array
        int[] result = new int[k];
        int i = 0;
        for (int val : minHeap) {
            result[i++] = val;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 12, 2, 11, 7, 9};
        int k = 3;

        int[] topK = topKLargest(nums, k);

        System.out.println("Input array : " + java.util.Arrays.toString(nums));
        System.out.println("Top " + k + " largest elements: " + java.util.Arrays.toString(topK));
        // Expected output contains 12, 11, 9 (order may vary)
    }
}
