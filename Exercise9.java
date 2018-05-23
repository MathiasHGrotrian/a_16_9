package Chapter16;

import java.util.ArrayList;

public class Exercise9
{
    /*
        Write a method called stutter that doubles the size of a list by replacing
         every integer in the list with two of that integer. For example, suppose a
          variable list stores the values [1, 8, 19, 4, 17], after a call of list.stutter(),
          it should store [1, 1, 8, 8, 19, 19, 4, 4, 17, 17].
      */

    public static ListNode front;

    public static void main(String[] args)
    {

        addNodeToList(0,1);
        addNodeToList(1,2);
        addNodeToList(2,3);
        addNodeToList(3,4);

        addNodeToList(4,5);
        addNodeToList(5,6);


        stutter();
        printList();
    }

    public static void stutter()
    {
        ArrayList<Integer> store = new ArrayList<>();

        for (ListNode current = front; current != null; current = current.next)
        {
            store.add(current.data);
        }

        for(ListNode current = front; front != null; current = current.next)
        {
            if(current.next.next == null)
            {
                current.next = null;
            }
            if(current.next == null)
            {
                front = null;
            }
        }

        int index = 0;
        for (int i = 0; i < store.size(); i++)
        {
            addNodeToList(index, store.get(i));
            addNodeToList(index+1, store.get(i));
            index += 2;
        }
    }

    public static void addNodeToList(int index, int value)
    {
        if(index == 0)
        {
            front = new ListNode(value, front);
        }
        else
        {
            ListNode current = front;
            for (int i = 0; i < index-1 ; i++)
            {
                current = current.next;
            }
            current.next = new ListNode(value,current.next);
        }
    }

    public static void printList()
    {
        System.out.println("[ ");
        for (ListNode current = front; current != null; current = current.next)
        {
            System.out.print(current.data + ", ");
        }
        System.out.println("]");
    }
}
