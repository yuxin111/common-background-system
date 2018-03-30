package com.medso.cn.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.medso.cn.sys.user.model.User;

/**
 * 自己工具类
 * @author yuxin
 *
 */
public class MyUtil {
	
	/**
	 * 合并两个对象的不同属性，两个对象的Class必须相同
	 * @author yuxin
	 * @param source
	 * @param target
	 * @return
	 */
	public static Object merge(Object source,Object target){
		Class<? extends Object> sourceClass = source.getClass();
		Class<? extends Object> targetClass = target.getClass();
		
		if(!sourceClass.getName().equals(targetClass.getName())) 
			throw new RuntimeException("合并对象异常:两个对象的Class不相同");
		
		Field[] sourceFields = sourceClass.getDeclaredFields();
        Field[] targetFields = targetClass.getDeclaredFields();
        
        for(int i=0; i<sourceFields.length; i++){
        	Field sourceField = sourceFields[i];
        	Field targetField = targetFields[i];
        	sourceField.setAccessible(true);
        	targetField.setAccessible(true);
        	try {
        		if(sourceField.get(source) == null) continue;
        		
        		targetField.set(target, sourceField.get(source));
        		
			} catch (IllegalArgumentException | IllegalAccessException e) {
				throw new RuntimeException("合并对象异常:", e);
			}
        }
        
        return target;
	}
	public static void main(String[] args) {
		List<Integer> lists = new ArrayList<Integer>();
		lists.add(1);
		lists.add(2);
		
		List<Integer> lists2 = new ArrayList<Integer>();
		lists2.add(2);
		
		User user1 = new User();
		user1.setUsername("yuxin");
		user1.setPassword("123");
		
		User user2 = new User();
		user2.setUsername("yuxin1");
//		user2.setLists(lists);
//		user2.setPassword("456");
		
		User targetUser = (User)merge(user2, user1);
		System.out.println(targetUser.getId()+"--"+targetUser.getUsername()+"--"+targetUser.getPassword()/*+"--"+targetUser.getLists()*/);
	}
}
