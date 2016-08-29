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
        //得到时间类
        Calendar date = Calendar.getInstance();
        //设置时间为 xx-xx-xx 00:00:00
        date.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DATE), 15, 41, 0);
        //一天的毫秒数
        long daySpan = 11 * 1000;
        long second=1000;
        //得到定时器实例
        Timer t = new Timer();
        //使用匿名内方式进行方法覆盖
        try {
            final Robot robot = new Robot();
            t.schedule(new TimerTask() {
                public void run() {
                    //run中填写定时器主要执行的代码块
                    //BufferedImage image = robot.createScreenCapture(new Rectangle(635, 462, 700-635, 476-462));
                    //ImageIO.write(image, "png", new File("E:\\ab.png"));
                    robot.mouseMove(1307, 381);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    robot.mouseMove(1307, 489);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);

                    System.out.println("定时器执行..");
                }
            }, date.getTime(), daySpan); //daySpan是一天的毫秒数，也是执行间隔
        }catch (AWTException e){}
    }
}
