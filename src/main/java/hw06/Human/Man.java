package hw06.Human;

import hw06.Pet.Pet;

import java.util.HashSet;

public final class Man extends Human {
    public Man(String surname, String name, int year, int iq) {
        super(surname,name,year,iq);}
    public Man(String surname, String name, int year, Human mother, Human father) {
        super(surname,name,year,mother,father);}
    public Man(String surname, String name, int year, Human mother, Human father, int iq, Pet pet) {
        super(surname, name, year, mother, father, iq, new HashSet<Pet>() {{
            add(pet);
        }});}
    Man() {}
    public void shaveНourFace(){System.out.println("I am shaving my beard.");}
    @Override
    public void greetPet() {
        for (Pet pet : family.getPets()) {System.out.println("Hello " + pet.getNickname());};}
    @Override
    public String toString() {
        return super.toString();
    }
}
