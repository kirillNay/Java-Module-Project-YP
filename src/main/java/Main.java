import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int persons = BillCalculator.amountRequest();


    }
}

class BillCalculator {

    public static int amountRequest() {
        Scanner scanner = new Scanner(System.in);
        int personsRequest = 0;

        while (personsRequest <= 1) {
            System.out.println("Уточните, пожалуйста, на сколько персон необходимо разделить счет?\nКоличество: ");
            personsRequest = scanner.nextInt();
            if (personsRequest == 1) {
                System.out.println("Тогда нет смысла делить счет :)");
            } else if (personsRequest <= 0) {
                System.out.println("Введено некорректное значение. Попробуйте снова.");
            }
        }
        return personsRequest;
    }


    public static  addProducts() {

    }
}