package hw07;

import hw07.Human.Human;
import hw07.Human.Man;
import hw07.Human.Woman;
import hw07.Pet.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Pet petLily = new Dog("Lily", 3);
        Pet petRoki = new RoboCat("Roki", 6);
        Pet petMimi = new DomesticCat("Mimi", 1);
        Pet petHanyka = new Fish("Hanyka", 4);
        Pet petBally = new Dog("Bally", 2);
        petLily.setSpecies(Pet.Species.dog);
        petRoki.setSpecies(Pet.Species.roboCat);
        petMimi.setSpecies(Pet.Species.domesticCat);
        petHanyka.setSpecies(Pet.Species.fish);

        Human nikolasNesturenko = new Man("Nesturenko", "Nikolas", "12/03/1975", 90);
        Human nataliNesturenko = new Woman("Nesturenko", "Natali", "01/02/1978", 89);
        Human davidLaser = new Man("Laser", "David", "20/03/1971", 75);
        Human alexaLaser = new Woman("Laser", "Alexa", "02/10/1976", 98);

        // Створення Set<Pet> вручну, без Set.of()
        Set<Pet> petsBally = new HashSet<>();
        petsBally.add(petBally);
        Human maryaLaser = new Woman("Laser", "Marya", "02/06/1996", alexaLaser, davidLaser, 82, petsBally);

        Set<Pet> petsLily = new HashSet<>();
        petsLily.add(petLily);
        Human piterNesturenko = new Man("Nesturenko", "Piter", "25/11/1995", nataliNesturenko, nikolasNesturenko, 94, petsLily);

        Set<Pet> petsHanyka = new HashSet<>();
        petsHanyka.add(petHanyka);
        Human harryNesturenko = new Man("Nesturenko", "Harry", "06/08/2019", maryaLaser, piterNesturenko, 78, petsHanyka);

        Set<Pet> petsRoki = new HashSet<>();
        petsRoki.add(petRoki);
        Human erikaNesturenko = new Woman("Nesturenko", "Erika", "28/06/1990", nataliNesturenko, nikolasNesturenko, 90, petsRoki);

        Set<Pet> petsMimi = new HashSet<>();
        petsMimi.add(petMimi);
        Human danielNesturenko = new Man("Nesturenko", "Daniel", "05/05/1993", nataliNesturenko, nikolasNesturenko, 88, petsMimi);

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

        // Ось створення youngNesterenko з Set<Pet> вручну
        Set<Pet> petsForYoungNesterenko = new HashSet<>();
        petsForYoungNesterenko.add(petLily);
        Family youngNesterenko = new Family(maryaLaser, piterNesturenko, petsForYoungNesterenko);

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
        System.out.println(harryNesturenko.describeAge());
        // Цикл для перевірки пам'яті (закоментовано)
        // for (int i = 0; i < 10000000; i++) {
        //     new Man("Name" + i, "Surname" + i, 1990 + i, 91 + i);
        // }
    }
}