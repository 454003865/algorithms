package com.main.unit2.unit2_3;

import com.main.dao.User;
import org.junit.Test;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        User user1 = new User(1, "234");
        User user2 = new User(2, "jerry");
        User user3 = new User(3, "Tom");

        List<User> empList = Arrays.asList(user1, user2, user3);
        Collections.sort(empList, new Comparator<User>() {
            public int compare(User u1, User u2) {
               // int diff = u1.getName().compareToIgnoreCase(u2.getName()) ;
                int diff =u2.getUserid()- u1.getUserid();
                System.out.println(u1.getName()+"|||"+u1.getName());
                if (diff > 0) {
                    return 1;
                }else if (diff < 0) {
                    return -1;
                }
                return 0; //相等为0
            }
        });
        for (User user:
        empList) {
            System.out.println(user+"|"+user.getName().getBytes());
        }

    }

    @Test
    public void test2(){
        int[] array = {10, 3, 6, 1, 4, 5, 9};
//正序排序
        Arrays.sort(array);//会检查数组个数大于286且连续性好就使用归并排序，若小于47使用插入排序，其余情况使用双轴快速排序
        System.out.println("升序排序：");

        for (int num : array) {
            System.out.println(num);
        }

    }
}
