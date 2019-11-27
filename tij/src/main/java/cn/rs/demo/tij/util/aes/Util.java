package cn.rs.demo.tij.util.aes;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import java.io.*;

public class Util {

    /**
     * Uses a cipher to transform the bytes in an input stream and sends the
     * transformed bytes to an output stream
     * @param in
     * @param out
     * @param cipher
     */
    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        int inLength = 0;
        boolean more = true;
        while (more){
            inLength = in.read(inBytes);
            if (inLength == blockSize){
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                out.write(outBytes, 0, outLength);
            }else
                more = false;
        }

        if (inLength > 0) outBytes = cipher.doFinal(inBytes, 0, inLength);
        else outBytes = cipher.doFinal();
        out.write(outBytes);
    }

    public static void crypt(InputStream in, PrintWriter out, Cipher cipher) throws IOException, ShortBufferException, BadPaddingException, IllegalBlockSizeException {
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        int inLength = 0;
        boolean more = true;
        while (more){
            inLength = in.read(inBytes);
            if (inLength == blockSize){
                int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
                baos.write(outBytes, 0, outLength);
            }else
                more = false;
        }

        if (inLength > 0) outBytes = cipher.doFinal(inBytes, 0, inLength);
        else outBytes = cipher.doFinal();
        baos.write(outBytes);

        out.print(new String(baos.toByteArray()));
    }

}
