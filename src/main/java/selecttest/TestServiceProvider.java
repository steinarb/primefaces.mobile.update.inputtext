package selecttest;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.ServletException;

import org.ops4j.pax.web.service.WebContainer;
import org.osgi.service.http.HttpContext;
import org.osgi.service.http.NamespaceException;

public class TestServiceProvider implements Provider<TestService>, TestService {

    private WebContainer webContainer;
    private HttpContext httpContext;

    @Inject
    public void setWebContainer(WebContainer webcontainer) throws ClassNotFoundException, ServletException, NamespaceException {
        webContainer = webcontainer;
        httpContext = webContainer.createDefaultHttpContext();

        // register images as resources
        webContainer.registerResources("/images", "/images", httpContext);
    }

    public String message() {
        // TODO Auto-generated method stub
        return "TestService started";
    }

    public TestService get() {
        return this;
    }

}
