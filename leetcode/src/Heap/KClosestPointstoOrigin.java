package Heap;

import java.util.concurrent.ThreadLocalRandom;

public class KClosestPointstoOrigin {

        private int[][] points;

        public int[][] kClosest(int[][] points, int K) {
            this.points = points;
            helper(0,points.length-1,K);

            int[][] res = new int[K][2];
            for (int i = 0; i < K; i ++)
            {
                res[i] = points[i];
            }
            return res;
        }

        private void helper(int l, int r, int num)
        {
            // pick a pivot
            int pivot = l + ThreadLocalRandom.current().nextInt(r-l+1);
            swap(l, pivot);

            // do partitioning
            int part = partition(l,r);

            // left part size
            int leftSize = part-l+1;
            if (leftSize == num) return;

            // recursion
            if (leftSize > num)
            {
                // recursion on the left side
                helper(l,part,num);
            }
            else
            {
                // recursion on the right side
                helper(part+1,r,num-leftSize);
            }
        }

        private void swap(int s, int e)
        {
            int[] tmp = points[s];
            points[s] = points[e];
            points[e] = tmp;
        }

        private int dist(int i)
        {
            return points[i][0]*points[i][0] + points[i][1]*points[i][1];
        }

        private int partition(int l, int r)
        {
            int value = dist(l);
            int k = l+1;
            for (int i = l+1; i<=r; i++)
            {
                if (dist(i) <= value)
                {
                    swap(i,k); k ++;
                }
            }

            return k-1;
        }

}
