import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskFrame_2 extends JFrame {
   public JButton buttonResult = new JButton("Узнать результат");
   public JTextField inputArea = new JTextField();
   public JTextField outputArea = new JTextField();
   public JLabel inputLabel = new JLabel("Введите ваше имя:");
   public JLabel outputLabel = new JLabel("Ваш релультат:");
   public JPanel centralPanel = new JPanel();

    public TaskFrame_2() {
        super("Task_2");
        this.setVisible(true);
        this.setBounds(500,250,600,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.lightGray);
        this.setLayout(new GridLayout(5,1));

        this.add(inputLabel);
        this.add(inputArea);

        this.centralPanel.setBackground(Color.black);
        this.add(centralPanel);

        this.add(outputLabel);
        this.add(outputArea);

        buttonResult.addActionListener(new ButtonClickListener());
        centralPanel.add(buttonResult);

        ImageIcon img =new ImageIcon("logo.png"); // image just for fun :D
        this.setIconImage(img.getImage());
    }

    public class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonResult) {
                try {
                    outputArea.setText(enterResult(inputArea.getText()));
                } catch (Exception ex) {
                    outputArea.setText ("Error");
                }
                inputArea.setText(null);
            }
        }
    }

    public static String enterResult(String name) {
        String answer = name.toLowerCase();
        if (answer.equals("вячеслав")) {
            answer = "Привет, Вячеслав";
        } else {
            answer = "Нет такого имени";
        }
        return answer;
    }
}

