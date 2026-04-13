# Top K Largest Elements

[![Instagram](https://img.shields.io/badge/Instagram-%40lacopydepastel-E4405F?style=for-the-badge&logo=instagram&logoColor=white)](https://www.instagram.com/lacopydepastel)
[![YouTube](https://img.shields.io/badge/YouTube-%40rvorine-FF0000?style=for-the-badge&logo=youtube&logoColor=white)](https://www.youtube.com/@rvorine)

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return the **top `k` largest elements** from the array.

**Example**

```
Input : nums = [3, 1, 5, 12, 2, 11, 7, 9],  k = 3
Output: [12, 11, 9]   (order may vary)
```

---

## Solution — Min-Heap (Priority Queue)

### Intuition

A naive approach sorts the entire array and takes the last `k` elements — **O(n log n)**.  
We can do better by using a **min-heap of size k**:

1. Iterate through every element in the array.
2. If the heap holds **fewer than `k` elements**, push the element.
3. Otherwise, if the current element is **greater than the heap's minimum** (the root), pop the minimum and push the current element.
4. After processing all elements, the heap contains exactly the `k` largest values.

### Complexity

| | Complexity |
|---|---|
| **Time** | O(n log k) |
| **Space** | O(k) |

---

## Implementations

### Java

**File:** [`java/src/TopKLargestElements.java`](java/src/TopKLargestElements.java)

```java
import java.util.PriorityQueue;

public class TopKLargestElements {

    public static int[] topKLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.offer(num);
            } else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }

        int[] result = new int[k];
        int i = 0;
        for (int val : minHeap) {
            result[i++] = val;
        }
        return result;
    }
}
```

**Run the Java example:**

```bash
cd java/src
javac TopKLargestElements.java
java TopKLargestElements
```

---

### Kotlin

**File:** [`kotlin/src/TopKLargestElements.kt`](kotlin/src/TopKLargestElements.kt)

```kotlin
import java.util.PriorityQueue

fun topKLargest(nums: IntArray, k: Int): List<Int> {
    val minHeap = PriorityQueue<Int>(k)

    for (num in nums) {
        when {
            minHeap.size < k -> minHeap.offer(num)
            num > minHeap.peek() -> {
                minHeap.poll()
                minHeap.offer(num)
            }
        }
    }

    return minHeap.toList()
}
```

**Run the Kotlin example:**

```bash
cd kotlin/src
kotlinc TopKLargestElements.kt -include-runtime -d TopKLargestElements.jar
java -jar TopKLargestElements.jar
```

---

## Repository Structure

```
top-k-largest-elements/
├── java/
│   └── src/
│       └── TopKLargestElements.java
├── kotlin/
│   └── src/
│       └── TopKLargestElements.kt
└── README.md
```
