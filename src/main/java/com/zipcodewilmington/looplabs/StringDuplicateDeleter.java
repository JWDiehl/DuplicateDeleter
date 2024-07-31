package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {
    //    //Given an object, StringDuplicateDeleter, with a composite String[] object, write a method
    //    //removeDuplicatesExactly which removes all values in the array which occur exactly the specified number of times.
    //    //removeDuplicates which removes all values in the array which occur at least the specified number of times.

    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] array = this.array;
        int[] counts = new int[array.length];

        //Count occurences - for loop
        for (int i = 0; i < array.length; i++) {
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i].equals(array[j])) {
                    counts[j]++;
                    counts[i] = 0;
                    break;
                }
            }
        }

        //Determine the size of new array
        int newSize = 0;
        for (int count : counts) {
            if (count < maxNumberOfDuplications) {
                newSize++;
            }
        }

        //Create new array
        String[] resultArray = new String[newSize];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (counts[i] < maxNumberOfDuplications) {
                resultArray[index++] = array[i];
            }
        }
        return resultArray;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] array = this.array;
        int[] counts = new int[array.length];

        //Count occurences
        for (int i = 0; i < array.length; i++) {
            counts[i] = 1;
            for (int j = 0; j < i; j++) {
                if (array[i].equals(array[j])) {
                    counts[j]++;
                    counts[i] = 0;
                    break;
                }
            }
        }

        //Size of newArray
        int newSize = 0;
        for (int count : counts) {
            if (count != exactNumberOfDuplications) {
                newSize++;
            }
        }

        //Create resultArray
        String[] resultArray = new String[newSize];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (counts[i] != exactNumberOfDuplications) {
                resultArray[index++] = array[i];
            }
        }

        return resultArray;
    }
}
