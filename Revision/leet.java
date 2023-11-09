import java.util.*;

class Main{
    public static void main(String[] args) {
        // ArrayList<Integer> nums = new ArrayList<>(List.of(5,10,1,5,2));
        // Minimum Right Shifts to Sort the Array
        // minRightShiftsToSort(nums);
        // Minimum Array Length After Pair Removals
        // minLengthAfterRemovals(nums);
        // Count set bits
        // System.out.println(sumIndicesWithKSetBits(nums,1));
        // maximumOddBinaryNumber("010");
        // System.out.println(differenceOfSums(10,3));
        
        // for (Integer item : lastVisitedIntegers(new ArrayList<>(List.of("1","2","prev","prev","prev"))) ) {
        //     System.out.println(item);
        // }

        // System.out.println(Arrays.toString(findIndices(new int[]{5,1,4,1},2,4)));
        // System.out.println(shortestBeautifulSubstring("100011001",3));
        System.out.println(minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));

    }

    public static long minSum(int[] nums1, int[] nums2) {
        long minSum=0;
        
        return minSum;
    }

    public static String shortestBeautifulSubstring(String s, int k) {

        int count = 0;
        for (Character ch : s.toCharArray()) {
            if(ch == '1')
                count++;
        }

        if(count == k){

        }

        return "";
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
    Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[]{-1, -1};

        for (int i = 0; i < nums.length; i++) {
            int ans = nums[i] - valueDifference;

            if (map.containsKey(ans)) {
                int j = map.get(ans);

                if (Math.abs(i - j) >= indexDifference) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
            map.put(nums[i], i);
        }

        return result;
}

    public static List<Integer> lastVisitedIntegers(List<String> words) {
    List<Integer> result = new ArrayList<>();
    List<Integer> nums = new ArrayList<>();
    int count = 0;

    for (String word : words) {
        if (word.equals("prev")) {
            if (count < nums.size())
                result.add(nums.get(nums.size() - count - 1));
            else
                result.add(-1);
            count++;
        } else {
            nums.add(Integer.parseInt(word));
            count = 0;
        }
    }

    return result;
}





    public static int differenceOfSums(int n, int m) {
        int num1 = 0, num2=0;
        for(int  i = 1; i <= n; i++){
            if(i % m != 0)
                num1 += i;
            else
                num2 += i;
        }
        return num1 - num2;
    }
    
    public static void maximumOddBinaryNumber(String s) {
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '1')
                count++;
        }

        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < count - 1; i++)
            result.append('1');

        for (int i = 0; i < s.length() - count; i++)
            result.append('0');

        result.append('1');
        System.out.println(result.toString()); 
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
