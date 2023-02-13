import java.util.Scanner;
public class Grades {
    
    private int[] scores; 

    // Constructor
    public Grades() {
        this.scores = new int[] {50,30, 60, 80, 100, 80, 90, 100};
    }

    // Helper functions
    /**
     * print all elements in array
     * @param arr array to be printed
     */
    public static void printArray(int[] arr) {
        System.out.print(" - ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " - ");
        }
        System.out.println();
    }

    // Functions on grades
    /**
     * retrieves score of student with given id
     * @param arr array of scores
     * @param id id of student who's score is being retrieved
     * @return int score of student with given id
     */
    public int getScore(int id) {
        return this.scores[id-1];
    }

    /**
     * Tester for getScore function
     * @param id id of student who's score is being retrieved
     */
    public void testGetScore(int id) {
        System.out.println("TESTING get Score");
        System.out.println("This is the array of scores we are working with:");
        printArray(this.scores);
        System.out.println("Student " + id + " got " + getScore(id) + " points.");
    }


    /**
     * sorts the array of scores and returns sorted array
     * @return int[] sorted array in descending order
     */
    public int[] sortedScores(){
        int[] map = new int[101]; //array to hold number of times each number appears in scores array
        int[] sorted = new int[scores.length]; //array to hold sorted scores


        for(int i = 0; i < scores.length; i++){
            map[scores[i]] = map[scores[i]]+1;
        }

        int index = 0;
    
        for(int i = (map.length -1); i >=0; i--){
            for(int j = 0; j < map[i]; j++){
                sorted[index] = i;
                index++;
            }
        }

        return sorted;

    }

    /**
     * Tester for sortedScores function
     */
    public void testSortedScores(){
        System.out.println("=== TESTING sortedScores ===");
        System.out.println("This is the array of scores we are sorting");
        printArray(scores);
        System.out.println("This is the result from sortedScores");
        printArray(sortedScores());
    }

    /**
     * finds student rank in array after sorting
     * @param id
     */
    public int getRank(int id){
        int[] sorted = sortedScores();
        int rank = 1;
        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] == scores[id-1]){
                return rank;
            }
            rank++;
        }
        return rank;
    }

    /**
     * Tester for getRank function
     * @param id id of rank to be retrieved
     */
    public void testGetRank(int id){
        System.out.println("=== TESTING getRank ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        System.out.println("Student " + id + " got " + getScore(id) + " points.");
        System.out.println("Student " + id + " got rank " + getRank(id) + " after sorting.");
    }

    /**
     * Checks to see if anyone received a perfect score
     * @return boolean
     */
    public boolean perfectScoreQ(){
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == 100){
                return true;
            }
        }
        return false;
    }

    /**
     * Tester for perfectScoreQ function
     */
    public void testPerfectScoreQ(){
        System.out.println("=== TESTING perfectScoreQ ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        if (perfectScoreQ()){
            System.out.println("Someone got a perfect score!");
        } else {
            System.out.println("No one got a perfect score.");
        }
    }

    /**
     * Checked to see if anyone received a score of 0 points
     * @return boolean
     */
    public boolean bottomScoreQ(){
        for(int i = 0; i < scores.length; i++){
            if(scores[i] == 0){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Tester for bottomScoreQ function
     */
    public void testBottomScoreQ(){
        System.out.println("=== TESTING bottomScoreQ ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        if (bottomScoreQ()){
            System.out.println("Someone got a score of 0!");
        } else {
            System.out.println("No one got a score of 0.");
        }
    }

    /**
     * finds the maximum score in the array
     * @return int
     */
    public int getMaxScore(){
        return sortedScores()[0];
    }

    /**
     * Tester for getMaxScore function
     */
    public void testGetMaxScore(){
        System.out.println("=== TESTING getMaxScore ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        System.out.println("The maximum score is " + getMaxScore());
    }

    /**
     * finds the number of people who got the maximum score
     * @return int
     */
     public int nrMaxScore(){
        int[] sorted = sortedScores();
        int count = 0;
        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] == getMaxScore()){
                count++; 
            }
        }
        return count;
     }

    /**
     * Tester for nrMaxScore function
     */
    public void testNrMaxScore(){
        System.out.println("=== TESTING nrMaxScore ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        System.out.println("The number of people who got the maximum score is " + nrMaxScore());
    }

     /**
      * finds the minimum score in the array
      * @return int
      */
    public int getMinScore(){
        return sortedScores()[sortedScores().length-1];
    }

    /**
     * Tester for getMinScore function
     */
    public void testGetMinScore(){
        System.out.println("=== TESTING getMinScore ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        System.out.println("The minimum score is " + getMinScore());
    }

    /**
     * finds the number of people who got the minimum score
     * @return int
     */
    public int nrMinScore(){
        int[] sorted = sortedScores();
        int count = 0;
        for(int i = 0; i < sorted.length; i++){
            if(sorted[i] == getMinScore()){
                count++; 
            }
        }
        return count;
    }

    /**
     * Tester for nrMinScore function
     */
    public void testNrMinScore(){
        System.out.println("=== TESTING nrMinScore ===");
        System.out.println("This is the array of scores we are working with:");
        printArray(scores);
        System.out.println("The number of people who got the minimum score is " + nrMinScore());
    }

    // Main Function
    public static void main(String[] args){
        System.out.println("$$$ PROGRAM STARTING $$$");

        Grades hw1 = new Grades();

        //Calling testers
        // hw1Grades.testGetScore(3);
        // hw1Grades.testSortedScores();
        // hw1Grades.testGetRank(3);
        // hw1Grades.testPerfectScoreQ();
        // hw1Grades.testBottomScoreQ();
        // hw1Grades.testGetMaxScore();
        // hw1Grades.testNrMaxScore();
        // hw1Grades.testGetMinScore();
        // hw1Grades.testNrMinScore();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (1-8) or type 'quit' to exit: ");
            String input = sc.nextLine();
            if (input.equals("quit")) {
                break;
            }
            int option = Integer.parseInt(input);
            switch (option) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int id = sc.nextInt();
                    hw1.getScore(id);
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    id = sc.nextInt();
                    hw1.getRank(id);
                    break;
                case 3:
                    System.out.println("Did anybody receive a perfect score of 100? " + hw1.perfectScoreQ());
                    break;
                case 4:
                    System.out.println("Did anybody receive a score of 0 points? " + hw1.bottomScoreQ());
                    break;
                case 5:
                    System.out.println("The maximum score is: " + hw1.getMaxScore());
                    break;
                case 6:
                    System.out.println("Number of students who received the maximum score: " + hw1.nrMaxScore());
                    break;
                case 7:
                    System.out.println("The minimum score is: " + hw1.getMinScore());
                    break;
                case 8:
                    System.out.println("Number of students who received the minimum score: " + hw1.nrMinScore());
                    break;
                case 9:
                    System.out.println("Sorted list of all scores: " + hw1.sortedScores());
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number between 1-8 or type 'quit' to exit.");
            }
        }
    }
}
