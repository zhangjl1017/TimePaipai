import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Calendar;
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
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 15, 41, 0);
        //һ��ĺ�����
        long daySpan = 11 * 1000;
        long second=1000;
        //�õ���ʱ��ʵ��
        Timer t = new Timer();
        //ʹ�������ڷ�ʽ���з�������
        try {
            final Robot robot = new Robot();
            t.schedule(new TimerTask() {
                public void run() {
                    //run����д��ʱ����Ҫִ�еĴ����
                    //BufferedImage image = robot.createScreenCapture(new Rectangle(635, 462, 700-635, 476-462));
                    //ImageIO.write(image, "png", new File("E:\\ab.png"));
                    robot.mouseMove(1307, 381);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.mouseMove(1307, 489);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

                    System.out.println("��ʱ��ִ��..");
                }
            }, date.getTime(), daySpan); //daySpan��һ��ĺ�������Ҳ��ִ�м��
        }catch (AWTException e){}
    }
}
