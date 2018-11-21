package propagation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.google.common.collect.Maps;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@ServerEndpoint(value = "/propagation/socket/{hallCode}")
@Component
@Data
@Slf4j
public class SocketComponent {

    private Session session;

    private String hallCode;

    private static Map<String, List<SocketComponent>> sseAllEmitters = Maps.newConcurrentMap();

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("hallCode") String hallCode) {
        this.session = session;
        this.hallCode = hallCode;

        synchronized (hallCode) {
            if (Objects.isNull(sseAllEmitters.get(hallCode))) {
                sseAllEmitters.put(hallCode, new ArrayList<SocketComponent>());
            }
            sseAllEmitters.get(hallCode).add(this);
            try {
                session.getBasicRemote().sendText("[]");
            } catch (IOException e) {
                log.info("onOpen当前站厅连接数：{}", sseAllEmitters.get(hallCode).size());
                log.info(e.getMessage());
            }
            log.info("onOpen当前站厅连接数：{}", sseAllEmitters.get(hallCode).size());
        }
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        sseAllEmitters.get(hallCode).remove(this);
        log.info("onClose当前站厅连接数：{}", sseAllEmitters.get(hallCode).size());
    }

    @OnError
    public void onError(Session session, Throwable e) {
        sseAllEmitters.get(hallCode).remove(this);
        log.info("onError当前站厅连接数：{}", sseAllEmitters.get(hallCode).size());
        log.info(e.getMessage());
    }

    @OnMessage
    public void onMessage(String message) {
        sseAllEmitters.forEach((k, v) -> {

            for (Iterator<SocketComponent> iterator = sseAllEmitters.get(k).iterator(); iterator.hasNext();) {
                SocketComponent socket = (SocketComponent) iterator.next();
                try {
                    log.info("sendText当前站厅连接数：{}", sseAllEmitters.get(hallCode).size());
                    socket.getSession().getBasicRemote().sendText(message);
                } catch (Exception e) {
                    log.info("sendText当前站厅连接数：{}", sseAllEmitters.get(hallCode).size());
                    log.info(e.getMessage());
                    iterator.remove();
                }
            }

        });
    }

}
