package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JanelaPrincipal extends JFrame{

    JButton botaoAddLeao = new JButton("Adicionar Leão");
    JButton botaoMostrarLeao = new JButton("Mostrar Leões");
    JButton botaoAtualizarLeao = new JButton("Editar Leões");
    JButton botaoRemoverLeao = new JButton("Remover Leões");
    JButton botaoAddGolfinho = new JButton("Adicionar Golfinho");
    JButton botaoMostrarGolfinho = new JButton("Mostrar Golfinhos");
    JButton botaoAtualizarGolfinho = new JButton("Editar Golfinhos");
    JButton botaoRemoverGolfinho = new JButton("Remover Golfinhos");
    
    public JanelaPrincipal() {
        ActionListener addLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAddLeaoActionPerformed(e);
            }
        };

        ActionListener showLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMostraLeaoActionPerformed(e);
            }
        };

        ActionListener editLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonEditaLeaoAction(e);
            }
        };

        ActionListener removeLeaoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonRemoveLeaoAction(e);
            }
        };
        botaoAddLeao.addActionListener(addLeaoAction);
        botaoMostrarLeao.addActionListener(showLeaoAction);
        botaoAtualizarLeao.addActionListener(editLeaoAction);
        botaoRemoverLeao.addActionListener(removeLeaoAction);

        Container pane = this.getContentPane();
        pane.setLayout(new FlowLayout(FlowLayout.CENTER));

        pane.add(botaoAddLeao);
        pane.add(botaoMostrarLeao);
        pane.add(botaoAtualizarLeao);
        pane.add(botaoRemoverLeao);
        pane.add(botaoAddGolfinho);
        pane.add(botaoMostrarGolfinho);
        pane.add(botaoAtualizarGolfinho);
        pane.add(botaoRemoverGolfinho);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(220,300);
        this.setVisible(true);

        
    }

    private void buttonAddLeaoActionPerformed(ActionEvent e) {
        new AdicionarLeao();
    }

    private void buttonMostraLeaoActionPerformed(ActionEvent e) {
        new InfoIdLeao();
    }

    private void buttonEditaLeaoAction(ActionEvent e) {

    }

    private void buttonRemoveLeaoAction(ActionEvent e) {

    }
}
