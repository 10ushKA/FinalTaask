package by.niitzi.bushylo.v3.util;

import java.util.ResourceBundle;

public class ApplicationProperties {

    public static final ApplicationProperties APPLICATION_PROPERTIES = new ApplicationProperties();

    private ApplicationProperties(){
        init();
    }

    private String dbUrl;
    private String login;
    private String password;
    private String dbDriver;
    private int initSize;
    private int maxSize;

    private void init(){
        ResourceBundle pr = ResourceBundle.getBundle("config");
        dbUrl = pr.getString("db.url");
        login = pr.getString("db.login");
        password = pr.getString("db.password");
        dbDriver = pr.getString("db.driver");
        initSize = Integer.parseInt(pr.getString("cp.init.size"));
        maxSize = Integer.parseInt(pr.getString("cp.max.size"));
    }

    public String getDbDriver(){
        return dbDriver;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getInitSize() {
        return initSize;
    }

    public int getMaxSize() {
        return maxSize;
    }
}
