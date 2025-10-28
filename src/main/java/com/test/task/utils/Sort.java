package com.test.task.utils;

import java.util.List;

public class Sort {
    public static Integer getMimNumber(String path, Integer num) throws Exception {
        List<Integer> listOfNumbers = FileReader.readFile(path);
        for (int gap = listOfNumbers.size() / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < listOfNumbers.size(); i += 1) {
                int temp = listOfNumbers.get(i);
                int j;
                for (j = i; j >= gap && listOfNumbers.get(j - gap) > temp; j -= gap){
                    listOfNumbers.set(j, listOfNumbers.get(j - gap));
                }
                listOfNumbers.set(j, temp);
            }
        }
        if(num>listOfNumbers.size()){
            throw new IllegalArgumentException("Число выходит за ра размер массива");
        }else {
            return listOfNumbers.get(num-1);
        }
    }
}
