import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {
    private static final String SERVER_ADDR = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        new ConsoleClient();
    }

    public ConsoleClient() {
        BufferedReader in;
        PrintWriter out;
        Socket socket;

        try {
            socket = new Socket(SERVER_ADDR, SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String msg = in.readLine();
//                            if (msg.equalsIgnoreCase("/end")) break;
                            System.out.println("Server: " + msg);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String msg = scanner.nextLine();
                            out.println(msg);
                            out.flush();
                            if (msg.equalsIgnoreCase("/exit")) {
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error!!!");
                    } finally {
                        try {
                            socket.close();
                            System.exit(0);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
