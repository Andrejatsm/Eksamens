package Quiz;

import java.util.Random;
import java.util.Scanner;

public class placeholder {
	
    public static void main(String[] args) {
	 
        int r, k, maxSS, pag, maxI = 0, maxJ = 0; 
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        do {
            System.out.print("Ievadi rindu skaitu: ");
            r = scan.nextInt();
            System.out.print("Ievadi kolonnu skaitu: ");
            k = scan.nextInt();
        } while (r < 2 || k < 2);
        
        int[][] A = new int[r][k];
        int[][] B = new int[r][k];
        int id = 0;
        int[] pagMas = new int[r * k];
        
        System.out.println("Izveidotais masīvs A: ");
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = rand.nextInt(100) + 1; 
                B[i][j] = A[i][j];
                System.out.print(A[i][j] + " ");
                pagMas[id] = A[i][j];
                id++;
            }
            System.out.println();
        }
        for (int i = 0; i < pagMas.length - 1; i++) {
            maxSS = i;
            for (int j = i + 1; j < pagMas.length; j++) {
                if (pagMas[j] > pagMas[maxSS])
                    maxSS = j;
            }
            pag = pagMas[maxSS];
            pagMas[maxSS] = pagMas[i];
            pagMas[i] = pag;
        }
        
        System.out.println("A sakārtots ar Selection Sort (dilstoši):");
        id = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = pagMas[id];
                id++;
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        id = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                pagMas[id] = B[i][j];
                id++;
            }
        }
            }
    }
