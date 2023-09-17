package com.lilong.代码随想录.回溯问题;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author :lilong
 * @date :2023-09-17-13:27
 * @description : 回溯问题
 */
public class LetterCombinations {
    List<String> res = new LinkedList<>();
    Map<Character,String> map=new HashMap<>();
    StringBuilder temp = new StringBuilder();
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     * @param digits 选择数字
     * @return 返回的结果
     */
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return res;
        }
        map.put('0',"");
        map.put('1',"");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        combineBack(digits,0);
        return res;
    }

    private void combineBack(String digits, int num) {
        if(num==digits.length()){
            res.add(temp.toString());
            return;
        }
        //获取指定的值
        String str = map.get(digits.charAt(num));
        for(int i=0;i<str.length();i++){
            temp.append(str.charAt(i));
            combineBack(digits,num+1);
            //回溯
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
