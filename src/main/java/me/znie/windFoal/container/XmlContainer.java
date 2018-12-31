package me.znie.windFoal.container;

import org.dom4j.Element;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * xml容器管理
 * @author znie
 */
public class XmlContainer {

    private static class XmlContainerHoder{

        private static final XmlContainer INSTANCE = new XmlContainer();
    }

    public static XmlContainer getINSTANCE(){
        return XmlContainerHoder.INSTANCE;
    }
    /**
     * 存放所有Element对象的Map
     */
    private final Map<String, Element> xmlMap = new ConcurrentHashMap<String, Element>();

    /**
     * 获取Element实例
     * @param path 路径
     * @return
     */
    public Element getElement(String path) {
        if (null == path) {
            return null;
        }
        return xmlMap.get(path);
    }

    /**
     * 获取所有的xml集合
     * @return
     */
    public Set<Element> getAllElement(){
        return new HashSet<Element>(xmlMap.values());
    }
    /**
     * 获取所有的xml集合
     * @return
     */
    public Set<String> getAllKeys(){
        return new HashSet<String>(xmlMap.keySet());
    }
    /**
     * 添加一个element对象
     * @param path
     * @param element
     */
    public void addElement(String path,Element element){
        xmlMap.put(path,element);
    }

    /**
     * 移除element对象
     * @param path
     */
    public void removeElement(String path){
        xmlMap.remove(path);
    }
}
