package model;

public  class Values {

    private final static String sqlPassword = "hejsanhoppsanSupportMe25";
    private final static String sqlUrl = "jdbc:sqlserver://supportme.duckdns.org;databaseName=support_me";
    private final static String sqlUsername = "supportmeadmin";


    public static String getSqlPassword() {
        return sqlPassword;
    }

    public static String getSqlUrl() {
        return sqlUrl;
    }

    public static String getSqlUsername() {
        return sqlUsername;
    }
}
