package hw11.Pet;
import java.io.Serializable;

public class DomesticCat extends Pet implements Foulable, Serializable {
    DomesticCat(String nickname){
        super(nickname);
        setSpecies(Species.domesticCat);}
    public DomesticCat(String nickname, int age){
        super(nickname,age);
        setSpecies(Species.domesticCat);}
    DomesticCat(){}
    @Override
    public void respond() {System.out.println("Meow... I'm your cat " + getNickname() + ", but I’ll come only if I want to.");}
    @Override
    public void voice() {System.out.println("Meow - Meow - Meow");}
    @Override
    public void foul() {System.out.println("I scratched the sofa again... and knocked your mug off the table.");}
    @Override
    public String toString() {
        return super.toString();
    }
}
