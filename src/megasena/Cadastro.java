
package megasena;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Cadastro {
private ArrayList<String> nomes = new ArrayList<>();
private ArrayList<String> cpfnome = new ArrayList<>();


//Contrutor da Classe.
public Cadastro(String c) throws IOException{
   Scanner cd;
    try {
        //Inserir as informações no Array.
        cd = new Scanner(new FileReader("cadastro.txt"));
           while(cd.hasNext()){
              cpfnome.add(cd.next());
              nomes.add(cd.nextLine());
           
            }
  
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
      }
    //Verificar informações.
    for (int i=0;i<cpfnome.size();i++){
        if (Verificador.qteCpf(cpfnome.get(i))== false){
            System.err.println("Quantidade de caracteres inválida");
            System.exit(1);
        }
        if (Verificador.verificaNome(nomes.get(i)) == false || nomes.get(i)==""){
            System.err.println("Nome vazio ou com caracter inválido");
            System.exit(3);
        }    
        
        if (Verificador.numeroCpf(cpfnome.get(i)) == false){
            System.err.println("CPF vazio ou com caracter inválido");
            System.exit(2);
        }
           
    }
    //Chamada de criação do aquivo de resultado (resultado.txt)
    criarResultado();   
       
   }
   //Recebe os cpf's e retorna o nome do apostador.
    public String GetNomes(String s){
     String n = null;
     for (int i=0;i<cpfnome.size();i++){
      if (s.equals(cpfnome.get(i))){
          n = nomes.get(i);
          
        }
      }
    return n;   
    }    
    //Retorna o ArrayList de Cpf dos apostadores cadastrados.
    public ArrayList<String> GetArraynome(){
        return cpfnome;
    }

//Inicio de criação do arquivo resultado.txt.
    public static boolean criarResultado() throws FileNotFoundException, IOException{
    FileOutputStream arqsaida = new FileOutputStream("resultado.txt");
    OutputStreamWriter escreve = new OutputStreamWriter(arqsaida);
    escreve.write("---------------------------------------------------\r\n");
    escreve.write("      RESULTADO DA MEGASENA\r\n");
    escreve.write("---------------------------------------------------\r\n");
    escreve.close();
    return true;
  }    
}    

   
    

