package ws;

import com.hand.hap.message.IMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.nio.channels.Channel;

/**
 * Created by nishuai on 2017/4/18.
 */
@WebService(
        endpointInterface = "ws.HelloWs",
        serviceName = "hello"
)
public class HelloWsImpl implements HelloWs {
    @Autowired
    private IMessagePublisher publisher;
    String channel;
    @Override
    public String publishHello(@WebParam(name="message") String message) {
        publisher.publish(channel="demo:hello",message="hello"+message);
        return "success";
    }
}
