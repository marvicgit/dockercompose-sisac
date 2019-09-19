package aate.gob.pe.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encriptador {

	public static String Encriptar(String textoQueEncriptaremos) throws Exception {
		return Encriptacion(textoQueEncriptaremos, "pass75dc@avz10", "s@lAvz", "MD5", 1, "@1B2c3D4e5F6g7H8", 128);
	}

	public static String Encriptacion(String textoQueEncriptaremos, String passBase, String saltValue, String hashAlgorithm,
			int passwordIterations, String initVector, int keySize) throws Exception {

		 byte[] bytes1 = initVector.getBytes(StandardCharsets.US_ASCII);
         byte[] bytes2 = saltValue.getBytes(StandardCharsets.US_ASCII);
         byte[] bytes3 = textoQueEncriptaremos.getBytes("utf-8"); final
         byte[] bytes4 = new PasswordDeriveBytes(passBase, bytes2, hashAlgorithm, passwordIterations).GetBytes(keySize / 8);
        

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(bytes4, "AES"), new IvParameterSpec(bytes1));
		byte[] ciphertext = cipher.doFinal(bytes3);

		return Base64.getEncoder().encodeToString(ciphertext);
	}
	
	public static String Desencriptar(String textoEncriptado, String passBase, String saltValue, String hashAlgorithm,
			int passwordIterations, String initVector, int keySize) throws Exception {
		byte[] bytes1 = initVector.getBytes(StandardCharsets.US_ASCII);
		byte[] bytes2 = saltValue.getBytes(StandardCharsets.US_ASCII);
		byte[] buffer = Base64.getDecoder().decode(textoEncriptado);
		byte[] bytes3 = new PasswordDeriveBytes(passBase, bytes2, hashAlgorithm, passwordIterations)
				.GetBytes(keySize / 8);

		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
		// You can use ENCRYPT_MODE or DECRYPT_MODE
		// cipher.init(Cipher.ENCRYPT_MODE, bytes3, bytes1);

		cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(bytes3, "AES"), new IvParameterSpec(bytes1));
		byte[] ciphertext = cipher.doFinal(buffer);

		return new String(ciphertext, "UTF-8");

	}

}
