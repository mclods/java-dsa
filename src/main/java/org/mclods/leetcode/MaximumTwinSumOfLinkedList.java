package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/description
public class MaximumTwinSumOfLinkedList {
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

    private int pairSum(ListNode head) {
        ListNode i = head, j = head;

        // Find mid
        while(i != null) {
            i = i.next;

            if(i != null) {
                i = i.next;
            }

            if(i != null) {
                j = j.next;
            }
        }

        ListNode prev = null, current = null, next = null;
        if(j != null) {
            prev = j;
            current = j.next;
            prev.next = null;
        }

        // Reverse the list from mid to end
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Find max pair sum
        int maxPairSum = 0, pairSum = 0;
        i = head;
        j = prev;
        while (i != null && j != null) {
            pairSum = i.val + j.val;

            if(pairSum > maxPairSum) {
                maxPairSum = pairSum;
            }

            i = i.next;
            j = j.next;
        }

        return maxPairSum;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        if(inputs.length == 0 || (inputs.length == 1 && inputs[0].isEmpty())) {
            return;
        }

        MaximumTwinSumOfLinkedList ob = new MaximumTwinSumOfLinkedList();

        ListNode head = new ListNode(Integer.parseInt(inputs[0]));

        ListNode prevNode = head;
        for(int i=1; i<inputs.length; ++i) {
            prevNode = ob.insertEnd(prevNode, Integer.parseInt(inputs[i]));
        }

        ob.printLL(head);

        int output = ob.pairSum(head);
        System.out.println(output);
    }
}
