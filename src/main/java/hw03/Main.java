package hw03;

public class Main {
    public static void main(String[] args) {
        Pet petLily = new Pet("dog", "Lily", 3);
        Pet petRoki = new Pet("dog","Roki",6);
        Pet petMimi = new Pet("cat","Mimi",1);
        Pet petHanyka = new Pet("cat","Hanyka",4);
        Human nikolasNesturenko = new Human("Nesturenko", "Nikolas", 1965,90);
        Human nataliNesturenko = new Human("Nesturenko", "Natali", 1968,89);
        Human davidLaser = new Human("Laser", "David", 1971,75);
        Human alexaLaser = new Human("Laser", "Alexa", 1976,98);
        Human maryaLaser = new Human("Laser", "Marya", 1996, alexaLaser,davidLaser,82,petLily);  // змінили прізвище на "Laser"
        Human piterNesturenko = new Human("Nesturenko", "Piter", 1995, nataliNesturenko, nikolasNesturenko, 94 , petLily);
        Human harryNesturenko = new Human("Nesturenko", "Harry", 2019, maryaLaser, piterNesturenko,78,petHanyka);
        Human erikaNesturenko = new Human("Nesturenko","Erika",1990,nataliNesturenko,nikolasNesturenko,90,petRoki);
        Human danielNesturenko = new Human("Nesturenko","Daniel",1993,nataliNesturenko,nikolasNesturenko,88,petMimi);

        Family oldNesterenko = new Family(nataliNesturenko, nikolasNesturenko);
        nikolasNesturenko.setFamily(oldNesterenko);
        nataliNesturenko.setFamily(oldNesterenko);
        piterNesturenko.setFamily(oldNesterenko);
        erikaNesturenko.setFamily(oldNesterenko);
        danielNesturenko.setFamily(oldNesterenko);
        oldNesterenko.addChild(piterNesturenko);
        oldNesterenko.addChild(erikaNesturenko);
        oldNesterenko.addChild(danielNesturenko);
        oldNesterenko.countFamily();
        System.out.println(oldNesterenko.toString());

        Family oldLaser = new Family(alexaLaser, davidLaser);
        davidLaser.setFamily(oldLaser);
        alexaLaser.setFamily(oldLaser);
        maryaLaser.setFamily(oldLaser);
        oldLaser.addChild(maryaLaser);
        oldLaser.countFamily();
        System.out.println(oldLaser.toString());

        Family youngNesterenko = new Family(maryaLaser, piterNesturenko, petLily);
        maryaLaser.setFamily(youngNesterenko);
        piterNesturenko.setFamily(youngNesterenko);
        harryNesturenko.setFamily(youngNesterenko);
        youngNesterenko.addChild(harryNesturenko);
        youngNesterenko.countFamily();
        System.out.println(youngNesterenko.toString());

        petMimi.describePet();
        petHanyka.eat();
        petRoki.respond();
        petLily.foul();

        piterNesturenko.printSchedule();

        oldNesterenko.deleteChild(piterNesturenko);
        oldNesterenko.countFamily();

        harryNesturenko.greetPet();
        harryNesturenko.describePet();
    }
}