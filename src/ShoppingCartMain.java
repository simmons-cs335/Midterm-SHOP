import javafx.concurrent.Task;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ShoppingCartMain {
    public static void main(String[] args) {
        runProgram t1 = new runProgram();
        runProgram t2 = new runProgram();
        Timer t = new Timer();
        t.schedule(t1, 1000);



    }
}

