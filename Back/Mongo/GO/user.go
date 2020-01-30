package main

type User struct {
	Name  string `json:"name"`
	Email string `json:"email"`
	Pwd   string `json:"pwd"`
}

type Users []User
