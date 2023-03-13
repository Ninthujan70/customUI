package com.example.customlistwithnavigation.models;

import java.util.ArrayList;

public class Person {

    String id, name, address, gender;

    ArrayList<String> songPlaylist;

    ArrayList<String> artistPlaylist;

    Phone phoneList;

    private Person() {

    }

    public Person(String id,
                  String name,
                  String address,
                  String gender,
                  ArrayList<String> songs,
                  ArrayList<String> artists,
                  Phone phones) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.songPlaylist = songs;
        this.artistPlaylist = artists;
        this.phoneList = phones;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public ArrayList<String> getSongPlaylist() {
        return songPlaylist;
    }

    public ArrayList<String> getArtistPlaylist() {
        return artistPlaylist;
    }

    public Phone getPhoneList() {
        return phoneList;
    }


    public static class Builder {
        String id, name, address, gender;

        ArrayList<String> songPlaylist;

        ArrayList<String> artistPlaylist;

        Phone phoneList;

        public Person.Builder withId(String id) {
            this.id = id;

            return this;
        }

        public Person.Builder withName(String name){
            this.name = name;

            return this;
        }

        public Person.Builder withAddress(String address){
            this.address = address;

            return this;
        }

        public Person.Builder withGender(String gender) {
            this.gender = gender;

            return this;
        }

        public Person.Builder withSongPlayList(ArrayList<String> songPlayList) {
            this.songPlaylist = songPlayList;

            return this;
        }

        public Person.Builder withArtistList(ArrayList<String> artistList) {
            this.artistPlaylist = artistList;

            return this;
        }

        public Person.Builder withPhoneList(Phone phone) {
            this.phoneList = phone;

            return this;
        }

        public Person build() {
            Person person = new Person();
            person.id = id;
            person.name = name;
            person.address = address;
            person.gender = gender;
            person.songPlaylist = songPlaylist;
            person.artistPlaylist = artistPlaylist;
            person.phoneList = phoneList;

            return person;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", songPlaylist=" + songPlaylist +
                ", artistPlaylist=" + artistPlaylist +
                ", phoneList=" + phoneList.toString() +
                '}';
    }
}


/*
   {
                "id": "12",
                "name": "Andra Ripa",
                "address": "xx-xx-xxxx,x - street, x - country",
                "gender" : "female",
                "song_play_list" : {
                    "song": [
                        "Aint My Fault",
                        "Alarm",
                        "Alejandro",
                        "All My Life",
                        "All of Me",
                        "All the Small Things"
                    ],
                    "artists": [
                        "Jackie Evancho",
                        "Anne-Marie",
                        "Lady Gaga",
                        "Foo Fighters",
                        "Cedarmont Kids",
                        "George Strait"
                    ]
                },
                "phone": {
                    "mobile": "+371 28476758",
                    "home": "+371 28525325",
                    "office": "+371 22988894"
                }
        },
 */