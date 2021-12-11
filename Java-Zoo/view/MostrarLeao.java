package view;


import javax.swing.*;
import model.Leao;
import java.awt.*;
import java.awt.event.*;

public class MostrarLeao extends JFrame{
    JLabel lIdLeao;
    JLabel lNomeLeao;
    JLabel lAlimentacao;
    JLabel lVisitantes;
    JLabel lDescricaoJaula;
    JTextField tIdLeao;
    JTextField tNomeLeao;
    JTextField tAlimentacao;
    JTextField tVisitantes;
    JTextField tDescricaoJaula;
    JButton bOkLeao = new JButton("OK");

    public MostrarLeao(Leao leao) {
        lIdLeao = new JLabel("Id do leão", JLabel.LEFT);
        lNomeLeao = new JLabel("Nome do leão", JLabel.LEFT);
        lAlimentacao = new JLabel("Alimentação do leão", JLabel.LEFT);
        lVisitantes = new JLabel("Visitantes do leão", JLabel.LEFT);
        lDescricaoJaula = new JLabel("Descrição da jaula", JLabel.LEFT);

        tIdLeao = new JTextField(15);
        tNomeLeao = new JTextField(15);
        tAlimentacao = new JTextField(15);
        tVisitantes = new JTextField(15);
        tDescricaoJaula = new JTextField(15);
        
        ActionListener okLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonOkActionPerformed(e);
            }
        };
        bOkLeao.addActionListener(okLeaoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.LEFT));

        pane.add(lIdLeao);
        pane.add(tIdLeao);
        pane.add(lNomeLeao);
        pane.add(tNomeLeao);
        pane.add(lAlimentacao);
        pane.add(tAlimentacao);
        pane.add(lVisitantes);
        pane.add(tVisitantes);
        pane.add(lDescricaoJaula);
        pane.add(tDescricaoJaula);
        pane.add(bOkLeao);

        tIdLeao.setText(Integer.toString(leao.getId()));
        tNomeLeao.setText(leao.getNome());
        tAlimentacao.setText(Integer.toString(leao.getAlimentacao()));
        tVisitantes.setText(Integer.toString(leao.getVisitantes()));
        tDescricaoJaula.setText(leao.getJaula().getDescricao());

        tIdLeao.setEditable(false);
        tNomeLeao.setEditable(false);
        tAlimentacao.setEditable(false);
        tVisitantes.setEditable(false);
        tDescricaoJaula.setEditable(false);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(195,305);
        this.setVisible(true);
    }

    private void buttonOkActionPerformed(ActionEvent e) {
        this.dispose();
    }
}
