package common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextUtils implements ApplicationContextAware {
    private static ApplicationContext appCtx;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        appCtx = applicationContext;
    }

    public static <T> T getBean(String name) {
        return (T) appCtx.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return appCtx.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return appCtx.getBean(name, requiredType);
    }
}
