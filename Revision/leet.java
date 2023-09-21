import java.util.*;

class Main{
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(5,10,1,5,2));
        // Minimum Right Shifts to Sort the Array
        minRightShiftsToSort(nums);
        // Minimum Array Length After Pair Removals
        minLengthAfterRemovals(nums);
        // Count set bits
        System.out.println(sumIndicesWithKSetBits(nums,1));

    }

    public static int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            int countSetBits = countSetBits(i);
            if (countSetBits == k) {
                sum += nums.get(i);
            }
        }

        return sum;
    }

    public static int countSetBits(int num) {
        int count = 0;
        String bin = Integer.toBinaryString(num);
        for (Character ch : bin.toCharArray()) {
            if(ch=='1')
                count++;
        }
        return count;
    }

    private static void minLengthAfterRemovals(List<Integer> nums) {
        for (int i = nums.size() - 1; i >= 1; i--) {
            if (nums.get(i) > nums.get(i - 1)) {
                nums.remove(i);
                nums.remove(i - 1);
                i--;
            }
        }
        System.out.println(nums.size());
    }

    private static void minRightShiftsToSort(List<Integer> nums) {
        ArrayList<Integer> sorted = new ArrayList<>(List.of(4,5,1,2,3));
        Collections.sort(sorted);
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if(!nums.equals(sorted)){
                Collections.rotate(nums, 1);
                count++;
            }
        }
        System.out.println(count);
    }
}