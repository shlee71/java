import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SeedNew {
    public static void main(String[] args) throws Exception {
        // Key: 16-byte SEED key
        byte[] key = "0123456789abcdef".getBytes(); 

        // Plaintext: Ensure exactly 16 bytes (e.g., zeros here)
        byte[] plainText = "0000000000000000".getBytes();

        // Initialize cipher for SEED/ECB/NoPadding
        Cipher cipher = Cipher.getInstance("SEED/ECB/NoPadding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "SEED");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encrypted = cipher.doFinal(plainText);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decrypted = cipher.doFinal(encrypted);

        // Output
        System.out.println("Plaintext: " + new String(plainText));
        System.out.println("Encrypted Message HEX: " + bytesToHex(encrypted));
        System.out.println("Decrypted Text: " + new String(decrypted));
    }

    // Helper method to convert bytes to hex
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
