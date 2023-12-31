import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import javax.swing.text.FlowView;
import java.util.Comparator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class calc {
    public static class init_calc implements ActionListener{
        protected JPanel pan = new JPanel();
        protected JFrame frm = new JFrame();
        protected JLabel ans = new JLabel("0");
        protected double op1 = 0, op2 = 0;
        public int cnt = 0;
        protected String buffer = "", op = "";
        protected JButton arr[] = {
            new JButton("0"), new JButton("1"), new JButton("2"), 
            new JButton("3"), new JButton("4"), new JButton("5"), 
            new JButton("6"), new JButton("7"), new JButton("8"), 
            new JButton("9"),new JButton("1/x"),  new JButton("x^2"),
            new JButton("sqrt(x)"),new JButton("del"),new JButton("C")
            ,new JButton("-"), new JButton("/"), new JButton("*"),
            new JButton("mod"), new JButton("+"), new JButton("=")};
        public init_calc(){
            init_win();
        }
        public void init_win(){
            this.set_wind();
            this.set_but();
        }
        public void set_wind(){
            frm.setTitle("Calculator");
            frm.setVisible(true);
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frm.setResizable(false);
            frm.setLocation(400, 100);
            
            frm.setLayout(new GridLayout(2, 0));
            pan.setLayout(new GridLayout(5, 2));
            
            pan.setPreferredSize(new Dimension(400, 300));
            ans.setPreferredSize(new Dimension(400, 50));
            
            frm.add(ans);
            frm.add(pan);
            frm.pack();

            pan.setBackground(new Color(150, 150, 150));

        }
        public void set_but(){
            for(int i = 0 ;i < arr.length;i++){
                if((int)arr[i].getText().charAt(0) >= 48 && (int)arr[i].getText().charAt(0) <= 57&&arr[i].getText().length()==1){
                    arr[i].setBackground(new Color(192, 192, 192));
                }else {
                    arr[i].setBackground(new Color(128, 128, 128));
                }
                arr[i].addActionListener(this);
                pan.add(arr[i]);
            }
        }
        @Override
        public void actionPerformed(ActionEvent e){
            JButton x = (JButton)e.getSource();
            if((int)x.getText().charAt(0) >= 48 && (int)x.getText().charAt(0) <= 57&&x.getText().length()==1){
                buffer+=x.getText();
                ans.setText(buffer);
                if(cnt == 0)
                op1 = Double.parseDouble(buffer);
                else
                op2 = Double.parseDouble(buffer);
            }else{
                if(cnt == 1){
                    switch (op) {
                        case "C":
                            cnt = 0;
                            buffer = "";
                            op1 = 0;
                            op2 = 0;
                            break;
                        case "+":
                            op1 = op1 + op2;
                            break;
                        case "-":
                            op1 = op1 - op2;
                        break;
                            case "*":
                            op1  *= op2;
                            break;
                        case "/":
                            op1/=op2;
                        break;
                        case "del":
                            buffer = "";
                            break;
                        case "sqrt(x)":
                            op1 = Math.sqrt(op1);
                            break;
                        case "x^2":
                            op1 *=op1;
                            break;
                        case "1/x":
                            op1/=op1;
                            break;
                        case "mod":
                            op1%=op2;
                            break;
                        default:
                        break;
                    }
                    ans.setText((String.valueOf(op1)));
                }else
                    cnt = 1;
                buffer = "";
                op = x.getText();
            }
            // System.out.println("cnt: " + cnt + " op1: " + op1 + " op2: " + op2 + " op: " + op);
        }   
    }
    public static void main(String[] args) {
        init_calc test = new init_calc();
    }
}