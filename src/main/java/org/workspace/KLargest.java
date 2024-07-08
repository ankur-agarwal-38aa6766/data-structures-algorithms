package org.workspace;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class KLargest {

    private int ndLargestEvenNumber(List<Integer> list/*Emplyeess*/, int k){
        Optional<Integer> result = list.stream()
                .distinct()
                .filter(n -> (n&1)==0) //filter for gender {Ladies}
                .sorted(Comparator.reverseOrder()) // (e1,e2) -> e1.salary - e2.salary
                .skip(k-1)
                .findFirst();

        return result.orElse(-1);
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,9,8,2,4,6,7,1,3,5);
        KLargest obj = new KLargest();
        int k = 2;
        System.out.println("Result : " + obj.ndLargestEvenNumber(list, k));
    }


}
