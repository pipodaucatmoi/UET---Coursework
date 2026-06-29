package task46;

import java.util.Arrays;

public class Main{

    public static void main(String[] args) {
        Integer[] list = {5, 1, 2, 3};
        ArrayUtils.sort(list);
        Arrays.stream(list).forEach(item -> System.out.print(item + " "));
        System.out.println();

        String[] list2 = {"Java", "C++", "Python"};
        ArrayUtils.sort(list2);
        Arrays.stream(list2).forEach(item -> System.out.print(item + " "));
        System.out.println();

        Student[] list3 = {new Student("tuyen", "@2006", 3.5), new Student("nam", "@2002", 3.8)};
        ArrayUtils.sort(list3);
        Arrays.stream(list3).forEach(item -> System.out.print(item + " "));
        System.out.println();

        Student[] list4 = {};
        ArrayUtils.sort(list4);
        Arrays.stream(list4).forEach(item -> System.out.print(item + " "));
        System.out.println();


    }
}
