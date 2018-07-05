package buaa.eos.model;

import javax.persistence.*;

public class Permission extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String perm_name;

    private String parent;

    private String required_auth;

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
     * @return required_auth
     */
    public String getRequired_auth() {
        return required_auth;
    }

    /**
     * @param required_auth
     */
    public void setRequired_auth(String required_auth) {
        this.required_auth = required_auth;
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