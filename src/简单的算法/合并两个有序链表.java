package 简单的算法;

import java.util.LinkedList;
import java.util.List;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <示例：>输入：1->2->4, 1->3->4    输出：1->1->2->3->4->4
 */
public class 合并两个有序链表 {
    public static void main(String[] args) {
        ListNode link1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(4);
        link1.next = node11;
        node11.next = node12;

        ListNode link2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        link2.next = node21;
        node21.next = node22;

        ListNode resLink = solution(link1, link2);
        System.out.println(resLink.val);
        System.out.println(resLink.next.val);
        System.out.println(resLink.next.next.val);
        System.out.println(resLink.next.next.next.val);
        System.out.println(resLink.next.next.next.next.val);
        System.out.println(resLink.next.next.next.next.next.val);


    }

    /**
     *官方题解
     * 递归
     */
    public static ListNode solution(ListNode link1, ListNode link2) {
        if(link1==null){
            return link2;
        }else if(link2==null){
            return link1;
        }else if(link1.val<link2.val){
            link1.next=solution(link1.next,link2);
            return link1;
        }else {
            link2.next=solution(link1,link2.next);
            return link2;
        }
    }

}


class ListNode {
    public int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}