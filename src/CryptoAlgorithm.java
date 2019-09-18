import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface CryptoAlgorithm {

    void encrypt(File decryptFile, File cryptFile, Object key) throws IOException;

    void decrypt(File encryptFile, File decryptFile, Object key) throws IOException;

    Object getKey();
}
