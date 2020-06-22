import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chat extends JFrame {
    private JTextField messageField;
    private JButton button;
    private JTextArea messageArea;

    public Chat() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(600, 100, 400, 400);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());

        messageArea = new JTextArea();
        JScrollPane jsp = new JScrollPane(messageArea);
        jPanel.add(jsp, BorderLayout.CENTER);
        messageArea.setBackground(new Color(36, 243, 143));


        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());

        addMessageField();
        jPanel1.add(messageField, BorderLayout.CENTER);

        addSendButton();
        jPanel1.add(button, BorderLayout.SOUTH);
        jPanel.add(jPanel1, BorderLayout.SOUTH);

        add(jPanel);

        setVisible(true);
    }

    private void addMessageField() {
        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void addSendButton() {
        button = new JButton("Send");
        button.setBackground(new Color(242, 0, 225));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        if (!messageField.getText().isEmpty()) {
            messageArea.append(messageField.getText() + "\n");
            messageField.setText("");
        }
    }
}