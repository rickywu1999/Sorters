//Ricky Wu

import java.util.ArrayList;

public class MySorts {
     public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    
    public static void main(String[] args){
	BogoSort bogo = new BogoSort();
	SelectionSort select = new SelectionSort();
	BubbleSort bubble = new BubbleSort();
	ArrayList test1 = populate(10,0,100);
	ArrayList test2 = populate(100,0,100);
	ArrayList test3 = populate(1000,0,100);
	long time1 = 0;
	long time2 = 0;
	//BOGOSORT
	time1 = System.nanoTime();
	bogo.bogoSort(test1);
	time2 = System.nanoTime();
	System.out.println("BogoSort for 10 element list: " + (time2 - time1));
	System.out.println("BogoSort for 100 element list takes too long");
	System.out.println("BogoSort for 1000 element list takes too long");
	//SELECTIONSORT
	shuffle(test1);
	shuffle(test2);
	shuffle(test3);
	time1 = System.nanoTime();
	select.selectionSort(test1);
	time2 = System.nanoTime();
	System.out.println("SelectionSort for 10 element list: " + (time2 - time1));
	time1 = System.nanoTime();
	select.selectionSort(test2);
	time2 = System.nanoTime();
	System.out.println("SelectionSort for 100 element list: " + (time2 - time1));
	time1 = System.nanoTime();
	select.selectionSort(test3);
	time2 = System.nanoTime();
	System.out.println("SelectionSort for 1000 element list: " + (time2 - time1));
	//BUBBLESORT
	shuffle(test1);
	shuffle(test2);
	shuffle(test3);
	time1 = System.nanoTime();
	bubble.bubbleSort(test1);
	time2 = System.nanoTime();
	System.out.println("BubbleSort for 10 element list: " + (time2 - time1));
	time1 = System.nanoTime();
	bubble.bubbleSort(test2);
	time2 = System.nanoTime();
	System.out.println("BubbleSort for 100 element list: " + (time2 - time1));    
	time1 = System.nanoTime();
	bubble.bubbleSort(test3);
	time2 = System.nanoTime();
	System.out.println("BubbleSort for 1000 element list: " + (time2 - time1));
    }
}
	
	
	
    
