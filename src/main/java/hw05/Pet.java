package hw05;
import java.util.Arrays;
import java.util.Random;

public abstract class Pet {
    private Species species;
    private String nickname;
    private int trickLevel;
    private String[] habits;
    private int age;
    public enum Species{ dog, roboCat,domesticCat, fish,UNKNOWN}
    Pet(String nickname){
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        Random rand = new Random();
        this.trickLevel = rand.nextInt(101);
        this.habits = getRandomHabits();}
    Pet(String nickname, int age ){
        this.species = Species.UNKNOWN;
        this.nickname = nickname;
        this.age = age;
        Random rand = new Random();
        this.trickLevel = rand.nextInt(101);
        this.habits = getRandomHabits();}
    Pet(){}
    public void setSpecies(Species species) {
        if (species != null) {
            this.species = species;
        } else {
            this.species = Species.UNKNOWN; // Якщо вид невідомий, ставимо UNKNOWN
        }
    }
    public Species getSpecies() {return species;}
    String getNickname(){return nickname;}
    String getDescribePet(){
        return "I have " + species + ", it is " + age + " years old, and its trick level is "+ getTrickLevelDescription() + ". Its habits are: " + String.join(", ", habits);}
    protected String[] getRandomHabits() {
        if (species == Species.fish || species == Species.roboCat) {
            return new String[] { "No hobbies" };
        }
        Random rand = new Random();
        String[] chosen = new String[3];
        for(int i = 0; i < 3; i++)
            chosen[i] = possibleHabits[rand.nextInt(possibleHabits.length)];
        return chosen;}
    public String getTrickLevelDescription() {
        if (trickLevel > 50) {
            return "very cunning";
        } else {
            return "almost not cunning";}}
    private static final String[] possibleHabits = {
            "playing with a ball",
            "sleeping on the couch",
            "hiding under the bed",
            "spilling food",
            "ruining furniture",
            "chasing its tail",
            "attacking from an ambush",
            "running on the grass",
            "scaring the squirrel",
            "waking the owner at 5 am"};
    void describePet() {System.out.println(getDescribePet());}
    void eat(){System.out.println("I eat!");}
    public abstract void respond();
    public abstract void voice();
    @Override
    protected void finalize() throws Throwable{
        System.out.println("Finalize is called for: " + this);
        super.finalize();
    }
    @Override
    public String toString() {
        return String.format("%s{nickname='%s', age=%s, trickLevel=%s, habits=%s}",
                (species != null) ? species : "Species: Not available",
                (nickname != null) ? nickname : "Nickname: Not available",
                (age > 0) ? age : "Age: Not available", // Тут повертається "Age: Not available", якщо age <= 0
                (trickLevel >= 0) ? trickLevel : "TrickLevel: Not available", // Якщо trickLevel < 0, повертається "TrickLevel: Not available"
                (habits != null) ? Arrays.toString(habits) : "Habits: Not available");}
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pet pet = (Pet) obj;
        return age == pet.age && species.equals(pet.species) && nickname.equals(pet.nickname);}
    @Override
    public int hashCode(){
        return java.util.Objects.hash(age,species,nickname);
    }
}
