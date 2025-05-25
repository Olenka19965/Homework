package hw11;
import hw11.Human.*;
import hw11.Pet.Pet;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {
    private final FamilyDao dao = new CollectionFamilyDao();
    public static final String DEFAULT_FILE_PATH = "Homework/src/main/java/hw11/data/families.dat";
    public void displayAllFamilies() {
        List<Family> families = dao.getAllFamilies();
        if (families.isEmpty()) {
            System.out.println("Список сімей порожній.");
            return;}
        for (int i = 0; i < families.size(); i++) {
            System.out.println("[" + (i + 1) + "]\n" + families.get(i).prettyFormat());
            System.out.println(String.join("", Collections.nCopies(90, "=")));}
    }
    public List<Family> getFamiliesBiggerThan(int count) {
        return dao.getAllFamilies().stream()
                .filter(f -> f.countFamily() > count)
                .collect(Collectors.toList());}
    public List<Family> getFamiliesLessThan(int count) {
        return dao.getAllFamilies().stream()
                .filter(f -> f.countFamily() < count)
                .collect(Collectors.toList());}
    public long countFamiliesWithMemberNumber(int count) {
        return dao.getAllFamilies().stream()
                .filter(f -> f.countFamily() == count)
                .count();}
    public void deleteAllChildrenOlderThan(int age) {
        List<Family> families = dao.getAllFamilies();
        for (Family family : families) {
            List<Human> filteredChildren = family.getChildren().stream()
                    .filter(child -> getAge(child) <= age)
                    .collect(Collectors.toList());
            family.getChildren().clear();
            family.getChildren().addAll(filteredChildren);}
        dao.loadData(families);
    }
    protected int getAge(Human human) {
        LocalDate birth = Instant.ofEpochMilli(human.getBirthDate())
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        return Period.between(birth, LocalDate.now()).getYears();}
    public void createFamily() {
        Scanner scanner = new Scanner(System.in);
        try {System.out.print("Введіть ім'я матері: ");
            String motherName = scanner.nextLine();
            System.out.print("Введіть прізвище матері: ");
            String motherSurname = scanner.nextLine();
            System.out.print("Введіть дату народження матері (dd/MM/yyyy): ");
            String motherBirthDay = scanner.nextLine();
            System.out.print("Введіть IQ матері: ");
            int motherIq = Integer.parseInt(scanner.nextLine());
            System.out.print("Введіть ім'я батька: ");
            String fatherName = scanner.nextLine();
            System.out.print("Введіть прізвище батька: ");
            String fatherSurname = scanner.nextLine();
            System.out.print("Введіть дату народження батька (dd/MM/yyyy): ");
            String fatherBirthDay = scanner.nextLine();
            System.out.print("Введіть IQ батька: ");
            int fatherIq = Integer.parseInt(scanner.nextLine());
            Human mother = new Woman(motherSurname, motherName, motherBirthDay, motherIq);
            Human father = new Man(fatherSurname, fatherName, fatherBirthDay, fatherIq);
            Family family = new Family(mother, father);
            dao.saveFamily(family);
            System.out.println("Сім’я створена успішно!");
        } catch (NumberFormatException e) {
            System.out.println("Некоректний формат введених числових даних.");}
    }
    public void deleteFamilyByIndex(int index) {
        List<Family> families = dao.getAllFamilies();
        if (index < 1 || index > families.size()) {
            System.out.println("Невірний індекс. Сім’я з таким номером не існує.");
            return;}
        Family removed = families.get(index - 1);
        dao.deleteFamily(removed);
        System.out.println("Сім’я \"" + removed.getFamilyName() + "\" успішно видалена.");}
    public void fillWithTestData() {
        List<Family> families = new ArrayList<>();
        Family f1 = new Family(
                new Woman("Ivanova", "Olga", "15/05/1980", 90),
                new Man("Ivanov", "Ivan", "03/10/1978", 85));
        f1.addChild(new Woman("Ivanova", "Anna", "20/07/2005", 80));
        f1.addChild(new Man("Ivanov", "Alex", "15/09/2003", 87));
        Family f2 = new Family(
                new Woman("Petrova", "Kateryna", "30/11/1985", 95),
                new Man("Petrov", "Pavel", "25/06/1983", 88));
        f2.addChild(new Woman("Petrova", "Marina", "01/12/2010", 93));
        Family f3 = new Family(
                new Woman("Sidorova", "Nina", "04/10/1975", 91),
                new Man("Sidorov", "Sergey", "22/08/1973", 83));
        families.addAll(Arrays.asList(f1, f2, f3));
        dao.loadData(families);}
    public void bornChild(int id, String boyName, String girlName) {
        List<Family> families = dao.getAllFamilies();
        if (id < 1 || id > families.size()) {
            throw new IndexOutOfBoundsException("Сім'я з таким ID не існує.");}
        Family family = families.get(id - 1);
        if (family.countFamily() >= 10) {
            throw new FamilyOverflowException("Розмір сім'ї досяг максимального (10 осіб).");}
        String birthDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Human child = Math.random() < 0.5
                ? new Man(family.getFather().getSurname(), boyName, birthDate, 100)
                : new Woman(family.getFather().getSurname(), girlName, birthDate, 100);
        family.addChild(child);
        dao.loadData(families);
        System.out.println("Дитина успішно народжена!");}
    public void saveFamiliesToFile(String path) {
        File file = new File(path);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();}
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(dao.getAllFamilies());
            System.out.println("Сім'ї збережено до файлу: " + file.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Помилка збереження: " + e.getMessage());
        }
    }
    public void loadFamiliesFromFile(String path) {
        if (dao instanceof CollectionFamilyDao) {
            ((CollectionFamilyDao) dao).loadFromFile(path);
        } else {System.out.println("Завантаження неможливе: DAO не підтримує цю функцію.");}
    }
    public void adoptChild(int familyId, Human child) {
        List<Family> families = dao.getAllFamilies();
        if (familyId < 1 || familyId > families.size()) {
            throw new IndexOutOfBoundsException("Сім'я з таким ID не існує.");}
        Family family = families.get(familyId - 1);
        if (family.countFamily() >= 10) {
            throw new FamilyOverflowException("Сім’я переповнена, усиновлення неможливе.");}
        family.addChild(child);
        dao.loadData(families);
        System.out.println("Дитина успішно усиновлена!");}
    public void setFamilies(List<Family> families) {dao.loadData(families);}
    public List<Family> getAllFamilies() {
        return dao.getAllFamilies();
    }
    public int count() {return dao.getAllFamilies().size();}
    public Family getFamilyById(int id) {return dao.getFamilyByIndex(id - 1);}
    public Set<Pet> getPets(int familyId) {
        Family family = getFamilyById(familyId);
        return family.getPets();}
    public void addPet(int familyId, Pet pet) {
        Family family = getFamilyById(familyId);
        family.getPets().add(pet);
        dao.saveFamily(family);}
    public void createNewFamily(Human mother, Human father) {
        Family family = new Family(mother, father);
        dao.saveFamily(family);
    }
    public Family bornChild(Family family, String boyName, String girlName) {
        int id = dao.getAllFamilies().indexOf(family);
        if (id == -1) throw new IllegalArgumentException("Сім'я не знайдена.");
        bornChild(id + 1, boyName, girlName);
        return family;
    }
    public Family adoptChild(Family family, Human child) {
        int id = dao.getAllFamilies().indexOf(family);
        if (id == -1) throw new IllegalArgumentException("Сім'я не знайдена.");
        adoptChild(id + 1, child);
        return family;
    }
}