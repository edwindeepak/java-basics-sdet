import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class InterviweQuestions {

    //

    public static void main(String[] args) {
        // Can you write a function to return the first non-repeating character in a
        // given string?
        String s = "Thos way is better";
        Set<Character> set = new HashSet<>();
        for (char x : s.toCharArray()) {
            if (set.contains(x)) {
                if (x == ' ')
                    continue;
                System.out.println("The first repeating character is  " + x);
                break;
            }
            else{
                set.add(x);
            }
        }

    }

  

}
