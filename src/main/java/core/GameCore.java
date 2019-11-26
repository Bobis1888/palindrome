package core;

public class GameCore {
    public int searchPalindrome(String input) {
        //слова должны быть длиннее 2 символов;
        if (input.length() < 3)
            return 0;
        //удаляем проебелы и переводим в нижний регистр для простого сравнивания;
        char[] inputArray = input.replaceAll("\\s","").toLowerCase().toCharArray();
        //определяем начало и конец строки для сравнения;
        int start = 0;
        int end = inputArray.length - 1;
        while (start<end){
            //если символ в начале строки не равен символу в конце строки return;
            if (inputArray[start]!=inputArray[end])
                return 0;
            start++;
            end--;
        }
        return inputArray.length;
    }
}
