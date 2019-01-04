import org.junit.Test;
import util.BCryptUtil;

public class UtilTest {
    @Test
    public void test1() {
        String encodedStr = BCryptUtil.encode("shop");
        System.out.println(encodedStr);

    }

    @Test
    public void test2() {
        boolean is = BCryptUtil.verify("shop", "$2a$10$lVQOuF5EhNiWwJOOLbBZfusSTWn/tGvFSgr.tMBG9MflQ7p.MAPRG");
        System.out.println(is);
    }


}
