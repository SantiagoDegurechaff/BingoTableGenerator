package test.satoshi.bingotable;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Generator {
    private final Model model;
    private final Random rand;

    public Generator(Model model){
        this.model = model;
        rand = new Random();
    }

    public void fillData(){
        int count = model.tableCount;
        int[][] table;

        for(int i=0; i<count; i++){
            table = getUnrepeatedTable();
            model.data.add(table);
        }
    }

    private int[][] getUnrepeatedTable(){
        int[][] table;

        do{
            table = createTable();
        }while(ListAnyMatch(table)); //ListAnyMatch(table)

        return table;
    }


    private boolean ListAnyMatch(int[][] table){
        return model.data.stream().anyMatch(l -> Arrays.deepEquals(l, table));
    }

    public int[][] createTable(){
        int[][] result = new int[model.filas][model.columnas];
        int rango = model.rangoCol;

        for(int i=0; i<model.filas; i++){
            for(int j=0; j<model.columnas; j++){
                result[i][j] = getUnrepeatedRandom(result[i], 1+rango*i, rango+1+rango*i);
            }
        }

        return result;
    }

    private int getUnrepeatedRandom(int[] array, int origin, int bound){
        int n;

        do{
            n = rand.nextInt(origin, bound);
        }while(arrayAnyMatch(array, n));

        return n;
    }

    private static boolean arrayAnyMatch(int[] array, int value){
        return IntStream.of(array).anyMatch(x -> x == value);
    }
}
