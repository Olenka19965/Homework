package hw11;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {
    private List<Family>families=new ArrayList<>();
    public void saveToFile(String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(families);
            System.out.println("Список сімей збережено у файл.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні у файл: " + e.getMessage());
        }
    }
    public void loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                List<?> list = (List<?>) obj;
                boolean allFamilies = list.stream().allMatch(element -> element instanceof Family);
                if (allFamilies) {families = list.stream().map(element -> (Family) element)
                            .collect(Collectors.toList());
                    System.out.println("Список сімей завантажено з файлу.");
                } else {System.out.println("Файл містить список, але не всі елементи є типу Family.");}
            } else {System.out.println("Файл не містить список сімей.");}
        } catch (IOException | ClassNotFoundException e) {System.out.println("Помилка при завантаженні з файлу: " + e.getMessage());}
    }
    @Override
    public List<Family> getAllFamilies() {
        return new ArrayList<>(families);
    }

    @Override
    public Family getFamilyByIndex(int index) {
        if (index >= 0 && index < families.size()) {
            return families.get(index);
        }
        return null;
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index >= 0 && index < families.size()) {
            families.remove(index);
            return true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family family) {
        int index = families.indexOf(family);
        if (index != -1) {
            families.set(index, family); // оновити
        } else {
            families.add(family); // додати нову
        }
    }

    @Override
    public boolean deleteFamily(Family family) {
        return families.remove(family);
    }

    @Override
    public void loadData(List<Family> families) {
    this.families=new ArrayList<>(families);
    }

}
