package com.ddstudy.app.a21;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockPart;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExpressionValueMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestHeaderMethodArgumentResolver;
import org.springframework.web.method.annotation.RequestParamMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author grallcd
 * @since 2022/4/14
 */
public class A21 {

    public static void main(String[] args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        // 准备测试 request
        HttpServletRequest request = mockRequest();

        // 1.控制器方法被封装成 HandlerMethod
        HandlerMethod handlerMethod = new HandlerMethod(new Controller(), Controller.class.getMethod("test", String.class, String.class, int.class, String.class, MultipartFile.class, int.class, String.class, String.class, String.class, HttpServletRequest.class, User.class, User.class, User.class));

        // 2.准备对象绑定与类型转换
        ServletRequestDataBinderFactory binderFactory = new ServletRequestDataBinderFactory(null, null);

        // 3.准备 ModelAndViewContainer 用来存储中间 Model 结果
        ModelAndViewContainer container = new ModelAndViewContainer();

        // 4.解析每个参数值
        DefaultParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();

        // 多个解析器组合
        HandlerMethodArgumentResolverComposite composite = new HandlerMethodArgumentResolverComposite();
        composite.addResolvers(

                new RequestParamMethodArgumentResolver(beanFactory, false), // false 表示必须要有 @RequestParam
                new PathVariableMethodArgumentResolver(),
                new RequestHeaderMethodArgumentResolver(beanFactory),
                new ServletCookieValueMethodArgumentResolver(beanFactory),
                new ExpressionValueMethodArgumentResolver(beanFactory),
                new ServletRequestMethodArgumentResolver(),
                // 注意以下顺序不可更改，否则 @RequestBody 不会解析请求体中的数据
                new ServletModelAttributeMethodProcessor(false),// 必须有 @ModelAttribute
                new RequestResponseBodyMethodProcessor(Stream.of(new MappingJackson2HttpMessageConverter()).collect(Collectors.toList())),
                new ServletModelAttributeMethodProcessor(true), // 省略了 @ModelAttribute
                new RequestParamMethodArgumentResolver(beanFactory, true) // true 表示省略了 @RequestParam
        );

        for (MethodParameter parameter : handlerMethod.getMethodParameters()) {
            String annotations = Arrays.stream(parameter.getParameterAnnotations()).map(e -> e.annotationType().getSimpleName()).collect(Collectors.joining(""));
            String str = annotations.isEmpty() ? "" : "@" + annotations + " ";
            parameter.initParameterNameDiscovery(parameterNameDiscoverer);

            if (composite.supportsParameter(parameter)) {
                Object value = composite.resolveArgument(parameter, container, new ServletWebRequest(request), binderFactory);
                // System.out.println(value.getClass());
                System.out.println("[" + parameter.getParameterIndex() + "] " + str + parameter.getParameterType().getSimpleName() + " " + parameter.getParameterName() + " -> " + value);
                System.out.println("模型数据为: " + container.getModel());
            } else {
                System.out.println("[" + parameter.getParameterIndex() + "] " + str + parameter.getParameterType().getSimpleName() + " " + parameter.getParameterName());
            }
        }

    }

    private static HttpServletRequest mockRequest() {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("name1", "张三");
        request.setParameter("name2", "李四");
        request.addPart(new MockPart("file", "abc", "hello".getBytes(StandardCharsets.UTF_8)));
        Map<String, String> map = new AntPathMatcher().extractUriTemplateVariables("/test/{id}", "/test/123");
        System.out.println(map);
        request.setAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, map);
        request.setContentType("application/json");
        request.setCookies(new Cookie("token", "123456"));
        request.setParameter("name", "zhangsan");
        request.setParameter("age", "18");
        request.setContent("{\"name\":\"李四\",\"age\":20}".getBytes(StandardCharsets.UTF_8));
        return new StandardServletMultipartResolver().resolveMultipart(request);
    }

    static class Controller {
        public void test(
                @RequestParam("name1") String name1,
                String name2,
                @RequestParam("age") int age,
                @RequestParam(value = "home", defaultValue = "${JAVA_HOME}") String home1,
                @RequestParam("file") MultipartFile file,
                @PathVariable("id") int id,
                @RequestHeader("Content-Type") String header,
                @CookieValue("token") String token,
                @Value("${JAVA_HOME}") String home2,
                HttpServletRequest request,
                @ModelAttribute("abc") User user1,
                User user2,
                @RequestBody User user3) {
        }
    }

    @Data
    static class User {
        private String name;
        private Integer age;
    }
}
