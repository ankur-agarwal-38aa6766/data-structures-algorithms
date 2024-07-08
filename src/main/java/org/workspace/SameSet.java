package org.workspace;

import java.util.Arrays;

public class SameSet {

    public static void main(String[] args) {
        SameSet obj = new SameSet();
        System.out.println(obj.checkFor("epam", "pamee", "aepm"));
    }

    private boolean checkFor(String... set){
        char[] checkString = set[0].toCharArray();
        Arrays.sort(checkString);//nlogn

        for(String s : set){//n
            char[] charSet = s.toCharArray();
            Arrays.sort(charSet);//nlogn
            if(!Arrays.equals(checkString, charSet))
                return false;
        }
        return true;
    }
}
