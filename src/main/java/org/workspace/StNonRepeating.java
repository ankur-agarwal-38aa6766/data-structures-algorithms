package org.workspace;

public class StNonRepeating {

    public static void main(String[] args) {
        StNonRepeating obj  = new StNonRepeating();

        System.out.println(obj.stNonReating("abcdcaf"));
    }
    private int stNonReating(String s){
        int[] freq = new int[26];

        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }

        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(freq[c - 'a'] == 1)
                return i+1;
        }

        return -1;
    }
}
