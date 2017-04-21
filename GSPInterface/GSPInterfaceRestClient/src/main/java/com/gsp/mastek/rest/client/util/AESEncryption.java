/*******************************************************************************
* This class is used to define methods 
* to encrypt Appkey and OTP in format required by GSTN
 ******************************************************************************/
package com.gsp.mastek.rest.client.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;


/**
 * @author suraj13392
 *
 */
public class AESEncryption {

	public static final String AES_TRANSFORMATION = "AES/ECB/PKCS5Padding";
	public static final String AES_ALGORITHM = "AES";
	public static final int ENC_BITS = 256;
	public static final String CHARACTER_ENCODING = "UTF-8";

	private static Cipher ENCRYPT_CIPHER;
	private static Cipher DECRYPT_CIPHER;
	private static KeyGenerator KEYGEN;

	static {
		try {
			ENCRYPT_CIPHER = Cipher.getInstance(AES_TRANSFORMATION);
			DECRYPT_CIPHER = Cipher.getInstance(AES_TRANSFORMATION);
			KEYGEN = KeyGenerator.getInstance(AES_ALGORITHM);
			KEYGEN.init(ENC_BITS);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to encode bytes[] to base64 string.
	 * 
	 * @param bytes
	 *            : Bytes to encode
	 * @return : Encoded Base64 String
	 */
	private static String encodeBase64String(byte[] bytes) {
		return new String(java.util.Base64.getEncoder().encode(bytes));
	}

	/**
	 * This method is used to decode the base64 encoded string to byte[]
	 * 
	 * @param stringData
	 *            : String to decode
	 * @return : decoded String
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] decodeBase64StringTOByte(String stringData) throws Exception {
		return java.util.Base64.getDecoder().decode(stringData.getBytes(CHARACTER_ENCODING));
	}

	/**
	 * This method is used to generate the base64 encoded secure AES 256 key *
	 * 
	 * @return : base64 encoded secure Key
	 * @throws NoSuchAlgorithmException
	 * @throws IOException
	 */
	public static String generateSecureKey() {
		SecretKey secretKey = KEYGEN.generateKey();
		return encodeBase64String(secretKey.getEncoded());
	}

	/**
	 * This method is used to encrypt the string which is passed to it as byte[]
	 * and return base64 encoded encrypted String
	 * 
	 * @param plainText
	 *            : byte[]
	 * @param secret
	 *            : Key using for encrypt
	 * @return : base64 encoded of encrypted string.
	 * 
	 */

	private static String encryptEK(byte[] plainText, byte[] secret) {
		try {

			SecretKeySpec sk = new SecretKeySpec(secret, AES_ALGORITHM);
			ENCRYPT_CIPHER.init(Cipher.ENCRYPT_MODE, sk);
			return Base64.encodeBase64String(ENCRYPT_CIPHER.doFinal(plainText));

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * This method is used to decrypt base64 encoded string using an AES 256 bit
	 * key.
	 * 
	 * @param plainText
	 *            : plain text to decrypt
	 * @param secret
	 *            : key to decrypt
	 * @return : Decrypted String
	 * @throws IOException
	 * @throws InvalidKeyException
	 * @throws BadPaddingException
	 * @throws IllegalBlockSizeException
	 */
	public static byte[] decrypt(String plainText, byte[] secret)
			throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException, Exception {
		SecretKeySpec sk = new SecretKeySpec(secret, AES_ALGORITHM);
		DECRYPT_CIPHER.init(Cipher.DECRYPT_MODE, sk);
		return DECRYPT_CIPHER.doFinal(Base64.decodeBase64(plainText));
	}

	public String getEncryptedAppKey(String appkey) {
		try {
			// Encrypt with GSTN public key
			String encryptedAppkey = EncryptionUtil.generateEncAppkey(decodeBase64StringTOByte(appkey));
			return encryptedAppkey;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}

	public String getEncryptedOTP(String otp, String appkey) {
		try {
			// Encryption of OTP with appkey
			String encryptedOtp = encryptEK(otp.getBytes(), decodeBase64StringTOByte(appkey));
			return encryptedOtp;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
}
