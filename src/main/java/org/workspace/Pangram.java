package org.workspace;

import org.workspace.annotations.Interview;

import java.util.Arrays;

/**
 * Given a string, identify if all the characters from a to z are present in the string (Pangram problem)
 *
 * @author Ankur Agarwal
 */
@Interview
public class Pangram {
    public static void main(String[] args) {
        String s = "ankur";
        Pangram obj = new Pangram();
        System.out.println(obj.isPangram(s));
    }

    private boolean isPangram(String string){
        string = string.toLowerCase();

        int[] array = new int[26];
        Arrays.fill(array, 0);
        for(char c : string.toCharArray()){
            array[c-'a'] = 1;
        }

        for (int i : array){
            if(i==0)
                return false;
        }

        return true;
        /*return string.chars().boxed().distinct().count() == 26;*/
    }
}
