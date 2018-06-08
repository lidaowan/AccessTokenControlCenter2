import java.util.TimerTask;

public class Task extends TimerTask {
    @Override
    public void run() {

//WeiXinAccessTokenUtil.getWeiXinAccessToken(CONFIG.APPID,CONFIG.SECRRT);
        try {
            WritAccessToken.start(CONFIG.PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
