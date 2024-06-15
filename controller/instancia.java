import java.sql.Connection;
import java.sql.SQLException;

public class instancia {
    private static Conexao conexao;
    private String Driver = "org.sqlite.JDBC";
    private String BD = "jbdc:sqlite:resorces/bdclientes.db";
    private static Connection conexao;

    private Conexao(){
    }

}

    public static Conexao getInstancia() {

        if (instancia == null) {
            instancia = new Conexao();
        }
        return instancia;
    }

public Conection abrirConexao(){
    try{
    Class.forname(DRIVER);
    conexao = DriverManager.getConnection(BD);
    conexao.set/autocommit(false);
    } catch(SQLException | ClassNotFoundException e){
        System.out.println("Erro ao conectar com o banco de dados" + e.getMessage());

    }
    return conexao;
}

public void fecharConexao() {
    try{
    if (conexao != null && !conexao.isClosed()) {
        conexao.close();
    }
    
} catch (SQLException e){
        System.out.println("Erro ao fechar a conexao com o banco de dados" + e.getMessage());
    } finally {
        conexao = null;
        
    }
