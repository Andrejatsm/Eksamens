package Quiz;

public class Awnsers {
    public static String[][] getIzveles() {
        return new String[][]{
            {"int[][] arr = new int[5][5];", "int[] arr = new int[5][5];", "int[][] arr = new int[5, 5];", "int arr[][] = new int[5][5];"},
            {"int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };", "int[][] arr = new int[3][3]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};", "int[][] arr = new int[3][3];", "int arr[][] = new int[3][3]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};"},
            {"for (int i = 0; i < arr.length; i++) { for (int j = 0; i < arr[i].length; j++) { System.out.print(arr[i][j] + ' '); } }", "for (int[] row : arr) { for (int val : row) { System.out.print(val + ' '); } }", "for (int i = 0; i < arr.length; i++) { System.out.println(Arrays.toString(arr[i])); }", "for (int i = 0; i < arr.length; i++) { for (int j = 0; i < arr[i].length; j++) { System.out.println(arr[i][j]); } }"},
            {"Visām rindām divdimensiju masīvā jābūt vienāda garuma.", "Divdimensiju masīvs būtībā ir masīvs ar masīviem.", "Jūs varat izmantot dažādus garumus dažādām rindām divdimensiju masīvā.", "Daudzdimensiju masīvi tiek glabāti kolonnas prioritārā secībā."},
            {"int[][] arr = new int[5][];", "int arr[][] = new int[][5];", "int[][] arr = new int[5][5];", "int arr[5][] = new int[][];"},
            {"arr.length", "arr[0].length", "arr.size()", "arr[0].size()"},
            {"Jūs varat inicializēt divdimensiju masīvu ar dažādu rindu garumu.", "Metodi `Arrays.deepToString()` var izmantot, lai izdrukātu divdimensiju masīvu.", "Divdimensiju masīvs var saglabāt dažādus datu tipus.", "Jūs varat dinamiski piešķirt divdimensiju masīva izmēru Java."},
            {"arr[1, 2]", "arr[1][2]", "arr[1].get(2)", "arr.get(1, 2)"},
            {"String[][] arr = { {'a', 'b'}, {'c', 'd'} };", "String[][] arr = new String[2][2]{{'a', 'b'}, {'c', 'd'}};", "String arr[][] = { {'a', 'b'}, {'c', 'd'} };", "String arr[][] = new String[2][2]; arr[0][0] = 'a'; arr[0][1] = 'b'; arr[1][0] = 'c'; arr[1][1] = 'd';"},
            {"Divdimensiju masīvu var izmantot matricas izveidei.", "Divdimensiju masīva izmērs ir jādeklarē izveides laikā.", "Divdimensiju masīva elementiem var piekļūt, izmantojot divus indeksus.", "Visiem divdimensiju masīva elementiem jābūt vienāda tipa."}
        };
    }
}

