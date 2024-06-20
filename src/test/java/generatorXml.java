
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.rmi.server.ExportException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.aliyun.auth.credentials.Credential;
import com.aliyun.auth.credentials.provider.StaticCredentialProvider;
import com.aliyun.core.http.HttpClient;
import com.aliyun.core.http.HttpMethod;
import com.aliyun.core.http.ProxyOptions;
import com.aliyun.httpcomponent.httpclient.ApacheAsyncHttpClientBuilder;
import com.aliyun.sdk.service.dysmsapi20170525.models.*;
import com.aliyun.sdk.service.dysmsapi20170525.*;
import com.google.gson.Gson;
import darabonba.core.RequestConfiguration;
import darabonba.core.client.ClientOverrideConfiguration;
import darabonba.core.utils.CommonUtil;
import darabonba.core.TeaPair;

//import javax.net.ssl.KeyManager;
//import javax.net.ssl.X509TrustManager;
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.io.*;



public class generatorXml {

    @Test
    public void mgb() throws SQLException, IOException, InterruptedException, XMLParserException, InvalidConfigurationException {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("mbg.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }

    @Test
    public void testSendMessage() throws Exception{
        StaticCredentialProvider provider = StaticCredentialProvider.create(Credential.builder()
                .accessKeyId(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID"))
                .accessKeySecret(System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET"))
                .build());


        AsyncClient client = AsyncClient.builder()
                .credentialsProvider(provider)
                .overrideConfiguration(
                        ClientOverrideConfiguration.create()
                                .setEndpointOverride("dysmsapi.aliyuncs.com")
                )
                .build();

        SendSmsRequest sendSmsRequest = SendSmsRequest.builder()
                .phoneNumbers("15375807058")
                .signName("hallowlemon")
                .templateParam("{\"code\":\"54088\"}")
                .templateCode("SMS_465328924")
                .build();


        CompletableFuture<SendSmsResponse> response = client.sendSms(sendSmsRequest);
        SendSmsResponse resp = response.get();
        System.out.println(new Gson().toJson(resp));

        client.close();
    }

    @Test
    public void envVarTest(){
        String alibabaCloudAccessKeyId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
        String alibabaCloudAccessKeySecret = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
        System.out.println(alibabaCloudAccessKeyId);
        System.out.println(alibabaCloudAccessKeySecret);
    }
    public static boolean validatePassword(String password) {
        int count = 0; // 用于计数满足条件的字符类型数量

        // 检查是否包含数字
        if (password.matches(".*[0-9].*")) {
            System.out.println("匹配到数字");
            count++;
        }

        // 检查是否包含符号
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            System.out.println("匹配到符号");
            count++;
        }

        // 检查是否包含小写字母
        if (password.matches(".*[a-z].*")) {
            System.out.println("匹配到小写字母");
            count++;
        }

        // 检查是否包含大写字母
        if (password.matches(".*[A-Z].*")) {
            System.out.println("匹配到大写字母");
            count++;
        }
        System.out.println(count);
        // 至少包含两种字符类型则返回true，否则返回false
        return count >= 2&&password.length()>=8;
    }


}
