public class Mountain {

    /** @param array an array of positive integer values

     @param stop the last index to check
     Precondition: 0 <= stop < arraylength
     @return true if for each j such that 0 <= j < stop, array[j] < array[j + 1] ;
     false otherwise
     */

    public static boolean isIncreasing(int[] array, int stop) {
        if(array.length < 2){
            return false;
        }

        if(stop >= array.length || stop <= 0){
            return false; // check if stop out of bounds
        }

        for(int j = 0; j < stop; j++){
            if(array[j] >= array[j+1]){
                return false; //found a non-increasing pair
            }
        }
        return true;
    }
    /** @param array an array of positive integer values

     @param start the first index to check
     Precondition: 0 <= start < arraylength - 1
     @return true if for each j such that start <= j < arraylength - 1,
     array[j] > array[j + 1];
     false otherwise
     */

    public static boolean isDecreasing(int[] array, int start) {
        if(array.length < 2){
            return false;
        }

        if(start <= 0 || start >=array.length-1){
            return false; //check if start is out of bounds
        }

        for(int j = start; j < array.length - 1; j++){
            if(array[j] <= array[j+1]){
                return false;  //found a non-decreasing pair
            }
        }

        return true; // all conditions have passed!
    }

    /** getPeakIndex returns the index of the first peak found in the parameter array
     * peak condition: array[i-1] < peak && array[i+1] < peak
     * returns first peak found
     * returns -1 if no peak is found
     * no peak if array is strictly increasing or decreasing
     * peak cannot be first index or last index
     */

    public static int getPeakIndex(int[] array) {
        if(array.length < 3){
            return -1;
        }

        for(int i = 1; i < array.length - 1; i++){
            if(array[i] > array[i-1] && array[i] > array[i+1]){
                return i;
            }
        }
        return -1; //no peak is found

    }

    public static boolean isMountain(int[] array) {
        /** getPeakIndex cannot be -1, return false if it is
         * isDecreasing and isIncreasing must be true
         */

        int peakIndex = getPeakIndex(array);

        if(peakIndex == -1){
            return false;
        }

        if(!isIncreasing(array, peakIndex)){
            return false;
        }

        if(!isDecreasing(array, peakIndex + 1)){
            return false;
        }

        return true;


    }
}