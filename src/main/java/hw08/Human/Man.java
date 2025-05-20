package hw08.Human;

import hw08.Pet.Pet;

import java.util.Set;

public final class Man extends Human {
    public Man(String surname, String name, String birthDateStr, int iq) {
        super(surname,name,birthDateStr,iq);}
    public Man(String surname, String name, String birthDateStr, Human mother, Human father) {
        super(surname,name,birthDateStr,mother,father);}
    public Man(String surname, String name, String birthDateStr, Human mother, Human father, int iq, Set<Pet> pets) {
        super(surname, name, birthDateStr, mother, father, iq, pets);}
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
