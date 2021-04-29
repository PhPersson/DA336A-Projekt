package model;

public  class Values {

    private final static String sqlUrl = "jdbc:sqlserver://supportme.database.windows.net:1433;database=SupportME;user=supportmeadmin@supportme;password=supportme.25;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";

    public static String getSqlUrl() {
        return sqlUrl;
    }

}
