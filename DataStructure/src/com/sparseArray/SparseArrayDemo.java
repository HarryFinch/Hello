package com.sparseArray;

import java.util.Scanner;
import java.util.zip.CheckedInputStream;

/**
 * @author Harold
 * @Date 2020/7/25
 * @Description : 稀疏数组
 *  稀疏数组是 N 行 3 列的数组
 *      [0][0]表示原数组共多少行
 *      [0][1]表示原数组共多少列
 *      [0][2]表示原数组共多少个数值
 *  其余行每行原数组元素的坐标点以及数值
 */
public class SparseArrayDemo {

    int row = 11;
    int col = 11;
    Scanner scanner = new Scanner(System.in);
    long num1 = scanner.nextLong();
    int num2 = scanner.nextInt();
    int[][] chess = new int[row][col];

    int[][] sparseArr = null;

    public void twoArrToSparseArr() {
        //创建一个原始的二维数组11*11
        //0表示没有棋子，1表示黑子  2表示白子

        //棋盘做个初始化
        chess[1][2] = 1;
        chess[2][3] = 2;
        chess[4][5] = 1;

        int count = 0;//表示稀疏数组的行数
        int sum = 0; //表示非0数据的总数

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    sum++;
                }
            }
        }

        sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = chess.length;
        sparseArr[0][1] = chess[row - 1].length;
        sparseArr[0][2] = sum;

        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chess[i][j];
                }
            }
        }

        for (int i = 0; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                System.out.print(sparseArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void sparseArrToTwoArr() {
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < chessArr[i].length; j++) {
                System.out.print(chessArr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SparseArrayDemo sad = new SparseArrayDemo();
        sad.twoArrToSparseArr();
        sad.sparseArrToTwoArr();
        System.out.println(sad.getClass());
    }
}
