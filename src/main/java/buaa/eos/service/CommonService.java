package buaa.eos.service;

import buaa.eos.background.HttpUtil;
import buaa.eos.model.Block;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;

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
    public static String getEosPrice() throws Exception{
        String url ="https://data.gateio.io/api2/1/ticker/eos_usdt";
        String url1 ="https://data.gateio.io/api2/1/ticker/usdt_cny";
        String result = HttpUtil.doGet(url);
        String result1 = HttpUtil.doGet(url1);
        ObjectMapper mapper = new ObjectMapper(); //转换器
        HashMap<String,String> map =mapper.readValue(result,HashMap.class);
        HashMap<String,String> map1 =mapper.readValue(result1,HashMap.class);
        String Usdt_price =map.get("last");
        String Cny_price = map1.get("last");
        float Usdt_price_f = new Float(Usdt_price);
        float Cny_price_f = new Float(Cny_price);
        float cny_price =Usdt_price_f*Cny_price_f;
        String returnresult = cny_price+"￥ /  "+Usdt_price +"$";
        return  returnresult;

    }

}
