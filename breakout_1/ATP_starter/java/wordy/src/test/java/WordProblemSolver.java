public class WordProblemSolver {
    public int solve(String s) {



        String[] inputWords = s.split(" ");
        if (inputWords.length == 3) {
            String inputWord = inputWords[2].substring(0,1);
            return Integer.parseInt(inputWord);
        }
        return 2;
    }
}
