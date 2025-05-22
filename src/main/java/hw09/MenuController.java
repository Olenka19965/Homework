package hw09;

import java.util.Scanner;
public class MenuController {
    private final Scanner scanner = new Scanner(System.in);
    private final FamilyService familyService = new FamilyService();
    public void start() {
        while (true) {
            printMenu();
            System.out.print("Введіть номер команди: ");
            String input = scanner.nextLine();
            try {
                switch (input) {
                    case "1": familyService.fillWithTestData();break;
                    case "2": familyService.displayAllFamilies();break;
                    case "3": {System.out.print("Введіть число: ");
                        int number = Integer.parseInt(scanner.nextLine());
                        familyService.getFamiliesBiggerThan(number)
                                .forEach(f -> System.out.println(f.prettyFormat()));break;}
                    case "4": {System.out.print("Введіть число: ");
                        int number = Integer.parseInt(scanner.nextLine());
                        familyService.getFamiliesLessThan(number).forEach(f -> System.out.println(f.prettyFormat()));break;}
                    case "5": {System.out.print("Введіть точну кількість членів: ");
                        int count = Integer.parseInt(scanner.nextLine());
                        long result = familyService.countFamiliesWithMemberNumber(count);
                        System.out.println("Кількість сімей: " + result);break;}
                    case "6": familyService.createFamily();break;
                    case "7": {System.out.print("Введіть індекс сім’ї: ");
                        int index = Integer.parseInt(scanner.nextLine());
                        familyService.deleteFamilyByIndex(index);break;}
                    case "8": editFamily();break;
                    case "9": {System.out.print("Введіть вік: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        familyService.deleteAllChildrenOlderThan(age);break;}
                    case "0": System.out.println("Завершення програми.");return;
                    default: System.out.println("Невірна команда. Спробуйте ще раз.");}
            } catch (NumberFormatException e) {
                System.out.println("Помилка: введено некоректне число.");
            } catch (FamilyOverflowException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Помилка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Сталася несподівана помилка: " + e.getMessage());
            }
        }
    }
    private void editFamily() {
        System.out.print("Введіть ID сім’ї: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Некоректний ID сім’ї.");
            return;}
        System.out.println("1. Народити дитину");
        System.out.println("2. Усиновити дитину");
        System.out.println("3. Назад");
        System.out.print("Введіть номер команди: ");
        String input = scanner.nextLine();
        switch (input) {
            case "1" : {System.out.print("Ім'я хлопчика: ");
                String boyName = scanner.nextLine();
                System.out.print("Ім'я дівчинки: ");
                String girlName = scanner.nextLine();
                try {familyService.bornChild(id, boyName, girlName);
                } catch (FamilyOverflowException e) {System.out.println("Помилка: " + e.getMessage());
                } catch (IndexOutOfBoundsException e) {System.out.println("Сім'я з таким ID не знайдена.");}
            }
            case "2" : System.out.println("Функція усиновлення ще не реалізована.");
            case "3" : System.out.println("Повернення в головне меню...");
            default : System.out.println("Невірна команда.");
        }
    }
    private void printMenu() {
        System.out.println(
                "- 1. Заповнити тестовими даними\n" +
                        "- 2. Відобразити весь список сімей\n" +
                        "- 3. Відобразити список сімей, де кількість людей більша за задану\n" +
                        "- 4. Відобразити список сімей, де кількість людей менша за задану\n" +
                        "- 5. Підрахувати кількість сімей, де кількість членів дорівнює\n" +
                        "- 6. Створити нову родину\n" +
                        "- 7. Видалити сім'ю за індексом сім'ї у загальному списку\n" +
                        "- 8. Редагувати сім'ю за індексом сім'ї у загальному списку\n" +
                        "   - 8.1. Народити дитину\n" +
                        "   - 8.2. Усиновити дитину\n" +
                        "   - 8.3. Повернутися до головного меню\n" +
                        "- 9. Видалити всіх дітей старше віку\n" +
                        "- 0. Вийти з програми\n"
        );
    }
}