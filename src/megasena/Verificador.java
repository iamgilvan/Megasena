
package megasena;

//Realizar toda a verificação de informações

import java.util.ArrayList;

public class Verificador {
    
    //Verificar caracter do cpf.
    public static boolean numeroCpf(String cpf){
      if (cpf ==null)
          return false;
      for (char letra : cpf.toCharArray()) 
          if (letra<'0' || letra >'9')
              return false;
    return true;    
    }
   //Verificar se a quantidade de digitos do cpf.
   public static boolean qteCpf(String cpf){
       if (cpf.length()!=11)
           return false;
       
    return true;   
       
   }
   //Verificar se existe algum caracter especial nos nomes.
  public static boolean verificaNome(String nome){
    boolean v = true;
    String charespec = ":|;ó,´`^~'ƒŠŒŽšœžŸÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖØÙÚÛÜÝÞß"
    + "àáâãäåæçèéêëìíîïðñòóôõöøùúûüýþÿ/|.°§³£¢¬ªº<>!-_?@#$%¨&*=(){}][^~";
    charespec+=""; 
     for(int j=0; j<nome.length(); j++) {
            for(int i=0; i<charespec.length(); i++) {
                if(nome.charAt(j) == charespec.charAt(i)){
                    v=false;
                    if(v==false){
                        return false;
                        
                    }
                }
            }
     
    }
  return v;
}
  //Verificar se o valor das dezenas(apostas) é válido.
  public static boolean verificaAposta(String dezena){
      String S[] = dezena.trim().split(" ");
      int numeros[] = new int [S.length];
      for (int i=0;i<numeros.length;i++){
          numeros[i] = Integer.parseInt(S[i]);
          if (numeros[i]<1 || numeros[i]>60)
              return false;
      }
  return true;    
  }
  //Verificar se quantidade de dezenas está correta.
  public static boolean qteDezena(String dezena){
      String S[] = dezena.trim().split(" ");
      if (S.length<6 || S.length>10)
          return false;
      
    return true;  
  }
  //Verificar se a quantidade de dezenas do sorteio está correta.
  public static boolean qteDezena2(String dezena){
     String S[] = dezena.trim().split(" ");
     if (S.length !=6)
         return false;
 return true;
 }
  //Verificar se o cpf da aposta está cadastrado.
  public static boolean cadastroCpf(String cpf, ArrayList<String> cpfnome){
     for (int i=0;i<cpfnome.size();i++){
      if (cpf.equals(cpfnome.get(i)))
          return true;      
     }
   return false;
  }
}