import java.util.PriorityQueue

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

/**
 * Returns a list containing the top [k] largest elements from [nums].
 * The returned list is not guaranteed to be sorted.
 *
 * @param nums the input array
 * @param k    the number of largest elements to return
 * @return a list of the k largest elements
 * @throws IllegalArgumentException if k <= 0 or k > nums.size
 */
fun topKLargest(nums: IntArray, k: Int): List<Int> {
    require(k in 1..nums.size) {
        "k must be between 1 and ${nums.size} (inclusive)."
    }

    // Min-heap: the root is always the smallest element in the heap
    val minHeap = PriorityQueue<Int>(k)

    for (num in nums) {
        when {
            minHeap.size < k -> minHeap.offer(num)
            num > (minHeap.peek() ?: Int.MIN_VALUE) -> {
                minHeap.poll()
                minHeap.offer(num)
            }
        }
    }

    return minHeap.toList()
}

fun main() {
    val nums = intArrayOf(3, 1, 5, 12, 2, 11, 7, 9)
    val k = 3

    val topK = topKLargest(nums, k)

    println("Input array : ${nums.toList()}")
    println("Top $k largest elements: $topK")
    // Expected output contains 12, 11, 9 (order may vary)
}
