package utils.math;

import utils.array.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static define.Predef.requier;

public class MathUtil {

    public static <T> ArrayList<ArrayList<T>> permuteList(ArrayList<T> list) {

        requier(list != null && list.size() >= 2);
        int listSize = list.size();
        ArrayList<ArrayList<T>> permutedLists = new ArrayList<>(listSize);

        if (listSize == 2) {
            permutedLists.add(list);
            permutedLists.add(new ArrayList<>(Arrays.asList(list.get(1), list.get(0))));
            return permutedLists;
        } else {
            for (int i = 0; i < listSize; i++) {
                T elem = list.get(i);
                ArrayList<T> otherElements = ArrayUtil.getOtherElements(list, i);
                for (ArrayList<T> e : permuteList(otherElements)) {
                    e.add(0, elem);
                    permutedLists.add(e);
                }
            }
            return permutedLists;
        }
    }

    public static <T> Set<Set<T>> getAllSubsetsOfSet(ArrayList<T> list) {

        requier(list != null && list.size() >= 1);
        Set<Set<T>> allSubsets = new HashSet<>();
        if (list.size() == 1) {
            allSubsets.add(new HashSet<T>());
            allSubsets.add(new HashSet<>(list));
            return allSubsets;
        } else {
            T elem = list.remove(list.size() - 1);
            Set<Set<T>> subsets = getAllSubsetsOfSet(list);
            for (Set<T> t : subsets) {
                allSubsets.add(new HashSet<>(t));
                t.add(elem);
                allSubsets.add(new HashSet<>(t));
            }
            return allSubsets;
        }
    }

    /**
     * @param number any natural number
     * @return is this number is prime
     */
    public static Boolean isPrimeNumber(Long number) {

        requier(number > 0);
        Set<Long> primes = getPrimesUp(number);
        return primes.contains(number);
    }

    public static Boolean isPrimeNumber(Integer number) {

        requier(number > 0);
        Set<Long> primes = getPrimesUp(Long.valueOf(number));
        return primes.contains(number);
    }

    public static Set<Long> getPrimesUp(Long upNumber) {
        requier(upNumber > 0);

        Set<Long> primes = new TreeSet<>();
        primes.add(1L);
        if (upNumber == 1) {
            return primes;
        }

        long number = 2;
        while (number <= upNumber) {
            Boolean isPrime = true;
            for (long prime : primes) {
                if (prime == 1) continue;
                if (number % prime == 0 && prime < number) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(number);
                System.out.println("added prime number: " + number);
            }
            number++;
        }
        return primes;
    }

    public static Integer getLargestPrimeFactor(Long upNumber){

        long number = 2;
        Set<Integer> primeFactors = new HashSet<>();
        while (number <= upNumber){
            if (upNumber % number == 0){
                upNumber = upNumber / number;
                primeFactors.add((int) number);
                number = 1;
            }
            number++;
        }
        return Collections.max(primeFactors);
    }
}
