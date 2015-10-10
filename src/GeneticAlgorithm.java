import java.util.Arrays;
import java.util.Random;

public class GeneticAlgorithm {
    
    private int generations;
    private int mutations;
    private final int[] desiredEvolution;
    private final Chromosome[] chromoList;
    
    public static void main(String[] args) {
        int[] e = {1,1,1,0,1,0,1,1,0,1,1,0,1,0,1,1,1,0,1,1,0,1,0,1,1,1,0,1,0,0,0,1,1};
        GeneticAlgorithm ga = new GeneticAlgorithm(1000, e);
        ga.startNaturalSelection();
    }
    
    public GeneticAlgorithm(int initialPopulation, int[] evo) {
        chromoList = new Chromosome[initialPopulation];
        desiredEvolution = evo;
        initialSetGeneration(initialPopulation);
    }
    
    public void startNaturalSelection() {
        fitnessCalculation();
        while(checkForDesiredEvolution()) {
            parentSelection();
            mutationPhase();
            fitnessCalculation();
            generations++;
        }
    }
    
    private void initialSetGeneration(int population) {
        Random r = new Random();
        for(int i = 0; i < population; i++) {
            int[] newGenes = new int[desiredEvolution.length];
            for(int j = 0; j < desiredEvolution.length; j++) {
                newGenes[j] = r.nextInt(2);
            }
            chromoList[i] = new Chromosome(newGenes);
        }
    }
    
    private void fitnessCalculation() {
        int fitTotal = 0;
        for(Chromosome c : chromoList) {
            int matchCounter = 0;
            for(int i = 0; i < desiredEvolution.length; i++) {
                if(desiredEvolution[i] == c.genes[i]) {
                    matchCounter++;
                }
            }
            c.fitness = matchCounter;
            fitTotal += matchCounter;
        }
        for(Chromosome ch : chromoList) {
            ch.fitness /= fitTotal;
        }
        sortChromosomes();
    }
    
    private void parentSelection() {
        for(int i = 0; i < chromoList.length; i += 2) {
            crossOver(chromoList[i], chromoList[i + 1]);
        }
    }
    
    private void crossOver(Chromosome cOne, Chromosome cTwo) {
        Random r = new Random();
        int crossPoint = r.nextInt(desiredEvolution.length);
        int holder;
        for(int i = 0; i <= crossPoint; i++) {
            holder = cOne.genes[i];
            cOne.genes[i] = cTwo.genes[i];
            cTwo.genes[i] = holder;
        }
    }
    
    private void mutationPhase() {
        Random r = new Random();
        for(Chromosome c : chromoList) {
            for(int i = 0; i < c.genes.length; i++) {
                int mutChance = r.nextInt(10000) + 1;
                if(mutChance == 5000) {
                    c.genes[i] = (c.genes[i] + 1) % 2;
                    mutations++;
                }
            }
        }
    }
    
    private void sortChromosomes() {
        Chromosome temp;
        for(int i = chromoList.length - 1; i > 0; i--) {
            int first = 0;
            for(int j = 1; j <= i; j++) {
                if(chromoList[j].fitness < chromoList[first].fitness) {
                    first = j;
                }
            }
            temp = chromoList[first];
            chromoList[first] = chromoList[i];
            chromoList[i] = temp;
        }
    }
    
    private boolean checkForDesiredEvolution() {
        for(Chromosome c : chromoList) {
            if(Arrays.equals(c.genes, desiredEvolution)) {
                System.out.println("Generations: " + generations);
                System.out.println("Mutations: " + mutations);
                System.out.print("Desired Evolution: ");
                for(int i = 0; i < desiredEvolution.length; i++) {
                    System.out.print(desiredEvolution[i]);
                }
                System.out.println();
                System.out.print("Evolution Results: ");
                for(int j = 0; j < desiredEvolution.length; j++) {
                    System.out.print(c.genes[j]);
                }
                System.out.println();
                return false;
            }
        }
        return true;
    }
}