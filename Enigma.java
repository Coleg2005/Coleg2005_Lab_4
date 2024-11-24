public class Enigma {
    private String[] rotorInit = new String[]{"#GNUAHOVBIPWCJQXDKRYELSZFMT", "#EJOTYCHMRWAFKPUZDINSXBGLQV", "#BDFHJLNPRTVXZACEGIKMOQSUWY", "#NWDKHGXZVRIFJBLMAOPSCYUTQE", "#TGOWHLIFMCSZYRVXQABUPEJKND"};
    private Rotor[] rotors = new Rotor[3];
 
    public Enigma(int var1, int var2, int var3, String var4) {
       this.rotors[0] = new Rotor(this.rotorInit[var1 - 1], var4.charAt(0));
       this.rotors[1] = new Rotor(this.rotorInit[var2 - 1], var4.charAt(1));
       this.rotors[2] = new Rotor(this.rotorInit[var3 - 1], var4.charAt(2));
    }
 
    public String decrypt(String var1) {
       String var2 = "";
 
       for(int var3 = 0; var3 < var1.length(); ++var3) {
          var2 = var2 + this.decryptChar(var1.charAt(var3));
       }
 
       return var2;
    }
 
    private char decryptChar(char var1) {
       int var2 = this.rotors[2].indexOf(var1);
       char var3 = this.rotors[1].charAt(var2);
       int var4 = this.rotors[2].indexOf(var3);
       char var5 = this.rotors[0].charAt(var4);
       this.rotate();
       return var5;
    }
 
    public String encrypt(String var1) {
       String var2 = "";
 
       for(int var3 = 0; var3 < var1.length(); ++var3) {
          var2 = var2 + this.encryptChar(var1.charAt(var3));
       }
 
       return var2;
    }
 
    private char encryptChar(char var1) {
       int var2 = this.rotors[0].indexOf(var1);
       char var3 = this.rotors[2].charAt(var2);
       int var4 = this.rotors[1].indexOf(var3);
       char var5 = this.rotors[2].charAt(var4);
       this.rotate();
       return var5;
    }
 
    private void rotate() {
       if (this.rotors[0].rotate() && this.rotors[1].rotate()) {
          this.rotors[2].rotate();
       }
 
    }
 }
 