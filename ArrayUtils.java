// Ricky Wu
// APCS1 pd9
// HW27 -- Objectify Your Array Tools
// 2015-11-09

public class ArrayUtils{
    public static void main(String[] args){
	Object[] arr;
	arr = new Object[3];
	//gives a number between 1 and 9
	populate(arr, 10, 1);
	Object[] arr2 = {"I","AM","GROOT"};
	System.out.println(Stringifier(arr));
	System.out.println(Stringifier(arr2));

	Object[] arr3 = {123,1,232,4512,12};
	System.out.println( "Array 1: "+Stringifier(arr3));
	System.out.println( "(I)Where is 232 in Array 3? "+linSearch( arr3, 232));
	System.out.println( "(I)Where is 13 in Array 3? "+linSearch( arr3, 13));
	System.out.println( "(R)Where is 232 in Array 3? "+linSearchR( arr3, 232));
	System.out.println( "(R)Where is 13 in Array 3? "+linSearchR( arr3, 13) + "\n");

	
	Object[] arr4 = {"a","b","c","a","e","1","2","3"};
	System.out.println( "Array 2: "+Stringifier(arr4));	
	System.out.println( "(I)How many a are in Array 4? "+freq( arr4, "a"));
	System.out.println( "(I)How many b are in Array 4? "+freq( arr4, "b"));
	System.out.println( "(R)How many z are in Array 4? "+freqRec( arr4, "z"));
	System.out.println( "(R)How many c are in Array 4? "+freqRec( arr4, "c"));
    }

    //gives values to the array; you can set an upper/lower bound (excluding the upper bound)
    public static void populate(Object[] arr, int upper, int lower){
	for (int x = 0; x < arr.length; x++){
	    int num = (int)(Math.random() * (upper - lower) + lower);
	    arr[x] = num;
	}
    }

    //Prints out the array as a String
    public static String Stringifier(Object[] a){
	String ans = "[ ";
	for (Object i: a){
	    String str = i + " , ";
	    ans += str;
	}
	return ans.substring(0,ans.length() - 2) + "]";
    }

    public static Object[] copycat(Object[] a) {
	Object[] _a = new Object[a.length];
	int counter = 0;
	for (Object i:a){
	    _a[counter] = i;
	    counter++;
	}
	return _a;
    }
    
    //Short,sweet,and simple. Why would we ever use the recursive version?
    public static int linSearch( Object[] a, Object target){
        int ans = -1;
	for (int i = 0; (i < a.length) && (ans == -1); ++i){
	    if (a[i].equals(target)){
		ans = i;
	    }
	}
	return ans;
    }

    //Used this to return an int that is either the index or not, which the linSearchR determines
    public static int wrapperR( Object[] a, Object target){
	int ans = 0;
	if (a.length == 0){
	    return 1;
	}
	if (a[0].equals(target)){
	    return 0;
	}
	Object[] newArr;
	newArr = new Object[a.length-1];
	for (int i = 1; i < a.length; ++i){
	    newArr[i-1] = a[i];
	}
	return 1 +  wrapperR(newArr,target); 
    }

    //I didn't know how to return -1 so I just made linSearchR a wrapper function that interprets wrapperR
    public static int linSearchR( Object[] a, Object target){
	int ans = wrapperR(a,target);
	if (ans > a.length){
	    return -1;
	}
	return ans;
    }

    public static int freq( Object[] a, Object target ){
	Object[] _a = copycat(a);
	int ans = 0;
	//placehold is simply a number that is not the target
	int placehold = 0;
	if (target == 0){
	    placehold = 1;
	}
	while (linSearch(_a,target) != -1){
	    ans += 1;
	    //replaces target with another number
	    _a[linSearch(_a,target)] = placehold;
	}
	return ans;
    }

    public static int freqRec( Object[] a, Object target ){
	Object[] _a = copycat(a);
	if (linSearch(_a,target) == -1){
	    return 0;
	}
	int placehold = 0;
	if (target == 0){
	    placehold = 1;
	}
	_a[linSearch(_a,target)] = placehold;
	return 1 + freqRec(_a,target);
    }
}

//At first, I thought I'd have problems with using .equals and == but it turns out that Objects use .equals
