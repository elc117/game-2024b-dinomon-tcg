package io.github.antoniosrt;

public class UtilHelper {

    private static final String[] ELEMENTOS = {"Vento", "Água", "Terra"};
    private static final String[] ELEMENTOS_PATH = {"vento", "agua", "terra"};

    public static String getElementoNome(int index){
        return ELEMENTOS[index];
    }

    public static String getElementoPath(int index){
        return ELEMENTOS_PATH[index];
    }

}
