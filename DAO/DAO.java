package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DAO {
    private static PreparedStatement preparedStatement = null
    private static ResultSet resultSet = null;

    private static String DRIVER = "org.sqlite.JDBC";
    private static String BD = "jdbc:sqlite:resources/bdclientes.db";

    private static String CADASTRAR_CLIENTE = "INSERT INTO CLIENTES "
            + "(ID, nome, data_nascimento, email, telefone, estado, cidade, bairro, rua, numero, cep, cpf)"
            + "VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private static String CONSULTAR_CLIENTE = "SELECT * FROM CLIENTES "
            + "WHERE ID = ?";

    private static String ALTERAR_CLIENTE = "UPDATE CLIENTES "
            + "nome = ?, data_nascimento = ?, email = ?, telefone = ?, estado = ?, cidade = ?, bairro = ?, rua = ?, numero = ?, cep = ?, cpf = ?)"
            + "WHERE ID = ?";

    private static String EXCLUIR_CLIENTE = "DELETE FROM CLIENTES "
            + "WHERE ID = ?";

    private static String LISTAR_CLIENTE = "SELECT * FROM CLIENTES "
            + "WHERE ID = ?";

    public DAO() {
    }

    public void cadastrarCliente(Cliente cliente) {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = CADASTRAR_CLIENTE;
        try {

            preparedStatement = connection.prepareStatement(query);

            int i = 0;
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

            connection.commit();

            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            fecharConexao();
        }
    }

    private void fecharConexao() {
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
            Conexao.getInstancia().fecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente consultarCliente(int id) {
        Connection connection = Conexao.getInstancia().abrirConexao();

        String query = CONSULTAR_CLIENTE;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("ID"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setDataNascimento(resultSet.getString("data_nascimento"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setEstado(resultSet.getString("estado"));
                cliente.setCidade(resultSet.getString("cidade"));
                cliente.setBairro(resultSet.getString("bairro"));
                cliente.setRua(resultSet.getString("rua"));
                cliente.setNumero(resultSet.getString("numero"));
                cliente.setCep(resultSet.getString("cep"));
                cliente.setCpf(resultSet.getString("cpf"));

                return cliente;
            }

        } catch (SQLException e) {
            e.printStackTrace();

}
