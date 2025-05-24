package hw10.Human;

import hw10.Pet.Pet;

import java.io.Serializable;
import java.util.Set;

public final class Man extends Human implements Serializable {
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
    public String prettyFormat(){
        return String.format("{Man: name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}",
            getName(), getSurname(), getFormattedBirthDate(), getIq(), (getSchedule() != null ? getSchedule() : "null"));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
