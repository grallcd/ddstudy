package com.ddstudy.app.a27;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.support.HandlerMethodReturnValueHandlerComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.method.annotation.*;
import org.springframework.web.servlet.view.DefaultRequestToViewNameTranslator;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import org.springframework.web.util.UrlPathHelper;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author grallcd
 * @since 2022/4/16
 */
@Slf4j
public class A27 {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);

        // 1. 测试返回值类型为 ModelAndView
        // testMethod(context, "test1");

        // 2. 测试返回值类型为 String 时，把它当作视图名
        // testMethod(context, "test2");

        // 3. 测试返回值添加了 @ModelAttribute 注解时，此时需找到默认视图名
        // testMethod(context, "test3");

        // 4. 测试返回值不加 @ModelAttribute 注解且返回非简单类型时，此时需找到默认视图名
        // testMethod(context, "test4");

        // 5. 测试返回值类型为 ResponseEntity 时，此时不走视图流程
        // testMethod(context, "test5");

        // 6. 测试返回值类型为 HttpHeaders 时，此时不走视图流程
        // testMethod(context, "test6");

        // 7. 测试返回值添加了 @ResponseBody 注解时，此时不走视图流程
        testMethod(context, "test7");

    }

    private static void testMethod(AnnotationConfigApplicationContext context, String methodName) throws Exception {
        Method method = Controller.class.getMethod(methodName);
        Controller controller = new Controller();
        Object returnValue = method.invoke(controller);

        HandlerMethod handlerMethod = new HandlerMethod(controller, method);

        ModelAndViewContainer container = new ModelAndViewContainer();
        HandlerMethodReturnValueHandlerComposite composite = getReturnValueHandler();

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setRequestURI("/" + methodName);
        UrlPathHelper.defaultInstance.resolveAndCacheLookupPath(request);
        MockHttpServletResponse response = new MockHttpServletResponse();
        ServletWebRequest webRequest = new ServletWebRequest(request, response);

        if (composite.supportsReturnType(handlerMethod.getReturnType())) {
            composite.handleReturnValue(returnValue, handlerMethod.getReturnType(), container, webRequest);
            System.out.println(container.getModel());
            System.out.println(container.getViewName());
            if (container.isRequestHandled()) {
                for (String headerName : response.getHeaderNames()) {
                    System.out.println(headerName + "=" + response.getHeader(headerName));
                }
                System.out.println(new String(response.getContentAsByteArray(), StandardCharsets.UTF_8));
            } else {
                // 渲染视图
                renderView(context, container, webRequest);
            }
        }
    }

    @SuppressWarnings("all")
    private static void renderView(AnnotationConfigApplicationContext context, ModelAndViewContainer container, ServletWebRequest webRequest) throws Exception {

        log.info(">>>>>>>>>>>>>>渲染试图");
        FreeMarkerViewResolver resolver = context.getBean(FreeMarkerViewResolver.class);
        String viewName = container.getViewName() != null ? container.getViewName() : new DefaultRequestToViewNameTranslator().getViewName(webRequest.getRequest());
        log.info("没有获取到视图名，采用默认视图名:{}", viewName);
        // 每次渲染时, 会产生新的视图对象, 它并非被 Spring 所管理, 但确实借助了 Spring 容器来执行初始化
        View view = resolver.resolveViewName(viewName, Locale.getDefault());
        view.render(container.getModel(), webRequest.getRequest(), webRequest.getResponse());
        System.out.println(new String(((MockHttpServletResponse) webRequest.getResponse()).getContentAsByteArray(), StandardCharsets.UTF_8));
    }


    public static HandlerMethodReturnValueHandlerComposite getReturnValueHandler() {
        HandlerMethodReturnValueHandlerComposite composite = new HandlerMethodReturnValueHandlerComposite();
        composite.addHandler(new ModelAndViewMethodReturnValueHandler());
        composite.addHandler(new ViewNameMethodReturnValueHandler());
        composite.addHandler(new ServletModelAttributeMethodProcessor(false));
        composite.addHandler(new HttpEntityMethodProcessor(Stream.of(new MappingJackson2HttpMessageConverter()).collect(Collectors.toList())));
        composite.addHandler(new HttpHeadersReturnValueHandler());
        composite.addHandler(new RequestResponseBodyMethodProcessor(Stream.of(new MappingJackson2HttpMessageConverter()).collect(Collectors.toList())));
        composite.addHandler(new ServletModelAttributeMethodProcessor(true));
        return composite;
    }

    static class Controller {

        public ModelAndView test1() {
            log.info("test1()");
            ModelAndView view = new ModelAndView("view1");
            view.addObject("name", "张三");
            return view;
        }

        public String test2() {
            log.info("test2()");
            return "view2";
        }

        @ModelAttribute
        public User test3() {
            log.info("test3()");
            return new User("李四", 20);
        }

        public User test4() {
            log.info("test4()");
            return new User("王五", 30);
        }

        public HttpEntity<User> test5() {
            log.info("test5()");
            return new HttpEntity<>(new User("赵六", 40));
        }

        public HttpHeaders test6() {
            log.info("test6()");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "text/html");
            return headers;
        }

        @ResponseBody
        public User test7() {
            log.info("test7()");
            return new User("钱七", 50);
        }
    }

    // 必须用 public 修饰, 否则 freemarker 渲染其 name, age 属性时失败
    @Data
    public static class User {
        private String name;

        private int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
