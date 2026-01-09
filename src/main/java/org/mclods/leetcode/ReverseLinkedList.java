package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/reverse-linked-list/description
public class ReverseLinkedList {
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

    private ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode prevNode = null, currentNode = head, nextNode = head.next;

        while(currentNode != null) {
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;

            if(nextNode != null) {
                nextNode = nextNode.next;
            }
        }

        return prevNode;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        if(inputs.length == 0 || (inputs.length == 1 && inputs[0].isEmpty())) {
            return;
        }

        ReverseLinkedList ob = new ReverseLinkedList();

        ListNode head = new ListNode(Integer.parseInt(inputs[0]));

        ListNode prevNode = head;
        for(int i=1; i<inputs.length; ++i) {
            prevNode = ob.insertEnd(prevNode, Integer.parseInt(inputs[i]));
        }

        ob.printLL(head);

        head = ob.reverseList(head);

        ob.printLL(head);
    }
}
