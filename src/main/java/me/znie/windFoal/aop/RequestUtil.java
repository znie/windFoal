package me.znie.windFoal.aop;

import me.znie.windFoal.AppConstants;
import me.znie.windFoal.container.XmlContainer;
import me.znie.windFoal.xml.XmlParser;
import org.dom4j.Element;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil {

    public void deal(String tranCode){
        //request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        //请求配置信息
        Element element = XmlContainer.getINSTANCE().getElement(AppConstants.TRANSID+tranCode);

    }
}
