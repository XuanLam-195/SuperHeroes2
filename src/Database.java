import java.util.ArrayList;
import java.util.Scanner;

public class Database {
    private ArrayList<Superhero> superheroes;

    public Database() {
        superheroes = new ArrayList<>();
        populateDatabase();
    }

    public void populateDatabase() {
        Superhero superman = new Superhero("Superman", "Clark Kent",
                "Super strength, flight, xray vision",
                1938, "No", 8698);
        System.out.println("-----------------------------");
        Superhero spiderman = new Superhero("Spider-Man", "Peter Parker",
                "Wall-climbing, web-shooting, danger sense",
                1962, "Yes", 6299);
        superheroes.add(superman);
        superheroes.add(spiderman);
    }

    public void addSuperhero(Superhero hero) {
        superheroes.add(hero);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(ArrayList<Superhero> superheroes) {
        this.superheroes = superheroes;
    }

    public ArrayList<Superhero> searchSuperheroName(String name) {
        ArrayList<Superhero> superheroList = new ArrayList<>();
        for (Superhero superhero : superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                if (!superheroList.contains(superhero.getName())) {
                    superheroList.add(superhero);
                }
            }
        }
        return superheroList;
    }
    public String toString() {
        String heroes = "";
        int counter = 0;
        for (Superhero superhero : superheroes) {
            heroes += (++counter) + "---" + superhero + "\n";
        }
        return heroes;
    }
}
