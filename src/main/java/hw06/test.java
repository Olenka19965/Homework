package hw06;

import hw06.Human.Human;
import hw06.Human.Man;
import hw06.Human.Woman;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class test {
    @Test
    public void testToString() {
        Human mother = new Woman("Nesturenko", "Natali", 1968, 89);
        Human father = new Man("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        String expectedString = "Family{mother=Human{name='Natali', surname='Nesturenko', year=1968, iq=89, mother='Natali', father='Nikolas', pet='Pets: Not available'}, " +
                "father=Human{name='Nikolas', surname='Nesturenko', year=1965, iq=90, mother='Natali', father='Nikolas', pet='Pets: Not available'}, " +
                "pets=Pets: Not available, children=Children: Not available}";
        assertEquals(expectedString, family.toString());
    }
    @Test
    public void testDeleteChild_Human() {
        Human mother = new Woman("Nesturenko", "Natali", 1968, 89);
        Human father = new Man("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child1 = new Man("Nesturenko", "Piter", 1995, mother, father);
        Human child2 = new Woman("Nesturenko", "Erika", 1990, mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertEquals(2, family.getChildren().size());
        family.deleteChild(child1);
        assertEquals(1, family.getChildren().size());
        assertFalse(Arrays.asList(family.getChildren()).contains(child1));
    }
    @Test
    public void testDeleteChild_Human_NotFound() {
        Human mother = new Woman("Nesturenko", "Natali", 1968, 89);
        Human father = new Man("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child = new Man("Nesturenko", "Piter", 1995, mother, father);
        assertEquals(0, family.getChildren().size());
        family.deleteChild(child);
        assertEquals(0, family.getChildren().size());
    }
    @Test
    public void testDeleteChildByIndex() {
        Human mother = new Woman("Nesturenko", "Natali", 1968, 89);
        Human father = new Man("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child1 = new Man("Nesturenko", "Piter", 1995, mother, father);
        Human child2 = new Woman("Nesturenko", "Erika", 1990, mother, father);
        family.addChild(child1);
        family.addChild(child2);
        assertEquals(2, family.getChildren().size());
        family.deleteChild(0);
        assertEquals(1, family.getChildren().size());
        assertFalse(Arrays.asList(family.getChildren()).contains(child1));
    }
    @Test
    public void testDeleteChildByInvalidIndex() {
        Human mother = new Woman("Nesturenko", "Natali", 1968, 89);
        Human father = new Man("Nesturenko", "Nikolas", 1965, 90);
        Family family = new Family(mother, father);
        Human child1 = new Man("Nesturenko", "Piter", 1995, mother, father);
        family.addChild(child1);
        assertEquals(1, family.getChildren().size());
        family.deleteChild(100);
        assertEquals(1, family.getChildren().size());
    }
   
}




