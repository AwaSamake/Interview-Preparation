import java.util.*;
import java.io.*;

 public class IntersectionOfTwoArrays {
	
    public static int[] getIntersection(int[] array, int[] array1) {
      if (array == null || array1 == null || array.length == 0 || array1.length == 0) {
	return new int[0];
      }  
	        
      Arrays.sort(array);
      Arrays.sort(array1);  
	         
      int i = 0, j = 0;
      int x = array.length;
      int y = array1.length;
	  
      ArrayList<Integer> list = new ArrayList();
	  
      while(i < x && j < y) {
        if(array[i] < array1[j]) {
	  i++;  
	}   
	else if(array[i] > array1[j]) {
	  j++;  
	}  
        else {
	  if (list.isEmpty() || array[i] != list.get(list.size()-1)) {
	    list.add(array[i]);
	  }            
	  i++;
	  j++;
	}
      }

      return listToArray(list);       
    }
	     
    private static int[] listToArray(List<Integer> list) {
      int[] result = new int[list.size()];
	        
      for (int i = 0; i < list.size(); i++) {
	result[i] = list.get(i);
      }
	        
      return result;
    }
	 
    public int[] getIntersection1(int[] array1, int[] array2) {
      HashSet<Integer> set1 = new HashSet<Integer>();
      HashSet<Integer> set2 = new HashSet<Integer>();
         
      for (int i = 0; i < array1.length; i++)  {
        set1.add(array1[i]);
      }
         
      for (int i = 0; i < array2.length; i++) { 
        if (set1.contains(array2[i])) {
          set2.add(array2[i]);
        }
      }
      int[] result = new int[set2.size()];
      int i = 0;
      for(int n : set2) {
        result[i++] = n;
      }
      return result;   
    }	 

    public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter number of elements in the first array: ");
      int number = input.nextInt();  
      int array[] = new int[number];
		  
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < array.length; i++) {
	array[i] = input.nextInt();
      }
		    
      System.out.println();	
      System.out.print("Enter number of elements in the second array: ");
      int number1 = input.nextInt();  
      int array1[] = new int[number1];
		  
      System.out.println();	
      System.out.print("Please enter number: ");
      for (int i = 0; i < array1.length; i++) {
	array1[i] = input.nextInt();
      }
		  
      int result[] = new int[array.length + array1.length];
		  
      result = getIntersection(array, array1);
      System.out.println();	
      System.out.print("The value of interection of the sorted arrays is: ");
      for(int i = 0; i < result.length; i++) {
	System.out.print(result[i] + " ");
      }
    }
 }
