package hw04;
import java.util.Arrays;
import java.util.Random;
public class Pet {
    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[]habits;
    public enum Species{ dog, cat, hamster, bird, turtle}
    Pet(Species species, String nickname){
        this.species = species;
        this.nickname = nickname;
        Random rand = new Random();
        this.trickLevel = rand.nextInt(101);
        this.habits = getRandomHabits();}
    Pet(Species species, String nickname, int age ){
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        Random rand = new Random();
        this.trickLevel = rand.nextInt(101);
        this.habits = getRandomHabits();}
    Pet(){}
    String getNickname(){
        return nickname;}
    String getDescribePet(){
        return "I have " + species + ", it is " + age + " years old, and its trick level is "+ getTrickLevelDescription() + ". Its habits are: " + String.join(", ", habits);}
    private String[] getRandomHabits() {
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
    void respond(){System.out.println("Hello, host. I " + nickname + " I missed you!");}
    void foul(){System.out.println("You need to cover your tracks well...");}
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
