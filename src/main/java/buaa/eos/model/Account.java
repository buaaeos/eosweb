package buaa.eos.model;

import javax.persistence.*;

public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "account_name")
    private String accountName;

    @Column(name = "head_block_num")
    private Integer headBlockNum;

    @Column(name = "head_block_time")
    private String headBlockTime;

    private String privileged;

    @Column(name = "last_code_update")
    private String lastCodeUpdate;

    private String created;

    @Column(name = "ram_quota")
    private Float ramQuota;

    @Column(name = "net_weight")
    private Float netWeight;

    @Column(name = "cpu_weight")
    private Float cpuWeight;

    @Column(name = "net_used")
    private Float netUsed;

    @Column(name = "net_available")
    private Float netAvailable;

    @Column(name = "net_max")
    private Float netMax;

    @Column(name = "cpu_used")
    private Float cpuUsed;

    @Column(name = "cpu_available")
    private Float cpuAvailable;

    @Column(name = "cpu_max")
    private Float cpuMax;

    @Column(name = "ram_usage")
    private Float ramUsage;

    @Column(name = "self_del_from")
    private String selfDelFrom;

    @Column(name = "self_del_to")
    private String selfDelTo;

    @Column(name = "self_del_net")
    private Float selfDelNet;

    @Column(name = "self_del_cpu")
    private Float selfDelCpu;

    @Column(name = "refund_request")
    private String refundRequest;

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
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * @return head_block_num
     */
    public Integer getHeadBlockNum() {
        return headBlockNum;
    }

    /**
     * @param headBlockNum
     */
    public void setHeadBlockNum(Integer headBlockNum) {
        this.headBlockNum = headBlockNum;
    }

    /**
     * @return head_block_time
     */
    public String getHeadBlockTime() {
        return headBlockTime;
    }

    /**
     * @param headBlockTime
     */
    public void setHeadBlockTime(String headBlockTime) {
        this.headBlockTime = headBlockTime;
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
    public String getLastCodeUpdate() {
        return lastCodeUpdate;
    }

    /**
     * @param lastCodeUpdate
     */
    public void setLastCodeUpdate(String lastCodeUpdate) {
        this.lastCodeUpdate = lastCodeUpdate;
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
    public Float getRamQuota() {
        return ramQuota;
    }

    /**
     * @param ramQuota
     */
    public void setRamQuota(Float ramQuota) {
        this.ramQuota = ramQuota;
    }

    /**
     * @return net_weight
     */
    public Float getNetWeight() {
        return netWeight;
    }

    /**
     * @param netWeight
     */
    public void setNetWeight(Float netWeight) {
        this.netWeight = netWeight;
    }

    /**
     * @return cpu_weight
     */
    public Float getCpuWeight() {
        return cpuWeight;
    }

    /**
     * @param cpuWeight
     */
    public void setCpuWeight(Float cpuWeight) {
        this.cpuWeight = cpuWeight;
    }

    /**
     * @return net_used
     */
    public Float getNetUsed() {
        return netUsed;
    }

    /**
     * @param netUsed
     */
    public void setNetUsed(Float netUsed) {
        this.netUsed = netUsed;
    }

    /**
     * @return net_available
     */
    public Float getNetAvailable() {
        return netAvailable;
    }

    /**
     * @param netAvailable
     */
    public void setNetAvailable(Float netAvailable) {
        this.netAvailable = netAvailable;
    }

    /**
     * @return net_max
     */
    public Float getNetMax() {
        return netMax;
    }

    /**
     * @param netMax
     */
    public void setNetMax(Float netMax) {
        this.netMax = netMax;
    }

    /**
     * @return cpu_used
     */
    public Float getCpuUsed() {
        return cpuUsed;
    }

    /**
     * @param cpuUsed
     */
    public void setCpuUsed(Float cpuUsed) {
        this.cpuUsed = cpuUsed;
    }

    /**
     * @return cpu_available
     */
    public Float getCpuAvailable() {
        return cpuAvailable;
    }

    /**
     * @param cpuAvailable
     */
    public void setCpuAvailable(Float cpuAvailable) {
        this.cpuAvailable = cpuAvailable;
    }

    /**
     * @return cpu_max
     */
    public Float getCpuMax() {
        return cpuMax;
    }

    /**
     * @param cpuMax
     */
    public void setCpuMax(Float cpuMax) {
        this.cpuMax = cpuMax;
    }

    /**
     * @return ram_usage
     */
    public Float getRamUsage() {
        return ramUsage;
    }

    /**
     * @param ramUsage
     */
    public void setRamUsage(Float ramUsage) {
        this.ramUsage = ramUsage;
    }

    /**
     * @return self_del_from
     */
    public String getSelfDelFrom() {
        return selfDelFrom;
    }

    /**
     * @param selfDelFrom
     */
    public void setSelfDelFrom(String selfDelFrom) {
        this.selfDelFrom = selfDelFrom;
    }

    /**
     * @return self_del_to
     */
    public String getSelfDelTo() {
        return selfDelTo;
    }

    /**
     * @param selfDelTo
     */
    public void setSelfDelTo(String selfDelTo) {
        this.selfDelTo = selfDelTo;
    }

    /**
     * @return self_del_net
     */
    public Float getSelfDelNet() {
        return selfDelNet;
    }

    /**
     * @param selfDelNet
     */
    public void setSelfDelNet(Float selfDelNet) {
        this.selfDelNet = selfDelNet;
    }

    /**
     * @return self_del_cpu
     */
    public Float getSelfDelCpu() {
        return selfDelCpu;
    }

    /**
     * @param selfDelCpu
     */
    public void setSelfDelCpu(Float selfDelCpu) {
        this.selfDelCpu = selfDelCpu;
    }

    /**
     * @return refund_request
     */
    public String getRefundRequest() {
        return refundRequest;
    }

    /**
     * @param refundRequest
     */
    public void setRefundRequest(String refundRequest) {
        this.refundRequest = refundRequest;
    }
}