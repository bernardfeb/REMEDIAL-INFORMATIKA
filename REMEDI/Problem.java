package REMEDI;
public class Problem {
    private String question;
    private String solution;

    public Problem(String question, String solution) {
        this.question = question;
        this.solution = solution;
    }

    public void display() {
        System.out.println("Pertanyaan: " + question);
        System.out.println("Penyelesaian: " + solution);
    }
} 