package com.lilong.面试;

/**
 * @author : lilong
 * @date : 2023-10-26 14:11
 * @description :
 */
public class Coa {
    /**
     * 1.实现把一个宽800px高100px背景为红色的div固定在居顶部100px的位置，无论怎么滚动网页，都不会改变此div的位置。
     * <p>
     * 2.实现一个无序的列表，使用jquery或js改变第二条的背景色为蓝色。
     * <p>
     * <p>
     * 3.使用spring mvc 实现一个简单的restful接口，返回json数据
     可以在Controller的类上加注解RestController 或者是
     * <p>
     * 4.对请求做拦截，所有非/admin下面的请求都返回无权限，其它都正常返回。
     * <p>
     * 5.使用mybatis 实现分页获取学生表信息功能。
     * select * from 表  limit  3,5  这里mybatis 存在插件形式
     * 6.用冒泡排序，把下数字排一下序：8，5，6，3，7，9，1，2，4
     */
    public static void main(String[] args) {
        sort(new int[] {8,5,6,3,7,9,1,2,4});
    }
    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        for (int num : nums) {
            System.out.print(num);
        }
    }
}
