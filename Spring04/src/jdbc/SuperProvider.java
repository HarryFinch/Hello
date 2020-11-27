package jdbc;

/**
 * @author Harold
 * @Date 2020/7/13
 * @Description :
 */
public class SuperProvider {

    private int providerId;
    private String providerName;
    private String providerDesc;

    public SuperProvider() {
    }

    public SuperProvider(int providerId, String providerName, String providerDesc) {
        this.providerId = providerId;
        this.providerName = providerName;
        this.providerDesc = providerDesc;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderDesc() {
        return providerDesc;
    }

    public void setProviderDesc(String providerDesc) {
        this.providerDesc = providerDesc;
    }

    @Override
    public String toString() {
        return "SuperProvider{" +
                "providerId=" + providerId +
                ", providerName='" + providerName + '\'' +
                ", providerDesc='" + providerDesc + '\'' +
                '}';
    }
}
