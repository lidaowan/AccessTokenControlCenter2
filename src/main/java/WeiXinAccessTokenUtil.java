import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;


import java.io.IOException;

public class WeiXinAccessTokenUtil {
   // private static final Logger DEBUG_LOGGER = Logger.getLogger(WeiXinAccessTokenUtil.class);

    /**
     *
     * 获取微信access_token
     * <功能详细描述>
     * @param appid
     * @param secret
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static GetAccessTokenRsp getWeiXinAccessToken(String appid, String secret)
    {
        if(appid==null || "".equals(appid) || secret==null || "".equals(secret))
        {
           // DEBUG_LOGGER.error("appid or secret is null");
            return null;
        }
        GetAccessTokenRsp getAccessTokenRsp = new GetAccessTokenRsp();
        try
        {
            String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
            HttpClient httpClient = new HttpClient();
            GetMethod getMethod = new GetMethod(url);
            int execute = httpClient.executeMethod(getMethod);
            System.out.println("execute:"+execute);
            String getResponse = getMethod.getResponseBodyAsString();
            getAccessTokenRsp.setAccessToken(getResponse);
        }
        catch (IOException e)
        {
          //  DEBUG_LOGGER.error("getAccessToken failed,desc:::"+e);
            e.printStackTrace();
        }
        System.out.println(getAccessTokenRsp);
        return getAccessTokenRsp;
    }
}
