package hw11;
import hw11.Human.*;
import org.junit.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void testToString() {
        Human mother = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family = new Family(mother, father);
        String expectedString = "Family{mother=Human{name='Natali', surname='Nesturenko', birthDate=01/02/1978, iq=89, mother='Natali', father='Nikolas', pet='Pets: Not available'}, " +
                "father=Human{name='Nikolas', surname='Nesturenko', birthDate=12/03/1975, iq=90, mother='Natali', father='Nikolas', pet='Pets: Not available'}, " +
                "pets=Pets: Not available, children=Children: Not available}";
        assertEquals(expectedString, family.toString());
    }
    @Test
    public void testDeleteChild_Human() {
        Human mother = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family = new Family(mother, father);
        Human child1 = new Man("Nesturenko", "Piter", "25/11/1995", mother, father);
        Human child2 = new Woman("Nesturenko", "Erika", "28/06/1990", mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertEquals(2, family.getChildren().size());
        family.deleteChild(child1);
        assertEquals(1, family.getChildren().size());
        assertFalse(Arrays.asList(family.getChildren()).contains(child1));
    }
    @Test
    public void testDeleteChild_Human_NotFound() {
        Human mother = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family = new Family(mother, father);
        Human child = new Man("Nesturenko", "Piter", "25/11/1995", mother, father);
        assertEquals(0, family.getChildren().size());
        family.deleteChild(child);
        assertEquals(0, family.getChildren().size());
    }
    @Test
    public void testDeleteChildByIndex() {
        Human mother = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family = new Family(mother, father);
        Human child1 = new Man("Nesturenko", "Piter", "25/11/1995", mother, father);
        Human child2 = new Woman("Nesturenko", "Erika", "28/06/1990", mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertEquals(2, family.getChildren().size());
        family.deleteChild(0);
        assertEquals(1, family.getChildren().size());
        assertFalse(Arrays.asList(family.getChildren()).contains(child1));
    }
    @Test
    public void testDeleteChildByInvalidIndex() {
        Human mother = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family = new Family(mother, father);
        Human child1 = new Man("Nesturenko", "Piter", "25/11/1995", mother, father);
        family.addChild(child1);
        assertEquals(1, family.getChildren().size());
        family.deleteChild(100);
        assertEquals(1, family.getChildren().size());
    }
    @Test
    public void testGetFamiliesBiggerThan() {
        Human mother1 = new Woman("Smith", "Anna", "01/01/1980", 90);
        Human father1 = new Man("Smith", "John", "01/01/1978", 90);
        Family family1 = new Family(mother1,father1);
        Human mother2 = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father2 = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family2 = new Family(mother2,father2);
        Human  child1 = new Man("Nesturenko", "Piter", "25/11/1995", mother2, father2);
        family2.addChild(child1);
        Human father3 = new Man("Maus", "Mike", "12/03/1976", 91);
        Human mother3 = new Woman("Maus", "Talia", "01/02/1979", 88);
        Family family3 = new Family(mother3,father3);
        Human child2 = new Man("Maus", "Kevin", "20/03/1981", 73);
        Human child3 = new Woman("Maus", "Lexy", "02/10/1986", 91);
        family3.addChild(child2);
        family3.addChild(child3);
        List<Family>families = new ArrayList<>();
        families.add(family1);
        families.add(family2);
        families.add(family3);
        FamilyService service = new FamilyService();
        service.setFamilies(families);
        List<Family>result=service.getFamiliesBiggerThan(3);
        assertEquals(1,result.size());
        assertTrue(result.contains(family3));
        assertFalse(result.contains(family1));
        assertFalse(result.contains(family2));
    }
    @Test
    public void testGetFamiliesLessThan(){
        Human mother1 = new Woman("Smith", "Anna", "01/01/1980", 90);
        Human father1 = new Man("Smith", "John", "01/01/1978", 90);
        Family family1 = new Family(mother1,father1);
        Human mother2 = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father2 = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family2 = new Family(mother2,father2);
        Human  child1 = new Man("Nesturenko", "Piter", "25/11/1995", mother2, father2);
        family2.addChild(child1);
        List<Family>families = new ArrayList<>();
        families.add(family1);
        families.add(family2);
        FamilyService service = new FamilyService();
        service.setFamilies(families);
        List<Family>result=service.getFamiliesLessThan(3);
        assertEquals(1,result.size());
        assertTrue(result.contains(family1));
        assertFalse(result.contains(family2));
    }
    @Test
    public void testCountFamiliesWithMemberNumber(){
        Human mother1 = new Woman("Smith", "Anna", "01/01/1980", 90);
        Human father1 = new Man("Smith", "John", "01/01/1978", 90);
        Family family1 = new Family(mother1,father1);
        Human mother2 = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human father2 = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Family family2 = new Family(mother2,father2);
        Human  child1 = new Man("Nesturenko", "Piter", "25/11/1995", mother2, father2);
        family2.addChild(child1);
        Human father3 = new Man("Maus", "Mike", "12/03/1976", 91);
        Human mother3 = new Woman("Maus", "Talia", "01/02/1979", 88);
        Family family3 = new Family(mother3,father3);
        Human child2 = new Man("Maus", "Kevin", "20/03/1981", 73);
        Human child3 = new Woman("Maus", "Lexy", "02/10/1986", 91);
        family3.addChild(child2);
        family3.addChild(child3);
        List<Family>families = new ArrayList<>();
        families.add(family1);
        families.add(family2);
        families.add(family3);
        FamilyService service = new FamilyService();
        service.setFamilies(families);
        assertEquals(1, service.countFamiliesWithMemberNumber(2));
        assertEquals(1, service.countFamiliesWithMemberNumber(3));
        assertEquals(1, service.countFamiliesWithMemberNumber(4));
        assertEquals(0, service.countFamiliesWithMemberNumber(5));
    }
    @Test
    public void testDeleteAllChildrenOlderThan(){
        Human father = new Man("Maus", "Mike", "12/03/1976", 91);
        Human mother = new Woman("Maus", "Talia", "01/02/1979", 88);
        Family family = new Family(mother,father);
        Human  child1 = new Man("Nesturenko", "Piter", "25/11/2010",88);
        Human child2 = new Man("Maus", "Kevin", "20/03/2005", 73);
        Human child3 = new Woman("Maus", "Lexy", "02/10/2016", 91);
        family.addChild(child1);
        family.addChild(child2);
        family.addChild(child3);
        List<Family> families = new ArrayList<>();
        families.add(family);
        FamilyService service = new FamilyService();
        service.setFamilies(families);
        service.deleteAllChildrenOlderThan(18);
        List<Human> remainingChildren = family.getChildren();
        assertEquals(2, remainingChildren.size());
        for (Human child : remainingChildren) {
            int age = service.getAge(child);
            assertTrue(age <= 18);
        }
        assertTrue(remainingChildren.contains(child1));
        assertTrue(remainingChildren.contains(child3));
        assertFalse(remainingChildren.contains(child2));
    }
    @Test
    public void testBornChild() {
        Human mother = new Woman("Gavrulenko", "Ylia", "05/11/1980", 92);
        Human father = new Man("Gavrulenko", "Max", "21/01/1978", 90);
        Family family = new Family(mother, father);
        List<Family> families = new ArrayList<>();
        families.add(family);
        FamilyService service = new FamilyService();
        service.setFamilies(families);
        int initialSize = family.countFamily();
        service.bornChild(1, "Jack", "Lily");
        assertEquals(initialSize + 1, family.countFamily());
    }
    @Test
    public void testAdoptChild() {
        FamilyService service = new FamilyService();
        Human mother = new Woman("Gavrulenko", "Ylia", "05/11/1980", 92);
        Human father = new Man("Gavrulenko", "Max", "21/01/1978", 90);
        Family family = new Family(mother, father);
        List<Family> families = new ArrayList<>();
        families.add(family);
        service.setFamilies(families);
        Human adoptedChild = new Woman("Maksimova", "Karina", "06/07/2020", 85);
        service.adoptChild(1, adoptedChild);
        List<Human> children = family.getChildren();
        assertEquals(1, children.size());
        assertTrue(children.contains(adoptedChild));
    }

}
   





