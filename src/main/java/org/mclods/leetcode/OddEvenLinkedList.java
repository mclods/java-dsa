package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/odd-even-linked-list/description
public class OddEvenLinkedList {
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

    private ListNode oddEvenList(ListNode head) {
        int i = 1;
        ListNode oddHead, oddEnd,
                evenHead, evenEnd,
                currentNode = head;

        oddHead = oddEnd = evenHead = evenEnd = null;

        while(currentNode != null) {
            if(i % 2 == 0) {
                if(evenEnd != null) {
                    evenEnd.next = currentNode;
                    evenEnd = evenEnd.next;
                } else {
                    evenHead = evenEnd = currentNode;
                }
            } else {
                if(oddEnd != null) {
                    oddEnd.next = currentNode;
                    oddEnd = oddEnd.next;
                } else {
                    oddHead = oddEnd = currentNode;
                }
            }

            i++;
            currentNode = currentNode.next;
        }

        if(oddEnd != null && evenEnd != null) {
            oddEnd.next = evenHead;
            evenEnd.next = null;
        }

        return oddHead;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        if(inputs.length == 0 || (inputs.length == 1 && inputs[0].isEmpty())) {
            return;
        }

        OddEvenLinkedList ob = new OddEvenLinkedList();

        ListNode head = new ListNode(Integer.parseInt(inputs[0]));

        ListNode prevNode = head;
        for(int i=1; i<inputs.length; ++i) {
            prevNode = ob.insertEnd(prevNode, Integer.parseInt(inputs[i]));
        }

        ob.printLL(head);

        head = ob.oddEvenList(head);

        ob.printLL(head);
    }
}
