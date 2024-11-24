public class Rotor {

    
   private String rotorValues;
   private char startChar;
   private int currentidx;

       
   public Rotor(String v, char c){
       this.rotorValues = new String(v);
       this.startChar = c;
       
       while(!this.rotate()){
           
           
       }
           
   }
   
   // If the current index has passed its max, rotate & reset currentidx
   public boolean rotate(){
           char rotarr[] = rotorValues.toCharArray();
   
           char temp = rotarr[26];
   
           for(int i = 26; i > 0; i--){
   
               rotarr[i] = rotarr[i - 1];
   
           }
   
           rotarr[0] = temp;
           rotorValues = new String (rotarr);

           if(charAt(0) == startChar){
               return true;
               }

       return false;

   }
   
   // Search for char c in rotor, 
   public int indexOf(char c){
       for(int i = 0; i < 27; i++){
           if(c == rotorValues.charAt(i)){
               return i;
           }
       }

       return 0;
   }

   // Returns the char at the idx given 
   public char charAt(int idx){
       return rotorValues.charAt((idx) % rotorValues.length());
   }
}
   
