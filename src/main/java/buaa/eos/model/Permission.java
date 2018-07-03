package buaa.eos.model;

import javax.persistence.*;

public class Permission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String perm_name;

    private String parent;

    private Integer threshold;

    private String key;

    private Float weight;

    private String accounts;

    private String waits;

    private Integer account_id;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return perm_name
     */
    public String getPerm_name() {
        return perm_name;
    }

    /**
     * @param perm_name
     */
    public void setPerm_name(String perm_name) {
        this.perm_name = perm_name;
    }

    /**
     * @return parent
     */
    public String getParent() {
        return parent;
    }

    /**
     * @param parent
     */
    public void setParent(String parent) {
        this.parent = parent;
    }

    /**
     * @return threshold
     */
    public Integer getThreshold() {
        return threshold;
    }

    /**
     * @param threshold
     */
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    /**
     * @return key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return weight
     */
    public Float getWeight() {
        return weight;
    }

    /**
     * @param weight
     */
    public void setWeight(Float weight) {
        this.weight = weight;
    }

    /**
     * @return accounts
     */
    public String getAccounts() {
        return accounts;
    }

    /**
     * @param accounts
     */
    public void setAccounts(String accounts) {
        this.accounts = accounts;
    }

    /**
     * @return waits
     */
    public String getWaits() {
        return waits;
    }

    /**
     * @param waits
     */
    public void setWaits(String waits) {
        this.waits = waits;
    }

    /**
     * @return account_id
     */
    public Integer getAccount_id() {
        return account_id;
    }

    /**
     * @param account_id
     */
    public void setAccount_id(Integer account_id) {
        this.account_id = account_id;
    }
}