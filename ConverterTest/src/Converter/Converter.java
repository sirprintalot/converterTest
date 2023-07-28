package Converter;

import java.util.*;

public class Converter {

    static String title = """
            =============================================================
            _________________________CONVERTER____________________________
            Choose an option:\s""";

    static String menu = """
                          1) US dollar to Bolivian peso.
                          2) Bolivian peso to US dollar.
                          3) US dollar to Argentinian peso.
                          4) Argentinian peso to US dollar.
                          5) Argentinian peso to Bolivian peso.
                          6) Bolivian peso to Argentinian peso.
                          99) EXIT.\s""";

    public static void showMenu(){
        System.out.println(title);
        System.out.println(menu);
    }

    public static void convertValues(String selectedCurrency, String destinationCurrency, Double proportion,
                                     Scanner userInput){
        System.out.println("Choose convert " + selectedCurrency + " to " + destinationCurrency);
        System.out.println("Enter the amount to be converted: ");
        double value = userInput.nextDouble();
        double total = value * proportion;
        System.out.println(value + " " + selectedCurrency + " equals " + total + " " + destinationCurrency);
    }
}
