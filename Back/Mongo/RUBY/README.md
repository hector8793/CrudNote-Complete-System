# README

This README would normally document whatever steps are necessary to get the
application up and running.

Things you may want to cover:

* Ruby version

* System dependencies

* Configuration

* Database creation

* Database initialization

* How to run the test suite

* Services (job queues, cache servers, search engines, etc.)

* Deployment instructions

* ...

rails new crud --api

gem 'mongoid'
gem 'bson_ext'
bundle install
rails g mongoid:config
rails generate model User name email pwd

rails new MONGORAILS
bundle install
rails generate model User name email pwd
rails g mongoid:config

rails server | correr app
bundle install | instalar paquetes
gem install rails
rails -v
rails s
rails new [nombre del proyecto] --api
rails generate scaffold [TABLA] [ATRIBUTOS] ejemplo rails generate scaffold book title author synopsis year
gem update --system
rails console
rails db:migrate
gem install tzinfo-data

rails g controller api/v1/User
rails routes
