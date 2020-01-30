package main

import (
	"encoding/json"
	"net/http"

	"github.com/gorilla/mux"
	"gopkg.in/mgo.v2"
	"gopkg.in/mgo.v2/bson"
)

var collection = getSesion().DB("mean-db").C("user")

func getSesion() *mgo.Session {
	session, err := mgo.Dial("mongodb://localhost:27017")

	if err != nil {
		panic(err)
	}

	return session
}

func UserList(w http.ResponseWriter, r *http.Request) {
	var results []User
	var err = collection.Find(nil).All(&results)
	if err != nil {
		w.WriteHeader(500)
		return
	}
	responseUsers(w, results)
}

func UserId(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	user_id := params["id"]
	var oid = bson.ObjectIdHex(user_id)
	var results = User{}
	var err = collection.FindId(oid).One(&results)
	if err != nil {
		w.WriteHeader(500)
		return
	}
	responseUser(w, results)
}

func UserAdd(w http.ResponseWriter, r *http.Request) {
	decoder := json.NewDecoder(r.Body)
	var user_data User
	err := decoder.Decode(&user_data)
	if err != nil {
		panic(err)
	}
	defer r.Body.Close()
	err = collection.Insert(user_data)
	if err != nil {
		w.WriteHeader(500)
		return
	}
	responseUser(w, user_data)
}

func UserUpdate(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	user_id := params["id"]
	decoder := json.NewDecoder(r.Body)
	oid := bson.ObjectIdHex(user_id)
	var user_data = User{}
	err := decoder.Decode(&user_data)
	if err != nil {
		panic(err)
		w.WriteHeader(500)
		return
	}
	defer r.Body.Close()
	document := bson.M{"_id": oid}
	change := bson.M{"$set": user_data}
	erro := collection.Update(document, change)
	if erro != nil {
		w.WriteHeader(500)
		return
	}
	responseUser(w, user_data)
}

func UserDelete(w http.ResponseWriter, r *http.Request) {
	params := mux.Vars(r)
	user_id := params["id"]

	var oid = bson.ObjectIdHex(user_id)
	var err = collection.RemoveId(oid)

	if err != nil {
		w.WriteHeader(500)
		return
	}
	result := Message{"Eliminado"}
	response(w, result)
}

type Message struct {
	Message string
}

func responseUser(w http.ResponseWriter, results User) {
	w.Header().Set("Content-type", "application/json")
	w.WriteHeader(200)
	json.NewEncoder(w).Encode(results)
}

func response(w http.ResponseWriter, results Message) {
	w.Header().Set("Content-type", "application/json")
	w.WriteHeader(200)
	json.NewEncoder(w).Encode(results)
}

func responseUsers(w http.ResponseWriter, results []User) {
	w.Header().Set("Content-type", "application/json")
	w.WriteHeader(200)
	json.NewEncoder(w).Encode(results)
}
