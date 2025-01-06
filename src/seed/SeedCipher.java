import java.util.ArrayList;
import java.util.List;

/**
 * Seed 암복호화 처리
 * 
 * @author chooty
 * @since 20131230
 */
public class SeedCipher {

	private final static int[] pdwRoundKey = new int[32];
	private final byte[] pbUserKey;
	private final static Seedx seedx = new Seedx();

	public SeedCipher(char serverType) {
		if (serverType == 'T') {
			this.pbUserKey = new byte[] {
				(byte) 0x01, (byte) 0x23, (byte) 0x45, (byte) 0x67, 
				(byte) 0x89, (byte) 0xab, (byte) 0xcd, (byte) 0xef,
				(byte) 0xfe, (byte) 0xdc, (byte) 0xba, (byte) 0x98, 
				(byte) 0x76, (byte) 0x54, (byte) 0x32, (byte) 0x10
			};
		} else if (serverType == 'P') {
			this.pbUserKey = new byte[] {
				(byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, 
				(byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77,
				(byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB,
				(byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF
			};
		} else {
			throw new IllegalArgumentException("Invalid server type: " + serverType + ". Expected 'T' or 'P'.");
		}

		this.seedx.SeedRoundKey(this.pdwRoundKey, this.pbUserKey);
	}

	public SeedCipher(byte[] byteKey) {
		if ( byteKey.length != 16 ){
			throw new IllegalArgumentException("Invalid Seed KEY Length : Input byte KEY LENGTH  " + byteKey.length);
		}

		this.pbUserKey = byteKey;
		this.seedx.SeedRoundKey(this.pdwRoundKey, this.pbUserKey);
	}

	public SeedCipher(String stringKey) {
		if ( stringKey.length() != 32 ){
			throw new IllegalArgumentException("Invalid Seed KEY Length : Input String KEY LENGTH  " + stringKey.length());
		}		
		this.pbUserKey = stringToHexBytes(stringKey);
		this.seedx.SeedRoundKey(this.pdwRoundKey, this.pbUserKey);
	}

	public byte[] encrypt(String stringData) {
		List<Byte> byteList = new ArrayList<Byte>();

		byte[] temp = stringData.getBytes();

		int count = temp.length / 16;
		int remainder = temp.length % 16;

		byte[] pbCipher = new byte[16];
		byte[] target = null;
		int startPos = 0;

		for (int i = 0; i < count; i++) {
			target = new byte[16];
			System.arraycopy(temp, startPos, target, 0, 16);
			seedx.SeedEncrypt(target, pdwRoundKey, pbCipher);
			addBytes(byteList, pbCipher);
			startPos += 16;
		}

		if (remainder > 0) {
			target = new byte[16];
			System.arraycopy(temp, startPos, target, 0, remainder);
			seedx.SeedEncrypt(target, pdwRoundKey, pbCipher);
			addBytes(byteList, pbCipher);
		}
		return listToByteArray(byteList);
	}

	public byte[] encrypt(byte[] byteData) {
			List<Byte> byteList = new ArrayList<Byte>();
	
			byte[] temp = byteData;
			int count = temp.length / 16;
			int remainder = temp.length % 16;
	
			byte[] pbCipher = new byte[16];
			byte[] target = null;
			int startPos = 0;
	
			for (int i = 0; i < count; i++) {
				target = new byte[16];
				System.arraycopy(temp, startPos, target, 0, 16);
				seedx.SeedEncrypt(target, pdwRoundKey, pbCipher);
				addBytes(byteList, pbCipher);
				startPos += 16;
			}
	
			if (remainder > 0) {
				target = new byte[16];
				System.arraycopy(temp, startPos, target, 0, remainder);
				seedx.SeedEncrypt(target, pdwRoundKey, pbCipher);
				addBytes(byteList, pbCipher);
			}
			return listToByteArray(byteList);
	}

	public byte[] decrypt(byte[] cipherData) {
		byte[] temp = cipherData;

		List<Byte> byteList = new ArrayList<Byte>();

		int count = temp.length / 16;
		int remainder = temp.length % 16;

		byte[] plainText = new byte[16];
		byte[] target = null;
		int startPos = 0;

		for (int i = 0; i < count; i++) {
			target = new byte[16];
			System.arraycopy(temp, startPos, target, 0, 16);
			seedx.SeedDecrypt(target, pdwRoundKey, plainText);
			addBytes(byteList, plainText);
			startPos += 16;
		}

		if (remainder > 0) {
			target = new byte[16];
			System.arraycopy(temp, startPos, target, 0, remainder);
			seedx.SeedDecrypt(target, pdwRoundKey, plainText);
			addBytes(byteList, plainText);
		}

		return removePadding(listToByteArray(byteList));
	}

	private static void addBytes(List<Byte> byteList, byte[] byteArray) {
		for (int i = 0; i < byteArray.length; i++) {
			byteList.add(byteArray[i]);
		}
	}

	private static byte[] listToByteArray(List<Byte> byteList) {
		byte[] temp = new byte[byteList.size()];
		for (int i = 0; i < byteList.size(); i++) {
			temp[i] = byteList.get(i);
		}
		return temp;
	}

	private static byte[] removePadding(byte[] value) {
		byte[] removePadding = null;
		int index = 0;
		for (int i = value.length - 1; i < value.length; i--) {
			if (value[i] == 0)
				continue;
			else {
				index = i + 1;
				break;
			}
		}
		removePadding = new byte[index];
		for (int i = 0; i < index; i++) {
			removePadding[i] = value[i];
		}

		return removePadding;
	}
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
}
