/**
 * 
 */
package ByteUtil;

import java.util.Arrays;


/**
 * @author tlm
 * Byte ���͵Ĺ�����
 */
public class ByteUtil {
	
	//byte ������ int ���໥ת�� 
	public static int bytesToInt(byte[] bytes) {
		int result ;
		result =  bytes[3] & 0xFF;
		result = result | ((bytes[2] << 8) & 0xFF00); 
		result = result | ((bytes[1] << 16) & 0xFF0000); 
		result = result | ((bytes[0] << 24) & 0xFF000000); 
		return result;
	}
	
	public static byte[] intToBytes(int i) {
		byte[] result = new byte[4];
		result[3] = (byte)(i & 0xFF);
		result[2] = (byte)((i >> 8) & 0xFF);
		result[1] = (byte)((i >> 16) & 0xFF);
		result[0] = (byte)((i >> 24) & 0xFF);
		return result;
	}
	//byte תΪ�ַ����� bit 
	public static String byteToBit(byte b) {  
        return ""  
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)  
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)  
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)  
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);  
    }  
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		test();
	}
	
	private static void test() {
		byte[] bytes = intToBytes(250);
		System.out.println(bytes);
		System.out.println(Arrays.toString(bytes));
		for (byte b : bytes) {
			System.out.print(byteToBit(b) +" ");
		}
		
		System.out.println(bytesToInt(bytes));
		
		System.out.println((byte)250);
	}
}
