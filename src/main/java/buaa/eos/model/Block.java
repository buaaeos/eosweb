package buaa.eos.model;

import java.util.Date;
import javax.persistence.*;
import  java.util.List;
public class Block extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blk_id;

    private String id;

    private Date timestamp;

    private String previous;

    private String transaction_mroot;

    private String action_mroot;

    private Integer schedule_version;

    private String new_producers;

    private String producer_signature;

    private Integer block_num;

    private Long ref_block_prefix;

    private List<String> header_extensions;

    private Integer comfirmed;

    private List<String> transactions;

    /**
     * @return blk_id
     */
    public Integer getBlk_id() {
        return blk_id;
    }

    /**
     * @param blk_id
     */
    public void setBlk_id(Integer blk_id) {
        this.blk_id = blk_id;
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
     * @return timestamp
     */
    public Date getTimestamp() {
        return timestamp;
    }

    /**
     * @param timestamp
     */
    public void setTimestamp(Date timestamp) {
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
    public String getTransaction_mroot() {
        return transaction_mroot;
    }

    /**
     * @param transaction_mroot
     */
    public void setTransaction_mroot(String transaction_mroot) {
        this.transaction_mroot = transaction_mroot;
    }

    /**
     * @return action_mroot
     */
    public String getAction_mroot() {
        return action_mroot;
    }

    /**
     * @param action_mroot
     */
    public void setAction_mroot(String action_mroot) {
        this.action_mroot = action_mroot;
    }

    /**
     * @return schedule_version
     */
    public Integer getSchedule_version() {
        return schedule_version;
    }

    /**
     * @param schedule_version
     */
    public void setSchedule_version(Integer schedule_version) {
        this.schedule_version = schedule_version;
    }

    /**
     * @return new_producers
     */
    public String getNew_producers() {
        return new_producers;
    }

    /**
     * @param new_producers
     */
    public void setNew_producers(String new_producers) {
        this.new_producers = new_producers;
    }

    /**
     * @return producer_signature
     */
    public String getProducer_signature() {
        return producer_signature;
    }

    /**
     * @param producer_signature
     */
    public void setProducer_signature(String producer_signature) {
        this.producer_signature = producer_signature;
    }

    /**
     * @return block_num
     */
    public Integer getBlock_num() {
        return block_num;
    }

    /**
     * @param block_num
     */
    public void setBlock_num(Integer block_num) {
        this.block_num = block_num;
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
     * @return header_extensions
     */
    public List<String> getHeader_extensions() {
        return header_extensions;
    }

    /**
     * @param header_extensions
     */
    public void setHeader_extensions(List<String> header_extensions) {
        this.header_extensions = header_extensions;
    }

    /**
     * @return comfirmed
     */
    public Integer getComfirmed() {
        return comfirmed;
    }

    /**
     * @param comfirmed
     */
    public void setComfirmed(Integer comfirmed) {
        this.comfirmed = comfirmed;
    }

    /**
     * @return transactions
     */
    public List<String> getTransactions() {
        return transactions;
    }

    /**
     * @param transactions
     */
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
}