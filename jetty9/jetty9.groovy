#!/usr/bin/env groovy
 
@Grapes([
    @Grab('org.eclipse.jetty:jetty-server:9.0.0.M5'),
 @Grab('org.eclipse.jetty:jetty-servlet:9.0.0.M5'),
 @Grab('javax.servlet:javax.servlet-api:3.0.1'),
 @GrabExclude('org.eclipse.jetty.orbit:javax.servlet:3.0.0.v201112011016'),
 @GrabConfig(systemClassLoader=true)
])
 
 
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import groovy.servlet.*
 
def startJetty() {
    def server = new Server(8080)
    def context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
 // Look in current dir for Groovy scripts.
    context.resourceBase = '.'  
 // All files ending with .groovy will be served.
    context.addServlet(GroovyServlet, '*.groovy')  
 // Handle gsp files
 context.addServlet(TemplateServlet, "*.gsp") 
 // Set an context attribute.
    context.setAttribute('version', '1.0')  
    server.start()
 }
 
startJetty()

