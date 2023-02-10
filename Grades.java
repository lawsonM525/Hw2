public class Grades {
    
    private int[] scores; 

    // Constructor
    public Grades(int[] scores) {
        this.scores = scores;
    }

    // Functions on grades
    /**
     * retrieves score of student with given id
     * @param id
     */
    public int getScore(int id) {
        return scores[id-1];
    }

    /**
     * sorts the array of scores and returns sorted array
     * @return int[] sorted array in descending order
     */
    public int[] sortedScores(){
        int[] map = new int[101]; //array to hold number of times each number appears in scores array
        int[] sorted = new int[scores.length]; //array to hold sorted scores

        //TODO: make to go in descending order
        for(int i = 0; i < scores.length; i++){
            map[scores[i]] = map[scores[i]]+1;
        }

        int index = 0;
    
        // TODO: create a new map with updated length
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i]; j++){
                sorted[index] = i;
                index++;
            }
        }

        return sorted;

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
     * finds the maximum score in the array
     * @return int
     */
    public int getMaxScore(){
        return sortedScores()[0];
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
                count++; //TODO: make this stop after it finds an int that is no longer the max
            }
        }
        return count;
     }

     /**
      * finds the minimum score in the array
      * @return int
      */
    public int getMinScore(){
        return sortedScores()[sortedScores().length-1];
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


}
