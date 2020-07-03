import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleServer {

    public static void main(String[] args) {
        new ConsoleServer();
    }

    public ConsoleServer() {
        ServerSocket server = null;
        Socket socket = null;
        BufferedReader in;
        PrintWriter out;

        try {
            server = new ServerSocket(1234);
            System.out.println("Сервер запущен. Ожидание подключения клиента...");
            socket = server.accept();
            System.out.println("Клиент подключился.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String str2 = scanner.nextLine();
                        out.println(str2);
                        out.flush();
                    }
                }
            }).start();

            try {
                if (socket.isConnected()) {
                    while (true) {
                        String msg = in.readLine();
                        if (msg.equalsIgnoreCase("/exit")) break;
                        System.out.println("Client: " + msg);
                    }
                }
            } catch(Exception e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("Клиент отключился.");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
                System.out.println("Сервер отключен.");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
