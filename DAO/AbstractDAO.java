    package DAO;

    import java.io.File;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
    import java.util.List;

    abstract class AbstractDAO<T> {
        private static final String DB_URL = "jdbc:sqlite:banco.db";
        private Connection conn = null;

        protected Connection connect() {
            try {
                Class.forName("org.sqlite.JDBC");

                if (conn == null || conn.isClosed()) {
                    System.out.println("Conectando ao banco de dados: " + DB_URL);
                    conn = DriverManager.getConnection(DB_URL);
                    conn.setAutoCommit(false);
                    System.out.println("Conexão com o banco estabelecida com sucesso.");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Driver JDBC para SQLite não encontrado. Certifique-se de que o driver está no classpath.");
                System.out.println(e.getMessage());
            }
            return conn;
        }

        public abstract void insert(T item);
        public abstract T get(int id);
        public abstract List<T> getAll();
        public abstract void update(T item);
        public abstract void delete(int id);
    }
