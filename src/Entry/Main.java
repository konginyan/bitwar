package Entry;

import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("bitwar>");
            String line = scanner.nextLine();
            if (line.equals("exit")) break;
            Cmd cmd = new Cmd(line);
            try {
                cmd.execute();
            }catch (Exception e){
                System.err.println(e.getLocalizedMessage());
            }
            System.out.println();
        }
    }
}
