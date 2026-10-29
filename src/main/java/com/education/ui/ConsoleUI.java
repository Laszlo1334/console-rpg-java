package com.education.ui;

import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public void showMessage (String message){
        System.out.println(message);
    }

    public void showMessage (List<String> messages){
        for(String message : messages){
            System.out.println(message);
        }
    }

    public int getValidIntInput(int min, int max){
        while(true){
            if(!scanner.hasNextInt()){
                showMessage("Invalid input. Please enter the number.");
                scanner.next();
                continue;
            }
            int input = scanner.nextInt();
            if((input < min) || (input > max)){
                showMessage("Invalid input! Enter a number between " + min + " and " + max + ".");
                continue;
            }
            return input;
        }
    }

    public <T> T selectFromList (String header, List<T> items, Function<T, String> formatter) {
        showMessage(header);

        if (items.isEmpty()) {
            showMessage("Nothing to choose from!");
            return null;
        }
        // Print the numbered list of items
        for (int i = 0; i < items.size(); i++) {
            T currentObject = items.get(i);
            //formater.apply() takes the object(Item/Ability/etc) and turns
            //it into the String
            String textToPrint = formatter.apply(currentObject);

            showMessage((i + 1) + ". " + textToPrint);
        }
        showMessage("0. Go back");
        //Get valid choice
        int choice = getValidIntInput(0, items.size());
        // 3. Return the correct object
        if(choice == 0) return null; // For Go back option
        else return items.get(choice - 1);

    }
}
