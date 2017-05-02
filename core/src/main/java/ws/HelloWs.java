package ws;

import javax.jws.WebService;

/**
 * Created by nishuai on 2017/4/18.
 */
@WebService
public interface HelloWs {
    String publishHello(String message);

}
