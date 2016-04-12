package Utils;
import jpb.*;

public class Search
{
  public static int forInt(int[] list, int key)
  {
	int first=0, last=list.length-1, middle, location;
	boolean found = false;

	do{
	  middle = (first + last) / 2;
	
	  if(key == list[middle])
		found = true;
	  else if(key < list[middle])
		last = middle-1;
	  else
		first = middle+1;
	}while((!found) && (first <= last));

	location = middle;

	return (found ? location : -1);
  }

}
