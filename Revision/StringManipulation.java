import java.util.*;

class StringManipulation{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        // System.out.println("Vowels are " + countVowels(str));
        // System.out.println("Reverse String: " + reverseString(str));
        // System.out.println("Reverse Words: '" + reverseWord(str)+"'");
        // System.out.println("Rotation possible : " + isRotation("ABCD","DACB"));
        // System.out.println("Is Palindrome : " + isPalindrome(str));
        // System.out.println("Removed Duplicates : " + removeDuplicates(str));
        System.out.println("Find most repeated : " + findMostRepeated(str));
        
        scan.close();
    }

    private static char findMostRepeated(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for(Character ch:str.toCharArray())
            map.put(ch, map.containsKey(ch) ? map.get(ch) + 1 : 1);

        int max = 0;
        char result = 'a';
        for (var item: map.entrySet()) {
            if(item.getValue() > max){
                max = item.getValue();
                result = item.getKey();
            }
        }
        return result;
    }

    private static String removeDuplicates(String str) {
        Set<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for(Character ch: str.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                result.append(ch);
            }
        }
        return result.toString();
    }

    private static boolean isPalindrome(String str) {
        // return str.equals(new StringBuilder(str).reverse().toString());

        // Faster Solution
        int left = 0;
        int right = str.length() - 1;

        while (left < right)
            if(str.charAt(left++) == str.charAt(right--))
                return true;
        return false;
    }

    private static boolean isRotation(String str1,String str2) {
        return (str1.length() == str2.length() && 
            (str1 + str1).contains(str2));
    }

    private static String reverseWord(String str) {
        String words[] = str.trim().split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
        // StringBuilder result = new StringBuilder();

        // for (int i = words.length - 1; i >= 0; i--) 
        //     result.append(words[i] + " ");
        
        // return result.toString().trim();
    }

    private static String reverseString(String str) {
        Stack<Character> rev = new Stack<>();

        for (Character ch : str.toCharArray())
            rev.push(ch);

        StringBuilder result = new StringBuilder();
        
        while (!rev.isEmpty())
            result.append(rev.pop());

        return result.toString();
        // return new StringBuilder(str).reverse();
    }

    private static int countVowels(String str) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int count = 0;
        
        for (Character ch:str.toLowerCase().toCharArray())
            if(set.contains(ch))
                count++;

        return count;
    }
    
}