package javaassignment4;

import java.util.ArrayList;

public class Assignment4Q4 {
    public ArrayList<String> removeOddLength(ArrayList<String> employeeList) {
        employeeList.removeIf(s -> s.length() % 2 != 0);
        return employeeList;
    }

    public static void main(String[] args) {
        ArrayList<String> employeeList = new ArrayList<>();
        employeeList.add("John");
        employeeList.add("Jane");
        employeeList.add("Jack");
        employeeList.add("Doe");
        employeeList.add("Smith");

        Assignment4Q4 obj = new Assignment4Q4();
        System.out.println("Before removing odd length words: " + employeeList);
        obj.removeOddLength(employeeList);
        System.out.println("After removing odd length words: " + employeeList);
    }
}