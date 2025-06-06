package hw11.Pet;

import java.io.Serializable;

public class RoboCat extends Pet implements Serializable {
    RoboCat(String nickname){
        super(nickname);
        setSpecies(Species.roboCat);}
    public RoboCat(String nickname, int age){
        super(nickname,age);
        setSpecies(Species.roboCat);}
    RoboCat(){}
    @Override
    public void respond() {System.out.println("Beep boop. RoboCat " + getNickname() + " is here to assist you.");}
    @Override
    public void voice() {System.out.println("Beep boop. M-e-o-w");}
    @Override
    public String toString() {
        return super.toString();
    }
}
