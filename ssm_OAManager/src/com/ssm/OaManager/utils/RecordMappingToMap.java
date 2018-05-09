package com.ssm.OaManager.utils;

import java.math.BigDecimal;
import java.sql.SQLException;

public class RecordMappingToMap {
			
	 /** 
     *  
     * @param clazz, 类型字节码
     */  
    public static <T> Object recordMappingToMap(Class clazz)  
            throws SQLException  
    {  
        // 优先规则：常用类型靠前  
        if (clazz==String.class)  
        {  
           return "-1";
        }  
        else if (clazz==Integer.class)  
        {  
            return -1;
        }  
        else if (clazz==Long.class)  
        {  
           return -1;
        }  
        else if (clazz==Boolean.class)  
        {  
           return false;
        }  
        else if (clazz==Short.class)  
        {  
            return -0.01;
        }  
        else if (clazz==Float.class)  
        {  
           return -0.1;
        }  
        else if (clazz==Double.class)  
        {  
          return -0.1;              
        }
        else if (clazz==BigDecimal.class)  
        {  
            return 0;
        } else if (clazz==int.class)  
        {  
            return -1;
        }
        else  
        {// 对于其它任何未知类型的处理  
           return null;
        }  
    }  
}
