import java.io.*;
import java.util.*;

public class MySimpleCryptoAlgorithm implements CryptoAlgorithm {

    private BiMap<Byte,Byte> key = new BiMap<>();

    private LinkedList<Byte> bytes = new LinkedList<>();

    @Override
    public void encrypt(File decryptFile, File cryptFile, Object key) throws IOException {
        if (key == null) {
            generateKey();
        } else {
            this.key=(BiMap<Byte,Byte>) key;
        }

        FileInputStream decryptFileStream = new FileInputStream(decryptFile);
        FileOutputStream cryptoFileStream = new FileOutputStream(cryptFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(decryptFileStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(cryptoFileStream);
        byte[] buffer = new byte[1000];
        byte[] outBuffer = new byte[1000];
        while (bufferedInputStream.available() > 0) {
            bufferedInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                byte b = buffer[i];
                byte d = this.key.getKey(b);
                outBuffer[i] = d;
            }
            bufferedOutputStream.write(outBuffer);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }

    @Override
    public void decrypt(File encryptFile, File decryptFile, Object key) throws IOException {
        FileInputStream encryptFileStream = new FileInputStream(encryptFile);
        FileOutputStream decryptoFileStream = new FileOutputStream(decryptFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(encryptFileStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(decryptoFileStream);
        byte[] buffer = new byte[1000];
        byte[] outBuffer = new byte[1000];
        while (bufferedInputStream.available() > 0) {
            bufferedInputStream.read(buffer);
            for (int i = 0; i < buffer.length; i++) {
                byte b = buffer[i];
                byte d = this.key.getValue(b);
                outBuffer[i] = d;
            }
            bufferedOutputStream.write(outBuffer);
        }
        bufferedOutputStream.flush();
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }

    @Override
    public Object getKey() {
        return key;
    }

    private void generateKey() {

        createBytesPool();

        for (int i = -128; i <= 127 ; i++) {
            byte d = (byte) i;
            byte b = getRandomByte();
            key.put(b, d);
        }
    }

    private void createBytesPool() {
        for (byte i = -128; i < 127 ; i++) {
            bytes.add(i);
        }
        bytes.add((byte)127);
        Collections.shuffle(bytes);
    }

    private Byte getRandomByte() {
        return bytes.poll();
    }
}
