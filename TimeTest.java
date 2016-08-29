import java.awt.*;
import java.awt.event.InputEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by jianleizhang on 2016/8/29.
 */
public class TimeTest {
    public static void main(String[] args) throws Exception {
        //�õ�ʱ����
        Calendar date = Calendar.getInstance();
        //����ʱ��Ϊ xx-xx-xx 00:00:00
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 11, 29, 4);
        //ִ�м������
        long daySpan = 11 * 1000;
        final int x1,y1;
        final int x2,y2;
        x1= Integer.parseInt(args[0]);
        y1= Integer.parseInt(args[1]);
        x2= Integer.parseInt(args[2]);
        y2= Integer.parseInt(args[3]);
        if(args.length>4)
            daySpan=Integer.parseInt(args[4]);
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
