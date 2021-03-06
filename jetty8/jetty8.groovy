import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.*
import groovy.servlet.*

@Grapes([
    @Grab('org.eclipse.jetty:jetty-server:8.1.8.v20121106'),
    @Grab('org.eclipse.jetty:jetty-servlet:8.1.8.v20121106'),
    @Grab('javax.servlet:javax.servlet-api:3.0.1'),
    @GrabExclude('org.eclipse.jetty.orbit:javax.servlet')
])

def startJetty() {
    def jetty = new Server(9090)

    def context = new ServletContextHandler(jetty, '/', ServletContextHandler.SESSIONS)  // Allow sessions.
    context.resourceBase = '.'  // Look in current dir for Groovy scripts.
    context.addServlet(GroovyServlet, '*.groovy')  // All files ending with .groovy will be served.
    context.setAttribute('version', '1.0')  // Set an context attribute.

    jetty.start()
}

println "Starting Jetty, press Ctrl+C to stop."
startJetty()
