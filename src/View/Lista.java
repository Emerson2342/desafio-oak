package View;

import program.Produtos;

import javax.swing.*;
import javax.swing.RowSorter.SortKey;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lista extends JFrame {
    private JPanel ListaPanel;
    private JTable tabelaProdutos;
    private JButton cadastrarOutroProdutoButton;
    private JButton btnFechar;
    private DefaultTableModel model;

    public Lista() {
        setTitle("Lista de Produtos");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] colunas = {"Nome", "Descrição", "Preço", "Disponível Para Venda"};
        model = new DefaultTableModel(colunas, 0);
        tabelaProdutos = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabelaProdutos);
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));


        cadastrarOutroProdutoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(cadastrarOutroProdutoButton);

        btnFechar.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(btnFechar);

        add(buttonPanel, BorderLayout.SOUTH);

        preencherTabela();


        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tabelaProdutos.setRowSorter(sorter);


        Comparator<Double> comparator = Comparator.nullsLast(Comparator.naturalOrder());
        sorter.setComparator(2, comparator);


        List<SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new SortKey(2, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
        sorter.sort();


        btnFechar.addActionListener(_ -> dispose());

        setVisible(true);
        cadastrarOutroProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new JCadastrar();
            }
        });
    }

    private void preencherTabela() {
        model.setRowCount(0);

        Produtos produtos = Produtos.getInstance();
        for (int i = 0; i < produtos.listaProdutos().size(); i++) {
             Object[] row = {
                    produtos.listaProdutos().get(i).getName(),
                    produtos.listaProdutos().get(i).getDiscription(),
                    produtos.listaProdutos().get(i).getPrice(),
                    produtos.listaProdutos().get(i).isAvaliable()
            };
            model.addRow(row);
        }
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
        SwingUtilities.invokeLater(Lista::new);
    }
}
