package diskscheduling;


import java.util.*;

public class SSTF {

    private  List<Integer> temp;
    private  List<Integer> difference = new ArrayList<>();;
    private  ArrayList<Integer> Visited= new ArrayList<>();
    private  List<Integer> temp2;
    private int seekTime = 0;


    SSTF(ArrayList<Integer> Queue,int head){
        int variableHead = head;
        int min;
        int j;
        temp = new ArrayList<>(Queue);

        for (int i = 0 ; i < Queue.size(); i++) {
            difference = new ArrayList<>();

            for (Integer integer : temp) {

                difference.add(Math.abs(integer - variableHead));
            }
            min = Collections.min(difference);
            j = difference.indexOf(min);
            variableHead = temp.get(j);
            Visited.add(temp.get(j));
            temp.remove(j);


        }

        Visited.add(0,head);

        for (int i = 0; i < Visited.size() - 1; i++)
        {
            seekTime += Math.abs(Visited.get(i) - Visited.get(i+1));
        }


    }
    ArrayList<Integer> getSequence()
    {
        return Visited;
    }

    int getTotalHedMovement()
    {
        return seekTime;
    }


}
