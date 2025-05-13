package hw06.Human;

import hw06.Family;
import hw06.Pet.Pet;
import java.util.*;

public abstract class Human {
    private String name;
    private String surname;
    private int year;
    private int iq;
    private EnumMap<DayOfWeek, String> schedule;
    protected Family family;
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
    public Human(String surname, String name, int year, Human mother, Human father, int iq, Set<Pet> pets){
            this.surname = surname;
            this.name = name;
            this.year = year;
            this.iq = iq;
            this.schedule = generateRandomSchedule();
            this.family = new Family(mother, father, (pets != null) ? pets : new HashSet<>());
    }
    public Human() {}
    public String getName() {return name;}
    public void setFamily(Family family) {
        this.family = family;
    }
    public void setSchedule(EnumMap<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }
    public EnumMap<DayOfWeek, String> getSchedule() {
        return schedule;
    }
    private EnumMap<DayOfWeek, String> generateRandomSchedule() {
        List<String> tasks = Arrays.asList("Reading", "Writing", "Gym", "Swimming", "Dancing", "Cooking",
        "Watching movies", "Cycling", "Hiking", "Painting", "Yoga", "Music practice", "Traveling", "Photography",
        "Gardening", "Playing chess", "Volunteering", "Playing sports", "Meditation", "Shopping", "Socializing with friends");
        EnumMap<DayOfWeek, String> schedule = new EnumMap<>(DayOfWeek.class);
        Random random = new Random();
        for (DayOfWeek day : DayOfWeek.values()) {
            String randomTask = tasks.get(random.nextInt(tasks.size()));
            schedule.put(day, randomTask);
        }
        return schedule;
    }
    public void printSchedule() {
        if (schedule == null || schedule.isEmpty()) {
            System.out.println("Schedule not set.");
            return;
        }
        for (Map.Entry<DayOfWeek, String> entry : schedule.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public abstract void greetPet();
    public void describePet() {
        for (Pet pet : family.getPets()) {
            System.out.println(pet.getDescribePet());
        }
    }
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Finalize is called for: " + this);
        super.finalize();
    }
    @Override
    public String toString() {
        return String.format("Human{name='%s', surname='%s', year=%d, iq=%d, mother='%s', father='%s', pet='%s'}",
                (name != null) ? name : "Name: Not available",
                (surname != null) ? surname : "Surname: Not available",
                (year > 0) ? year : "Year: Not available",
                (iq != 0) ? iq : "Iq: Not available",
                (family != null &&family.getMother() != null) ? family.getMother().getName() : "Mother: Not available",
                (family != null &&family.getFather() != null) ? family.getFather().getName() : "Father: Not available",
                (family != null && !family.getPets().isEmpty()) ? family.getPets().toString() : "Pets: Not available"
        );
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
        return Objects.hash(year, surname, name);
    }
}