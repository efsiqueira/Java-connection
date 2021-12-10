package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Leao;

public class InfoIdLeao extends JFrame{
    JLabel lInfoId = new JLabel("Informe o Id");
    JTextField tInfoId = new JTextField(5);
    JButton bInfoOk = new JButton("OK");

    public InfoIdLeao() {

        ActionListener okLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonConfirmaActionPerformed(e);
            }
        };
        bInfoOk.addActionListener(okLeaoAction);
        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(lInfoId);
        pane.add(tInfoId);
        pane.add(bInfoOk);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(100,100);
        this.setVisible(true);

    }

    private void buttonConfirmaActionPerformed(ActionEvent e) {
        Leao.selectLeao(Integer.parseInt(tInfoId.getText()));
    }
}