package Converter;

import java.util.*;

import static Converter.Converter.convertValues;
import static Converter.Converter.showMenu;

public class ConverterApp {
    public static void main(String[] args) {
        Scanner usInput = new Scanner(System.in);
        int inputValue = 0;

        while (inputValue != 99) {
            showMenu();
            while (!usInput.hasNextInt() && !usInput.hasNextDouble()) {
                System.out.println("Only numbers allowed!!!");
                usInput.next();
            }
            if (usInput.hasNextInt()) {
                inputValue = usInput.nextInt();
            }
            switch (inputValue) {
                case 1 -> convertValues("Us dollar", "Bolivian peso", 6.95, usInput);
                case 2 -> convertValues("Bolivian peso", "US dollar", 1 / 6.95, usInput);
                case 3 -> convertValues("Us dollar", "Argentinian peso",
                        550.0, usInput);
                case 4 -> convertValues("Argentinian peso", "US dollar",
                        1 / 550.0, usInput);
                case 5 -> convertValues("Argentinian peso", "Bolivian peso",
                        6.95 / 550, usInput);
                case 6 -> convertValues("Bolivian peso", "Argentinian peso",550/6.95, usInput);
                case 99 -> System.out.println("Exiting program");
                default -> System.out.println("Enter a valid option. ");
            }
            System.out.println();
        }
        usInput.close();
    }
}
