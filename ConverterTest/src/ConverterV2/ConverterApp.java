package ConverterV2;

import java.util.*;

import static ConverterV2.Converter.Currency.*;
import static ConverterV2.Converter.displayMenu;


public class ConverterApp {
    public static void main(String[] args) {
        Scanner menuChoice = new Scanner(System.in);
        int menuOptionValue = 0;

        Scanner userInput = new Scanner(System.in);

        while (menuOptionValue != 99) {
            displayMenu();

            while (!menuChoice.hasNextInt()) {
                System.out.println("Only numbers ");
                menuChoice.next();
            }

            menuOptionValue = menuChoice.nextInt();
            menuChoice.nextLine();
            
            switch (menuOptionValue) {         
                case 1 -> Converter.convertCurrency(USD, BOLIVIAN_PESO, userInput);
                case 2 -> Converter.convertCurrency(BOLIVIAN_PESO, USD, userInput);
                case 3 -> Converter.convertCurrency(USD, ARGENTINIAN_PESO_BLUE, userInput);
                case 4 -> Converter.convertCurrency(USD, ARGENTINIAN_PESO_OFFICIAL, userInput);
                case 5 -> Converter.convertCurrency(ARGENTINIAN_PESO_BLUE, USD, userInput);
                case 6 -> Converter.convertCurrency(ARGENTINIAN_PESO_OFFICIAL, USD, userInput);
                case 7 -> Converter.convertCurrency(BOLIVIAN_PESO, ARGENTINIAN_PESO_BLUE, userInput);
                case 8 -> Converter.convertCurrency(BOLIVIAN_PESO, ARGENTINIAN_PESO_OFFICIAL, userInput);
                case 9 -> Converter.convertCurrency(ARGENTINIAN_PESO_BLUE, BOLIVIAN_PESO, userInput);
                case 10 -> Converter.convertCurrency(ARGENTINIAN_PESO_OFFICIAL, BOLIVIAN_PESO, userInput);
                case 11 -> Converter.convertCurrency(BRAZILIAN_REAL, BOLIVIAN_PESO, userInput);
                case 12 -> Converter.convertCurrency(BOLIVIAN_PESO, BRAZILIAN_REAL, userInput);
                case 13 -> Converter.convertCurrency(BRAZILIAN_REAL, ARGENTINIAN_PESO_BLUE, userInput);
                case 14 -> Converter.convertCurrency(ARGENTINIAN_PESO_BLUE, BRAZILIAN_REAL, userInput);
                case 99 -> System.out.println("Exiting program...");
                default -> System.out.println("Select a valid option!");
            }
            System.out.println();
        }
        menuChoice.close();
    }

}
