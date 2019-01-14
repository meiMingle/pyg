import org.junit.Test;
import util.FastDFSClient;

public class FastDFSUtilTest {
    @Test
    public void test1() throws Exception {
//        FastDFSClient fastDFSClient = new FastDFSClient("classpath:tracker.properties");

        FastDFSClient fastDFSClient = new FastDFSClient("D:\\projects\\pyg_parent_74\\pyg_common\\src\\main\\resources\\fdfs_client.conf");
        String filePath = fastDFSClient.uploadFile("C:\\Users\\Ti\\Desktop\\456.jpg");
        System.out.println(filePath);
    }
}
