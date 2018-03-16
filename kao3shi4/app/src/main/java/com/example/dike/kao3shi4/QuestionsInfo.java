package com.example.dike.kao3shi4;

import java.util.List;

/**
 * Created by dik on 2018/3/13.
 */

public class QuestionsInfo {
    private String message;
    private List<QuestionsInfo.Question> data;


    public class Question {

        private String question;
        private String uuid;
        private String answerid;
        private String type;
        private int readcount;
        private int rightcount;
        private int errorcount;
        private String explain;

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }



        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getAnswerid() {
            return answerid;
        }

        public void setAnswerid(String answerid) {
            this.answerid = answerid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getReadcount() {
            return readcount;
        }

        public void setReadcount(int readcount) {
            this.readcount = readcount;
        }

        public int getRightcount() {
            return rightcount;
        }

        public void setRightcount(int rightcount) {
            this.rightcount = rightcount;
        }

        public int getErrorcount() {
            return errorcount;
        }

        public void setErrorcount(int errorcount) {
            this.errorcount = errorcount;
        }

        public List<OptonInfo> getOptons() {
            return optons;
        }

        public void setOptons(List<OptonInfo> optons) {
            this.optons = optons;
        }

        private List<QuestionsInfo.Question.OptonInfo> optons;

        public class OptonInfo {

            private String context;
            private String uuid;

            public String getContext() {
                return context;
            }

            public void setContext(String context) {
                this.context = context;
            }

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }
        }
    }


    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public List<Question> getData() {
        return data;
    }

    public void setData(List<Question> data) {
        this.data = data;
    }
}
