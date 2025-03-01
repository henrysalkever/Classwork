import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;


public class Numeral_Converter {
    
    private String numeral;
    private Dictionary<String,Integer> characters;
    private List<String> numeralCharacters;

    Numeral_Converter(String new_input){
        this.characters = new Hashtable<>();
        this.numeralCharacters = new ArrayList<>();
        this.characters.put("I",1);
        this.characters.put("C",100);
        this.characters.put("L",50);
        this.characters.put("V",5);
        this.characters.put("X",10);
        this.characters.put("M",1000);
        StringtoList(new_input);


    }
    
    private void StringtoList(String new_string){
        for (char ch : numeral.toCharArray()) {
            numeralCharacters.add(ch);
        }
    }

    private int toInt(){
       
        int i; 
        for (i=0;i < numeralCharacters.size();i++){
            String new_char = numeralCharacters.get(i);
        }
    }
}
