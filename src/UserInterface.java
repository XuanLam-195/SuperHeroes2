import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    public void startProgram() {
        final int CREATE = 1;
        final int EXIT = 9;
        final int VIEW = 2;
        final int SEARCH = 3;
        final int EDIT = 4;

        int userChoice;
        Scanner sc = new Scanner(System.in);
        Database database = new Database();
        System.out.println("Welcome to Supperhero Universe: ");

        do {
            System.out.println("Press 1 to 'Create your Superhero'");
            System.out.println("-------------------------------");
            System.out.println("Press 2 to 'View Database'");
            System.out.println("--------------------------");
            System.out.println("Press 3 to 'Search Heroes' ");
            System.out.println("-----------------------------");
            System.out.println("Press 4 to 'Edit Heroes' ");
            System.out.println("-----------------------------");
            System.out.println("Press 9 to 'Exit Program'");
            System.out.println("-----------------------------");

            userChoice = sc.nextInt();
            if (userChoice == CREATE) {
                System.out.println("Create Superhero:");
                System.out.println("Enter Hero name: ");
                String name = sc.next();
                if (name.isEmpty()) {
                    name = "Unknown";
                }
                System.out.println("Enter Hero real name: ");
                String realName = sc.next();
                if (realName.isEmpty()) {
                    realName = "Unknown";
                }
                System.out.println("Hero's superpower: ");
                String superPower = sc.next();
                if (superPower.isEmpty()) {
                    superPower = "Unknown";
                }
                System.out.println("year of created: ");
                String year = sc.next();
                if (year.isEmpty()) {
                    year = "0";
                }
                int yearCreated = Integer.parseInt(year);

                System.out.println("Is hero a human: ");
                String isHuman = sc.next();
                if (isHuman.isEmpty()) {
                    isHuman = "Yes";
                }

                System.out.println("What are the hero's strengths: ");
                String strengthValue = sc.next();
                if (strengthValue.isEmpty()) {
                    strengthValue = "1";
                }
                double strength = Double.parseDouble(strengthValue);

                Superhero newhero = new Superhero(name, realName, superPower,
                        yearCreated, isHuman, strength);
                database.addSuperhero(newhero);
                System.out.println(newhero);
            }

            if (userChoice == VIEW) {
                System.out.println(database);
            }
            if (userChoice == SEARCH) {
                System.out.println("Insearch Name");
                sc.nextLine();
                String searchName = sc.nextLine();
                ArrayList<Superhero> heroList = database.searchSuperheroName(searchName);
                String heroes = "";
                for (Superhero superhero : heroList) {
                    heroes += superhero + "\n";
                }
                System.out.println(heroes);
            }
            if (userChoice == EDIT) {
                System.out.println(database);
                int heroNumberPicked = sc.nextInt();
                System.out.println(database.getSuperheroes().get(heroNumberPicked - 1));

                System.out.println("---------------------");
                System.out.println("Insert new hero name: ");
                sc.nextLine(); //necessary to flush garbage input
                String newName = sc.nextLine();
                System.out.println("Insert new real name: ");
                String newRealName = sc.nextLine();
                System.out.println("Insert new superpower");
                String newSuperPower = sc.nextLine();
                System.out.println("Insert new year created: ");
                int newYearCreated = Integer.parseInt(sc.nextLine());
                System.out.println("Is hero still human? ");
                String newIsHero = sc.nextLine();
                System.out.println("Insert new strength value: ");
                double newStrength = Double.parseDouble(sc.nextLine());

                Superhero newHero = new Superhero(newName, newRealName, newSuperPower,
                        newYearCreated, newIsHero, newStrength);

                database.getSuperheroes().set(heroNumberPicked, newHero);

                System.out.println("Edit completed!");
                System.out.println(newHero);
            }
        }
        while (userChoice != EXIT);
        System.out.println("'Searching er done.'");

    }
}















