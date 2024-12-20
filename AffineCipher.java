import java.util.Scanner;

// Affine Cipher

public class AffineCipher{

    public static void main(String[] args){

        // default key 
        int a = 5;
        int b = 8;
        boolean repeat = true;
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("this is the Affine Cipher program");
        while(repeat){
            System.out.println("Would you like to type your own key? (y/n) if you say no, the default key will be used.");
            String answer = inputScanner.nextLine();
            if(answer == "y")
            {
                System.out.println("Please enter the key. The key should be two numbers separated by a space. Example: 5(a) 8(b)");
                String key = inputScanner.nextLine();
                String[] keyArray = key.split(" ");
                a = Integer.parseInt(keyArray[0]);
                b = Integer.parseInt(keyArray[1]);
                // check if the key is gcd(a, 26) = 1 and a, b are not divisible by 2 or 13
                if(a % 2 == 0 || a % 13 == 0 || b % 2 == 0 || b % 13 == 0)
                {
                    System.out.println("The key is invalid. Please enter a valid key. This cipher is mod 26.");
                    return;
                }
            }

            System.out.println("Would you like to encrypt(1) or decrypt(2)? Please enter 1 or 2.");
            int choice = inputScanner.nextInt();
            inputScanner.nextLine();
            if(choice == 1) {
                encryption(a, b, inputScanner);
            }
            else {
                decryption(a, b, inputScanner);
            }

            System.out.println("Would you like to encrypt or decrypt another text? (y/n)");
            answer = inputScanner.nextLine();
            if(answer == "n")
            {
                repeat = false;
            }
        }

        inputScanner.close();
    }

    // encryption function. e(x) = (ax + b) mod 26
    private static void encryption(int a, int b, Scanner inputScanner) {
        System.out.println("Please enter the text you would like to encrypt.");
        String text = inputScanner.nextLine();
        String encryptedText = "";
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(Character.isLetter(c))
            {
                if(Character.isUpperCase(c))
                {
                    encryptedText += (char) ((a * (c - 'A') + b) % 26 + 'A');
                }
                else
                {
                    encryptedText += (char) ((a * (c - 'a') + b) % 26 + 'a');
                }
            }
            else
            {
                encryptedText += c;
            }
        }
        System.out.println("The encrypted text is: " + encryptedText);
    }

    // decryption function. d(x) = a^-1(x - b) mod 26
    private static void decryption(int a, int b, Scanner inputScanner) {

        System.out.println("Please enter the text you would like to decrypt.");
        String text = inputScanner.nextLine();
        String decryptedText = "";
        int aInverse = 0;
        // find the modular multiplicative inverse of a in mod 26
        for(int i = 0; i < 26; i++)
        {
            if((a * i) % 26 == 1)
            {
                aInverse = i;
                break;
            }
        }
        for(int i = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(Character.isLetter(c))
            {
                if(Character.isUpperCase(c))
                {
                    decryptedText += (char) (aInverse * (c - 'A' - b + 26) % 26 + 'A');
                }
                else
                {
                    decryptedText += (char) (aInverse * (c - 'a' - b + 26) % 26 + 'a');
                }
            }
            else
            {
                decryptedText += c;
            }
        }
        System.out.println("The decrypted text is: " + decryptedText);
    }
}
