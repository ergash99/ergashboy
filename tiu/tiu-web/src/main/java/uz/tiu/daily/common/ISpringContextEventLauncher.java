package uz.tiu.daily.common;

import org.springframework.context.ApplicationEvent;


public interface ISpringContextEventLauncher {
    void onContextEvent(ApplicationEvent event);
}
