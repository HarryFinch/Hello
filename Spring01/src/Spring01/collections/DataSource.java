package Spring01.collections;

import java.util.Properties;

/**
 * @author Harold
 * @Date 2020/5/26
 * @Description :
 */
public class DataSource {

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "properties=" + properties +
                '}';
    }
}
