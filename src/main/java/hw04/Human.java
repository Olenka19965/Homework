package hw04;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private String[][] schedule;
    private Family family;
    public enum DayOfWeek{ Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;}

    public Human(String surname, String name, int year, int iq) {
        this.surname = surname;
        this.name = name;
        this.year = year;
        this.iq = iq;
    }
    public Human(String surname, String name, int year, Human mother, Human father) {
        this.surname = surname;
        this.name = name;
        this.year = year;
        this.family = new Family(mother,father);
    }
    Human(String surname, String name, int year, Human mother, Human father, int iq, Pet pet) {
        this.surname = surname;
        this.name = name;
        this.year = year;
        this.family = new Family(mother,father,pet);
        this.iq = iq;
        this.schedule = generateRandomSchedule();
    }

    Human() {
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    private String[][] generateRandomSchedule() {
        String[] tasks = {"Reading", "Writing", "Gym", "Swimming", "Dancing", "Cooking", "Watching movies", "Cycling",
                "Hiking", "Painting", "Yoga", "Music practice", "Traveling", "Photography", "Gardening",
                "Playing chess", "Volunteering", "Playing sports", "Meditation", "Shopping", "Socializing with friends"};
        DayOfWeek[]daysOfWeek = DayOfWeek.values();
        String[][] randomSchedule = new String[7][2];
        Random random = new Random();
        for (int i = 0; i < randomSchedule.length; i++) {
            randomSchedule[i][0] = daysOfWeek[i].name();
            int randomTaskIndex = random.nextInt(tasks.length);
            randomSchedule[i][1] = tasks[randomTaskIndex];
        }
        return randomSchedule;
    }

    public void printSchedule() {
        for (String[] day : schedule) {
            System.out.println(day[0] + ": " + day[1]);
        }
    }

    void greetPet() {
        System.out.println("Hello " + family.getPet().getNickname());
    }

    void describePet() {
        System.out.println(family.getPet().getDescribePet());
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Finalize is called for: " + this);
        super.finalize();
    }
    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother=%s, father=%s, pet=%s}",
                (name != null) ? name : "Name: Not available",
                (surname != null) ? surname : "Surname: Not available",
                (year > 0) ? year : "Year: Not available",
                (iq != 0) ? iq : "Iq: Not available",
                (family.getMother() != null) ? family.getMother().toString() : "Mother: Not available",
                (family.getFather() != null) ? family.getFather().toString() : "Father: Not available",
                (family.getPet() != null) ? family.getPet().toString() : "Pet: Not available");
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return year == ((Human) obj).year && surname.equals(human.surname) && name.equals(human.name);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(year, surname, name);
    }
}