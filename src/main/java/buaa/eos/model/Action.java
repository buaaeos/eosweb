package buaa.eos.model;

import javax.persistence.*;

public class Action extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String account;

    private String name;

    private String authorization;

    private String data;

    private Integer trx_id;

    private String hex_data;

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
     * @return account
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return authorization
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * @param authorization
     */
    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    /**
     * @return data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return trx_id
     */
    public Integer getTrx_id() {
        return trx_id;
    }

    /**
     * @param trx_id
     */
    public void setTrx_id(Integer trx_id) {
        this.trx_id = trx_id;
    }

    /**
     * @return hex_data
     */
    public String getHex_data() {
        return hex_data;
    }

    /**
     * @param hex_data
     */
    public void setHex_data(String hex_data) {
        this.hex_data = hex_data;
    }
}