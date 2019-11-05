/**
 * @author Vincent.M
 * @mail mengshaojie@188.com
 * @date 2019/11/5
 * @copyright ©2018 孟少杰 All Rights Reserved
 * @desc 链表两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution2 {

    public static void main(String[] args) {

        ListNode l13 = new ListNode(3);
        ListNode l12 = new ListNode(4, l13);
        ListNode l1 = new ListNode(2, l12);

        ListNode l23 = new ListNode(4);
        ListNode l22 = new ListNode(6, l23);
        ListNode l2 = new ListNode(5, l22);
        addTwoNumbers(l1, l2);
    }


    /**
     * 链表的使用，和指针的引用,以及链表通过指针的方式设置值，44，52，54行
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        //dummyHead和curr同时链接一个地址
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            //第一次赋值了dummyHead的next的指向地址，这时候dummyHead的next指向了新的地址。第二次之后则设定之前对象的next的指向对象的新地址，一层层地址指向最后链起来
            curr.next = new ListNode(sum % 10);
            //将curr重新指向新创建对象的地址，为下次循环的next指向新的地址，和当前对象做桥梁
            curr = curr.next;
            // System.out.println("val"+curr.val);
            // if(null != dummyHead.next) System.out.println("dummyHead"+dummyHead.next.val);
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (1 == carry) {
            curr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }
}
