package fb;

import java.util.PriorityQueue;

public class KClosestToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for (int[] point: points) {
            if (maxHeap.size() < K) {
                maxHeap.add(point);
            } else {
                int[] maxDistancePoint = maxHeap.peek();
                if (point[0]*point[0] + point[1]*point[1] < maxDistancePoint[0]*maxDistancePoint[0] + maxDistancePoint[1]*maxDistancePoint[1]) {
                    maxHeap.remove();
                    maxHeap.add(point);
                }
            }
        }
        int[][] resultArr = new int[K][2];
        for (int j=0; j < K; j++) {
            resultArr[j] = maxHeap.remove();
        }
        return resultArr;
    }
}
