import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FooBarQixApp {

    // Map rules
    public static Map<Integer,String> divide = new HashMap();
    public static Map<Character,String> contains = new HashMap();

    public static void main(String[] args){
        // Add rules
        divide.put(3,"Foo");
        divide.put(5,"Bar");
        divide.put(7,"Qix");
        contains.put('3',"Foo");
        contains.put('5',"Bar");
        contains.put('7',"Qix");
        contains.put('0',"*");
    }

    public static String compute(String input){
        // vars
        String result = "";
        int value = Integer.valueOf(input);

        // First check dividers
        for (Map.Entry<Integer, String> entry : divide.entrySet())
            if(value % entry.getKey() == 0)
                result += entry.getValue();

        // Replace chars
        char[] chars = input.toCharArray();
        for(char current : chars){
            for (Map.Entry<Character, String> entry : contains.entrySet()){
                if(current == entry.getKey()) {
                    result += entry.getValue();
                }
            }
        }

        // No rules applied || Fix step 2
        if(result.isEmpty() || (result.replace("*","")).isEmpty()) {
            return input.replace("0", "*");
        }

        return result;
    }
}
