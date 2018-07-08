package buaa.eos.service;

import buaa.eos.background.HttpUtil;
import buaa.eos.model.Block;
import net.sf.json.JSONObject;

import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JavaType;

public class CommonService {
    public static Object autoSetAttr(Object json,Object object)throws NoSuchMethodException {
        // 将json字符串转换成jsonObject
        JSONObject jsonObject = JSONObject.fromObject(json);
        Iterator ite = jsonObject.keys();
        // 遍历jsonObject数据
        while (ite.hasNext()) {
            String key = ite.next().toString();
            Object value = jsonObject.get(key);
            char[] cs = key.toCharArray();
            cs[0] -= 32;
            key = "set"+String.valueOf(cs);

            String c = value.getClass().toString();
            if(!c.startsWith("class java")||value instanceof Boolean){
                value = value.toString();
            }
//            else if(value instanceof String){
//                DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//                try{
//                    Date date = df.parse((String)value);
//                    value = date;
//                }catch (ParseException p){}
//            }
            try {
                Method method = object.getClass().getDeclaredMethod(key,value.getClass());
                method.invoke(object, value);
            }catch (Exception e){
                Method method = object.getClass().getDeclaredMethod(key,Long.class);
                try {

                    method.invoke(object, Long.valueOf(value.toString()));
                }catch (Exception e1) {
                    System.out.println(e1.fillInStackTrace());
                }
            }
        }
        return object;
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
