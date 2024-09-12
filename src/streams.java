import java.net.Inet4Address;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class streams {
    // Remove duplicates from a list
    public static List<Integer> removeDuplicates(List<Integer> list){
        return list.stream().distinct().collect(Collectors.toList());
    }

    //Count the frequency of the character in a string
    public int countChar(String s){
        return 1;
    }

    //Count the frequency of elements in a list
    public static void countElementsInList(List<Integer> list){
        Map<Integer,Long> map = list.stream()
                .collect(Collectors.groupingBy(e -> e,Collectors.counting()));
        map.forEach((key,value)->System.out.println(key+":"+" "+value));
    }

    // Multiples of 5
    public List<Integer> multipleOfFive(List<Integer> list){
        return list.stream().filter(e -> e%5==0).collect(Collectors.toList());
    }

    //Find the max and min of list
    public void maxAndMin(List<Integer> list){
        Optional<Integer> max = list.stream().reduce(Integer::max);
        Optional<Integer> min = list.stream().reduce(Integer::min);
        System.out.println("maximum: "+max.orElse(null));
        System.out.println("minimum: "+min.orElse(null));
    }

    //Sum of a list
    public Integer sumOfList(List<Integer> list){
        return list.stream().reduce(0,(a,b)->a+b);
    }

    //Sort arrays
    public List<Integer> sortArrays(List<Integer> list){
        return list.stream().sorted().collect(Collectors.toList());
    }

    //combine two unsorted list into single sorted list
    public List<Integer> combineAndSort(List<Integer> l1, List<Integer> l2){
        return Stream.concat(l1.stream(),l2.stream()).distinct().sorted().collect(Collectors.toList());
    }

    //Three maximum and three minimum numbers from a given list of integers
    public void threeMaxAndMin(List<Integer> list){
        List<Integer> threeMax = list.stream().sorted().limit(3).collect(Collectors.toList());
        List<Integer> threeMin = list.stream().sorted((a,b)->b-a).limit(3).collect(Collectors.toList());
        System.out.println(threeMin);
        System.out.println(threeMax);
    }

    //sum of digits in a number
    public int sumOfDigits(int n){
        return Integer.toString(n).chars().map(Character::getNumericValue).reduce(0,(a,b) -> a+b);
    }

    //find the second largest number in intger array
    public int secondLarge(int[] arr){
        List<Integer> newArray = Arrays.stream(arr).boxed().sorted((a,b)->b-a).limit(2).collect(Collectors.toList());
        return newArray.getLast();
    }

    //find the sum and average of elements in array
    public void sumAndAverage(int[] arr){
        int sum = Arrays.stream(arr).boxed().reduce(0,(a,b) -> a+b);
        System.out.println(sum);
        OptionalDouble average = Arrays.stream(arr).average();
        if(average.isPresent()){
            System.out.println(average.getAsDouble());
        }
    }

    //reverse each word of a string
    public String reverse(String s){
        return Arrays
                .stream(s.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    //find the sum of first 5 numbers
    public int firstFive(int n){
        int n1 =IntStream.range(1,5).sum();
        return Integer.toString(n).chars().map(Character::getNumericValue).limit(5).sum();
    }

    //reverse integer array
    public int[] reverseIntArray(int[] arr){
        return Arrays
                .stream(arr) //int stream
                .boxed() //integer stream
                .sorted(Collections.reverseOrder()) //reversing
                .mapToInt(Integer::intValue) //converting back to int stream
                .toArray(); // int stream to array
    }

    //Find the first repeated character in a string
    public char findFirstRepeatedChar(String s){
        HashSet<Character> set = new HashSet<>();
         Optional t = s.chars()
                 .mapToObj(c -> (char) c)
                 .filter(c -> !set.add(c))
                 .findFirst();
         if(t.isPresent()){
             return (char) t.get();
         }
        return '\0';
    }

    //Print first 10 odd numbers
    public void firstTenOdd(){
        IntStream.iterate(1,n->n+2).limit(10).forEach(System.out::println);
    }
}

