package typeinfo.project2;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.System.err;

public class MyCraftBackup {

    public static void main(String[] args) {
        BackupHelper backupImpl = new BackupHelper();

        Backup proxy = (Backup) Proxy.newProxyInstance(
                Backup.class.getClassLoader(),
                new Class[]{Backup.class},
                new BackupProxyHandler(backupImpl));

        System.out.println("input a command to start:");
        Scanner input = new Scanner(System.in);
        while (true) {
            String message = input.nextLine();

            if (!message.replaceAll(" ", "").isEmpty()) {
                System.out.println("message: " + message);
                proxy.backup(message);
            }else {
                System.out.println("input a command please!");
            }
        }

    }

}

interface Backup {
    void backup(String message);
}

class BackupHelper implements Backup {

    @Override
    public void backup(String operation) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Path filePath = Paths.get(System.getProperty("user.dir"), String.format("mc%s.txt", sdf.format(new Date())));

        if (Files.notExists(filePath)) {
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                err.println("fail to create file : " + filePath);
                return;
            }
        }

        try (OutputStream os = Files.newOutputStream(filePath, StandardOpenOption.APPEND)) {
            os.write((operation + new Date() + "\n").getBytes());
        } catch (IOException e) {
            err.println("fail to save operation: " + operation);
        }
    }
}

class BackupProxyHandler implements InvocationHandler {
    private Object proxied;

    public BackupProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass() +
                ", method: " + method + ", args: " + args);
        if (args != null)
            for (Object arg : args)
                if (String.valueOf(arg).contains("error") || String.valueOf(arg).contains("exception")
                || String.valueOf(arg).contains("rollback"))
                {
                    err.printf("error: %s occurred, rollback\n", arg);
                    return null;
                }

        return method.invoke(proxied, args);
    }
}
