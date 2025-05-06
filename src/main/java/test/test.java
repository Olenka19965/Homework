package test;
import hw04.Family;
import hw04.Human;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void testToString() {
        Human mother = new Human("Nesturenko", "Natali", 1968, 89);
        Human father = new Human("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        String expectedString = "Family{mother=Human{name='Natali', surname='Nesturenko', year=1968, iq=89, mother=Mother: Not available, father=Father: Not available, pet=Pet: Not available}, father=Human{name='Nikolas', surname='Nesturenko', year=1965, iq=90, mother=Mother: Not available, father=Father: Not available, pet=Pet: Not available}, pet=Pet: Not available, children=Children: Not available}";
        assertEquals(expectedString, family.toString());
    }
    @Test
    public void testDeleteChild_Human() {
        Human mother = new Human("Nesturenko", "Natali", 1968, 89);
        Human father = new Human("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child1 = new Human("Nesturenko", "Piter", 1995, mother, father);
        Human child2 = new Human("Nesturenko", "Erika", 1990, mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertEquals(2, family.getChildren().length);
        family.deleteChild(child1);
        assertEquals(1, family.getChildren().length);
        assertFalse(Arrays.asList(family.getChildren()).contains(child1));
    }
    @Test
    public void testDeleteChild_Human_NotFound() {
        Human mother = new Human("Nesturenko", "Natali", 1968, 89);
        Human father = new Human("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child = new Human("Nesturenko", "Piter", 1995, mother, father);
        assertEquals(0, family.getChildren().length);
        family.deleteChild(child);
        assertEquals(0, family.getChildren().length);
    }
    @Test
    public void testDeleteChildByIndex() {
        Human mother = new Human("Nesturenko", "Natali", 1968, 89);
        Human father = new Human("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child1 = new Human("Nesturenko", "Piter", 1995, mother, father);
        Human child2 = new Human("Nesturenko", "Erika", 1990, mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertEquals(2, family.getChildren().length);
        family.deleteChild(0);
        assertEquals(1, family.getChildren().length);
        assertFalse(Arrays.asList(family.getChildren()).contains(child1));
    }
    @Test
    public void testDeleteChildByInvalidIndex() {
        Human mother = new Human("Nesturenko", "Natali", 1968, 89);
        Human father = new Human("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child1 = new Human("Nesturenko", "Piter", 1995, mother, father);
        family.addChild(child1);
        assertEquals(1, family.getChildren().length);
        family.deleteChild(100); // Недійсний індекс
        assertEquals(1, family.getChildren().length);
    }
   
}




