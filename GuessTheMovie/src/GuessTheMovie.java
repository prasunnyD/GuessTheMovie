import java.io.File;
import java.util.Random;
import java.util.Scanner;


public class GuessTheMovie {

    public static void main(String[] args) throws Exception {

        // TODO Auto-generated method stub

        String movie = selectMovie();
        int movieLength = movie.length();
        char[] prompt = new char[movieLength]; //array that holds the entries
        for(int i =0; i < movieLength; i++){   //loop to put underscore and spaces giving user idea of what to guess
            if(movie.charAt(i) == ' '){
                prompt[i] = ' ';
            }
            else{
                prompt[i] = '_';
            }
        }
        String blank = new String(prompt); //intial prompt
        System.out.println("You are guessing:" + blank);
        int numberofGuesses = 0;
        char [] wrong = new char[11];
        Scanner scanner = new Scanner(System.in);
        String Prompt = new String(prompt);
        String wrongEntries = new String(wrong);
              while(numberofGuesses < 10){
                  System.out.print("Guess:");
                  char input = scanner.next().charAt(0);  // user input of a character
                  while (Character.isLetter(input) == false ){
                      System.out.println("Not a letter. Please enter a letter.");
                      System.out.print("Guess:");
                      input = scanner.next().charAt(0);
                  }

                  while(Prompt.indexOf(input) !=-1 || wrongEntries.indexOf(input) != -1){
                      System.out.println("'"+ input +"' has already been guess. Try again");
                      System.out.print("Guess:");
                      input = scanner.next().charAt(0);
                  }
                  if(movie.indexOf(input) != -1){
                      for (int j = 0; j < movie.length(); j++) {  //built indexOf function because it can identify more that one instance of the character
                          if(movie.charAt(j)==input){
                              prompt[j]=input;
                          }
                      }
                      Prompt = new String(prompt);
                      if (movie.equalsIgnoreCase(Prompt)) {
                          System.out.println("You win!");
                          System.out.println("You have guessed '" + movie + "' correctly.");
                          break;
                      }
                      else {
                          System.out.println("Correct guess");
                          System.out.println(Prompt);
                      }
                  }
                  else{
                      numberofGuesses++;
                      wrong[numberofGuesses] = input;
                      wrongEntries = new String(wrong);
                      System.out.println("You have guessed " + numberofGuesses + " wrong letters: " + wrongEntries);
                      System.out.println(Prompt);
                  }

              }
    }

    public static String selectMovie() throws Exception { //method that randomly selects a movie from the movie.txt file

        File list = new File("movies.txt");
        Scanner scanner = new Scanner(list);
        Random generator = new Random();
        int choice = generator.nextInt(25) + 1;
        int i = 0;
        String movie = null;
        while (scanner.hasNextLine()){
            movie =  scanner.nextLine();
            if(choice == i) return movie;
            i++;
        }
        return movie;
    }


    /*public static String UnderScore(String movie) {

        int movieLength = movie.length();
        char[] underscore = new char[movieLength];
        for(int i =0; i < movieLength; i++){
            if(movie.charAt(i) == ' '){
                underscore[i] = ' ';
            }
            else{
                underscore[i] = '_';
            }
        }
        String underScore = new String(underscore);
        return underScore;
    }

    public static String CorrectPrompt(String movie, char guess) {

        int movieLength = movie.length();
        char[] prompt = new char[movieLength];
        for(int i =0; i < movieLength; i++){
            if(movie.charAt(i) == guess){
                prompt[i] = guess;
            }
            else if(movie.charAt(i) == ' '){
                prompt[i] = ' ';
            }
            else{
                prompt[i] = '_';
            }
        }
        String underScore = new String(underscore);
        return underScore;
    }


    public static boolean checkGuess(char guess, String movie) {
        boolean check;
        if (movie.indexOf(guess) == -1){
            check = false;
        }
        else{
            check = true;
        }
        return check;
    }*/

}


