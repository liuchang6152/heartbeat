package com.liuchang.heartbeat.entity.bc;

/**
 * @ Author     ：liuchang
 * @ Date       ：Created in 15:30 2019/8/12
 * @ Description：邮件实体
 * @ Modified By：
 */
public class MailEntity {
   private String title;
   private String url;
   private String email;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public static void main(String[] args) {
//        String tel = "tel:13785663683;";
//        tel = tel.substring(0,tel.length()-1);
//        System.out.println(tel);
//    }
}
