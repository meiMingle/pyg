import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Crack for Intellij IDEA plugin: MybatisCodeHelperPro.
 * Just run this java code.
 *
 * @author https://zhile.io
 */
public class MyBatisCodeHelperProCrack {
    public static void main(String[] args) throws IOException {
        File f = new File(System.getProperty("user.home") + "/.config/install/setup.dll");
        System.out.println(f);
        f.getParentFile().mkdirs();
        f.createNewFile();

        FileWriter w = new FileWriter(f);
        w.write("3771504000000");
        w.close();
    }
}
