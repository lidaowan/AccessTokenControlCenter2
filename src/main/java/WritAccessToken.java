import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Date;

import static java.lang.Thread.sleep;

public class WritAccessToken {



    public static void start(String path) {
        FileLock lock =null;
        FileChannel channel = null;
try {

WeiXinAccessTokenUtil.getWeiXinAccessToken(CONFIG.APPID,CONFIG.SECRRT);
    File file = new File(path);
    //  System.out.println(getFileContent(f) + 1);// no lock
    RandomAccessFile fi = new RandomAccessFile(file, "rws");
     channel = fi.getChannel();
   lock =  channel.lock();
    write(file,channel);
    //sleep(10000);
    //System.out.println(getFileContent(f) + 2);
    //lock.release();// lock release
}catch (Exception e){
    e.printStackTrace();
}finally {
    try {
        lock.release();
        channel.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    }

    public static void write(File file,FileChannel channel){

        try {
           // ByteBuffer sendBuffer = ByteBuffer.wrap((new Date() + " 写入\n").getBytes());
            channel.truncate(0);
           String accesstoken = GetAccessTokenRsp.getAccessToken();
           ByteBuffer bb = ByteBuffer.wrap(accesstoken.getBytes());
            channel.write(bb);
        }

        catch (Exception e){
           e.printStackTrace();
        }

    }




}
