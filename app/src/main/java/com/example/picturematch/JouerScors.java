package com.example.picturematch;

public class JouerScors {
    public int id,theme;
    public String name,scor,niveau, prenom,mail,login,password;


    public int age;

    public JouerScors(String niveau, String name, String prenom, String scor) {

        this.id = id;
        this.name = name;
        this.prenom = prenom;
        this.niveau = niveau;
        this.theme = theme;


        this.mail = mail;
        this.scor = scor;
        this.login = login;
        this.password = password;

    }

    public int getId() {
        return id;
    }

    public String getScor() {
        return scor;
    }

    public String getNiveau() {
        return niveau;
    }

    public int getTheme() {
        return theme;
    }

    public String getName() {
        return name;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setScor(String scor) {
        this.scor = scor;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
