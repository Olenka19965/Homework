package hw08;

import hw08.Human.Human;
import java.time.*;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    private List<Family> families;

    public FamilyService(List<Family> families) {
        this.families = families;
    }

    public void displayAllFamilies() {
        families.forEach(System.out::println);
    }

    public List<Family> getFamiliesBiggerThan(int count) {
        return families.stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());
    }

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
}
