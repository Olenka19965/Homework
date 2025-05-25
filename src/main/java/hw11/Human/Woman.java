package hw11.Human;
import hw11.Pet.Pet;
import java.io.Serializable;
import java.util.Set;

public final class Woman extends Human implements Serializable {
    public Woman(String surname, String name, String birthDateStr, int iq) {
        super(surname,name,birthDateStr,iq);}
    public Woman(String surname, String name, String birthDateStr, Human mother, Human father) {
        super(surname,name,birthDateStr,mother,father);}
    public Woman(String surname, String name, String birthDateStr, Human mother, Human father, int iq, Set<Pet> pets) {
        super(surname, name, birthDateStr, mother, father, iq, pets);}
    Woman(String motherSurname, String motherName, int birthDay, int iq) {}
    public void manicure(){System.out.println("I paint my nails with red polish.");}
    @Override
    public void greetPet() {
        for (Pet pet : family.getPets()) {
        System.out.println("Hello, my sweet " + pet.getNickname());}}
    @Override
    public String prettyFormat() {
        return String.format("{Woman: name='%s', surname='%s', birthDate='%s', iq=%d, schedule=%s}",
                getName(), getSurname(), getFormattedBirthDate(), getIq(), (getSchedule() != null ? getSchedule() : "null"));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
