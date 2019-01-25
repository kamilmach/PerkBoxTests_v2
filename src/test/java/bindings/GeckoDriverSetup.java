package bindings;

class GeckoDriverSetup {

    private static String OS = System.getProperty("os.name").toLowerCase();
    private static boolean isWindows() {

        return (OS.contains("win"));

    }

    private static boolean isMac() {

        return (OS.contains("mac"));

    }

    private static boolean isUnix() {

        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));

    }

    static String getPathToDriver()
    {
        String path = "";
        if (isWindows()) {
            path = "src/main/resources/win/geckodriver.exe";
        } else if (isMac()) {
            path = "src/main/resources/mac/geckodriver";
        } else if (isUnix()) {
            path = "src/main/resources/lin64/geckodriver";
        }
          else {
            System.out.println("Your OS is not support!!");
        }
          return path;
    }


}
