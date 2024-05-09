import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int persons = BillCalculator.amountRequest();
        HashMap<ArrayList<String>, Float> finalProductMap = BillCalculator.Calculator();
    }
}

class BillCalculator {


    // Запрос и проверка корректности количества человек
    public static int amountRequest() {
        Scanner scanner = new Scanner(System.in);
        int personsAmount = 0;

        while (personsAmount <= 1) {
            System.out.println("Уточните, пожалуйста, на сколько персон необходимо разделить счет?\nКоличество: ");
            personsAmount = scanner.nextInt();
            if (personsAmount == 1) {
                System.out.println("Тогда нет смысла делить счет :)");
            } else if (personsAmount <= 0) {
                System.out.println("Введено некорректное значение. Попробуйте снова.");
            }
        }
        return personsAmount;
    }


    // Метод getCost для try-catch
    public static float getCost() {
        Scanner scanner = new Scanner(System.in);
        float getCost = scanner.nextFloat();
        return getCost;
    }


    //Обработка окончаний для вывода
    public static String properTextEnd(float inCost) {
        String textEnd = "";
        int temp = (int)inCost % 10;
        if (temp == 1) {
            textEnd = "ь";
        } else if (temp > 1 & temp < 5) {
            textEnd = "я";
        } else {
            textEnd = "ей";
        }
        return textEnd;
    }


    // Калькулятор товаров
    public static HashMap<ArrayList<String>, Float> Calculator() {

        Scanner scanner = new Scanner(System.in);
        HashMap<ArrayList<String>, Float> productHashMap = new HashMap<>();

        String command = "";
        ArrayList<String> productList = new ArrayList<>();
        float totalCost = 0.0f;
        float productCost = 0.0f;

        while (!command.equals("завершить")) {
            System.out.println("Введите название товара: ");
            String productName = scanner.next();

            //Запрос и проверка ввода стоимости
            while (true) {
                System.out.println("Введите стоимость товара: ");
                try {
                    productCost = getCost();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректное значение стоимости");
                }
            }

            productList.add(productName);
            totalCost = totalCost + productCost;
            System.out.printf("Товар '%s' стоимостью %.2f рубл%s успешно добавлен.\n", productName, productCost, properTextEnd(productCost));

            System.out.println("Хотите добавить еще товар? (Для завершения ввода введите команду 'Завершить')");
            command = scanner.next().toLowerCase();
        }
        productHashMap.put(productList, totalCost);
        return productHashMap;
    }
}