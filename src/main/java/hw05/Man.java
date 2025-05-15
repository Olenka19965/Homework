package hw05;
public final class Man extends Human{
    Man(String surname, String name, int year, int iq) {
        super(surname,name,year,iq);}
    Man(String surname, String name, int year, Human mother, Human father) {
        super(surname,name,year,mother,father);}
    Man(String surname, String name, int year, Human mother, Human father, int iq, Pet pet) {
        super(surname,name,year,mother,father,iq,pet);}
    Man() {}
    public void shaveНourFace(){System.out.println("I am shaving my beard.");}
    @Override
    public void greetPet() {System.out.println("Hello " + family.getPet().getNickname());}
    @Override
    public String toString() {
        return super.toString();
    }
}
