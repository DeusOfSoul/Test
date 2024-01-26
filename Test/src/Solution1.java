import java.util.*;

class Solution1 {
    public int solution(String letters) {

        Set<Character> smallCase = new HashSet<>();
        HashMap<Character, Boolean> map = new HashMap<>();
        for(char c: letters.toCharArray()){
            if(c >= 'A' && c <= 'Z'){
                // Process upper case
                char low = Character.toLowerCase(c);

                // Only add upper case to map if unknown
                if(!map.containsKey(c)){
                    //check if small case already appeared
                    map.put(c, smallCase.contains(low));
                }
                continue;
            }

            // Process lower case
            smallCase.add(c);

            if (map.containsKey(Character.toUpperCase(c))){
                map.put(Character.toUpperCase(c), false);
            }
        }

        // True in map means rules are fulfilled
        int count = 0;
        for (boolean b: map.values()){
            if (b) count++;
        }

        return count;
    }
}