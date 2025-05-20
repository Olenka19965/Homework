package hw08.Pet;

public class Dog extends Pet implements Foulable {
    Dog(String nickname){
        super(nickname);
        setSpecies(Species.dog);}
    public Dog(String nickname, int age){
        super(nickname,age);
        setSpecies(Species.dog);
        }
    Dog(){}
    @Override
    public void respond() {System.out.println("Woof! I'm your dog " + super.getNickname() + "! I love you!");}
    @Override
    public void voice() {System.out.println("Woof! Woof! Woof!");}
    @Override
    public void foul() {System.out.println("I messed up the yard again!");}
    @Override
    public String toString() {
        return super.toString();
    }
}
