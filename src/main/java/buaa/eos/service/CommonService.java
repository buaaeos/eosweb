package buaa.eos.service;

import buaa.eos.model.Block;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CommonService {

    public static Object autoSetAttr(Map<String,Object> map,Object object)throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        for (Map.Entry<String, Object> entry: map.entrySet()) {

            String key = entry.getKey();

            Object value = entry.getValue();

            if(value == null)
                continue;

            char[] cs = key.toCharArray();
            cs[0] -= 32;
            key = "set"+String.valueOf(cs);
            String c = value.getClass().toString();
            if(value instanceof ArrayList||value instanceof Boolean||value instanceof Map){
                value = mapper.writeValueAsString(value);
//                value = value.toString();
            }
            try {
                Method method = object.getClass().getDeclaredMethod(key,value.getClass());
                method.invoke(object, value);
            }catch (Exception e){
                try {
                    Method method = object.getClass().getDeclaredMethod(key,Long.class);
                    method.invoke(object, Long.valueOf(value.toString()));
                }catch (Exception e1) {
                    System.out.println(e1.fillInStackTrace());
                }
            }
        }
        return object;
//        Iterator iter = map.entrySet().iterator();
//        // 遍历jsonObject数据
//        while (iter.hasNext()) {
//            String key = iter.next().toString();
//            Object value = jsonObject.get(key);
//            char[] cs = key.toCharArray();
//            cs[0] -= 32;
//            key = "set"+String.valueOf(cs);
//
//            String c = value.getClass().toString();
//            if(!c.startsWith("class java")||value instanceof Boolean){
//                value = value.toString();
//            }
////            else if(value instanceof String){
////                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
////                try{
////                    Date date = df.parse((String)value);
////                    value = date;
////                }catch (ParseException p){}
////            }
//            try {
//                Method method = object.getClass().getDeclaredMethod(key,value.getClass());
//                method.invoke(object, value);
//            }catch (Exception e){
//                Method method = object.getClass().getDeclaredMethod(key,Long.class);
//                try {
//
//                    method.invoke(object, Long.valueOf(value.toString()));
//                }catch (Exception e1) {
//                    System.out.println(e1.fillInStackTrace());
//                }
//            }
//        }

    }

}
