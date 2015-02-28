package com.matafe.jeewebapp.client.main;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.matafe.jeewebapp.core.bussiness.IMyFacadeBeanRemote;

/**
 * Verificar
 * <ul>
 * <li>Se o arquivo jboss-ejb-client.properties esta no classpath do client</li>
 * </ul>
 * 
 * @author Mauricio Tavares Ferraz
 */
public class EJBClient {

	public static void main(String[] args) throws Exception {
		
		 // Let's lookup the remote stateless facade bean
        final IMyFacadeBeanRemote facade = lookupRemoteStatelessBean();
        System.out.println("Obtained a remote stateless facade for invocation");
        // invoke on the remote calculator
        System.out.println(facade.getMessage("Hello from Remote Client"));
	}
	
    /**
     * Looks up and returns the proxy to remote stateless bean
     * 
     * @return The proxy.
     * 
     * @throws NamingException
     */
    private static IMyFacadeBeanRemote lookupRemoteStatelessBean() throws NamingException {
    	
        final Hashtable<String, String> jndiProperties = new Hashtable<>();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        // The JNDI lookup name for a stateless session bean has the syntax of:
        // ejb:<appName>/<moduleName>/<distinctName>/<beanName>!<viewClassName>
        //
        // <appName> The application name is the name of the EAR that the EJB is deployed in
        // (without the .ear). If the EJB JAR is not deployed in an EAR then this is
        // blank. The app name can also be specified in the EAR's application.xml
        //
        // <moduleName> By the default the module name is the name of the EJB JAR file (without the
        // .jar suffix). The module name might be overridden in the ejb-jar.xml
        //
        // <distinctName> : WildFly allows each deployment to have an (optional) distinct name.
        // This example does not use this so leave it blank.
        //
        // <beanName> : The name of the session been to be invoked.
        //
        // <viewClassName>: The fully qualified classname of the remote interface. Must include
        // the whole package name.

        // let's do the lookup
        return (IMyFacadeBeanRemote) context.lookup("ejb:/jeewebapp/MyFacadeBean!"
                + IMyFacadeBeanRemote.class.getName());
    }
}
