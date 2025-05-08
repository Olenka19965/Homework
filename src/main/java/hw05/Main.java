package hw05;

public class Main {
    public static void main(String[] args) {
        Pet petLily = new Dog( "Lily", 3);
        Pet petRoki = new RoboCat("Roki",6);
        Pet petMimi = new DomesticCat("Mimi",1);
        Pet petHanyka = new Fish("Hanyka",4);
        Pet petBally = new Dog("Bally",2);
        petLily.setSpecies(Pet.Species.dog);
        petRoki.setSpecies(Pet.Species.roboCat);
        petMimi.setSpecies(Pet.Species.domesticCat);
        petHanyka.setSpecies(Pet.Species.fish);

        Human nikolasNesturenko = new Man("Nesturenko", "Nikolas", 1965,90);
        Human nataliNesturenko = new Woman("Nesturenko", "Natali", 1968,89);
        Human davidLaser = new Man("Laser", "David", 1971,75);
        Human alexaLaser = new Woman("Laser", "Alexa", 1976,98);
        Human maryaLaser = new Woman("Laser", "Marya", 1996, alexaLaser,davidLaser,82,petBally);
        Human piterNesturenko = new Man("Nesturenko", "Piter", 1995, nataliNesturenko, nikolasNesturenko, 94 , petLily);
        Human harryNesturenko = new Man("Nesturenko", "Harry", 2019, maryaLaser, piterNesturenko,78,petHanyka);
        Human erikaNesturenko = new Woman("Nesturenko","Erika",1990,nataliNesturenko,nikolasNesturenko,90,petRoki);
        Human danielNesturenko = new Man("Nesturenko","Daniel",1993,nataliNesturenko,nikolasNesturenko,88,petMimi);

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
        ((Dog) petLily).foul();

        piterNesturenko.printSchedule();

        oldNesterenko.deleteChild(piterNesturenko);
        oldNesterenko.countFamily();

        harryNesturenko.greetPet();
        harryNesturenko.describePet();


        for (int i = 0; i< 10000000; i++){
            new Man("Name" + i, "Surname" + i, 1990 +i,91 + i);
        }

    }
}