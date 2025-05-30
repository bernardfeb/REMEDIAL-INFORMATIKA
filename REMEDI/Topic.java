package REMEDI;
public class Topic {
    private String name;
    private String definition;
    private String[] formulas;
    private Problem example;

    public Topic(String name, String definition, String[] formulas, Problem example) {
        this.name = name;
        this.definition = definition;
        this.formulas = formulas;
        this.example = example;
    }

    public void display() {
        System.out.println("\n=== " + name.toUpperCase() + " ===");
        System.out.println("\nPengertian:");
        System.out.println(definition);
        
        System.out.println("\nRumus Penting:");
        for (String formula : formulas) {
            System.out.println("- " + formula);
        }
        
        System.out.println("\nContoh Soal:");
        example.display();
    }
} 