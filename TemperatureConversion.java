import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int temperature = 0;
        while (true) {
            System.out.println("Введите температуру.");
            try {
                temperature = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректные данные.");
                System.exit(0);
            }
            System.out.println("""
                    Введите единицу измерения температуры:
                    C - для Цельсия
                    K - для Кельвина
                    F - для Фаренгейт""");
            String choice = scanner.next().toUpperCase();

            switch (choice) {
                case "C" -> {
                    System.out.println(findFahrenheitForCelsius(temperature));
                    System.out.println(findKelvinForCelsius(temperature));
                }
                case "K" -> {
                    System.out.println(findCelsiusForKelvin(temperature));
                    System.out.println(findFahrenheitForKelvin(temperature));
                }
                case "F" -> {
                    System.out.println(findCelsiusForFahrenheit(temperature));
                    System.out.println(findKelvinForFahrenheit(temperature));
                }
                default -> System.out.println("Неправильный ввод единицы измерения.");
            }
        }
    }

    private static double findFahrenheitForCelsius(double celsius) {
        return celsius * 1.8 + 32;
    }

    private static double findKelvinForCelsius(double celsius) {
        return celsius + 273.15;
    }

    private static double findCelsiusForKelvin(double kelvin) {
        return kelvin - 273.15;
    }

    private static double findFahrenheitForKelvin(double kelvin) {
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    private static double findCelsiusForFahrenheit(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static double findKelvinForFahrenheit(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9 + 273.15;
    }
}