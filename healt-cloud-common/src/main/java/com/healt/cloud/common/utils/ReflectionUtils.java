package com.healt.cloud.common.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author GuYue
 * @date 2022-02-15 17:23
 * @description: 反射相关辅助方法
 */
public class ReflectionUtils {
    /**
     * 根据方法名调用指定对象的方法
     * @param object 要调用方法的对象
     * @param method 要调用的方法名
     * @param args 参数对象数组
     * @return
     */
    public static Object invoke(Object object, String method, Object... args) throws Exception {
        Object result = null;
        //Class<? extends Object> clazz = object.getClass();//这块这么写有问题，会获取不到实际的类型
        Method queryMethod = getMethod(object, method, args);
        if(queryMethod != null) {
            try {
                result = queryMethod.invoke(object, args);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
                throw e;
            }
        } else {
            throw new NoSuchMethodException(object.getClass().getName() + " 类中没有找到 " + method + " 方法。");
        }
        return result;
    }

    public static Method getMethod(Object obj, String methodName, Object[] args) {
        Method queryMethod = null;
        Method[] methods = obj.getClass().getMethods();
        for(Method method:methods) {
            if(method.getName().equals(methodName)) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if(parameterTypes.length == args.length) {
                    boolean isTheMethod = false;//是否是要调用的方法
                    for(int i=0; i<parameterTypes.length; i++) {
                        Object arg = args[i];
                        if(arg == null) {
                            arg = "";
                        }
                        //特殊处理，数据库实体bean对象set方法，因为前端传值都是String型，对于数值型需要进行强制转换
                        if(methodName.contains("set")){
                            if(parameterTypes[i].getName().equals("java.lang.Integer")){
                                args[i] = Integer.parseInt(args[i].toString());
                            }
                        }
                        //特殊处理，强制类型转换
                        //因为泛型的原因，mybatisplus自动生成的service无法通过反射获取方法中参数的实体类类型，都是Object类型
                        //当参数的数量为一个时，不判断类型是否相同
                        if(parameterTypes[i].getName().equals("java.lang.Object")&&parameterTypes.length == 1){
                            isTheMethod = true;
                            break;
                        }
                        //有一个同位置参数类型不同，就不是要调用的方法
                        if(parameterTypes[i].equals(args[i].getClass())||parameterTypes[i].isAssignableFrom(args[i].getClass())) {
                            isTheMethod = true;
                        }else{
                            isTheMethod = false;
                            break;
                        }
                    }
                    if(isTheMethod) {
                        queryMethod = method;
                        break ;
                    }
                }
            }
        }
        return queryMethod;
    }

}
