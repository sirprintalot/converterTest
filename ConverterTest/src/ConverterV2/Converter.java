package ConverterV2;

import java.util.*;

public class Converter {
    public enum Currency {

        USD("US dollar"),
        BOLIVIAN_PESO("Bolivian peso"),
        ARGENTINIAN_PESO_BLUE("Argentinian peso blue"),
        ARGENTINIAN_PESO_OFFICIAL("Argentinian peso official"),
        BRAZILIAN_REAL("Brazilian real");

        private final String name;

        Currency(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    //USD
    public static final double USD_TO_BOLIVIAN_PESO = 6.95;
    public static final double US_DOLLAR_TO_ARGENTINIAN_PESO_BLUE = 551.0;
    public static final double US_DOLLAR_TO_ARGENTINIAN_PESO_OFFICIAL = 273.65;
    public static final double US_DOLLAR_TO_BRAZILIAN_REAL = 4.72;

    //BOL peso
    public static final double BOLIVIAN_PESO_TO_US_DOLLAR = 1 / USD_TO_BOLIVIAN_PESO;
    public static final double BOLIVIAN_PESO_TO_ARGENTINIAN_PESO_BLUE = 6.95 / 551;
    public static final double BOLIVIAN_PESO_TO_ARGENTINIAN_PESO_OFFICIAL = 6.95 / 273.65;
    public static final double BOLIVIAN_PESO_TO_BRAZILIAN_REAL = 6.95 / 4.72;

    //Arg peso
    public static final double ARGENTINIAN_PESO_OFFICIAL_TO_US_DOLLAR = 1 / US_DOLLAR_TO_ARGENTINIAN_PESO_OFFICIAL;
    public static final double ARGENTINIAN_PESO_BLUE_TO_US_DOLLAR = 1 / US_DOLLAR_TO_ARGENTINIAN_PESO_BLUE;
    public static final double ARGENTINIAN_PESO_BLUE_TO_BOLIVIAN_PESO = 1 / BOLIVIAN_PESO_TO_ARGENTINIAN_PESO_BLUE;
    public static final double ARGENTINIAN_PESO_OFFICIAL_TO_BOLIVIAN_PESO = 1 / BOLIVIAN_PESO_TO_ARGENTINIAN_PESO_OFFICIAL;
    public static final double ARGENTINIAN_PESO_BLUE_TO_BRAZILIAN_REAL = 551 / 4.72;
    public static final double ARGENTINIAN_PESO_OFFICIAL_TO_BRAZILIAN_REAL = 273.65 / 4.72;

    //BR real
    public static final double BRAZILIAN_REAL_TO_US_DOLLAR = 1 / US_DOLLAR_TO_BRAZILIAN_REAL;
    public static final double BRAZILIAN_REAL_TO_BOLIVIAN_PESO = 1 / BOLIVIAN_PESO_TO_BRAZILIAN_REAL;
    public static final double BRAZILIAN_REAL_TO_ARGENTINIAN_PESO_OFFICIAL =
            1 / ARGENTINIAN_PESO_OFFICIAL_TO_BRAZILIAN_REAL;
    public static final double BRAZILIAN_REAL_TO_ARGENTINIAN_PESO_BLUE = 1 / ARGENTINIAN_PESO_BLUE_TO_BRAZILIAN_REAL;

    public static void displayMenu() {
        System.out.println("""
                ============================================================================
                ----------------------------CONVERTER 2.0----------------------------------
                CHOOSE AN OPTION:\s
                1) US dollar to bolivian peso.
                2) Bolivian peso to us dollar.
                3) US dollar to argentinian blue peso.
                4) US dollar to argentinian official peso.
                5) Argentinian peso blue to US dollar.
                6) Argentinian peso official to US dollar.
                7) Bolivian peso to Argentinian Blue peso.
                8) Bolivian peso to Argentinian official peso.
                9) Argentinian peso blue to Bolivian peso.
                10) Argentinian peso official to Bolivian peso.
                11) Brazilian real to Bolivian peso.
                12) Bolivian peso to Brazilian real.
                13) Brazilian peso to Argentinian peso blue.
                14) Argentinian peso blue to Brazilian real.
                99) EXIT.               \s
                 """);
        System.out.println("====================================================================");
    }

    public static double getExchangeRate(Currency fromCurrency, Currency toCurrency) {
        switch (fromCurrency) {
            case USD : {
                switch (toCurrency) {
                    case BOLIVIAN_PESO : {
                        return USD_TO_BOLIVIAN_PESO;
                    }
                    case ARGENTINIAN_PESO_OFFICIAL : {
                        return US_DOLLAR_TO_ARGENTINIAN_PESO_OFFICIAL;
                    }
                    case ARGENTINIAN_PESO_BLUE : {
                        return US_DOLLAR_TO_ARGENTINIAN_PESO_BLUE;
                    }
                    case BRAZILIAN_REAL : {
                        return US_DOLLAR_TO_BRAZILIAN_REAL;
                    }

                }
                break;
            }
            case BOLIVIAN_PESO : {
                switch (toCurrency) {
                    case USD -> {
                        return BOLIVIAN_PESO_TO_US_DOLLAR;
                    }
                    case ARGENTINIAN_PESO_OFFICIAL -> {
                        return BOLIVIAN_PESO_TO_ARGENTINIAN_PESO_OFFICIAL;
                    }
                    case ARGENTINIAN_PESO_BLUE -> {
                        return BOLIVIAN_PESO_TO_ARGENTINIAN_PESO_BLUE;
                    }
                    case BRAZILIAN_REAL -> {
                        return BOLIVIAN_PESO_TO_BRAZILIAN_REAL;
                    }
                }
                break;
            }

            case ARGENTINIAN_PESO_BLUE : {
                switch (toCurrency) {
                    case USD -> {
                        return ARGENTINIAN_PESO_BLUE_TO_US_DOLLAR;
                    }
                    case BOLIVIAN_PESO -> {
                        return ARGENTINIAN_PESO_BLUE_TO_BOLIVIAN_PESO;
                    }
                    case BRAZILIAN_REAL -> {
                        return ARGENTINIAN_PESO_BLUE_TO_BRAZILIAN_REAL;
                    }
                }
                break;
            }

            case ARGENTINIAN_PESO_OFFICIAL : {
                switch (toCurrency) {
                    case USD -> {
                        return ARGENTINIAN_PESO_OFFICIAL_TO_US_DOLLAR;
                    }
                    case BOLIVIAN_PESO -> {
                        return ARGENTINIAN_PESO_OFFICIAL_TO_BOLIVIAN_PESO;
                    }
                    case BRAZILIAN_REAL -> {
                        return ARGENTINIAN_PESO_OFFICIAL_TO_BRAZILIAN_REAL;
                    }
                }
                break;
            }

            case BRAZILIAN_REAL : {
                switch (toCurrency) {
                    case USD -> {
                        return BRAZILIAN_REAL_TO_US_DOLLAR;
                    }
                    case BOLIVIAN_PESO -> {
                        return BRAZILIAN_REAL_TO_BOLIVIAN_PESO;
                    }
                    case ARGENTINIAN_PESO_OFFICIAL -> {
                        return BRAZILIAN_REAL_TO_ARGENTINIAN_PESO_OFFICIAL;
                    }
                    case ARGENTINIAN_PESO_BLUE -> {
                        return BRAZILIAN_REAL_TO_ARGENTINIAN_PESO_BLUE;
                    }
                }
                break;
            }

        }
        throw new IllegalArgumentException("Unsupported currency");
    }

    public static void convertCurrency(Currency fromCurrency, Currency toCurrency, Scanner amount) {

        double rate = getExchangeRate(fromCurrency, toCurrency);
        double amountToConvert = amount.nextDouble();
        amount.nextLine();
        double total = rate * amountToConvert;
        
        System.out.println("You choose to convert " + fromCurrency.getName() + " to " + toCurrency.getName());
        System.out.println("Enter the amount to be converted: ");
        System.out.printf("%.2f %s is equal to: %.2f %s%n", amountToConvert, fromCurrency.getName(), total, toCurrency.getName());

    }


}
