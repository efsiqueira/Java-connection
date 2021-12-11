package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import model.Golfinho;
import model.Leao;


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

        ActionListener addGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonAddGolfinhoActionPerformed(e);
            }
        };

        ActionListener showGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonMostraGolfinhoActionPerformed(e);
            }
        };

        ActionListener editGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonEditaGolfinhoAction(e);
            }
        };

        ActionListener removeGolfinhoAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonRemoveGolfinhoAction(e);
            }
        };
        botaoAddGolfinho.addActionListener(addGolfinhoAction);
        botaoMostrarGolfinho.addActionListener(showGolfinhoAction);
        botaoAtualizarGolfinho.addActionListener(editGolfinhoAction);
        botaoRemoverGolfinho.addActionListener(removeGolfinhoAction);

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

    // Leão
    private void buttonAddLeaoActionPerformed(ActionEvent e) {
        new AdicionarLeao();
    }

    private void buttonMostraLeaoActionPerformed(ActionEvent e) {
        String option = JOptionPane.showInputDialog(this, "Insira o ID do Leão");
        if (option != null && !option.isEmpty()) {
            try {
                Leao leao = Leao.selectLeao(Integer.parseInt(option));
                new MostrarLeao(leao);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Não foi possível localizar o leão. " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    private void buttonEditaLeaoAction(ActionEvent e) {
        new EditarLeao();
    }

    private void buttonRemoveLeaoAction(ActionEvent e) {
        String option = JOptionPane.showInputDialog(
            this,
            "Insira o ID de exlcusão"
        );
        if (option != null && !option.isEmpty()) {
            try {
                int ret = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja excluir?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if(ret == JOptionPane.YES_OPTION) {
                    Leao.deleteLeao(Integer.parseInt(option));
                    JOptionPane.showMessageDialog(this, "Operação realizada.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Operação cancelada.", "CANCELADO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Não foi possível localizar o leão. " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Golfinho
    private void buttonAddGolfinhoActionPerformed(ActionEvent e) {
        new AdicionarGolfinho();
    }

    private void buttonMostraGolfinhoActionPerformed(ActionEvent e) {
        String option = JOptionPane.showInputDialog(this, "Insira o ID do Golfinho");
        if (option != null && !option.isEmpty()) {
            try {
                Golfinho golfinho = Golfinho.selectGolfinho(Integer.parseInt(option));
                new MostrarGolfinho(golfinho);
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Não foi possível localizar o golfinho. " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }

    private void buttonEditaGolfinhoAction(ActionEvent e) {
        new EditarGolfinho();
    }

    private void buttonRemoveGolfinhoAction(ActionEvent e) {
        String option = JOptionPane.showInputDialog(
            this,
            "Insira o ID de exlcusão"
        );
        if (option != null && !option.isEmpty()) {
            try {
                int ret = JOptionPane.showConfirmDialog(
                    this,
                    "Deseja excluir?",
                    "Excluir",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
                );
                if(ret == JOptionPane.YES_OPTION) {
                    Golfinho.deleteGolfinho(Integer.parseInt(option));
                    JOptionPane.showMessageDialog(this, "Operação realizada.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Operação cancelada.", "CANCELADO", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception err) {
                JOptionPane.showMessageDialog(this, "Não foi possível localizar o golfinho. " + err.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
