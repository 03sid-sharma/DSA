import java.util.*;

class Main {
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

        // for (Integer item : lastVisitedIntegers(new
        // ArrayList<>(List.of("1","2","prev","prev","prev"))) ) {
        // System.out.println(item);
        // }

        // System.out.println(Arrays.toString(findIndices(new int[]{5,1,4,1},2,4)));
        // System.out.println(shortestBeautifulSubstring("100011001",3));
        // System.out.println(minSum(new int[]{3,2,0,1,0}, new int[]{6,5,0}));
        // System.out.println(findMinimumOperations("abc","abb","ab"));
        // System.out.println(findMinimumOperations("cxx","a","a"));
        // for (Integer item : findWordsContaining(new
        // String[]{"abc","bcd","aaaa","cbc"}, 'a'))
        // {
        // System.out.println(item);
        // }
        // System.out.println(Arrays.toString(lexicographicallySmallestArray(new
        // int[]{5,100,44,45,16,30,14,65,83,64}, 15)));
        // System.out.println(Arrays.toString(findMissingAndRepeatedValues(new
        // int[][]{{9,1,7},{8,9,2},{3,4,6}})));
        // System.out.println(areaOfMaxDiagonal(new int[][]{{9,3},{8,6}}));
        // System.out.println(maxFrequencyElements(new int[]{1,2,3,4,5}));
        // System.out.println(countKeyChanges("mDVD"));
        // System.out.println(triangleType(new int[] { 3,4,5}));
        // System.out.println(returnToBoundaryCount(new int[] { 2,3,-5}));
        // System.out.println(returnToBoundaryCount("abacaba",3));
        // int[][] resultMatrix = modifiedMatrix(new int[][] { {2,-1,2,-1,2},
        // {1,0,-1,2,-1}});

        // Iterate through each row and print using Arrays.toString()
        // for (int i = 0; i < resultMatrix.length; i++) {
        // System.out.println(Arrays.toString(resultMatrix[i]));
        // }

        // System.out.println(countPrefixSuffixPairs(new String[]{ "a", "aba", "ababa",
        // "aa"}));
        // System.out.println(longestCommonPrefix(new int[]{1,10,100},new int[]{1000}));
        // System.out.println(isPossibleToSplit(new int[] { 1, 1, 2, 2, 3, 4 }));
        // System.out.println(minOperations(new int[] { 2, 11, 10, 1, 3 }, 10));
        // System.out.println(Arrays.toString(resultArray(new int[] { 5, 4, 3, 8 })));
        // System.out.println(sumOfEncryptedInt(new int[] { 109 }));
        // System.out.println(isSubstringPresent("abcba"));
        // System.out.println(maximumLengthSubstring("bcbbbcba"));
        // System.out.println(sumOfTheDigitsOfHarshadNumber(23));
        // System.out.println(longestMonotonicSubarray(new int[] { 1,10,10 }));
        // System.out.println(scoreOfString("hello"));
        // System.out.println(findLatestTime("1?:?4"));
        // System.out.println(numberOfSpecialChars("AbBCab"));
        // System.out.println(numberOfSpecialChars("aaAbcBC"));
        // System.out.println(numberOfSpecialChars("cCceDC"));
        // System.out.println(isValid("UuE6"));
        // System.out.println(isValid("UuE6"));
        // System.out.println(lengthOfLastWord("Hello World siddharth"));
        // System.out.println(minimumAverage(new int[] {7,8,3,4,15,13,4,1}));
        // System.out.println(getSmallestString("45320"));
        System.out.println(generateKey(1, 10, 1000)); // Output: 0
        System.out.println(generateKey(987, 879, 798)); // Output: 777
        System.out.println(generateKey(1, 2, 3)); // Output: 1
    }

    public static int generateKey(int num1, int num2, int num3) {
        String str1 = String.format("%04d", num1);
        String str2 = String.format("%04d", num2);
        String str3 = String.format("%04d", num3);

        StringBuilder key = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int digit1 = str1.charAt(i) - '0';
            int digit2 = str2.charAt(i) - '0';
            int digit3 = str3.charAt(i) - '0';

            key.append(Math.min(Math.min(digit1, digit2), digit3));
        }

        return Integer.parseInt(key.toString());
    }

    // public static String getSmallestString(String s) {
    //     char[] chars = s.toCharArray();
    //     boolean swapped = false;

    //     for (int i = 0; i < chars.length - 1; i++) {
    //         int num1 = Character.getNumericValue(chars[i]);
    //         int num2 = Character.getNumericValue(chars[i + 1]);

    //         if (num1 % 2 == num2 % 2) {
    //             if (chars[i] > chars[i + 1]) {
    //                 char temp = chars[i];
    //                 chars[i] = chars[i + 1];
    //                 chars[i + 1] = temp;
    //                 swapped = true;
    //                 break;
    //             }
    //         }
    //     }
    //     return swapped ? new String(chars) : s;
    // }

//     public static double minimumAverage(int[] nums) {
//         int n = nums.length;
//         List<Float> averages = new ArrayList<>();
//         List<Integer> numList = new ArrayList<>();
//         for (int num : nums) 
//             numList.add(num);
        

//         for (int i = 0; i < n / 2; i++) {
//             float min = Arrays.stream(nums).min().orElseThrow(IllegalArgumentException::new);
//             float max = Arrays.stream(nums).max().orElseThrow(IllegalArgumentException::new);

//             averages.add((min + max) / 2.0f);
//             numList.remove(min);
//             numList.remove(max);
//         }
// System.out.println(numList);
// System.out.println(averages);

//         OptionalDouble minAverage = averages.stream()
//                 .mapToDouble(Float::doubleValue)
//                 .min();

//         return minAverage.orElseThrow(IllegalArgumentException::new);
//     }

    // public static int lengthOfLastWord(String s) {
    //     String arr[] = s.trim().split(" ");
    //     return arr[arr.length - 1].length();
    // }

    // public static boolean isValid(String word) {
    //     Set<Character> vowels = new HashSet<>();
    //     Set<Character> symbols = new HashSet<>();
    //     symbols.add('@');
    //     symbols.add('#');
    //     symbols.add('$');
    //     vowels.add('a');
    //     vowels.add('e');
    //     vowels.add('i');
    //     vowels.add('o');
    //     vowels.add('u');

    //     int consonantCount = 0;
    //     int vowelCount = 0;
    //     int symCount = 0;

    //     if (word.length() >= 3) {
    //         for (int i = 0; i < word.length(); i++) {
    //             char ch = Character.toLowerCase(word.charAt(i));
    //             if (vowels.contains(ch)) {
    //                 vowelCount++;
    //             } else if (symbols.contains(ch)) {
    //                 symCount++;
    //             } else if (Character.isLetter(ch)) {
    //                 consonantCount++;
    //             }
    //         }
    //     }
    //     return vowelCount >= 1 && symCount == 0 && consonantCount >= 1;
    // }

    // public static int numberOfSpecialChars(String word) {
    //     boolean[] lowercaseProcessed = new boolean[26];
    //     boolean[] uppercaseOccurred = new boolean[26];

    //     for (int i = 0; i < word.length(); i++) {
    //         char ch = word.charAt(i);
    //         int index = Character.toLowerCase(ch) - 'a';

    //         // Check if it's a lowercase character and it's the first occurrence
    //         if (Character.isLowerCase(ch) && !lowercaseProcessed[index]) {
    //             lowercaseProcessed[index] = true;
    //         }
    //         // Check if it's an uppercase character and its lowercase counterpart has been
    //         // processed
    //         else if (Character.isUpperCase(ch) && lowercaseProcessed[index]) {
    //             // Check if there are no more occurrences of the character in either uppercase
    //             // or lowercase forms
    //             if ((Character.isLowerCase(ch) )  
    //                     || Character.isUpperCase(ch) && word.indexOf(ch, i + 1) == -1 ) {
    //                 uppercaseOccurred[index] = true;
    //             }
    //         }
    //     }

    //     int count = 0;
    //     for (int i = 0; i < 26; i++) {
    //         if (uppercaseOccurred[i]) {
    //             count++;
    //         }
    //     }

    //     return count;
    //     // HashSet<Character> set = new HashSet<>();
    //     // int count = 0;

    //     // for (int i = 0; i < word.length(); i++) 
    //     //     if (word.charAt(i) == Character.toLowerCase(word.charAt(i)) && word.indexOf(Character.toUpperCase(word.charAt(i))) > i && )
    //     //         count++;
            
    //     // return count;

    //     // HashSet<Character> specialChars = new HashSet<>();
    //     // HashSet<Character> processed = new HashSet<>();

    //     // for (int i = 0; i < word.length(); i++) {
    //     //     char ch = word.charAt(i);
    //     //     char lowerCh = Character.toLowerCase(ch);
    //     //     char upperCh = Character.toUpperCase(ch);
            
    //     //     if (ch == lowerCh && !processed.contains(upperCh)) {
    //     //         if (word.indexOf(upperCh) > i) 
    //     //             if (word.indexOf(ch, i + 1) == -1) 
    //     //                 specialChars.add(lowerCh);
    //     //         processed.add(lowerCh);
    //     //     }
    //     // }

    //     // return specialChars.size();

    // }

    // public static String findLatestTime(String s) {
    //     StringBuilder ans = new StringBuilder();

    //     if (s.charAt(0) == '?')
    //         ans.append(Character.valueOf(s.charAt(1)) < 2 ? '1' : '0');
    //     else    
    //         ans.append(s.charAt(0));
        
    //     if (s.charAt(1) == '?')
    //         ans.append(Character.valueOf(s.charAt(0)) < 1 ? '9' : '1');
    //     else
    //         ans.append(s.charAt(1));

    //     ans.append(s.charAt(2));
        
    //     if (s.charAt(3) == '?')
    //         ans.append('5');
    //     else
    //         ans.append(s.charAt(3));
        
    //     if (s.charAt(4) == '?')
    //         ans.append('9');
    //     else
    //         ans.append(s.charAt(4));
        
    //     return ans.toString();        
    // }

    // public static int scoreOfString(String s) {
    //     int sum = 0;
    //     char arr[] = s.toCharArray();

    //     for (int i = 1; i < arr.length; i++) {
    //         int diff = arr[i] - arr[i - 1];
    //         sum += Math.abs(diff);
    //     }
    //     return sum;
    // }

    // public static int longestMonotonicSubarray(int[] nums) {
    //     if (nums.length <= 1) 
    //         return nums.length;
    //     int maxLength = 0; 

    //     int currentLength = 0;
    //     boolean flag = true; 

    //     for (int i = 1; i < nums.length; i++) {
    //         if(nums[i] == nums[i-1] && !flag){
    //             currentLength = 1;
    //             flag = false;
    //         } else if ((nums[i] > nums[i - 1] && flag) || (nums[i] < nums[i - 1] && !flag)) {
    //             currentLength++;
    //         }else{
    //             maxLength = Math.max(maxLength, currentLength);
    //             currentLength = 2;
    //             flag = !flag;
    //         }
    //     }
    //     return Math.max(maxLength, currentLength);
    // }

    // public static int sumOfTheDigitsOfHarshadNumber(int x) {
    //     int num = x;
    //     int sum = 0;
    //     while(num>0){
    //         int dig = num%10;
    //         sum += dig;
    //         num/=10;
    //     }
    //     if(x%sum == 0)
    //         return sum;
    //     return -1;
    // }

    // public static int maximumLengthSubstring(String s) {
    //     int len = s.length();
    //     int ans = 0;
    //     StringBuilder str = new StringBuilder();
    //     Map<Integer, Character> map = new HashMap<>();
    //     for (Character ch : s.toCharArray()) {
    //         int count  = map.getOrDefault(ch, 0) + 1;
    //         if(count <= 2){
    //             map.put(ch, count);
    //         }
            
    //     }
    //     System.out.println(map);
    //     return ans;
    // }

    // public static boolean isSubstringPresent(String s) {
    //     StringBuilder str = new StringBuilder(s);
    //     int j=2;
    //     boolean ans = false;
    //     for (int i = 0; i < str.length() && j< str.length(); i++,j++) {
    //         StringBuilder rev = new StringBuilder(str.substring(i, j));
            
    //         if (rev.reverse().toString().equals(s.substring(i, j))){
    //             ans = true;
    //         }
    //     }
    //     return ans;
    // }

    // public static int sumOfEncryptedInt(int[] nums) {
    //     int sum = 0;

    //     for (int i = 0; i < nums.length; i++) {
            
    //         int digitsReal = (int) Math.floor(Math.log10(nums[i]));
    //         int digits = (int) Math.floor(Math.log10(nums[i]));
    //         int max = -1;
    //         while (digits != -1) {
    //             int a = Character.getNumericValue(String.valueOf(nums[i]).charAt(digits));
    //             max = Math.max(max, a);
    //             digits--;
    //         }
       
    //         if(digitsReal > 0)
    //             sum += replaceDigitsWithMax(nums[i],max);
    //         else
    //             sum +=  replaceDigitsWithMax(nums[i], max);
    //         max = -1;
    //     }
    //     return sum;
    // }
    
    // public static int replaceDigitsWithMax(int number, int max) {
    //     int result = 0;
    //     int multiplier = 1;
    //     int maxDigit = max;
    //     while (number > 0) {
    //         result += maxDigit * multiplier;
    //         multiplier *= 10;
    //         number /= 10;
    //     }
    //     return result;
    // }
    

    // public static int[] resultArray(int[] nums) {
    //     int arr1[] = new int[nums.length+1];
    //     int arr2[] = new int[nums.length+1];

    //     arr1[0] = nums[0];
    //     arr2[0] = nums[1];
    //     int index = 0;
    //     int k=2;
    //     for (int i = 2; i < nums.length; i++) {
    //         if(index == 0){
    //             if (arr1[index] > arr2[index])
    //                 arr1[++index] = nums[i];
    //             else
    //                 arr2[++index] = nums[i];
    //         }else{
                
    //             if (arr1[k] > arr2[k])
    //                 arr1[k] = nums[i];
    //             else
    //                 arr2[k] = nums[i];
    //                 k++;
    //         }
    //     }
    //     System.out.println(Arrays.toString(arr1));
    //     System.out.println(Arrays.toString(arr2));
        
    //     int newItems[] = new int[nums.length];
    //     for (int i = 0; i < arr1.length; i++) 
    //         newItems[i] = arr1[i];
    //     int j=0;
    //     for (int i = newItems.length - 1; i < arr2.length; i++){
    //         newItems[i] = arr2[j++];
    //     }
        
    //     return newItems;
    // }

    // public static int minOperations(int[] nums, int k) {
    // PriorityQueue<Integer> min = new PriorityQueue<>();

    // for (int num : nums)
    // min.offer(num);
    // int count = 0;

    // while (min.peek() < k || min.size() < 2) {
    // int min1 = min.poll();
    // int min2 = min.poll();
    // int sum = Math.min(min1, min2) * 2 + Math.max(min1, min2);
    // min.offer(sum);

    // count++;
    // }

    // return count;
    // }

    // public static boolean isPossibleToSplit(int[] nums) {
    // HashSet<Integer> numsSet = new HashSet<>();
    // int length = nums.length;
    // int targetSize = length / 2;

    // // Ensure the length is even
    // if (length % 2 != 0) {
    // return false;
    // }

    // // Count the distinct elements in the array
    // int distinctCount = 0;

    // for (int num : nums) {
    // if (numsSet.add(num)) {
    // distinctCount++;
    // }
    // }

    // // Check if the number of distinct elements is equal to half of the array
    // length
    // return distinctCount == targetSize;
    // }

    // public static int longestCommonPrefix(int[] arr1, int[] arr2) {
    // int max = 0;

    // for (int i = 0; i < arr1.length; i++) {
    // for (int j = 0; j < arr2.length; j++) {
    // int commonPrefixLength = findCommonPrefixLength(String.valueOf(arr1[i]),
    // String.valueOf(arr2[j]));
    // max = Math.max(max, commonPrefixLength);
    // }
    // }

    // return max;
    // }

    // private static int findCommonPrefixLength(String str1, String str2) {
    // int commonPrefixLength = 0;
    // int minLength = Math.min(str1.length(), str2.length());

    // for (int i = 0; i < minLength; i++) {
    // if (str1.charAt(i) == str2.charAt(i)) {
    // commonPrefixLength++;
    // } else {
    // break;
    // }
    // }

    // return commonPrefixLength;
    // }
    // public static long countPrefixSuffixPairs(String[] words) {
    // long count = 0;
    // for (int i = 0; i < words.length; i++)
    // for (int j = 1; j < words.length ; j++)
    // if(i<j && isPrefixAndSuffix(words[i],words[j]))
    // count++;
    // return count;
    // }

    // private static boolean isPrefixAndSuffix(String str1, String str2){
    // if(str2.startsWith(str1) && str2.endsWith(str1))
    // return true;
    // return false;
    // }

    // public static int[][] modifiedMatrix(int[][] matrix) {
    // int max = -1;
    // for (int i = 0; i < matrix.length; i++) {
    // for (int j = 0; j < matrix.length; j++) {
    // if(matrix[i][j] == -1){
    // for (int j2 = 0; j2 < matrix.length; j2++)
    // max = Math.max(max, matrix[j2][j]);
    // matrix[i][j] = max;
    // max = -1;
    // }
    // }
    // }
    // return matrix;
    // }

    // public static int minimumTimeToInitialState(String word, int k) {
    // int count = 0;
    // for (int i = 0; i < word.length(); i++) {
    // String sub = word.rem;
    // StringBuilder ss = new StringBuilder();
    // ss.append(sub);
    // }
    // return count;
    // }

    public static int returnToBoundaryCount(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return 0;

        int ans = 0;
        int count = n;
        int boundary = n;

        for (int i : nums) {
            if (i > 0)
                count += i;
            else
                count -= Math.abs(i);
            if (count == Math.abs(boundary))
                ans++;
        }
        return ans;
    }

    public static String triangleType(int[] nums) {
        if (nums[0] + nums[1] > nums[2] && nums[2] + nums[1] > nums[0] && nums[0] + nums[2] > nums[1]) {
            if (nums[0] != nums[1] && nums[2] != nums[1] && nums[0] != nums[2])
                return "scalene";
            else if (nums[0] == nums[1] && nums[2] == nums[1] && nums[0] == nums[2])
                return "equilateral";
            else
                return "isosceles";
        } else
            return "none";
    }

    public static int countKeyChanges(String s) {
        if (s.length() <= 1)
            return 0;
        int count = 0;
        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.toLowerCase(ch) != Character.toLowerCase(prev))
                count++;

            prev = ch;
        }

        return count;
    }

    public static int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
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

        return new int[] { a, b };
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
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (ch == x) {
                    result.add(count);
                    break;
                }
            }
            count++;
        }

        return result;
    }

    public static int findMinimumOperations(String s1, String s2, String s3) {

        if (s1.length() < 2 && s2.length() < 2 && s3.length() < 2)
            return 0;

        if (s1.length() == s2.length() && s2.length() == s3.length() && s3.length() == s1.length()
                || s1.length() < 2 || s2.length() < 2 || s3.length() < 2)
            return -1;

        int minLength = 2;
        if (s1.length() < s2.length() && s1.length() >= minLength)
            minLength = s1.length();
        else if (s2.length() < s3.length() && s2.length() >= minLength)
            minLength = s2.length();
        else if (s3.length() < s1.length() && s3.length() >= minLength)
            minLength = s3.length();
        int count = 0;
        if (s1.length() > minLength)
            count += s1.length() - minLength;
        if (s2.length() > minLength)
            count += s2.length() - minLength;
        if (s3.length() > minLength)
            count += s3.length() - minLength;

        return count;
    }

    public static long minSum(int[] nums1, int[] nums2) {
        long minSum = 0;

        return minSum;
    }

    public static String shortestBeautifulSubstring(String s, int k) {

        int count = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '1')
                count++;
        }

        if (count == k) {

        }

        return "";
    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[] { -1, -1 };

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
        int num1 = 0, num2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0)
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
            if (ch == '1')
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
        ArrayList<Integer> sorted = new ArrayList<>(List.of(4, 5, 1, 2, 3));
        Collections.sort(sorted);
        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (!nums.equals(sorted)) {
                Collections.rotate(nums, 1);
                count++;
            }
        }
        System.out.println(count);
    }
}
