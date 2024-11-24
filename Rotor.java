public class Rotor {
    private String rotorValues;
    private char startChar;
 
    public Rotor(String var1, char var2) {
       this.rotorValues = new String(var1);
       this.startChar = var2;
 
       while(!this.rotate()) {
       }
 
    }
 
    public boolean rotate() {
       char var10001 = this.rotorValues.charAt(this.rotorValues.length() - 1);
       this.rotorValues = "" + var10001 + this.rotorValues.substring(0, this.rotorValues.length() - 1);
       return this.rotorValues.charAt(0) == this.startChar;
    }
 
    public int indexOf(char var1) {
       return this.rotorValues.indexOf(var1);
    }
 
    public char charAt(int var1) {
       return this.rotorValues.charAt(var1);
    }
 }
 