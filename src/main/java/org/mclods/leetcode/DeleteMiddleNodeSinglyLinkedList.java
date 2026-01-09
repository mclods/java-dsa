package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description
public class DeleteMiddleNodeSinglyLinkedList {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode insertEnd(ListNode prevNode, int val) {
        ListNode node = new ListNode(val);
        prevNode.next = node;

        return node;
    }

    private void printLL(ListNode head) {
        ListNode current = head;

        while(current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    private ListNode deleteMiddle(ListNode head) {
        // When linked list has only one node
        if(head != null && head.next == null) {
            return null;
        }

        ListNode p1 = head, p2 = head, p2Prev = null;

        while(p1 != null) {
            p1 = p1.next;

            if(p1 != null) {
                p1 = p1.next;

                p2Prev = p2;
                p2 = p2.next;
            }
        }

        // Delete the Middle Node
        if(p2Prev != null && p2 != null) {
            p2Prev.next = p2.next;
        }

        return head;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        if(inputs.length == 0 || (inputs.length == 1 && inputs[0].isEmpty())) {
            return;
        }

        DeleteMiddleNodeSinglyLinkedList ob = new DeleteMiddleNodeSinglyLinkedList();

        ListNode head = new ListNode(Integer.parseInt(inputs[0]));

        ListNode prevNode = head;
        for(int i=1; i<inputs.length; ++i) {
            prevNode = ob.insertEnd(prevNode, Integer.parseInt(inputs[i]));
        }

        ob.printLL(head);

        head = ob.deleteMiddle(head);

        ob.printLL(head);
    }
}
