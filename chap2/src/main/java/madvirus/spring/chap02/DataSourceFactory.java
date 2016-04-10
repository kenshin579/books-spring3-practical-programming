package madvirus.spring.chap02;

public class DataSourceFactory {

    private String jdbcDriver;
    private String jdbcUrl;
    private String username;
    private String password;

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "DataSourceFactory [jdbcDriver=" + jdbcDriver + ", jdbcUrl="
                + jdbcUrl + ", user=" + username + ", password=" + password + "]";
    }

}
