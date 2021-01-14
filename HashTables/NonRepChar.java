import java.util.*;

class NonRepChar {
    public static void main(String[] args) {
        String str="a green apple";
        CharFinder cf=new CharFinder();
        
        System.out.println(cf.findFirstNonRepeated(str));
        System.out.println(cf.findFirstRepeated(str));
    
    }
}

class CharFinder{
    public char findFirstNonRepeated(String str){
        Map<Character,Integer> map=new HashMap<>();
        var chars=str.toCharArray();
        for(Character ch:chars){
            var count=map.containsKey(ch)?map.get(ch):0;
            map.put(ch,count+1);
        }
        for (Character ch:chars){
            if(map.get(ch)==1)
                return ch;
        }
        return Character.MIN_VALUE;
    }

    public char findFirstRepeated(String str){
        Set<Character> set=new HashSet<>();

        for(Character ch:str.toCharArray()){
            if(set.contains(ch))
                return ch;

            set.add(ch);
        }

        return Character.MIN_VALUE;
    }
}