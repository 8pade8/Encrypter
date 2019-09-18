import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {

        String fileName1 = "C:\\test\\crypt\\MeusInstruments.db";
        String fileName2 = fileName1+".crypt";
        String fileName3 = "C:\\test\\crypt\\MeusInstruments(UC).db";
        String keyFile = "C:\\test\\crypt\\key.txt";
        BiMap<Byte,Byte> key;

        Encrypter encrypter = new Encrypter(new MySimpleCryptoAlgorithm());
        encrypter.encrypt(fileName1,fileName2,null);
        Object key1 = encrypter.getKey();
        key = (BiMap<Byte, Byte>) key1;
        File keyFileFile = new File(keyFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(keyFileFile));
        objectOutputStream.writeObject(key);
        objectOutputStream.close();
        encrypter.decrypt(fileName2, fileName3,key);



    }
}
