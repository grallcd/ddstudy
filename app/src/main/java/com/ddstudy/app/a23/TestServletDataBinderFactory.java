package com.ddstudy.app.a23;

import lombok.Data;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.ServletRequestParameterPropertyValues;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.InvocableHandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ServletRequestDataBinderFactory;

import java.util.Date;

/**
 * @author grallcd
 * @since 2022/4/15
 */
public class TestServletDataBinderFactory {

    public static void main(String[] args) throws Exception {

        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter("birthday", "2022|04|15");
        request.setParameter("address.name", "hello");

        User user = new User();


        // 1.用工厂，无转换功能
        // ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null, null);

        // 2.用 @InitBinder 转换       PropertyEditorRegistry  PropertyEditor
        InvocableHandlerMethod handlerMethod = new InvocableHandlerMethod(new Controller(), Controller.class.getMethod("aaa", WebDataBinder.class));
        // ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(Stream.of(handlerMethod).collect(Collectors.toList()), null);

        // 3.用 ConversionService 转换         ConversionService   Formatter
        // FormattingConversionService service = new FormattingConversionService();
        // service.addFormatter(new MyDateTimeFormatter("用 ConversionService 方式扩展"));
        // ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        // initializer.setConversionService(service);
        // ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null, initializer);

        // 4.同时加了 @InitBinder 和 ConversionService,优先使用 @InitBinder 方式
        // ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(Stream.of(handlerMethod).collect(Collectors.toList()), initializer);

        // 5.使用默认 ConversionService 转换,配合 @DateTimeFormatter
        ApplicationConversionService service = new ApplicationConversionService();
        ConfigurableWebBindingInitializer initializer = new ConfigurableWebBindingInitializer();
        initializer.setConversionService(service);
        ServletRequestDataBinderFactory factory = new ServletRequestDataBinderFactory(null, initializer);

        WebDataBinder dataBinder = factory.createBinder(new ServletWebRequest(request), user, "user");

        dataBinder.bind(new ServletRequestParameterPropertyValues(request));
        System.out.println(user);

    }

    static class Controller {

        @InitBinder
        public void aaa(WebDataBinder dataBinder) {
            // 扩展 dataBinder 的转换
            dataBinder.addCustomFormatter(new MyDateTimeFormatter("用 @InitBinder 方式扩展"));

        }

    }


    @Data
    static class User {

        @DateTimeFormat(pattern = "yyyy|MM|dd")
        private Date birthday;

        private Address address;

        @Data
        static class Address {
            private String name;
        }
    }
}


