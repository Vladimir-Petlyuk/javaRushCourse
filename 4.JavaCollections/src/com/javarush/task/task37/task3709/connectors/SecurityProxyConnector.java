package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * Created by Владимир on 04.11.2017.
 */
public class SecurityProxyConnector implements Connector {
    public SimpleConnector simpleConnector;
    public SecurityChecker securityChecker;

    public SecurityProxyConnector(String string){
        this.simpleConnector=new SimpleConnector(string);
        this.securityChecker=new SecurityCheckerImpl();
    }


    @Override
    public void connect() {
        if(securityChecker.performSecurityCheck())
            simpleConnector.connect();
    }
}
