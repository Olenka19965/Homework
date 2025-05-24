package hw10;

import hw10.Human.Human;
import hw10.Pet.Pet;

import java.io.Serializable;
import java.util.*;

public class Family implements Serializable {
    private Human mother;
    private Human father;
    private List<Human> children;
    private Set<Pet> pets;

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
        this.pets = new HashSet<>();
        mother.setFamily(this);
        father.setFamily(this);}

    public Family(Human mother, Human father, Set<Pet> pets) {
        this(mother, father);
        this.pets = (pets != null) ? pets : new HashSet<>();}

    public Set<Pet> getPets() {return pets;}
    public void addPet(Pet pet) {pets.add(pet);}
    public void removePet(Pet pet) {pets.remove(pet);}
    public Human getMother() {return mother;}
    public Human getFather() {return father;}
    public void addChild(Human child) {
        children.add(child);
        child.setFamily(this);
    }
    public List<Human> getChildren() {return children;}
    public void deleteChild(int index) {
        if (index < 0 || index >= children.size()) {
            System.out.println("Invalid index");
            return;
        }
        children.remove(index);
    }
    public void deleteChild(Human child) {
        if (!children.remove(child)) {
            System.out.println("Child not found");
        }
    }
    public int countFamily() {
        int count = 2 + children.size();
        return count;
    }
    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        sb.append("family:\n");
        sb.append("\tmother: ").append(mother.prettyFormat()).append(",\n");
        sb.append("\tfather: ").append(father.prettyFormat()).append(",\n");
        if (!children.isEmpty()) {
            sb.append("\tchildren:\n");
            for (Human child : children) {
                sb.append("\t\t").append(child.prettyFormat()).append("\n");
            }}
        if (!pets.isEmpty()) {
            sb.append("\tpets:\n");
            for (Pet pet : pets) {
                sb.append("\t\t").append(pet.prettyFormat()).append("\n");
            }}
        return sb.toString();}
    public String getFamilyName() {
        return father.getSurname(); // або father.getSurname() — залежно від логіки
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize is called for: " + this);
        super.finalize();
    }
    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, pets=%s, children=%s}",
                (mother != null) ? mother.toString() : "Mother: Not available",
                (father != null) ? father.toString() : "Father: Not available",
                (!pets.isEmpty()) ? pets.toString() : "Pets: Not available",
                (!children.isEmpty()) ? children.toString() : "Children: Not available"
        );
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Family family = (Family) obj;
        return Objects.equals(mother, family.mother)
                && Objects.equals(father, family.father)
                && Objects.equals(pets, family.pets);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mother, father, pets);
    }
}