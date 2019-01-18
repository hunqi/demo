package v2ch08;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.util.List;

public class ScriptEngineManagerTest {

    public static void main(String[] args) throws ScriptException {

        ScriptEngineManager sem = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = sem.getEngineFactories();

        for (ScriptEngineFactory f : engineFactories)
            System.out.println(f.getEngineName() + ", " + f.getMimeTypes() + ", " + f.getExtensions());

        System.out.println("supported engine's size: " + engineFactories.size());

        ScriptEngineFactory engineFactory = engineFactories.get(0);
        ScriptEngine engine = engineFactory.getScriptEngine();

        engine.eval("n = 8");
        Object result = engine.eval("n + 1");
        System.out.println("result: " + result);

        engine.put("k", 100);
        result = engine.eval("k + 1");
        System.out.println("result: " + result);

        result = engine.get("n");
        System.out.println("result: " + result);

        engine.put("b", new JButton());
        engine.eval("b.text = 'OK'");
        System.out.println(((JButton)engine.get("b")).getText());
    }

}
