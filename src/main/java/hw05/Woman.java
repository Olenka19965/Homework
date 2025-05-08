package hw05;
public final class Woman extends Human{
    Woman(String surname, String name, int year, int iq) {
        super(surname,name,year,iq);}
    Woman(String surname, String name, int year, Human mother, Human father) {
        super(surname,name,year,mother,father);}
    Woman(String surname, String name, int year, Human mother, Human father, int iq, Pet pet) {
        super(surname,name,year,mother,father,iq,pet);}
    Woman() {}
    public void manicure(){System.out.println("I paint my nails with red polish.");}
    @Override
    public void greetPet() {System.out.println("Hello, my sweet " + family.getPet().getNickname());}
}
