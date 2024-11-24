import java.util.Scanner;

/**
 * Creates an Enigma machine based on command-line arguments, and reads the message
 * from the user on STDIN. Decrypts/Encrypts using the enigma class.
 */
public class Comms {

  public static String processEnigma(String[] args, String message) {

    // Check for the correct # of arguments
    if( args.length != 5 || args[3].length() != 3 ) {
      return "Please enter all fields correctly";
    }
    
    // Encrypt or decrypt argument
    boolean encrypt = true;
    if( args[4].equals("decrypt") )
      encrypt = false;

    // Rotors
    int id1 = Integer.parseInt(args[0]);
    int id2 = Integer.parseInt(args[1]);
    int id3 = Integer.parseInt(args[2]);    

    // Call the Enigma's constructor to build the machine
    Enigma enigma = new Enigma(id1, id2, id3, args[3]);

    // Encrypt or Decrypt
    if( encrypt )
      return enigma.encrypt(message);
    else
      return enigma.decrypt(message);
  }

  public static void main(String args[]) {

    if( args.length != 5 || args[3].length() != 3 ) {
      System.out.println("usage: java Comms <inner#> <middle#> <outer#> \"init\" (encrypt|decrypt)");
      System.exit(1);
    }

    // Check for the correct 3 ints
    for( int i = 0; i < 3; i++ ) {
      if( args[i].length() != 1 || args[i].charAt(0) < '0' || args[i].charAt(0) > '9' ) {
        System.out.println("You entered a rotor value not between 1-5. We have 5 rotors");
        System.exit(1);
      }
    }

    System.out.println("Enter message you want crypted");

    Scanner scan = new Scanner(System.in);
    String message = scan.next();


    String res = processEnigma(args, message);
    System.out.println(res);
    scan.close();
  }
}
