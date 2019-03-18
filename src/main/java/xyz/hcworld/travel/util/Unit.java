package xyz.hcworld.travel.util;


import xyz.hcworld.travel.lib.Lib;

/**
     *
     * 功能描述: 工具类
     *
     * @param:
     * @return:
     * @author: 张红尘
     * @date: 2018/9/28 1:00
     */
    public class Unit {

        /**防止JS注入，把符号反转义*/
        public static String jsSecurity(String content){
            for(int i = 0; i<Lib.JSSECURITY.length; i++){
                //替换字符串
                content=content.replace(Lib.JSSECURITY[i],Lib.JSSECURITYTRANSLATE[i]);
            }
            return content;
        }
    }

