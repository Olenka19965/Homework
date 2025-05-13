package hw06.Human;

import hw06.Pet.Pet;

import java.util.HashSet;

public final class Woman extends Human {
    public Woman(String surname, String name, int year, int iq) {
        super(surname,name,year,iq);}
    public Woman(String surname, String name, int year, Human mother, Human father) {
        super(surname,name,year,mother,father);}
    public Woman(String surname, String name, int year, Human mother, Human father, int iq, Pet pet) {
        super(surname, name, year, mother, father, iq, new HashSet<Pet>() {{
            add(pet);
        }});}
    Woman() {}
    public void manicure(){System.out.println("I paint my nails with red polish.");}
    @Override
    public void greetPet() {
        for (Pet pet : family.getPets()) {
        System.out.println("Hello, my sweet " + pet.getNickname());}}
    @Override
    public String toString() {
        return super.toString();
    }
}
