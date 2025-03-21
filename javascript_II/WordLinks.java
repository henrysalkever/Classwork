import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class WordLinks {
    
    public String[] dict;
    
    WordLinks(){
        try{
        FileReader fr = new FileReader("words.txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> word_dict = this.readDictionary(br);
        this.dict = word_dict.toArray(new String[word_dict.size()]);
        } catch (IOException e){
            System.err.println("Error reading file");
        }
    }
    
    public ArrayList <String> readDictionary(BufferedReader newReader){
        ArrayList <String> dictionary = new ArrayList<>();
        try {
            String word;
            while((word = newReader.readLine())!= null){
                dictionary.add(word);
            }
        } catch (IOException e){
            System.err.println("Error reading from BufferedReader: " + e.getMessage());
        }

        return dictionary;

    }

    public String[] readWordList(String wordString){
        String[] words = wordString.split(",");
        for (int i = 0; i < words.length; i++){
            words[i] = words[i].trim();
        }
        return words;
    }

    public boolean isUniqueList(String[] userWords){
        ArrayList<String> usedwords = new ArrayList<>();
        int i;
        for (i = 0;i < userWords.length;i++){
            boolean seen = usedwords.contains(userWords[i]);
            if (seen == true){
                return false;
            }
            else {
                usedwords.add(userWords[i]);
            }
        }

        return true;
    }

    public boolean isEnglishWord(String[] userWords, String[] wordDict){
        Arrays.sort(wordDict);
        int i;
        for (i=0;i<userWords.length;i++){
            int found = Arrays.binarySearch(wordDict,userWords[i]);
            if (found < 0){
                return false;
            }
        }
        return true;
    }

    public boolean isDifferentByOne(String[] userWords){
        int i;
        for (i=1;i<userWords.length;i++){
            if (userWords[i].length() != userWords[i-1].length()){
                return false;
            }
            String[] letter_array0 = userWords[i-1].split("");
            String[] letter_array1 = userWords[i].split("");
            int differences = 0;
            int j;
            for (j=0;j<letter_array0.length;j++){
                if ((letter_array0[j]).compareTo(letter_array1[j]) != 0){
                    if (differences == 0){
                        differences = 1;
                    } else {
                        return false;
                    }
                }
            }

        }
        return true;
    }


    public void isWordChain(String[] dictionary,String[] userWords){
        //likely prints something to output 
        boolean unique = this.isUniqueList(userWords);
        boolean english = this.isEnglishWord(userWords,dictionary);
        boolean different = this.isDifferentByOne(userWords);
        if (unique == true && english == true && different == true){
            System.out.print("Valid chain of words from Lewis Carroll's word-links game.");
        } else {
            System.out.print("Not a valid chain of words from Lewis Carroll's word-links game");
        }

    }

    public void printWords(String[] userWords){
        int i;
        for (i=0;i<userWords.length;i++){
            System.out.print(userWords[i]);
        }

    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        WordLinks word_game = new WordLinks();
        System.out.println("Enter a comma separated list of words (or an empty list to quit):");
        String words = scanner.nextLine();
        System.out.println(words);
        String[] word_list = word_game.readWordList(words);
        word_game.isWordChain(word_game.dict,word_list);

        scanner.close();

    }

}
