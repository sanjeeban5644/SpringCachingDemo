package com.sanjeeban.SpringCaching.entities;


import jakarta.persistence.*;

@Entity
@Table(
        name="t_user",
        schema = "brs",
        uniqueConstraints = {
                @UniqueConstraint(name = "uniqueUserIdName",columnNames = {"user_id","user_name"})
        }
)
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="user_id",nullable = false)
        private Long userId;

        @Column(name="user_name",nullable = false,length = 255)
        private String userName;

        @Column(name="fav_genre",nullable = true,length = 100)
        private String favGenre;

        public User() {
        }

        public User(Long userId, String userName, String favGenre) {
                this.userId = userId;
                this.userName = userName;
                this.favGenre = favGenre;
        }

        public Long getUserId() {
                return userId;
        }

        public void setUserId(Long userId) {
                this.userId = userId;
        }

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }

        public String getFavGenre() {
                return favGenre;
        }

        public void setFavGenre(String favGenre) {
                this.favGenre = favGenre;
        }

        @Override
        public String toString() {
                return "User{" +
                        "userId=" + userId +
                        ", userName='" + userName + '\'' +
                        ", favGenre='" + favGenre + '\'' +
                        '}';
        }
}
