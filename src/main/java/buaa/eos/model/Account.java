package buaa.eos.model;

import javax.persistence.*;

public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String account_name;

    private Integer head_block_num;

    private String head_block_time;

    private String privileged;

    private String last_code_update;

    private String created;

    private Float ram_quota;

    private Float net_weight;

    private Float cpu_weight;

    private String net_limit;

    private String cpu_limit;

    private Float ram_usage;

    private String permissions;

    private String total_resources;

    private String self_delegated_bandwidth;

    private String refund_request;

    private String voter_info;

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
     * @return account_name
     */
    public String getAccount_name() {
        return account_name;
    }

    /**
     * @param account_name
     */
    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    /**
     * @return head_block_num
     */
    public Integer getHead_block_num() {
        return head_block_num;
    }

    /**
     * @param head_block_num
     */
    public void setHead_block_num(Integer head_block_num) {
        this.head_block_num = head_block_num;
    }

    /**
     * @return head_block_time
     */
    public String getHead_block_time() {
        return head_block_time;
    }

    /**
     * @param head_block_time
     */
    public void setHead_block_time(String head_block_time) {
        this.head_block_time = head_block_time;
    }

    /**
     * @return privileged
     */
    public String getPrivileged() {
        return privileged;
    }

    /**
     * @param privileged
     */
    public void setPrivileged(String privileged) {
        this.privileged = privileged;
    }

    /**
     * @return last_code_update
     */
    public String getLast_code_update() {
        return last_code_update;
    }

    /**
     * @param last_code_update
     */
    public void setLast_code_update(String last_code_update) {
        this.last_code_update = last_code_update;
    }

    /**
     * @return created
     */
    public String getCreated() {
        return created;
    }

    /**
     * @param created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * @return ram_quota
     */
    public Float getRam_quota() {
        return ram_quota;
    }

    /**
     * @param ram_quota
     */
    public void setRam_quota(Float ram_quota) {
        this.ram_quota = ram_quota;
    }

    /**
     * @return net_weight
     */
    public Float getNet_weight() {
        return net_weight;
    }

    /**
     * @param net_weight
     */
    public void setNet_weight(Float net_weight) {
        this.net_weight = net_weight;
    }

    /**
     * @return cpu_weight
     */
    public Float getCpu_weight() {
        return cpu_weight;
    }

    /**
     * @param cpu_weight
     */
    public void setCpu_weight(Float cpu_weight) {
        this.cpu_weight = cpu_weight;
    }

    /**
     * @return net_limit
     */
    public String getNet_limit() {
        return net_limit;
    }

    /**
     * @param net_limit
     */
    public void setNet_limit(String net_limit) {
        this.net_limit = net_limit;
    }

    /**
     * @return cpu_limit
     */
    public String getCpu_limit() {
        return cpu_limit;
    }

    /**
     * @param cpu_limit
     */
    public void setCpu_limit(String cpu_limit) {
        this.cpu_limit = cpu_limit;
    }

    /**
     * @return ram_usage
     */
    public Float getRam_usage() {
        return ram_usage;
    }

    /**
     * @param ram_usage
     */
    public void setRam_usage(Float ram_usage) {
        this.ram_usage = ram_usage;
    }

    /**
     * @return permissions
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /**
     * @return total_resources
     */
    public String getTotal_resources() {
        return total_resources;
    }

    /**
     * @param total_resources
     */
    public void setTotal_resources(String total_resources) {
        this.total_resources = total_resources;
    }

    /**
     * @return self_delegated_bandwidth
     */
    public String getSelf_delegated_bandwidth() {
        return self_delegated_bandwidth;
    }

    /**
     * @param self_delegated_bandwidth
     */
    public void setSelf_delegated_bandwidth(String self_delegated_bandwidth) {
        this.self_delegated_bandwidth = self_delegated_bandwidth;
    }

    /**
     * @return refund_request
     */
    public String getRefund_request() {
        return refund_request;
    }

    /**
     * @param refund_request
     */
    public void setRefund_request(String refund_request) {
        this.refund_request = refund_request;
    }

    /**
     * @return voter_info
     */
    public String getVoter_info() {
        return voter_info;
    }

    /**
     * @param voter_info
     */
    public void setVoter_info(String voter_info) {
        this.voter_info = voter_info;
    }
}