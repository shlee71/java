//package KISA_SEED;
//package sample.security.kisa.seed;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
//import org.apache.xmlbeans.impl.util.Base64;
//import java.util.Base64;

public class SeedMain {
    private static final int BLOCK_SIZE = 16;
	private static String CHARSET = "utf-8";
	//private static final String PBUserKey = "kics2019Hwang!@#"; //16Byte로 설정
	private static final String DEFAULT_IV = "1234567890123456"; //16Byte로 설정

	public static byte pbUserKey[] = { (byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, (byte) 0x89, (byte) 0xab, (byte) 0xcd,
            (byte) 0xef, (byte) 0xfe, (byte) 0xdc, (byte) 0xba, (byte) 0x98, (byte) 0x76, (byte) 0x54, (byte) 0x32,
            (byte) 0x10 };

	//private static byte pbUserKey[] = PBUserKey.getBytes();

	/*
    public static byte bszIV[] = { (byte) 0x27, (byte) 0x28, (byte) 0x27, (byte) 0x6d, (byte) 0x2d, (byte) 0xd5, (byte) 0x4e,
            (byte) 0x29, (byte) 0x2c, (byte) 0x56, (byte) 0xf4, (byte) 0x2a, (byte) 0x65, (byte) 0x2a, (byte) 0xae,
            (byte) 0x08 };
    */
	private static byte bszIV[] = DEFAULT_IV.getBytes();
    
    // 문자열을 HEX로 변환 (unpack -> pack)
    private static byte[] stringToHexBytes(String input) {
        int length = input.length();
        byte[] hexBytes = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            hexBytes[i / 2] = (byte) ((Character.digit(input.charAt(i), 16) << 4)
                    + Character.digit(input.charAt(i + 1), 16));
        }
        return hexBytes;
    }

    // HEX 바이트 배열을 문자열로 변환 (pack -> unpack)
    private static String hexBytesToString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

	/**
	 * - 용도 : 현재 시간을 long 타입으로 변환하며 시간 차를 구하는 함수로 사용
	 * - Return Type: long
	 * - Argument Type : none
	 */
	public static long getCurrentTimeLong() {
		long time;
        java.util.Calendar cal = java.util.Calendar.getInstance();
        time = cal.getTimeInMillis();
        return time;
    }    

    // 데이터 패딩 (NULL Padding 적용)
    /***************************************
     * Main 함수
     * @param args
     **************************************/
    public static void main(String[] args) {
    	
        String plainText = "0000000000000000";
        System.out.println("plainText : " + plainText);   
 
        /* (1) 시작 시간 측정 */
        long startTimeLong = getCurrentTimeLong();
        /*test*/System.out.println( "startTimeLong : " + startTimeLong );
        
        /*************************************
         * 암호화
         *************************************/
        byte[] encryptData = encrypt(plainText);
        String encryptedHex = hexBytesToString(encryptData);
        System.out.println("암호화 결과 (HEX): " + encryptedHex);       
        /*************************************
         * 복호화
         *************************************/
        byte[] xcryptData = 
        { (byte) 0x45, (byte) 0x64, (byte) 0xD5, (byte) 0x05,(byte) 0x7A,(byte) 0x51,(byte) 0x97,(byte) 0x48,(byte) 0xEE,(byte) 0x3E,(byte) 0x6E,(byte) 0x73,(byte) 0xE9,(byte) 0x69,(byte) 0x3F,(byte) 0xEB,
          (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00,(byte) 0x00
        };

        //plainText = decrypt(encryptData);
        plainText = decrypt(encryptData);
        System.out.println("decrypt:" + plainText);
        
        /* (2)종료 시간  측정   */
        long endTimeLong = getCurrentTimeLong();
        /*test*/System.out.println( "endTimeLong : " + endTimeLong );

        long useTime = Math.abs( endTimeLong - startTimeLong ); //절대값을 반환 - 밀리세컨
        /*test*/System.out.println( "  useTime : " + useTime + "(MM)");
            
        //} catch (UnsupportedEncodingException e) {
        //    e.printStackTrace();
        //} catch (Exception e) {
		//	e.printStackTrace();
		//}
        
    }

    public static byte[] encrypt(String str) {
        byte[] enc = null;

        try {
            // Encrypt using KISA_SEED_CBC
            System.out.println("input String length : " + str.getBytes(CHARSET).length);
            enc = KISA_SEED_ECB.SEED_ECB_Encrypt(pbUserKey, str.getBytes(CHARSET), 0, str.getBytes(CHARSET).length);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }        
    
        // Encode to Base64
        //byte[] encArray = Base64.getEncoder().encode(enc);
        //return encArray;
        return enc;
    }
    
    public static String decrypt(byte[] str) {
        // Decode from Base64
        //byte[] enc = Base64.getDecoder().decode(str);
    
        String result = "";
        byte[] dec = null;
    
        try {
            // Decrypt using KISA_SEED_CBC
            dec = KISA_SEED_ECB.SEED_ECB_Decrypt(pbUserKey, str, 0, str.length);
            result = new String(dec, CHARSET);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    
        return result;
    }
    
}
