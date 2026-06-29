package bai61;

class AppConfig {

    private static volatile AppConfig instance;

    private String appName;
    private String version;
    private String logLevel;

    private AppConfig() {
        this.appName = "Hệ thống Quản lý Tiki";
        this.version = "v1.0.0";
        this.logLevel = "DEBUG";

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class) {
                if (instance == null) {
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    public static void setInstance(AppConfig instance) {
        AppConfig.instance = instance;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }
}
