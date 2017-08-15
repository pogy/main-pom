package com.shigu.main4.spread.vo.active.draw;

/**
 * 类名：DrawPrizePool
 * 类路径：com.shigu.main4.spread.vo.active.draw.DrawPrizePool
 * 创建者：王浩翔
 * 创建时间：2017-08-14 15:38
 * 项目：main-pom
 * 描述：活动奖池
 */
public class DrawPrizePool {
    /**
     * 活动类型
     */
    private Integer activeType;
    /**
     * 活动名称
     */
    private String activeName;
    /**
     * 期次展示
     */
    private Long term;
    /**
     * 期次
     */
    private Long pemId;
    /**
     * 奖品等级
     */
    private Integer rank;
    /**
     * 总奖品数
     */
    private Integer fullNumber;
    /**
     * 当前剩余奖品数
     */
    private Integer currentPrizeNum;
    /**
     * 已发奖品总数
     */
    private Integer distributedNum;
    /**
     * 中奖率
     */
    private Integer hitProbability;
    /**
     * 奖品
     */
    private String prizeGood;

    public Integer getActiveType() {
        return activeType;
    }

    public void setActiveType(Integer activeType) {
        this.activeType = activeType;
    }

    public Long getTerm() {
        return term;
    }

    public void setTerm(Long term) {
        this.term = term;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getFullNumber() {
        return fullNumber;
    }

    public void setFullNumber(Integer fullNumber) {
        this.fullNumber = fullNumber;
    }

    public Integer getCurrentPrizeNum() {
        return currentPrizeNum;
    }

    public void setCurrentPrizeNum(Integer currentPrizeNum) {
        this.currentPrizeNum = currentPrizeNum;
    }

    public Integer getHitProbability() {
        return hitProbability;
    }

    public void setHitProbability(Integer hitProbability) {
        this.hitProbability = hitProbability;
    }

    public String getPrizeGood() {
        return prizeGood;
    }

    public void setPrizeGood(String prize) {
        this.prizeGood = prize;
    }

    public Integer getDistributedNum() {
        return distributedNum;
    }

    public void setDistributedNum(Integer distributedNum) {
        this.distributedNum = distributedNum;
    }

    public Long getPemId() {
        return pemId;
    }

    public void setPemId(Long pemId) {
        this.pemId = pemId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public static class Comparator implements java.util.Comparator{

        /**
         * 比较非空DraaPrizePool，按奖品等级排，一等奖，二等奖...
         * @param o1
         * @param o2
         * @return
         */
        @Override
        public int compare(Object o1, Object o2) {
            DrawPrizePool pool1 = (DrawPrizePool) o1;
            DrawPrizePool pool2 = (DrawPrizePool) o2;
            return pool2.getRank()-pool1.getRank();
        }
    }
}
