class Kadane
{
    // Function to find contiguous sub-array with the largest sum
    // in given set of integers
    public static int kadane(int[] A)
    {
        // stores maximum sum sub-array found so far
        int maxSoFar = Integer.MIN_VALUE;

        // stores maximum sum of sub-array ending at current position
        int maxEndingHere = 0;
        // traverse the given array
        for (int i=1;i<A.length;i++)
        {
            
            maxEndingHere = Integer.max(maxEndingHere + A[i], A[i]);

            // update result if current sub-array sum is found to be greater
            maxSoFar = Integer.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    // main function
    public static void main(String[] args)
    {
        int[] A = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println("The sum of contiguous sub-array with the largest sum is " +
                            kadane(A));
    }
}