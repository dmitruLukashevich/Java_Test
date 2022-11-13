import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SplittableRandom;

public class TaskFrame_3 extends JFrame {
    public JButton buttonResult = new JButton("Получить результат");
    public JButton buttonReset = new JButton("Обновить массив");
    public JTextField inputArea = new JTextField();
    public JTextField outputArea = new JTextField();
    public JLabel inputLabel = new JLabel("Произвольный массив чисел:");
    public JLabel outputLabel = new JLabel("Числа кратные 3:");
    public JPanel centralPanel = new JPanel();
    public static int[] arrayInt = new int[20];

    public TaskFrame_3() {
        super("Task_3");
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
        buttonReset.addActionListener(new ButtonClickListener());
        centralPanel.add(buttonReset);

        generateArray();
        inputArea.setText(Arrays.toString(arrayInt));

        ImageIcon img =new ImageIcon("logo.png"); // image just for fun :D
        this.setIconImage(img.getImage());
    }

    public class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == buttonResult) {
                ArrayList<Integer> list = sortArray(arrayInt);
                Integer[] tmp = list.toArray(new Integer[list.size()]);
                outputArea.setText(Arrays.toString(tmp));

            }else if (e.getSource()==buttonReset){
                inputArea.setText(null);
                generateArray();
                inputArea.setText(Arrays.toString(arrayInt));
            }
        }
    }

    public static void generateArray() {
        SplittableRandom random = new SplittableRandom();
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = random.nextInt(0, 1000);
        }
    }

    public ArrayList<Integer> sortArray(int[] array) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int var : array) {
            if (var % 3 == 0) {
                result.add(var);
            }
        }
        return result;
    }
}

