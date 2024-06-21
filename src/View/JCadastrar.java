package View;

import program.Produtos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCadastrar extends JFrame {
    private JPanel CadastrarPanel;
    private JTextField nomeField;
    private JTextField descricaoField;
    private JFormattedTextField precoField;
    private JButton btnListar;
    private JButton btnAdicionar;
    private JComboBox<String> comboBox;
    private JButton fecharButton;


    private String nome;
    private String descricao;
    private String disponivel;
    private String preco;


    public JCadastrar() {
        setContentPane(CadastrarPanel);
        setTitle("Cadastro de Produtos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(420, 600);
        setLocationRelativeTo(null);
        setVisible(true);

        preencherComboBox(comboBox);


        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome = nomeField.getText();
                descricao = descricaoField.getText();
                preco = precoField.getText();


                disponivel = (String) comboBox.getSelectedItem();

                if(!validarCampos(nome, descricao, preco, disponivel)){
                    return;
                }
                Double valor;
                try {
                    valor = Double.parseDouble(preco);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                            CadastrarPanel, "Preço inválido",
                            "Erro", JOptionPane.ERROR_MESSAGE);
                    precoField.requestFocus();
                    return;
                }


                Produtos novo = Produtos.getInstance();
                novo.adicionarProduto(nome, descricao, valor, disponivel);

                dispose();

                Lista lista = new Lista();
                lista.setLocationRelativeTo(lista);

                System.out.println(novo.listaProdutos());
            }
        });

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Lista lista = new Lista();
                lista.setLocationRelativeTo(lista);
            }
        });
    }

    private static void preencherComboBox(JComboBox<String> comboBox) {
        String[] opcoes = {"Sim", "Não"};

        for (String cargo : opcoes) {
            comboBox.addItem(cargo);
        }
    }

    private boolean validarCampos(String nom, String desc, String valor, String avaliable) {

        if (nom.equals("")) {
            JOptionPane.showMessageDialog(
                    CadastrarPanel, "Favor preencer o campo NOME DO PRODUTO",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            nomeField.requestFocus();
            return false;
        }
        if (desc.equals("")) {
            JOptionPane.showMessageDialog(
                    CadastrarPanel, "Favor preencer o campo DESCRIÇÃO DO PRODUTO",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            precoField.requestFocus();
            return false;
        }
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(
                    CadastrarPanel, "Favor preencer o campo PREÇO",
                    "Erro", JOptionPane.ERROR_MESSAGE);
            precoField.requestFocus();
            return false;
        }

        return true;
    }


public static void main(String[] args) {
    try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

    UIManager.put("Button.focus", UIManager.get("Button.background"));

    SwingUtilities.invokeLater(() -> new JCadastrar());

}

}
