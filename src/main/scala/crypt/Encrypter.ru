require 'base64'
require 'openssl'


# ==> Agreed beforehand <==
key = "abcdefghijklmnop"
# ==>  Agreed beforehand <==

# notSoSecret = "I'm ..."

# ==> Sent by Scala ! <==
secret = 'AfcIopbGJrmUuqWPz1zfJzpViqkF5D8r3G6ZSVFBLtTT3racXZqGGECBCB7D4cKKx2NSF+akFldaWaJDaE9Lmg=='
iv = Base64.decode64("Coq2VNf+zBaSrnzOr2pBiA==")
# ==> Sent by Scala ! <==

cipher = OpenSSL::Cipher::AES.new(128, :CBC)

cipher.decrypt
cipher.key = key
cipher.iv = iv

result = cipher.update(Base64.decode64(secret)) + cipher.final

puts result

