package com.ddstudy.app.a24;

import com.ddstudy.app.a24.WebConfig.Controller1;
import com.ddstudy.app.a24.WebConfig.Controller2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.method.ControllerAdviceBean;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author grallcd
 * @since 2022/4/16
 */
@Slf4j
public class A24 {


    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

        /*
           @InitBinder 来源有两个
           1. @ControllerAdvice 中 @InitBinder 标注的方法，由 RequestMappingHandlerAdapter 在初始化时解析并记录
           2. @Controller 中 @InitBinder 标注的方法，由 RequestMappingHandlerAdapter 会在控制器方法首次执行时解析并记录
         */

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

        RequestMappingHandlerAdapter handlerAdapter = new RequestMappingHandlerAdapter();
        handlerAdapter.setApplicationContext(context);
        handlerAdapter.afterPropertiesSet();

        log.info("刚开始1...");
        showInitBinderMethods(handlerAdapter);

        Method method = RequestMappingHandlerAdapter.class.getDeclaredMethod("getDataBinderFactory", HandlerMethod.class);
        method.setAccessible(true);

        log.info("模拟控制器1 foo 方法...");
        method.invoke(handlerAdapter, new HandlerMethod(new Controller1(), Controller1.class.getMethod("foo")));
        showInitBinderMethods(handlerAdapter);

        log.info("模拟控制器2 bar 方法...");
        method.invoke(handlerAdapter, new HandlerMethod(new Controller2(), Controller2.class.getMethod("bar")));
        showInitBinderMethods(handlerAdapter);

        context.close();

    }

    @SuppressWarnings("unchecked")
    private static void showInitBinderMethods(RequestMappingHandlerAdapter handlerAdapter) throws NoSuchFieldException, IllegalAccessException {
        Field initBinderAdviceCache = RequestMappingHandlerAdapter.class.getDeclaredField("initBinderAdviceCache");
        initBinderAdviceCache.setAccessible(true);
        Map<ControllerAdviceBean, Set<Method>> globalMap = (Map<ControllerAdviceBean, Set<Method>>) initBinderAdviceCache.get(handlerAdapter);
        log.info("全局的 @InitBinder 方法{}",
                globalMap.values().stream()
                        .flatMap(methods -> methods.stream().map(Method::getName))
                        .collect(Collectors.toList())
        );

        Field initBinderCache = RequestMappingHandlerAdapter.class.getDeclaredField("initBinderCache");
        initBinderCache.setAccessible(true);
        Map<Class<?>, Set<Method>> controllerMap = (Map<Class<?>, Set<Method>>) initBinderCache.get(handlerAdapter);
        log.info("控制器的 @InitBinder 方法{}",
                controllerMap.values().stream()
                        .flatMap(methods -> methods.stream().map(Method::getName))
                        .collect(Collectors.toList())
        );
    }
}
