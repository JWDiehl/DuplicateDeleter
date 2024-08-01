package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    //Instructions
    //
    //Given an object, IntegerDuplicateDeleter, with a composite Integer[] object, write a method
    //removeDuplicatesExactly which removes all values in the array which occur exactly the specified number of times.
    //removeDuplicates which removes all values in the array which occur at least the specified number of times.

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {

        //Using a stream
        return Arrays.stream(array).filter(y -> getOccurence(y) < maxNumberOfDuplications).toArray(Integer[]::new);
    }

    public Long getOccurence(int x) {
        return Arrays.stream(array).filter(z -> z==x).count();
    }

//
//
//        Integer[] array = this.array;
//        int length = array.length;
//        int[] counts = new int[length];
//
//        // Count occrrences - for loop
//        for (int i = 0; i < length; i++) {
//            if (counts[i] == 0) { // Element not yet counted
//                int count = 1;
//                for (int j = i + 1; j < length; j++) {
//                    if (array[i].equals(array[j])) {
//                        count++;
//                        counts[j] = -1; // these are for the counted
//                    }
//                }
//                counts[i] = count;
//            }
//        }
//
//        //Determine the size of new array
//        int newSize = 0;
//        for (int count : counts) {
//            if (count < maxNumberOfDuplications && count > 0) {
//                newSize++;
//            }
//        }
//
//        //Create new array
//        Integer[] resultArray = new Integer[newSize];
//        int index = 0;
//        for (int i = 0; i < length; i++){
//            if (counts[i] < maxNumberOfDuplications && counts[i] > 0) {
//                resultArray[index++] = array[i];
//            }
//        }
//        return resultArray;
//    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        //   //removeDuplicatesExactly which removes all values in the array which occur exactly the specified number of times.

        //Does this number appear a specifc number of times?
        // exactNumberOfDuplications = ?

        // if a number appears in array = exactNumberOfDuplications the remove that number
        //if a number appears more than maxNumberOfDuplicates - remove from array
        // Keep rest in the array

        //Using a stream
        return Arrays.stream(array).filter(y -> getOccurence(y) != exactNumberOfDuplications).toArray(Integer[] :: new);
    }
}

//
//        Integer[] array = this.array;
//        int length = array.length;
//        int[] counts = new int[length];
//
//        //count occurences of each element
//        for (int i = 0; i < length; i++) {
//            if (counts[i] == 0) { // Element not yet counted
//                int count = 1;
//                for (int j = i + 1; j < length; j++) {
//                    if (array[i].equals(array[j])) {
//                        count++;
//                        counts[j] = -1; // counted
//                    }
//                }
//                counts[i] = count;
//            }
//        }
//
//        //Determine the size of new ARRAY
//        int newSize = 0;
//        for (int count : counts) {
//            if (count != exactNumberOfDuplications && count > 0) {
//                newSize++;
//            }
//        }
//
//        //Create new array
//        Integer[] resultArray = new Integer[newSize];
//        int index = 0;
//        for (int i = 0; i < length; i++) {
//            if (counts[i] != exactNumberOfDuplications && counts[i] > 0) {
//                resultArray[index++] = array[i];
//            }
//        }
//
//        return resultArray;
//    }
//}
