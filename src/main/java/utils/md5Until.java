package utils;

import java.io.FileInputStream;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class md5Until {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// 986c6721a70c6abbb32b092f0d1ef98a
		String file = "C:/Users/Administrator/Desktop/apache-tomcat-8.5.6-src.zip";
		try {
			System.out.println(getFileMD5(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getStringMD5(String string) throws NoSuchAlgorithmException {
		MessageDigest message = MessageDigest.getInstance("MD5");
		message.update(string.getBytes());
		byte[] ms = message.digest();
		return fromBytesToHex(ms);
	}

	public static String getFileMD5(String file) throws Exception {
		FileInputStream fileInputStream = new FileInputStream(file);
		DigestInputStream diStream = new DigestInputStream(fileInputStream, MessageDigest.getInstance("MD5"));
		byte[] buffer = new byte[1024];
		int read = diStream.read(buffer);
		while (read != -1) {
			read = diStream.read(buffer);
		}
		MessageDigest md = diStream.getMessageDigest();
		return fromBytesToHex(md.digest());
	}

	public static String fromBytesToHex(byte[] resultBytes) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < resultBytes.length; i++) {
			if (Integer.toHexString(0xFF & resultBytes[i]).length() == 1) {
				builder.append("0").append(Integer.toHexString(0xFF & resultBytes[i]));
			} else {
				builder.append(Integer.toHexString(0xFF & resultBytes[i]));
			}
		}
		return builder.toString();
	}

}
