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

    private Float net_used;

    private Float net_available;

    private Float net_max;

    private Float cpu_used;

    private Float cpu_available;

    private Float cpu_max;

    private Float ram_usage;

    private String self_del_from;

    private String self_del_to;

    private Float self_del_net;

    private Float self_del_cpu;

    private String refund_request;

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
     * @return net_used
     */
    public Float getNet_used() {
        return net_used;
    }

    /**
     * @param net_used
     */
    public void setNet_used(Float net_used) {
        this.net_used = net_used;
    }

    /**
     * @return net_available
     */
    public Float getNet_available() {
        return net_available;
    }

    /**
     * @param net_available
     */
    public void setNet_available(Float net_available) {
        this.net_available = net_available;
    }

    /**
     * @return net_max
     */
    public Float getNet_max() {
        return net_max;
    }

    /**
     * @param net_max
     */
    public void setNet_max(Float net_max) {
        this.net_max = net_max;
    }

    /**
     * @return cpu_used
     */
    public Float getCpu_used() {
        return cpu_used;
    }

    /**
     * @param cpu_used
     */
    public void setCpu_used(Float cpu_used) {
        this.cpu_used = cpu_used;
    }

    /**
     * @return cpu_available
     */
    public Float getCpu_available() {
        return cpu_available;
    }

    /**
     * @param cpu_available
     */
    public void setCpu_available(Float cpu_available) {
        this.cpu_available = cpu_available;
    }

    /**
     * @return cpu_max
     */
    public Float getCpu_max() {
        return cpu_max;
    }

    /**
     * @param cpu_max
     */
    public void setCpu_max(Float cpu_max) {
        this.cpu_max = cpu_max;
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
     * @return self_del_from
     */
    public String getSelf_del_from() {
        return self_del_from;
    }

    /**
     * @param self_del_from
     */
    public void setSelf_del_from(String self_del_from) {
        this.self_del_from = self_del_from;
    }

    /**
     * @return self_del_to
     */
    public String getSelf_del_to() {
        return self_del_to;
    }

    /**
     * @param self_del_to
     */
    public void setSelf_del_to(String self_del_to) {
        this.self_del_to = self_del_to;
    }

    /**
     * @return self_del_net
     */
    public Float getSelf_del_net() {
        return self_del_net;
    }

    /**
     * @param self_del_net
     */
    public void setSelf_del_net(Float self_del_net) {
        this.self_del_net = self_del_net;
    }

    /**
     * @return self_del_cpu
     */
    public Float getSelf_del_cpu() {
        return self_del_cpu;
    }

    /**
     * @param self_del_cpu
     */
    public void setSelf_del_cpu(Float self_del_cpu) {
        this.self_del_cpu = self_del_cpu;
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
}