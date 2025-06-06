package hw09;

import hw09.Human.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {
    private List<Family> families;
    public FamilyService() {
        this.families = new ArrayList<>();}
    public FamilyService(List<Family> families) {
        this.families = families;}
    public void displayAllFamilies() {
        for (int i = 0; i < families.size(); i++) {
            System.out.println("[" + (i + 1) + "]\n" + families.get(i).prettyFormat());
            System.out.println("=======================================================================================");
        }}
    public List<Family> getFamiliesBiggerThan(int count) {
        return families.stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());}
    public List<Family> getFamiliesLessThan(int count) {
        return families.stream()
                .filter(family -> family.countFamily() < count)
                .collect(Collectors.toList());
    }
    public long countFamiliesWithMemberNumber(int count) {
        return families.stream()
                .filter(family -> family.countFamily() == count)
                .count();
    }
    public void deleteAllChildrenOlderThan(int age) {
        families.forEach(family -> {
            List<Human> filteredChildren = family.getChildren().stream()
                    .filter(child -> getAge(child) <= age)
                    .collect(Collectors.toList());
            family.getChildren().clear();
            family.getChildren().addAll(filteredChildren);
        });
    }
    public int getAge(Human human) {
        LocalDate birth = Instant.ofEpochMilli(human.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();
        return Period.between(birth, now).getYears();
    }
    public void createFamily() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть ім'я матері: ");
            String motherName = scanner.nextLine();
            System.out.print("Введіть прізвище матері: ");
            String motherSurname = scanner.nextLine();
            System.out.print("Введіть дату народження матері: ");
            String birthDay = scanner.nextLine();
            System.out.print("Введіть IQ матері: ");
            int iq = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть ім'я батька: ");
            String fatherName = scanner.nextLine();
            System.out.print("Введіть прізвище батька: ");
            String fatherSurname = scanner.nextLine();
            System.out.print("Введіть дату народження батька: ");
            String fatherBirthDay = scanner.nextLine();
            System.out.print("Введіть IQ батька: ");
            int fatherIq = Integer.parseInt(scanner.nextLine());
            Human mother = new Woman(motherSurname, motherName, birthDay, iq);
            Human father = new Man(fatherSurname, fatherName, fatherBirthDay, fatherIq);
            Family newFamily = new Family(mother, father);
            families.add(newFamily);
            System.out.println("Сім’я створена успішно!");
        } catch (NumberFormatException e) {
            System.out.println("Некоректний формат введених даних.");
        }
    }
    public void deleteFamilyByIndex(int index) {
        if (index < 1 || index > families.size()) {
            System.out.println("Невірний індекс. Сім’я з таким номером не існує.");
            return;
        }
        Family removedFamily = families.remove(index - 1); // індексація з 1 для користувача
        System.out.println("Сім’я \"" + removedFamily.getFamilyName() + "\" успішно видалена.");
    }
    public void fillWithTestData() {
        families = new ArrayList<>(); // Ініціалізуємо список сімей
        Human mother1 = new Woman("Ivanova", "Olga", "15/05/1980", 90);
        Human father1 = new Man("Ivanov", "Ivan", "03/10/1978", 85);
        Family family1 = new Family(mother1, father1);
        family1.addChild(new Woman("Ivanova", "Anna", "20/07/2005", 80));
        family1.addChild(new Man("Ivanov", "Alex", "15/09/2003", 87));

        Human mother2 = new Woman("Petrova", "Kateryna", "30/11/1985", 95);
        Human father2 = new Man("Petrov", "Pavel", "25/06/1983", 88);
        Family family2 = new Family(mother2, father2);
        family2.addChild(new Woman("Petrova", "Marina", "01/12/2010", 93));

        Human mother3 = new Woman("Sidorova", "Nina", "04/10/1975", 91);
        Human father3 = new Man("Sidorov", "Sergey", "22/08/1973", 83);
        Family family3 = new Family(mother3, father3);

        families.add(family1);
        families.add(family2);
        families.add(family3);
    }
    public void bornChild(int id, String boyName, String girlName) {
        if (id < 1 || id > families.size()) {
            throw new IndexOutOfBoundsException("Сім'я з таким ID не існує.");}
        Family family = families.get(id - 1);
        if (family.countFamily() >= 10) {
            throw new FamilyOverflowException("Розмір сім'ї досяг максимального (10 осіб), дитину не можна народити.");}
        String today = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Human child;
        if (Math.random() < 0.5) {child = new Man(family.getFather().getSurname(), boyName, today, 100);
        } else {child = new Woman(family.getFather().getSurname(), girlName, today, 100);}
        family.addChild(child);
        System.out.println("Дитина успішно народжена!");
    }
}
