package br.com.bruno.santana;

import java.util.*;

public class ExemploScannerComNextInt {
   public static void main(String[] args) {

      String s = "Hello World! 3 + 3.0 = 6.0 true ";

      // create a new scanner with the specified String Object
      Scanner scanner = new Scanner(s);

      // find the next int token and print it
      // loop for the whole scanner
      while (scanner.hasNext()) {

         // if the next is a int, print found and the int
         if (scanner.hasNextInt()) {
            System.out.println("Found :" + scanner.nextInt());
         }
         // if no int is found, print "Not Found:" and the token
         System.out.println("Not Found :" + scanner.next());
      }

      // close the scanner
      scanner.close();
   }
}
