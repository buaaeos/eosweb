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

    private String memo;

    @Column(name = "trx_id")
    private String trxId;

    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "action_id")
    private String actionId;

    @Column(name = "hex_data")
    private String hexData;

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

    /**
     * @return trx_id
     */
    public String getTrxId() {
        return trxId;
    }

    /**
     * @param trxId
     */
    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    /**
     * @return account_id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * @param accountId
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * @return action_id
     */
    public String getActionId() {
        return actionId;
    }

    /**
     * @param actionId
     */
    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    /**
     * @return hex_data
     */
    public String getHexData() {
        return hexData;
    }

    /**
     * @param hexData
     */
    public void setHexData(String hexData) {
        this.hexData = hexData;
    }
}