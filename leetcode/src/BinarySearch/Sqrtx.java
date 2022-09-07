package BinarySearch;

public class Sqrtx {
    public int mySqrt(int x) {
         /*
        CODE Explanation:
           Step1:  Check if the Given number is 0 then Simply return 0
           Step2: Now take three Variables as
                  start -> 1
                  end   -> x (Given Number)
              Reason: 1, 2, 3 .......... X      --> Because SquareRoot Always Lies Before the Given number  Not After it
                     /                   \
                  start                  end
                ans -> 0   For Storing the result
           Step3: Now repeat the Following Steps Till start <= end
                 --> Find Mid = start + (end - start)/2
                 --> check if mid * mid <= x ?   --> This will cause overflow so take mid = x/mid
                      if YES -->  then Store mid in Ans Because it might be the Possible ans
                      and Search in right half    start = mid + 1
                --> otherwise Search in left half   end = mid - 1
          Step4: At the and Return the ans
         */
        // if x is 0 then Simply Return 0
        if(x == 0)
            return x;
        int start = 1;
        int end = x;
        int ans = 0;
        while(start <= end){
            // find mid value
            int mid = start + (end - start)/2;
            if(mid <= x/mid){
                ans = mid;   // Store mid in ans Because it might be the possible ans
                start = mid+1;  // then Search in Right Half
            }
            else
                end = mid-1;   // otherwise Search in left Half
        }
        // if X is not a Perfect SquareRoot then return Floor(sqrt(x))
        return ans;
    }
}
