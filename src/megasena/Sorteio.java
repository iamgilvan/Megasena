
package megasena;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Sorteio {
 private ArrayList<String>sorteio = new ArrayList<>(); 
   
 //Metodo responsável por retornar o ArrayList sorteio.
 public ArrayList<String> GetSorteio(){
    return sorteio;
 }    
 
 //Construtor da Classe.
 public Sorteio(String s) throws IOException{
   try {  
      Scanner st = new Scanner(new FileReader("sorteio.txt"));
      while(st.hasNext()){
        sorteio.add(st.next());
      }
   
    } catch (FileNotFoundException ex) {
            Logger.getLogger(Sorteio.class.getName()).log(Level.SEVERE, null, ex);
    }
   //Verificar informações 
   String Sorteio = "";
   for(int i=0;i<sorteio.size();i++){
        Sorteio+=sorteio.get(i);
        Sorteio+=" ";
    }
    if (Verificador.qteDezena2(Sorteio)==false){
        System.err.println("Quantidade de dezenas do sorteio inválidas");
        System.exit(6);
    }
    if (Verificador.verificaAposta(Sorteio)== false){
        System.err.println("Valor das dezenas inválidas");
        System.exit(4);
    }
 }
}





