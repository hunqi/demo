package v2ch08.compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * A java class that holds the bytecodes in a byte array
 */
public class ByteArrayJavaClass extends SimpleJavaFileObject {

    private ByteArrayOutputStream stream;

    public ByteArrayJavaClass(String name) {
        super(URI.create("bytes:///" + name), Kind.CLASS);
        stream = new ByteArrayOutputStream();
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return stream;
    }

    public byte[] getBytes() {
        return stream.toByteArray();
    }

}
