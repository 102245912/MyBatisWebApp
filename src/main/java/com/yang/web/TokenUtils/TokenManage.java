package com.yang.web.TokenUtils;

import java.util.*;

/**
 * Token管理器
 * @author yangshijie
 */
public class TokenManage {
    private static Map<String,String> tokens=new HashMap<>();
    public static boolean VerificationToken(String id,String token){

        String s1 = tokens.get(id);
        System.out.println(s1+"======"+id);
        if (s1==null){
            return false;
        }
        if (s1.equals(token)){
            return true;
        }else {
            return false;
        }
    }

    public static Token getToken(String id){
        Token token=new Token();
        token.setId(id);
        token.setToken(getRandomString2(16));
        tokens.put(id,token.getToken());

        System.out.println(tokens.get(id));
        return token;
    }




    public static String getRandomString2(int length){
        //产生随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //循环length次
        for(int i=0; i<length; i++){
            //产生0-2个随机数，既与a-z，A-Z，0-9三种可能
            int number=random.nextInt(3);
            long result=0;
            switch(number){
                //如果number产生的是数字0；
                case 0:
                    //产生A-Z的ASCII码
                    result=Math.round(Math.random()*25+65);
                    //将ASCII码转换成字符
                    sb.append(String.valueOf((char)result));
                    break;
                case 1:
                    //产生a-z的ASCII码
                    result=Math.round(Math.random()*25+97);
                    sb.append(String.valueOf((char)result));
                    break;
                case 2:
                    //产生0-9的数字
                    sb.append(String.valueOf
                            (new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }
}
