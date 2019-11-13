package com.xz.jkzs.entity;

public class TikuListEntity {
    /**
     * question : 未取得驾驶证的学员在道路上学习驾驶技能，下列哪种做法是正确的？
     * option1 : A、使用所学车型的教练车由教练员随车指导
     * option2 : B、使用所学车型的教练车单独驾驶学习
     * option3 : C、使用私家车由教练员随车指导
     * option4 : D、使用所学车型的教练车由非教练员的驾驶人随车指导
     * answer : A
     * explain : 《公安部令第123号》规定：未取得驾驶证的学员在道路上学习驾驶技能，使用所学车型的教练车由教练员随车指导。
     * pic :
     * type : C1,C2,C3
     */

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;
    private String explain;
    private String pic;
    private String type;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
