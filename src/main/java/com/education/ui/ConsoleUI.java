package com.education.ui;

import java.util.List;
import java.util.Scanner;

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

    public int getUserIntInput(){
        return scanner.nextInt();
    }
}
