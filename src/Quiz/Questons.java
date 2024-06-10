package Quiz;

public class Questons {
	
    public static String[][] getQuestions() {
        return new String[][]{
            {"Kā pareizi deklarēt divdimensiju masīvu Java?"},
            {"Kādas metodes var izmantot, lai inicializētu 3x3 divdimensiju masīvu Java?"},
            {"Kuras no šīm koda daļām pareizi izdrukā divdimensiju masīva elementus Java?"},
            {"Kuri no šiem apgalvojumiem par divdimensiju masīviem Java ir patiesi?"},
            {"Kuri no šiem apgalvojumiem kompilēsies bez kļūdām?"},
            {"Kādas metodes var izmantot, lai iegūtu divdimensiju masīva garumu Java?"},
            {"Kuri apgalvojumi par divdimensiju masīviem Java ir pareizi?"},
            {"Kādi ir pareizi veidi, kā piekļūt divdimensiju masīva 'arr' elementiem Java?"},
            {"Kā pareizi definēt un inicializēt divdimensiju String masīvu Java?"},
            {"Kuri no šiem apgalvojumiem par divdimensiju masīviem Java ir patiesi?"}
        };
    }
    
    public static char[][] getAnswers() {
        return new char[][]{
            {'1', '4'},
            {'1', '3'},
            {'1', '2'},
            {'2', '3'},
            {'1', '3'},
            {'1', '2'},
            {'1', '2'},
            {'2', '3'},
            {'1', '4'},
            {'1', '3'}
        };
    }
}
