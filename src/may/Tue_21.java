/*
 *	숫자 야구 게임 프로그램 작성
 *	중복 숫자, 0 입력 불가. 123 ~ 789 사이의 값만 입력 가능
 *	textField는 비활성화를 기본 값으로 하고, 게임이 시작되면 활성화 되도록 구현.
 */

package may;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tue_21 extends JFrame implements ActionListener {
    private JTextField tf;
    private JButton b1, b2;
    private JTextArea ta;
    private int[] com = new int[3];
    private int[] user = new int[3];
    private int s, b;

    public Tue_21() {
        tf = new JTextField();
        b1 = new JButton("시작");
        b2 = new JButton("종료");
        ta = new JTextArea();

        setLayout(null);

        // 컴포넌트 설정 및 추가
        tf.setBounds(10, 15, 150, 30);
        tf.setEnabled(false); // 초기 상태 비활성화
        add(tf);

        b1.setBounds(165, 15, 100, 30);
        add(b1);

        b2.setBounds(270, 15, 100, 30);
        add(b2);

        ta.setEditable(false);
        JScrollPane js = new JScrollPane(ta);
        js.setBounds(10, 55, 360, 300);
        add(js);

        // 프레임 설정
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tf.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public static void main(String[] args) {
        new Tue_21();
    }

    private void getRandom() {
        for (int i = 0; i < com.length; i++) {
            com[i] = (int) (Math.random() * 9) + 1;
            for (int j = 0; j < i; j++) {
                if (com[i] == com[j]) {
                    i--;
                    break;
                }
            }
        }
    }

    private void compare() {
        s = 0;
        b = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (com[i] == user[j]) {
                    if (i == j) {
                        s++;
                    } else {
                        b++;
                    }
                }
            }
        }

        String msg = "Input Number: " + user[0] + "" + user[1] + "" + user[2] +
                     ", Result: " + s + "S-" + b + "B\n";
        ta.append(msg);

        if (s == 3) {
            int no = JOptionPane.showConfirmDialog(this, "정답입니다! 게임을 종료할까요?", "종료",
                                                   JOptionPane.YES_NO_OPTION);
            if (no == JOptionPane.YES_OPTION) {
                System.exit(0);
            } else {
                resetGame();
            }
        }
    }

    private void resetGame() {
        tf.setText("");
        tf.setEnabled(false);
        ta.setText("");
        b1.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b2) {
            System.exit(0);
        } else if (e.getSource() == b1) {
            getRandom();
            JOptionPane.showMessageDialog(this, "게임을 시작합니다!!");
            tf.setEnabled(true);
            tf.requestFocus();
            b1.setEnabled(false);
        } else if (e.getSource() == tf) {
            String inputStr = tf.getText();

            try {
                int input = Integer.parseInt(inputStr);
                if (input < 100 || input > 999) {
                    JOptionPane.showMessageDialog(this, "세 자리 숫자만 입력하세요.");
                    resetInput();
                    return;
                }

                user[0] = input / 100;
                user[1] = (input % 100) / 10;
                user[2] = input % 10;

                if (user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
                    JOptionPane.showMessageDialog(this, "같은 숫자는 사용할 수 없습니다.");
                    resetInput();
                    return;
                }

                if (user[0] == 0 || user[1] == 0 || user[2] == 0) {
                    JOptionPane.showMessageDialog(this, "0은 입력이 불가합니다.");
                    resetInput();
                    return;
                }

                compare();
                resetInput();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "정수만 가능합니다.");
                resetInput();
            }
        }
    }

    private void resetInput() {
        tf.setText("");
        tf.requestFocus();
    }
}