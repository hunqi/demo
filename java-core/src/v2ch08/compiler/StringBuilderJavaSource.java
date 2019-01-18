package v2ch08.compiler;

import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.net.URI;

/**
 * A Java source that holds the code in a string builder
 */
public class StringBuilderJavaSource extends SimpleJavaFileObject {

    private StringBuilder code;

    public StringBuilderJavaSource(String name) {
        super(URI.create("string:///" + name.replace(".", "/") + Kind.SOURCE.extension), Kind.SOURCE);
        code = new StringBuilder();
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return code;
    }

    public void append(String str) {
        code.append(str);
        code.append("\n");
    }



}
