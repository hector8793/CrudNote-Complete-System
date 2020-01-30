package main

import "gopkg.in/mgo.v2/bson"

type User struct {
	Id    bson.ObjectId `bson:"_id,omitempty",json:"_id"`
	Name  string        `json:"name"`
	Email string        `json:"email"`
	Pwd   string        `json:"pwd"`
}

type Users []User
