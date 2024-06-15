package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {
    private static PreparedStatement preparedStatement = null;
    private static ResultSet resultSet = null;

    private static final String DRIVER = "org.sqlite.JDBC";
    private static final String BD = "jdbc:sqlite:resources/bdclientes.db";

    private static final String CADASTRAR_CLIENTE = "INSERT INTO CLIENTES "
            + "(ID, nome, data_nascimento, email, telefone, estado, cidade, bairro, rua, numero, cep, cpf)"
            + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String CONSULTAR_CLIENTE = "SELECT * FROM CLIENTES "
            + "WHERE ID = ?";

    private static final String ALTERAR_CLIENTE = "UPDATE CLIENTES SET "
            + "nome = ?, data_nascimento = ?, email = ?, telefone = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ?, cpf = ? "
            + "WHERE ID = ?";

    private static final String EXCLUIR_CLIENTE = "DELETE FROM CLIENTES "
            + "WHERE ID = ?";

    private static final String LISTAR_CLIENTE = "SELECT * FROM CLIENTES "
            + "WHERE ID = ?";

    public DAO() {
    }

    public void cadastrarCliente(Cliente cliente) {
        Connection connection = Conexao.getInstancia().abrirConexao();

        try {
            preparedStatement = connection.prepareStatement(CADASTRAR_CLIENTE);
            int i = 1;
            preparedStatement.setString(i++, cliente.getNome());
            preparedStatement.setString(i++, cliente.getDataNascimento());
            preparedStatement.setString(i++, cliente.getEmail());
            preparedStatement.setString(i++, cliente.getTelefone());
            preparedStatement.setString(i++, cliente.getEstado());
            preparedStatement.setString(i++, cliente.getCidade());
            preparedStatement.setString(i++, cliente.getBairro());
            preparedStatement.setString(i++, cliente.getRua());
            preparedStatement.setString(i++, cliente.getNumero());
            preparedStatement.setString(i++, cliente.getCep());
            preparedStatement.setString(i++, cliente.getCpf());

            preparedStatement.executeUpdate();
            connection.commit();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    public Cliente consultarCliente(int id) {
        Connection connection = Conexao.getInstancia().abrirConexao();
        Cliente cliente = null;

        try {
            preparedStatement = connection.prepareStatement(CONSULTAR_CLIENTE);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setId(resultSet.getInt("ID"));
                cliente.setNome(resultSet.getString("nome"));
                // Complete os demais campos aqui, conforme feito acima
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
        return cliente;
    }

    private void fecharConexao() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
