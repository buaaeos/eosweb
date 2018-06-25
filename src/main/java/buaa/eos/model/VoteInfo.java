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

    @Column(name = "last_vote_weight")
    private Float lastVoteWeight;

    @Column(name = "proxied_vote_weight")
    private Float proxiedVoteWeight;

    @Column(name = "is_proxy")
    private Short isProxy;

    @Column(name = "deferred_trx_id")
    private Integer deferredTrxId;

    @Column(name = "last_unstake_time")
    private String lastUnstakeTime;

    private String unstaking;

    @Column(name = "owner_id")
    private Integer ownerId;

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
    public Float getLastVoteWeight() {
        return lastVoteWeight;
    }

    /**
     * @param lastVoteWeight
     */
    public void setLastVoteWeight(Float lastVoteWeight) {
        this.lastVoteWeight = lastVoteWeight;
    }

    /**
     * @return proxied_vote_weight
     */
    public Float getProxiedVoteWeight() {
        return proxiedVoteWeight;
    }

    /**
     * @param proxiedVoteWeight
     */
    public void setProxiedVoteWeight(Float proxiedVoteWeight) {
        this.proxiedVoteWeight = proxiedVoteWeight;
    }

    /**
     * @return is_proxy
     */
    public Short getIsProxy() {
        return isProxy;
    }

    /**
     * @param isProxy
     */
    public void setIsProxy(Short isProxy) {
        this.isProxy = isProxy;
    }

    /**
     * @return deferred_trx_id
     */
    public Integer getDeferredTrxId() {
        return deferredTrxId;
    }

    /**
     * @param deferredTrxId
     */
    public void setDeferredTrxId(Integer deferredTrxId) {
        this.deferredTrxId = deferredTrxId;
    }

    /**
     * @return last_unstake_time
     */
    public String getLastUnstakeTime() {
        return lastUnstakeTime;
    }

    /**
     * @param lastUnstakeTime
     */
    public void setLastUnstakeTime(String lastUnstakeTime) {
        this.lastUnstakeTime = lastUnstakeTime;
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
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * @param ownerId
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }
}