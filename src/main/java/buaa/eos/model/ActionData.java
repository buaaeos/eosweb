package buaa.eos.model;

import javax.persistence.*;

@Table(name = "action_data")
public class ActionData extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String from_;

    private String to_;

    private String quantity;

    private Integer action_id;

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
     * @return from_
     */
    public String getFrom_() {
        return from_;
    }

    /**
     * @param from_
     */
    public void setFrom_(String from_) {
        this.from_ = from_;
    }

    /**
     * @return to_
     */
    public String getTo_() {
        return to_;
    }

    /**
     * @param to_
     */
    public void setTo_(String to_) {
        this.to_ = to_;
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
     * @return action_id
     */
    public Integer getAction_id() {
        return action_id;
    }

    /**
     * @param action_id
     */
    public void setAction_id(Integer action_id) {
        this.action_id = action_id;
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