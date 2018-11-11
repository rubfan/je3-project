package ua.od.game;

import java.util.logging.Level;
import java.util.logging.Logger;

import ua.od.game.config.AppContextConfig;
import org.eclipse.jetty.server.Server;

/**
 * @author ruslang.ramatic
 */
public class ApplicationStarter {
    public static void main(String[] args) throws Exception {
        if (args != null && args.length > 0 && args[0].equals("deploy")) {
            DataBaseDeployer.createDb();
            DataBaseDeployer.deployDb();
        }
        boolean debug = false;

        Server jettyServer = new Server(9090);
        jettyServer.setHandler(new AppContextConfig().getHandlersConfig());
        try {
            jettyServer.start();
            if(debug) jettyServer.dumpStdErr();
            jettyServer.join();
        } catch (Exception e) {
            Logger.getLogger(ApplicationStarter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            jettyServer.destroy();
        }
    }
}
