import java.util.Arrays;
import java.util.Base64;

public class SEEDTest {

    private static final int BLOCK_SIZE = 16;

    // String to HEX Conversion ( Unpack to pack )
    private static byte[] stringToHexBytes(String input) {
        int length = input.length();

        if ( length % 2 != 0 ) {
            length = length + 1;
            input = input + '\n';
        }

        byte[] hexBytes = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            hexBytes[i / 2] = (byte) ((Character.digit(input.charAt(i), 16) << 4)
                    + Character.digit(input.charAt(i + 1), 16));
        }
        return hexBytes;
    }

    // HEX To String Conversion (pack -> unpack)
    private static String hexBytesToString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

    // NULL Padding
    private static byte[] padWithNull(byte[] data) {
        int paddingSize = BLOCK_SIZE - (data.length % BLOCK_SIZE);
        return Arrays.copyOf(data, data.length + paddingSize);
    }

    // Remove Padding
    private static byte[] removeNullPadding(byte[] paddedData) {
        int actualLength = paddedData.length;
        for (int i = paddedData.length - 1; i >= 0; i--) {
            if (paddedData[i] != 0) {
                actualLength = i + 1;
                break;
            }
        }
        return Arrays.copyOf(paddedData, actualLength);
    }

    // TEST main Method
    public static void main(String[] args) {
        try {
            // TEST KEY String INPUT 
            String keyHex  = "0123456789ABCDEFFEDCBA9876543210";
            SeedCipher seed = new SeedCipher(keyHex);
            //byte[] keyData = stringToHexBytes(keyHex);
            //SeedCipher seed = new SeedCipher(keyData);
     
            System.out.println();

            //Key constructor for hiding in SeedCipher.java :  T : test, P : production
            //SeedCipher seed = new SeedCipher('T');
 
            // INPUT TEST : Plain TEXT
            String inputText = "0000000000000000";             
            System.out.println("==================================================================================");
            System.out.println("Input TEXT (Plain Text)   : " + inputText);
            System.out.println("Encryption/Decryption Key : " + keyHex);
            System.out.println("==================================================================================");

            // encrypt String
            byte[] encryptedData = seed.encrypt(inputText);

            // encrypt result
            String encryptedHex  = hexBytesToString(encryptedData);
            System.out.println("Encryption Result (HEX)   : " + encryptedHex); 

            // Encryption & Decryption with Hex
            byte[] cipherData = stringToHexBytes(encryptedHex);
            byte[] decryptedData = seed.decrypt(cipherData);
              
            String decryptedStr  = new String(decryptedData);
            System.out.println("Decryption Result String  : " + decryptedStr);
            String decryptedHex = hexBytesToString(decryptedData);            
            System.out.println("Decryption Result (HEX)   : " + decryptedHex);
            System.out.println("==================================================================================");
            // Encryption & Decryption with Base64
            // INPUT TEST : Plain TEXT
            inputText = "Hello World ! Good morning everyone !! Have a good day ^^";     
            System.out.println("Input TEXT (Plain Text)   : " + inputText);
            encryptedData = seed.encrypt(inputText);

            String encodedBase64 = Base64.getEncoder().encodeToString(encryptedData);
            System.out.println("Encryption Result (BASE64): " + encodedBase64);

            byte[] decodedBase64 = Base64.getDecoder().decode(encodedBase64);
            decryptedData = seed.decrypt(decodedBase64);
            decryptedStr  = new String(decryptedData);
            System.out.println("Decryption Result String  : " + decryptedStr);
            System.out.println("==================================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
