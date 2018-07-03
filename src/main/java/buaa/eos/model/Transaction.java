package buaa.eos.model;

import javax.persistence.*;

public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trx_id;

    private String id;

    private String compression;

    private String packed_trx;

    private String expiration;

    private Integer ref_block_num;

    private Long ref_block_prefix;

    private Integer max_net_usage_words;

    private Integer max_cpu_usage_ms;

    private Integer delay_sec;

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
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return compression
     */
    public String getCompression() {
        return compression;
    }

    /**
     * @param compression
     */
    public void setCompression(String compression) {
        this.compression = compression;
    }

    /**
     * @return packed_trx
     */
    public String getPacked_trx() {
        return packed_trx;
    }

    /**
     * @param packed_trx
     */
    public void setPacked_trx(String packed_trx) {
        this.packed_trx = packed_trx;
    }

    /**
     * @return expiration
     */
    public String getExpiration() {
        return expiration;
    }

    /**
     * @param expiration
     */
    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    /**
     * @return ref_block_num
     */
    public Integer getRef_block_num() {
        return ref_block_num;
    }

    /**
     * @param ref_block_num
     */
    public void setRef_block_num(Integer ref_block_num) {
        this.ref_block_num = ref_block_num;
    }

    /**
     * @return ref_block_prefix
     */
    public Long getRef_block_prefix() {
        return ref_block_prefix;
    }

    /**
     * @param ref_block_prefix
     */
    public void setRef_block_prefix(Long ref_block_prefix) {
        this.ref_block_prefix = ref_block_prefix;
    }

    /**
     * @return max_net_usage_words
     */
    public Integer getMax_net_usage_words() {
        return max_net_usage_words;
    }

    /**
     * @param max_net_usage_words
     */
    public void setMax_net_usage_words(Integer max_net_usage_words) {
        this.max_net_usage_words = max_net_usage_words;
    }

    /**
     * @return max_cpu_usage_ms
     */
    public Integer getMax_cpu_usage_ms() {
        return max_cpu_usage_ms;
    }

    /**
     * @param max_cpu_usage_ms
     */
    public void setMax_cpu_usage_ms(Integer max_cpu_usage_ms) {
        this.max_cpu_usage_ms = max_cpu_usage_ms;
    }

    /**
     * @return delay_sec
     */
    public Integer getDelay_sec() {
        return delay_sec;
    }

    /**
     * @param delay_sec
     */
    public void setDelay_sec(Integer delay_sec) {
        this.delay_sec = delay_sec;
    }
}