import java.io.File;
import java.io.IOException;

public class Encrypter {

    CryptoAlgorithm algorithm;


    public Encrypter(CryptoAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void encrypt(String decryptFile,String cryptFile,Object key) throws IOException {
        algorithm.encrypt(new File(decryptFile),new File(cryptFile),key);
    }

    public void decrypt(String cryptFile, String decryptFile, Object key) throws IOException {
        algorithm.decrypt(new File(cryptFile),new File(decryptFile),key);
    }

    public Object getKey() {
    return algorithm.getKey();
    }

}
