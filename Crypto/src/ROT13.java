package Crypto.src;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static java.lang.Character.*;

public class ROT13 {

    int encrypt;
    int decrypt;
    char cs;
    char cf;
    private Mac cipher;


    public ROT13(Character cs, Character cf) {

        encrypt = (int) cf - cs;
        decrypt = (int) 26 - encrypt;
        this.cs = cs;
        this.cf = cf;
    }

    public ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return rotate(text, (char) encrypt);
    }


    public String encrypt(String text) throws InvalidKeyException {

        String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        String renewed = "";
        String[] array = text.split("");

            for (int i=0; i<array.length;i++) {
            for (int j=0; j<alphabet.length;j++) {
                if (array[i].equals(alphabet[j])&& j>13){
                    renewed += alphabet[(j+13)-alphabet.length];
                }
                else if(array[i].equals(alphabet[j]));
                renewed += alphabet[j+13];
            }

        }

        return renewed;

    }



    public String decrypt(String text) {

        return rotate(text, (char) decrypt);
    }

    public String rotate(String s, Character c) {

        Integer num;
        if(!Character.isAlphabetic(c) || c == 'A' || c == 'a') return s;
        if(Character.isUpperCase(c)) num = c-'A';
        else num = c-'a';


        return rotateByNum(s,num);
    }

    private String rotateByNum(String text, int encrypt) {

        String firstPart = text.substring(0,encrypt);
        String secondPart = text.substring(encrypt);
        return secondPart + firstPart;
    }

}
