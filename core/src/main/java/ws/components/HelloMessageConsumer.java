package ws.components;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.hand.hap.message.IMessageConsumer;
import com.hand.hap.message.TopicMonitor;
import org.springframework.stereotype.Component;

/**
 * Created by nishuai on 2017/4/18.
 */
@Component
@TopicMonitor(channel="demo:hello")
public class HelloMessageConsumer implements IMessageConsumer<String>{
    @Override
    public void onMessage(String message, String pattern) {
        System.out.println("-------------------------------");
        System.out.println(message);
        System.out.println("--------------------------------");
    }
}
