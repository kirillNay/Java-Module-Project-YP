import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int persons = BillCalculator.amountRequest();


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
                try {
                    System.out.println("Введите стоимость товара: ");
                    productCost = scanner.nextFloat();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Некорректное значение стоимости. Стоимость должна быть числом в формате xx.xx");
                }
            }

            productList.add(productName);
            totalCost = totalCost + productCost;
            System.out.println("Товар '" + productName + "'стоимостью" + productCost + "руб. успешно добавлен.");

            System.out.println("Хотите добавить еще товар?\nЕсли хотите завершить добавление товаров, введите команду 'Завершить'");
            command = scanner.next().toLowerCase();
            if (command.equals("завершить")) {
                productHashMap.put(productList, totalCost);
                break;
            }
        }
        return productHashMap;
    }
}