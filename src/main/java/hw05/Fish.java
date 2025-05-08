package hw05;

public class Fish extends Pet{
    Fish(String nickname){
        super(nickname);
        setSpecies(Species.fish);
        }
    Fish(String nickname, int age ){
        super(nickname,age);
        setSpecies(Species.fish);
        }
    Fish(){}
    @Override
    public void respond() {
        System.out.println("... (Fish silently swims)");
    }
    @Override
    public void voice() {System.out.println(" ... ");}
}
