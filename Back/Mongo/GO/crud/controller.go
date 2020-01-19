package main

import (
	"net/http"

	"github.com/gorilla/mux"
)

type Route struct {
	Name       string
	Method     string
	Pattern    string
	HandleFunc http.HandlerFunc
}

type Routes []Route

func NewController() *mux.Router {
	router := mux.NewRouter().StrictSlash(true)

	for _, route := range routes {
		router.Methods(route.Method).
			Path(route.Pattern).
			Name(route.Name).
			Handler(route.HandleFunc)
	}

	return router
}

var routes = Routes{
	Route{
		"UserList",
		"GET",
		"/users",
		UserList,
	},
	Route{
		"UserId",
		"GET",
		"/user/{id}",
		UserId,
	},
	Route{
		"UserAdd",
		"POST",
		"/user",
		UserAdd,
	},
	Route{
		"UserUpdate",
		"PUT",
		"/user/{id}",
		UserUpdate,
	},
	Route{
		"UserDeñete",
		"DELETE",
		"/user/{id}",
		UserDelete,
	},
}
