package uz.tiu.daily.common;



import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.List;
import java.util.Map;

public class ApplicationListenerBean implements ApplicationListener {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private Map<Long, List<ISpringContextEventLauncher>> launchedMap;
    private static long eventCount = 0L;

    public void setLaunchedMap(Map<Long, List<ISpringContextEventLauncher>> launchedMap) {
        this.launchedMap = launchedMap;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ContextRefreshedEvent) {

            eventCount++;

/*
            ApplicationContext applicationContext = ((ContextRefreshedEvent) event).getApplicationContext();
            // now you can do applicationContext.getBean(...)
            // ...
*/
            if (logger.isDebugEnabled())
                logger.debug("*** Catched: ContextRefreshedEvent, event number {}", eventCount);

            if (launchedMap!=null)
            {
                for (Map.Entry<Long, List<ISpringContextEventLauncher>> entry : launchedMap.entrySet()) {
                    Long eventNumber = entry.getKey();
                    if (eventNumber.equals(eventCount))
                    {

                        List<ISpringContextEventLauncher>  eventLauncherList = entry.getValue();
                        if (eventLauncherList!=null)
                        {
                            if (logger.isDebugEnabled())
                                logger.debug("*** Event is passing to launchers...");
                            for (ISpringContextEventLauncher eventLauncher : eventLauncherList)
                                eventLauncher.onContextEvent(event);
                        }
                    }
                }
            }
        }
    }
}