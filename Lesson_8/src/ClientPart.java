import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientPart extends JFrame {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nick;
    private boolean auth;
    private JTextField messageField;
    private JButton button;
    private JTextArea chatArea;
    private JLabel nickField;
//    private JTextArea loginField;                  //задел на будущее
//    private JTextArea passField;                   //задел на будущее

    public ClientPart() {
        connectToServer();
    }

    public void connectToServer() {
        try {
            Socket socket = new Socket("localhost", 1111);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            setAuthorized(false);
        } catch (IOException e) {
            System.out.println("Не удалось подключиться к серверу");
            e.printStackTrace();
        }
        new Thread(() -> resetSocketOnTimeout()).start();
        prepareChatWindow();
        new Thread(() -> {
            try {
                while (true) {
                    String str = in.readUTF();
                    if (str.startsWith("/authok ")) {
                        setAuthorized(true);
                        nick = str.split("\\s")[1];
                        nickField.setText(nick);
                        break;
                    }
                    chatArea.append(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public synchronized void prepareChatWindow() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 20, 400, 400);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        chatArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(chatArea);
        jPanel.add(jsp, BorderLayout.CENTER);
        chatArea.setBackground(new Color(36, 243, 143));

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());

        messageField = new JTextField();
        jPanel1.add(messageField, BorderLayout.CENTER);

        nickField = new JLabel(nick);
        jPanel1.add(nickField, BorderLayout.WEST);

        button = new JButton("Send");
        jPanel1.add(button, BorderLayout.EAST);
        jPanel.add(jPanel1, BorderLayout.SOUTH);
        button.setBackground(new Color(242, 0, 225));

        messageField.addActionListener(e -> {
            try {
                sendMessage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button.addActionListener(e -> {
            try {
                sendMessage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        add(jPanel);

        new Thread(() -> {
            try {
                while (true) {
                    if (in.available() > 0) {
                        String msg = in.readUTF();
                        chatArea.append(msg);
                        chatArea.append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        setVisible(true);
    }

    private void sendMessage() throws IOException {
        String messageStr = messageField.getText();
        out.writeUTF(messageStr);
        out.flush();
        messageField.setText("");
    }

    public boolean setAuthorized(boolean auth) {
        return auth;
    }

    private void resetSocketOnTimeout() {  //тайм-аут 120 сек
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (setAuthorized(auth)) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public void onAuthClick() throws IOException {                        //задел на будущее
//        if (socket == null || socket.isClosed()) {
//            connectToServer();
//        }
//        try {
//            out.writeUTF("/auth " + loginField.getText() + " " + passField.getText());
//            loginField.setText("");
//            passField.setText("");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    public void prepareRegGUI() {   //попыта создать отдельное окно для регистрации   //задел на будущее
//        setTitle("Registration");
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setBounds(30, 30, 150, 150);
//
//        JPanel jPanel = new JPanel();
//        jPanel.setLayout(new BorderLayout());
//
//        loginField = new JTextArea();
//        jPanel.add(loginField, BorderLayout.CENTER);
//
//        passField = new JTextArea();
//        jPanel.add(passField, BorderLayout.CENTER);
//
//        JPanel jPanel1 = new JPanel();
//
//        JButton regButton = new JButton("Log in");
//        jPanel1.add(regButton, BorderLayout.EAST);
//        jPanel.add(jPanel1, BorderLayout.SOUTH);
//
//        add(jPanel);
//
//        setVisible(true);
//    }
}
