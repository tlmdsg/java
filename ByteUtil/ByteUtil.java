/**
 * 
 */
package ByteUtil;

import java.nio.ByteBuffer;
import java.util.Arrays;


/**
 * @author tlm
 * Byte 类型的工具类
 */
public class ByteUtil {
	
	//byte 数组与 int 的相互转换 
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
	
	//byte 数组与 long 的相互转换 
	public static long bytesToLong(byte[] bytes) {
		ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
		return byteBuffer.getLong();
	}
	
	public static byte[] longToBytes(long i) {
		ByteBuffer byteBuffer = ByteBuffer.allocateDirect(8);
		byte[] bytes = new byte[8];
		byteBuffer.putLong(i).flip();
		byteBuffer.get(bytes);
		return bytes;
	}
	
	//byte 转为字符串的 bit 
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

		bytes = longToBytes(256);
		System.out.println(bytes);
		System.out.println(Arrays.toString(bytes));
		for (byte b : bytes) {
			System.out.print(byteToBit(b) +" ");
		}
		System.out.println(bytesToLong(bytes));
		
	}
}
