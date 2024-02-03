package PROGRAMMING_2.Discussion7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BigCompanies {
    public static void main(String[] args) {
        List<String> companySuggestions = new ArrayList<>();
        companySuggestions.add("Amazon");
        companySuggestions.add("Tesla");
        companySuggestions.add("Amazon"); 

        System.out.println("Big Company Suggestions (List): " + companySuggestions);


        Set<String> uniqueCompanySuggestions = new HashSet<>();
        for (int i = 0; i < companySuggestions.size(); i++) {
            uniqueCompanySuggestions.add(companySuggestions.get(i));
        }
        
        System.out.println("Big Company Suggestions (Set): " + uniqueCompanySuggestions);

    }
}