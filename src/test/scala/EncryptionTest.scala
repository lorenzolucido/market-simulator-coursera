import crypt.EncrypterExample
import org.specs2.mutable.Specification

/**
 * Created by lorenzo on 18/10/14.
 */
class EncryptionTest extends Specification {

  "The encrypter" should {
    val secretMessage = "I'm a secret message and I want to be sent over IronMQ"
    val secretKey = "abcdefghijklmnop"

    "encode the message" in {
      val cryptedThenDecoded = EncrypterExample(secretMessage, secretKey, EncrypterExample.EnumMode._ENCRYPT_)

      cryptedThenDecoded mustEqual secretMessage
    }
  }


  "A simple base64 encoder" should {

  }
}
