package com.examples.java.core.loops;

public class LoopsDemo {
    public static void main(String[] args) {

        int[] nos = {10,20,30};

        // Loop control
        // while
        System.out.println("\n" + "while loop example...");
        int index = 0;
        while(index < nos.length)
        {
            System.out.println(nos[index]);
            index++;
        }

        System.out.println("\n" + "do..while loop example...");
        index = 0;
        // do while
        do
        {
            System.out.println(nos[index]);
            index++;
        }
        while(index < nos.length);

        // for
        System.out.println("\n" + "for loop with control structure example...");
        for(int i = 0; i < nos.length; i++)
        {
            // switch case control structure
            switch (i) {
                case 0:
                    System.out.println(nos[i]);
                    // breaks switch-case execution flow
                    break;

                default:
                    break;
            }

            // if-else control structure
            if(i == 1)
            {
                System.out.println(nos[i]);
                // breaks the loop
                break;
            }
            else
            {
                // continues the loop iteration
                continue;
            }
        }

        System.out.println("\n" + "for each loop example...");
        // for each
        for(int item: nos)
        {
            System.out.println(item);

        }
    }
}
