package com.zero.spring_boot_file_upload;

import org.apache.coyote.http11.AbstractHttp11Protocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;

@SpringBootApplication
public class SpringBootFileUploadApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootFileUploadApplication.class, args);
    }

    public TomcatServletWebServerFactory tomcatEmbedded () {
        //  TomcatServletWebServerFactory() 方法主要是为了解决上传文件大于10M出现连接重置的问题
        //  ，此异常内容 GlobalException 也捕获不到。
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers((TomcatConnectorCustomizer) connector -> {
            if ((connector.getProtocolHandler() instanceof AbstractHttp11Protocol<?>)) {
                // -1 means unlimited
                ((AbstractHttp11Protocol<?>) connector.getProtocolHandler()).setMaxSwallowSize(-1);
            }
        });
        return tomcat;
    }
}
