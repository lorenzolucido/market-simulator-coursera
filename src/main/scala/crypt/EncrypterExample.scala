package crypt

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.{IvParameterSpec, SecretKeySpec}

import crypt.EncrypterExample.EnumMode.CryptMode
import sun.misc.{BASE64Decoder, BASE64Encoder}


/**
 * Created by lorenzo on 18/10/14.
 */
object EncrypterExample {

  //val iv = "12345678901234568944621086".getBytes take 16

  object EnumMode extends Enumeration {
    type CryptMode = Value
    val _ENCRYPT_, _DECRYPT_ = Value
  }

  def apply(msg: String, private_key: String, mode: CryptMode = EnumMode._ENCRYPT_): String = {

    println(s"1. The initial message is $msg")
    // -----

    val secretKey = new SecretKeySpec(private_key getBytes "UTF-8", "AES")
    val encipher = Cipher getInstance "AES/CBC/PKCS5Padding"

    encipher.init( Cipher.ENCRYPT_MODE, secretKey) //, new IvParameterSpec(iv))
    val iv = encipher.getIV
    val ivString = Base64.getEncoder.encodeToString(iv)
    println(s"-The IV is " + ivString)

    val cryptedBytes = encipher doFinal (msg getBytes "UTF-8")

    println(s"2. The crypted message (in bytes) is now : $cryptedBytes")
    // -----

    val cryptedString = new BASE64Encoder encode cryptedBytes
    val cryptedString2 = Base64.getEncoder.encodeToString(cryptedBytes)
    val unencoded = Base64.getDecoder.decode(cryptedString2)

    println(s"3. The crypted message (as a String) is now : $cryptedString")
    // -----

    val backtoCryptedBytes = new BASE64Decoder decodeBuffer cryptedString

    println(s"4. The crypted message (converted back to bytes) is now : $backtoCryptedBytes")
    // -----

    encipher.init( Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv))
    val uncryptedBytes = encipher doFinal backtoCryptedBytes
    val decodedMessage = new String(uncryptedBytes)

    println(s"5. The message decoded is : $decodedMessage")
    // -----

    decodedMessage
  }
}
