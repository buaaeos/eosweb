package buaa.eos.model;

import javax.persistence.*;

@Table(name = "vote_info")
public class VoteInfo extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String owner;

    private String proxy;

    private String producers;

    private Float staked;

    private Float last_vote_weight;

    private Float proxied_vote_weight;

    private Short is_proxy;

    private Integer deferred_trx_id;

    private String last_unstake_time;

    private String unstaking;

    private Integer owner_id;

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
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return proxy
     */
    public String getProxy() {
        return proxy;
    }

    /**
     * @param proxy
     */
    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    /**
     * @return producers
     */
    public String getProducers() {
        return producers;
    }

    /**
     * @param producers
     */
    public void setProducers(String producers) {
        this.producers = producers;
    }

    /**
     * @return staked
     */
    public Float getStaked() {
        return staked;
    }

    /**
     * @param staked
     */
    public void setStaked(Float staked) {
        this.staked = staked;
    }

    /**
     * @return last_vote_weight
     */
    public Float getLast_vote_weight() {
        return last_vote_weight;
    }

    /**
     * @param last_vote_weight
     */
    public void setLast_vote_weight(Float last_vote_weight) {
        this.last_vote_weight = last_vote_weight;
    }

    /**
     * @return proxied_vote_weight
     */
    public Float getProxied_vote_weight() {
        return proxied_vote_weight;
    }

    /**
     * @param proxied_vote_weight
     */
    public void setProxied_vote_weight(Float proxied_vote_weight) {
        this.proxied_vote_weight = proxied_vote_weight;
    }

    /**
     * @return is_proxy
     */
    public Short getIs_proxy() {
        return is_proxy;
    }

    /**
     * @param is_proxy
     */
    public void setIs_proxy(Short is_proxy) {
        this.is_proxy = is_proxy;
    }

    /**
     * @return deferred_trx_id
     */
    public Integer getDeferred_trx_id() {
        return deferred_trx_id;
    }

    /**
     * @param deferred_trx_id
     */
    public void setDeferred_trx_id(Integer deferred_trx_id) {
        this.deferred_trx_id = deferred_trx_id;
    }

    /**
     * @return last_unstake_time
     */
    public String getLast_unstake_time() {
        return last_unstake_time;
    }

    /**
     * @param last_unstake_time
     */
    public void setLast_unstake_time(String last_unstake_time) {
        this.last_unstake_time = last_unstake_time;
    }

    /**
     * @return unstaking
     */
    public String getUnstaking() {
        return unstaking;
    }

    /**
     * @param unstaking
     */
    public void setUnstaking(String unstaking) {
        this.unstaking = unstaking;
    }

    /**
     * @return owner_id
     */
    public Integer getOwner_id() {
        return owner_id;
    }

    /**
     * @param owner_id
     */
    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }
}