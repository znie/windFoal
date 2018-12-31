package me.znie.windFoal.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

public class SecretUtil {

	public static final class SecretUtilHolder{
		 private static SecretUtil INSTANCE = new SecretUtil();
	}
	
	public static SecretUtil getInstance(){
		return SecretUtilHolder.INSTANCE;
	}
	
	public List<String> getSecretPath(String pkg){
		Reflections refs = new Reflections(pkg);
		//获取所有的方法注解
		Set<Class<?>> clazzs = refs.getTypesAnnotatedWith(Secret.class);
		
		List<String> paths = new ArrayList<String>();
		for(Class clazz : clazzs){
			List<String> temp = getClassSecrePath(clazz);
			if(temp.size()>0){
				paths.addAll(temp);
			}
		}
		return paths;
		
	}
	/**
	 * 获取整个类中的注解
	 * @param clazz
	 * @return
	 */
	public List<String> getClassSecrePath(Class clazz){
		Method[] methods = clazz.getMethods();
		List<String> paths = new ArrayList<String>();
		for(Method method : methods){
			String path = getMethodSecrePath(method);
			if(path != null){
				paths.add(path);
			}
		}
		return paths;
	}
	
	/**
	 * 获取当前方法的路径 并且 路径是需要权限的
	 * @param method
	 * @return
	 */
	public String getMethodSecrePath(Method method){
		Secret secret = getMethodSecre(method);
		
		if(secret != null && secret.isSecret()) {
			return secret.path();
		}
		return null;
	}
	
	/***
	 * 读取方法的注解
	 * @param method
	 * @return
	 */
	public Secret getMethodSecre(Method method){
		Secret secret = method.getAnnotation(Secret.class);
		if(secret != null) {
			return secret;
		}
		return null;
	}
	
	public static void main(String[] args){
		System.out.println(SecretUtil.getInstance().getSecretPath("com.bcs.portal.frontend"));
	}
}
