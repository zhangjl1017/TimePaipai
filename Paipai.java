import java.awt.*;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by jianleizhang on 2016/8/29.
 */
public class Paipai {
    public static void main(String[] args) throws Exception {
        System.out.println("PaiPai �Ѿ�����------");
        //�õ�ʱ����
        Calendar date = Calendar.getInstance();
        InputStream is=new  FileInputStream("G:\\codejava\\test06\\src\\main\\resources\\conf.properties");
        Properties properties=new Properties();
        properties.load(is);
        int hh=Integer.parseInt(properties.getProperty("hh"));
        int mm=Integer.parseInt(properties.getProperty("mm"));
        int ss=Integer.parseInt(properties.getProperty("ss"));
        //����ʱ��Ϊ xx-xx-xx 00:00:00
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), hh, mm, ss);
        //ִ�м������
        long daySpan = 11 * 1000;
        final int x1,y1;
        final int x2,y2;
        x1= Integer.parseInt(properties.getProperty("x1"));
        y1= Integer.parseInt(properties.getProperty("y1"));
        x2= Integer.parseInt(properties.getProperty("x2"));
        y2= Integer.parseInt(properties.getProperty("y2"));
        daySpan=Integer.parseInt(properties.getProperty("span"));
        //�õ���ʱ��ʵ��
        Timer t = new Timer();
        //ʹ�������ڷ�ʽ���з�������
        try {
            final Robot robot = new Robot();
            t.schedule(new TimerTask() {
                public void run() {
                    //1307 381 1307 489
                    robot.mouseMove(x1, y1);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.mouseMove(x2, y2);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
                    System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
                }
            }, date.getTime(), daySpan); //daySpan��һ��ĺ�������Ҳ��ִ�м��
        }catch (AWTException e){}
    }
}
