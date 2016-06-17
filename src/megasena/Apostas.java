
package megasena;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

public class Apostas {
  
  FileOutputStream arqsaida2;
  OutputStreamWriter escreve2;
  private ArrayList<String>cpfap = new ArrayList<>();  
  private ArrayList<String>dezenas = new ArrayList<>();
  private String v ;
  private int cont = 0; 
  private Cadastro cadastro1;

 //Inserção no arquivo resultado.txt resultado dos apostadores.
  public void mostraResultado(int c,String a,int i) throws IOException{
    
  System.out.println("Apostador: "+cadastro1.GetNomes(cpfap.get(i)));
  System.out.println("Acertou "+c+" dezenas");
  System.out.println(a);
  System.out.println("---------------------------------------------------");
  escreve2.write("Apostador: "+cadastro1.GetNomes(cpfap.get(i))+"\r\n");
  escreve2.write("Acertou "+c+" dezenas\r\n");
  escreve2.write(a+"\r\n");
  escreve2.write("-------------------------------------------------\r\n");  
 }

 //Comparação de dezenas dos apostadores com as dezenas do sorteio
  public void apuraResultado(Sorteio s) throws IOException{
    String acertos = ""; 
    String p1 = s.GetSorteio().get(0);
    String p2 = s.GetSorteio().get(1);
    String p3 = s.GetSorteio().get(2);
    String p4 = s.GetSorteio().get(3);
    String p5 = s.GetSorteio().get(4);
    String p6 = s.GetSorteio().get(5);
    for (int i=0;i<dezenas.size();i++){
      v = dezenas.get(i);
      int t =  v.indexOf(p1);
      if (t!=-1){
       acertos=(p1);
       acertos+=" ";
       cont++;}
      t =  v.indexOf(p2);
      if (t!=-1){
       acertos+=(p2);
       acertos+=" ";
       cont++;}
      t =  v.indexOf(p3);
      if (t!=-1){
       acertos+=(p3);
       acertos+=" ";
       cont++;}
      t =  v.indexOf(p4);
      if (t!=-1){
       acertos+=(p4);
       acertos+=" ";
       cont++;}
      t =  v.indexOf(p5);
      if (t!=-1){
       acertos+=(p5);
       acertos+=" ";
       cont++;}
      t =  v.indexOf(p6);
      if (t!=-1){
       acertos+=(p6);
       acertos+=" ";
       cont++;}
          
      mostraResultado(cont,acertos,i);
      acertos = "";
      cont = 0;
    }   
    escreve2.close();
   }

  //Construtor da classe.
  public Apostas(String a,Cadastro t) throws IOException{
   Scanner ap;
   cadastro1 = t;
   arqsaida2 = new FileOutputStream("resultado.txt",true);
   escreve2 = new OutputStreamWriter(arqsaida2);
   try {
      ap = new Scanner(new FileReader("apostas.txt"));
      while(ap.hasNext()){
         cpfap.add(ap.next());
         dezenas.add(ap.nextLine());
        }
       
    } catch (FileNotFoundException ex) {
        Logger.getLogger(Apostas.class.getName()).log(Level.SEVERE, null, ex);
    }
    //Verificação das informações
    for (int i=0;i<cpfap.size();i++){
       if (Verificador.qteCpf(cpfap.get(i))== false){
            System.err.println("Quantidade de caracteres inválida");
            System.exit(1);
        } 
       if (Verificador.numeroCpf(cpfap.get(i)) == false){
            System.err.println("CPF vazio ou com caracter inválido");
            System.exit(2);
        } 
        if (Verificador.qteDezena(dezenas.get(i))== false){
            System.err.println("Quantidade de dezenas invalidas");
            System.exit(5);
        } 
       
        if (Verificador.verificaAposta(dezenas.get(i))==false){
            System.err.println("Dezena com valor inválido");
            System.exit(4);
        }
        if (Verificador.cadastroCpf(cpfap.get(i),cadastro1.GetArraynome())==false){
           System.err.println("CPF não cadastrado");
           System.exit(7);
        }   
    
    }
     
   }
}
    

