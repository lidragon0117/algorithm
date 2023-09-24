package com.lilong.代码随想录.栈;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :lilong
 * @date :2023-09-23-9:30
 * @description : 栈的应用
 */
public class StackDecodeString {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     * @param s 字符串
     * @return
     */
    int index;
    public String decodeString(String s) {
        LinkedList<String> stk=new LinkedList<>();
        index=0;
        while(index<s.length()){
            char cur = s.charAt(index);
            if (Character.isDigit(cur)) {
                //进入数字栈
                String digits = getDigits(s);
                stk.add(digits);
            } else if(Character.isLetter(cur) || cur == '['){
                //获取第一个字母进栈
                stk.addLast(String.valueOf(s.charAt(index++)));
            }else{
                index++;
                //表示出栈
                LinkedList<String> sub=new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                //左括号出栈，此时左括号的是数字
                stk.removeLast();
                Integer count = Integer.valueOf(stk.removeLast());
                //拼接成字符串
                String val="";
                for(String temp:sub){
                    val+=temp;
                }
                StringBuilder sb=new StringBuilder();
                while(count>0){
                    sb.append(val);
                    count--;
                }
                stk.addLast(sb.toString());

            }
        }
        return getString(stk);
    }
    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(index))) {
            ret.append(s.charAt(index++));
        }
        return ret.toString();
    }

}
