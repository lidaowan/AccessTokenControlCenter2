import java.util.Timer;

public class test {

    public static void main(String[] args) {
        Integer cacheTime = 1000 * 3;
        Timer timer = new Timer();
        // (TimerTask task, long delay, long period)任务，延迟时间，多久执行
        timer.schedule(new Task(), 1000, 6600000);
    }
}
    // WeiXinAccessTokenUtil.getWeiXinAccessToken(CONFIG.APPID,CONFIG.SECRRT);


