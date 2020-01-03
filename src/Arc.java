public class Arc {
    private Integer s;
    private Integer ac;
    private Integer acc;
    private String from;
    private String to;

    public Arc(){

    }
    public Arc(Integer s,Integer ac,Integer acc, String from, String to){
        this.s=s;
        this.ac=ac;
        this.acc=acc;
        this.from = from;
        this.to = to;
    }

    public Integer getS() {
        return s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getAcc() {
        return acc;
    }

    public void setAcc(Integer acc) {
        this.acc = acc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
