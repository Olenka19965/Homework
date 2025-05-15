package hw07.Pet;
import java.util.*;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int trickLevel;
    private Set<String> habits;
    private int age;

    public enum Species { dog, roboCat, domesticCat, fish, UNKNOWN }

    private static final Set<String> possibleHabits = new HashSet<>();
    static {
        possibleHabits.add("playing with a ball");
        possibleHabits.add("sleeping on the couch");
        possibleHabits.add("hiding under the bed");
        possibleHabits.add("spilling food");
        possibleHabits.add("chasing its tail");
        possibleHabits.add("attacking from an ambush");
        possibleHabits.add("running on the grass");
        possibleHabits.add("scaring the squirrel");
        possibleHabits.add("waking the owner at 5 am");
    }

    public Pet(String nickname) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        Random rand = new Random();
        this.trickLevel = rand.nextInt(101);
        this.habits = getRandomHabits();
    }

    public Pet(String nickname, int age) {
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        Random rand = new Random();
        this.trickLevel = rand.nextInt(101);
        this.habits = getRandomHabits();
    }

    public Pet() {}

    public void setSpecies(Species species) {
        this.species = (species != null) ? species : Species.UNKNOWN;
    }

    public Species getSpecies() { return species; }

    public String getNickname() { return nickname; }

    public String getDescribePet() {
        return "I have " + species + ", it is " + age + " years old, and its trick level is " + getTrickLevelDescription() +
                ". Its habits are: " + String.join(", ", habits);
    }

    protected Set<String> getRandomHabits() {
        Set<String> chosen = new HashSet<>();
        List<String> habitList = new ArrayList<>(possibleHabits);
        Random rand = new Random();
        if (species == Species.fish || species == Species.roboCat) {
            chosen.add("No hobbies");
            return chosen;
        }
        while (chosen.size() < 3) {
            chosen.add(habitList.get(rand.nextInt(habitList.size())));
        }
        return chosen;
    }

    public String getTrickLevelDescription() {
        return (trickLevel > 50) ? "very cunning" : "almost not cunning";
    }

    public void describePet() {
        System.out.println(getDescribePet());
    }

    public void eat() {
        System.out.println("I eat!");
    }

    public abstract void respond();
    public abstract void voice();

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize is called for: " + this);
        super.finalize();
    }

    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%s, trickLevel=%s, habits=%s}",
                (species != null) ? species : "Species: Not available",
                (nickname != null) ? nickname : "Nickname: Not available",
                (age > 0) ? age : "Age: Not available",
                (trickLevel >= 0) ? trickLevel : "TrickLevel: Not available",
                (habits != null) ? habits.toString() : "Habits: Not available");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return age == pet.age && species.equals(pet.species) && nickname.equals(pet.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, species, nickname);
    }
}