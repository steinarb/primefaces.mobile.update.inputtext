package selecttest;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("jobConverter")
public class JobConverter implements Converter {
    private static Map<String, Job> registry = new HashMap<String, Job>();

    public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {
        return registry.get(value);
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) throws ConverterException {
        if (value == null || "".equals(value)) {
            return null;
        }

        if (value.getClass() != Job.class) {
            throw new ConverterException("Object value was not a Job, but an instance of " + value.getClass().getSimpleName() + "  \"" + value.toString() + "\"");
        }

        return value.toString();
    }

    public static void registerJob(Job job) {
        registry.put(job.toString(), job);
    }

}
