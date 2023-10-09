package solution;

import org.jetbrains.annotations.NotNull;

public class PrimeInfo implements Comparable<PrimeInfo> {

    private Integer num;
    private Long threadId;
    private Long calculateMills;

    @Override
    public String toString() {
        return "PrimeInfo{" +
                "num=" + num +
                ", threadId=" + threadId +
                ", calculateMills=" + calculateMills +
                '}';
    }


    public PrimeInfo(Integer num, Long threadId, Long calculateMills) {
        this.num = num;
        this.threadId = threadId;
        this.calculateMills = calculateMills;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public Long getCulculateMills() {
        return calculateMills;
    }

    public void setCulculateMills(Long calculateMills) {
        this.calculateMills = calculateMills;
    }

    @Override
    public int compareTo(@NotNull PrimeInfo o) {
        return this.num - o.getNum();
    }
}
