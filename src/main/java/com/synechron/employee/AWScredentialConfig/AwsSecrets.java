package com.synechron.employee.AWScredentialConfig;

public class AwsSecrets {
    private String username;
    private String password;
    private String host;
    private String engine;
    private String port;
    private String dbInstanceIdentifier;

    private String driverClassName;
    public AwsSecrets() {

    }
    public AwsSecrets(String username, String password, String host, String engine, String port, String dbInstanceIdentifier, String driverClassName) {
        this.username = username;
        this.password = password;
        this.host = host;
        this.engine = engine;
        this.port = port;
        this.dbInstanceIdentifier = dbInstanceIdentifier;
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbInstanceIdentifier() {
        return dbInstanceIdentifier;
    }

    public void setDbInstanceIdentifier(String dbInstanceIdentifier) {
        this.dbInstanceIdentifier = dbInstanceIdentifier;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    @Override
    public String toString() {
        return "AwsSecrets{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", host='" + host + '\'' +
                ", engine='" + engine + '\'' +
                ", port='" + port + '\'' +
                ", dbInstanceIdentifier='" + dbInstanceIdentifier + '\'' +
                ", driverClassName='" + driverClassName + '\'' +
                '}';
    }
}
