import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class GetAccessTokenRsp implements Serializable {


    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -7021131613095678023L;

    private static String accessToken;

    public static String getAccessToken()
    {
        return accessToken;
    }

    public void setAccessToken(String accessToken)
    {
    JSONObject jsonObject =    JSONObject.parseObject(accessToken);

        this.accessToken = jsonObject.getString("access_token");
       // this.accessToken = accessToken;
    }

    @Override
    public String toString()
    {
        return "GetAccessTokenRsp [accessToken=" + accessToken + "]";
    }

}
