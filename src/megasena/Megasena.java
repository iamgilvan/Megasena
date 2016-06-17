package megasena;

import java.io.FileNotFoundException;
import java.io.IOException;


public class Megasena {
    /*  @authors: APENAS NO ARQUIVO Megasena.java!!!!!
    
        Gilvan Praxedes de Almeida: 2013200887
        Vinicius Veronesi Medina: 2015201111
        Kellen Cristina de Souza Coelho: 2014201690
        Patric de Oliveira Freitas: 2013101377
        Rodrigo Ferreira Gomes: 2014201952
    
        @param args the command line arguments
        @throws java.io.FileNotFoundException
    */
    public static void main(String[] args)throws FileNotFoundException, IOException{ 
        // TODO code application logic here
    
      Cadastro cadastro = new Cadastro("cadastro.txt");
      Apostas apostas = new Apostas("aposta.txt",cadastro);
      Sorteio sorteio = new Sorteio("sorteio.txt");
      apostas.apuraResultado(sorteio);
    }
}
    