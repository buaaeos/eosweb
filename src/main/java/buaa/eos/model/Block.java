package buaa.eos.model;

import javax.persistence.*;

public class Block extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "blk_id")
    private String blkId;

    private String timestamp;

    private String previous;

    @Column(name = "transaction_mroot")
    private String transactionMroot;

    @Column(name = "action_mroot")
    private String actionMroot;

    @Column(name = "schedule_version")
    private Integer scheduleVersion;

    @Column(name = "new_producers")
    private String newProducers;

    @Column(name = "block_num")
    private Integer blockNum;

    @Column(name = "ref_block_prefix")
    private Long refBlockPrefix;

    @Column(name = "producer_signature")
    private String producerSignature;

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
     * @return blk_id
     */
    public String getBlkId() {
        return blkId;
    }

    /**
     * @param blkId
     */
    public void setBlkId(String blkId) {
        this.blkId = blkId;
    }

    /**
     * @return timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * @return previous
     */
    public String getPrevious() {
        return previous;
    }

    /**
     * @param previous
     */
    public void setPrevious(String previous) {
        this.previous = previous;
    }

    /**
     * @return transaction_mroot
     */
    public String getTransactionMroot() {
        return transactionMroot;
    }

    /**
     * @param transactionMroot
     */
    public void setTransactionMroot(String transactionMroot) {
        this.transactionMroot = transactionMroot;
    }

    /**
     * @return action_mroot
     */
    public String getActionMroot() {
        return actionMroot;
    }

    /**
     * @param actionMroot
     */
    public void setActionMroot(String actionMroot) {
        this.actionMroot = actionMroot;
    }

    /**
     * @return schedule_version
     */
    public Integer getScheduleVersion() {
        return scheduleVersion;
    }

    /**
     * @param scheduleVersion
     */
    public void setScheduleVersion(Integer scheduleVersion) {
        this.scheduleVersion = scheduleVersion;
    }

    /**
     * @return new_producers
     */
    public String getNewProducers() {
        return newProducers;
    }

    /**
     * @param newProducers
     */
    public void setNewProducers(String newProducers) {
        this.newProducers = newProducers;
    }

    /**
     * @return block_num
     */
    public Integer getBlockNum() {
        return blockNum;
    }

    /**
     * @param blockNum
     */
    public void setBlockNum(Integer blockNum) {
        this.blockNum = blockNum;
    }

    /**
     * @return ref_block_prefix
     */
    public Long getRefBlockPrefix() {
        return refBlockPrefix;
    }

    /**
     * @param refBlockPrefix
     */
    public void setRefBlockPrefix(Long refBlockPrefix) {
        this.refBlockPrefix = refBlockPrefix;
    }

    /**
     * @return producer_signature
     */
    public String getProducerSignature() {
        return producerSignature;
    }

    /**
     * @param producerSignature
     */
    public void setProducerSignature(String producerSignature) {
        this.producerSignature = producerSignature;
    }
}