public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){    

        char[] messagearr = message.toCharArray();

        char[] result = new char[messagearr.length];
        
        for(int i = 0; i < message.length(); i++){

                int out2 = rotors[2].indexOf(messagearr[i]);

                char mid_index = rotors[1].charAt(out2);

                int out = rotors[2].indexOf(mid_index);

                char index_in = rotors[0].charAt(out);

                result[i] = index_in;

                rotate();
        }

        

        return new String (result);
             
    }


    
    public String encrypt(String message){

        char[] messagearr = message.toCharArray();

        char[] result = new char[messagearr.length];
        
        for(int i = 0; i < message.length(); i++){

                int index_in = rotors[0].indexOf(messagearr[i]);

                char out = rotors[2].charAt(index_in);

                int mid_index = rotors[1].indexOf(out);

                char out2 = rotors[2].charAt(mid_index);

                result[i] = out2;

                rotate();
        }

        

        return new String (result);

    }
        


    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
