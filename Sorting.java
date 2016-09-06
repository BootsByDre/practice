import java.lang.Math; // headers MUST be above the first class

public class Sorting {
  private static int complexity = 0;
  
  // arguments are passed using the text field below this editor
  public static void main(String[] args) {
    int numValues = args.length;
    int[] values = new int[numValues];
    for (int i = 0; i < numValues; i++) {
      values[i] = Integer.parseInt(args[i]);
    }
    
    int[] sorted = mergeSort(values, numValues);
    
    System.out.println();
    System.out.print("Sorted: ");
    for (int i = 0; i < numValues; i++) {
      System.out.print(sorted[i] + " ");
    }
    System.out.println();         
    
    System.out.println();
    System.out.println("Size: " + numValues + ", Complexity: " + complexity);
  }
 
  public static int[] bubbleSort(int[] values, int numValues) {
    for (int i = 0; i < numValues; i++) {
      for (int j = 0; j < (numValues - 1); j++) {
        complexity++;
        
        System.out.println("Is " + values[j] + " greater than " + values[j + 1] + "?");
        if (values[j] > values[j + 1]) {
          System.out.println("Yes, swapping...");
          int first = values[j];
          values[j] = values[j + 1];
          values[j + 1] = first;
        } else {
          System.out.println("Nope");
        }
      }
      System.out.println("State after pass: ");
      for (int k = 0; k < numValues; k++) {
        System.out.print(values[k] + " ");
      }
      System.out.println();
    }
    return values;
  }
  
  public static int[] mergeSort(int[] values, int numValues) {
    return mergeSortHelper(values);
  }
  
  public static int[] mergeSortHelper(int[] set) {
    if (set.length <= 1) {
      return set;
    } else {
      int size1 = set.length / 2;
      int size2 = set.length - size1;
      int split1[] = new int[size1];
      int split2[] = new int[size2];
      
      for (int i = 0; i < set.length; i++) {
        if (i < size1) {
          split1[i] = set[i];
        } else {
          split2[i - size1] = set[i];
        }
      }
      return mergeSortMerge(mergeSortHelper(split1), mergeSortHelper(split2));
    }
  }
                   
  public static int[] mergeSortMerge(int[] split1, int[] split2) {
    int outSize = split1.length + split2.length;
    int[] output = new int[outSize];
    
    int split1Index = 0;
    int split2Index = 0;
    for (int outIndex = 0; outIndex < outSize; outIndex++) {
      complexity++;
      
      if (split1Index >= split1.length) {
        output[outIndex] = split2[split2Index++];
      } else if (split2Index >= split2.length) {
        output[outIndex] = split1[split1Index++];
      } else {
        if (split2[split2Index] < split1[split1Index]) {
          output[outIndex] = split2[split2Index++];
        } else {
          output[outIndex] = split1[split1Index++];
        }
      }
    }
    return output;
  }                   
}
