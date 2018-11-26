package restaurant;

import logger.*;


public interface Operation {
    final Logger logger = LoggerFactory.getLogger(new FileLogger("Operation"), new ContextualLogger("Operation", new ConsoleLogger("Operation")));

    void launchOp();
    String name();
    String instruction();

}
