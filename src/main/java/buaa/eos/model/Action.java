package buaa.eos.model;

import javax.persistence.*;

public class Action extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String account;

    private String name;

    private String actor;

    private String permission;

    private String from;

    private String to;

    private String quantity;

    private Integer trx_id;

    private String hex_data;

    private Integer account_id;

    private String memo;

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
     * @return actor
     */
    public String getActor() {
        return actor;
    }

    /**
     * @param actor
     */
    public void setActor(String actor) {
        this.actor = actor;
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission;
    }

    /**
     * @return from
     */
    public String getFrom() {
        return from;
    }

    /**
     * @param from
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * @return to
     */
    public String getTo() {
        return to;
    }

    /**
     * @param to
     */
    public void setTo(String to) {
        this.to = to;
    }

    /**
     * @return quantity
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
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

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
}