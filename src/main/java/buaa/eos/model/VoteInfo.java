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

    private Long staked;

    private String last_vote_weight;

    private String proxied_vote_weight;

    private Integer is_proxy;

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
    public Long getStaked() {
        return staked;
    }

    /**
     * @param staked
     */
    public void setStaked(Long staked) {
        this.staked = staked;
    }

    /**
     * @return last_vote_weight
     */
    public String getLast_vote_weight() {
        return last_vote_weight;
    }

    /**
     * @param last_vote_weight
     */
    public void setLast_vote_weight(String last_vote_weight) {
        this.last_vote_weight = last_vote_weight;
    }

    /**
     * @return proxied_vote_weight
     */
    public String getProxied_vote_weight() {
        return proxied_vote_weight;
    }

    /**
     * @param proxied_vote_weight
     */
    public void setProxied_vote_weight(String proxied_vote_weight) {
        this.proxied_vote_weight = proxied_vote_weight;
    }

    /**
     * @return is_proxy
     */
    public Integer getIs_proxy() {
        return is_proxy;
    }

    /**
     * @param is_proxy
     */
    public void setIs_proxy(Integer is_proxy) {
        this.is_proxy = is_proxy;
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