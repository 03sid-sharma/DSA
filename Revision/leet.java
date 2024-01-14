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
        // System.out.println(minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
        // System.out.println(findMinimumOperations("abc","abb","ab"));
        // System.out.println(findMinimumOperations("cxx","a","a"));
        // for (Integer item : findWordsContaining(new String[]{"abc","bcd","aaaa","cbc"}, 'a'))
        // {
        //     System.out.println(item);
        // }
        // System.out.println(Arrays.toString(lexicographicallySmallestArray(new int[]{5,100,44,45,16,30,14,65,83,64}, 15)));
        // System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{9,1,7},{8,9,2},{3,4,6}})));
        // System.out.println(areaOfMaxDiagonal(new int[][]{{9,3},{8,6}}));
        System.out.println(maxFrequencyElements(new int[]{1,2,3,4,5}));
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for (int i : nums) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
            max = Math.max(max, count);
        }

        int result = 0;
        for (int count : map.values())
            if (count == max)
                result += count;

        return result;
    }

    public static int areaOfMaxDiagonal(int[][] dimensions) {
   int n = dimensions.length;
        int[] area = new int[n];

        for (int i = 0; i < n; i++) {
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            int diagonal = (int) Math.sqrt(length * length + width * width);
            area[i] = diagonal * 1000 + length * width; 
        }

        Arrays.sort(area);

        int maxArea = 0;
        for (int i = n - 1; i >= 0; i--) {
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            int diagonal = (int) Math.sqrt(length * length + width * width);
            maxArea = Math.max(maxArea, length * width);
            if (diagonal == area[i] / 1000) {
                break; 
            }
        }

        return maxArea;
}





   public static int[] findMissingAndRepeatedValues(int[][] grid) {
    int n = grid.length;
    int[] count = new int[n * n + 1];
    int a = 0;
    int b = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            int num = grid[i][j];
            count[num]++;
        }
    }

    for (int i = 1; i <= n * n; i++) {
        if (count[i] == 2) 
            a = i;
        else if (count[i] == 0)
            b = i;
    }

    return new int[]{a, b};
}

    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (Math.abs(nums[i] - nums[j]) <= limit && compareArrays(nums, i, j)) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
    return nums;
}

// Helper function to compare arrays lexicographically
private static boolean compareArrays(int[] nums, int i, int j) {
    for (int k = 0; k < i; k++) {
        if (nums[k] < nums[i]) {
            return false;
        } else if (nums[k] > nums[i]) {
            return true;
        }
    }
    return nums[i] > nums[j];
}
    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        int count = 0;
        for (String word: words) {
            for (char ch : word.toCharArray()) {
                if(ch == x){
                    result.add(count);
                    break;
                }
            }
            count++;
        }

        return result;
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {
        
        if(s1.length() < 2 && s2.length() < 2 && s3.length() < 2)
            return 0;

        if(s1.length() == s2.length() && s2.length() == s3.length() && s3.length() == s1.length()
            || s1.length() < 2 ||  s2.length() < 2 || s3.length() < 2)
            return -1;

        int minLength = 2;
        if(s1.length() < s2.length() && s1.length() >= minLength)
            minLength = s1.length();
        else if(s2.length() < s3.length() && s2.length() >= minLength)
            minLength = s2.length();
        else if(s3.length() < s1.length() && s3.length() >= minLength)
            minLength = s3.length();
        int count = 0;
        if(s1.length() > minLength)
            count += s1.length() - minLength;
        if(s2.length() > minLength)
            count += s2.length() - minLength;
        if(s3.length() > minLength)
            count += s3.length() - minLength;

        return count;
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
