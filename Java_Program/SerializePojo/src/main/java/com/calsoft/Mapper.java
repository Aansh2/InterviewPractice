package com.calsoft;

import com.calsoft.model.Location;
import com.calsoft.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Mapper {
    static  ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setFirstName("Nikhil Soni");
        Location location = new Location();
        location.setCity("Pune");
        location.setPin(411057);
        location.setState("MH");
        user.setLocation(location);

        Map<String, Object> map =  serializePojoToMap(user);
        System.out.println("serialized object to  Map >>>>>>>>>>>>>>>>" +map.toString());

        User deSerialzedUser =  new User();
        deSerializeMapToPojo(map, deSerialzedUser);

        System.out.println("DeSerialized  Map to object >>>>>>>>>>>>>>>>" +map.toString());

    }
    private static Map<String, Object> serializePojoToMap(Object obj){
        Map<String, Object> hashMap = new HashMap<String, Object>();
        try {
            Class<? extends Object> c = obj.getClass();
            Method m[] = c.getMethods();
            for (int i = 0; i < m.length; i++) {
                if (m[i].getName().indexOf("get") == 0 && !m[i].getName().equalsIgnoreCase("getclass") ) {
                    String name = m[i].getName().toLowerCase().substring(3, 4) + m[i].getName().substring(4);
                    Object fieldObj = m[i].invoke(obj, new Object[0]);
                   boolean isCustomObj =  isJavaCustomObject(fieldObj);
                   if(isCustomObj){
                       hashMap.put(name,   serializePojoToMap(fieldObj ));

                   }else {
                       hashMap.put(name, m[i].invoke(obj,  new Object[0]));
                   }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    private static Object deSerializeMapToPojo(Map<String, Object> hashMap,  Object classObject )
            throws Exception {
        Class clz = classObject.getClass();
        Method m[] = clz.getMethods();

        hashMap.forEach((key, value) -> {
            if (isMap(value)) {
                for (int i = 0; i < m.length; i++) {
                    if (m[i].getName().equalsIgnoreCase("set" + key)) {
                        try {
                            m[i].invoke(classObject, deSerializeMapToPojo((Map<String, Object>) value,
                                    m[i].getParameterTypes()[0].newInstance()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
                ;
            } else {
                for (int i = 0; i < m.length; i++) {
                    if (m[i].getName().equalsIgnoreCase("set" + key)) {
                        try {
                            m[i].invoke(classObject, value);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        });
        return classObject;
    }
    public static boolean isJavaCustomObject(Object check) {
        return !check.getClass().getName().startsWith("java.lang");
    }
    public static boolean isMap(Object obj) {
        return obj instanceof Map;
    }

}
