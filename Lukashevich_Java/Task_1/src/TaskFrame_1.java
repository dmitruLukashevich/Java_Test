import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskFrame_1 extends JFrame {
   public JButton buttonTryNumber = new JButton("Узнать результат");
   public JTextField inputArea = new JTextField();
   public JTextField outputArea = new JTextField();
   public JLabel inputLabel = new JLabel("Введите любое число:");
   public JLabel outputLabel = new JLabel("Ваш релультат:");
   public JPanel centralPanel = new JPanel();

    public TaskFrame_1() {
        super("Task_1");
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

        buttonTryNumber.addActionListener(new ButtonClickListener());
        centralPanel.add(buttonTryNumber);

        ImageIcon img =new ImageIcon("logo.png"); // image just for fun :D
        this.setIconImage(img.getImage());
    }

    public class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttonTryNumber) {
                try {
                    outputArea.setText(enterResult(Integer.parseInt(inputArea.getText())));
                } catch (Exception ex) {
                    outputArea.setText ("Вы ввели не число, попробуйте еще раз !");
                }
                inputArea.setText(null);
            }
        }
    }

    public static String enterResult(int number) {
        String answer = "";
        if (number > 7) {
            answer = "Привет";
        }  else if(number <=0) {
            answer = "Введите положительное число";
        } else if (number > 0 && number <= 7)
            answer = "Введите число побольше";
        return answer;
    }
}